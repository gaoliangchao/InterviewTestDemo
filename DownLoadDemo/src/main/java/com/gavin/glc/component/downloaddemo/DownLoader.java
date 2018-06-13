package com.gavin.glc.component.downloaddemo;

import android.content.Context;
import android.os.AsyncTask;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Gaoliangchao on 2018/6/12.
 * <p>
 * Description :    基于AsyncTask的下载器
 * 三个泛型分别为 执行时传入的参数
 * 下载过程中
 * 下载结果
 */

public class DownLoader extends AsyncTask<String, Integer, Integer> {

    /**
     * 下载过程中的标志
     */
    public static final int TYPE_SUCCESS = 1;
    public static final int TYPE_FAIL = 2;
    //    public static final int TYPE_PAUSE = 3;
    //    public static final int TYPE_CANCEL = 4;
    private DownloadListener downloadListener;
    private Context mContext;
    private String mFileName;

    public DownLoader(Context context, String fileName, DownloadListener downloadListener) {
        this.mContext = context;
        this.mFileName = fileName;
        this.downloadListener = downloadListener;
    }

    @Override
    protected Integer doInBackground(String... params) {
        String downloadPath = params[0];
        String savePath = mContext.getExternalCacheDir().getAbsolutePath();
        File file = new File(savePath, mFileName);
        long downloadLength = 0;
        if (file.exists()) {
            downloadLength = file.length();
        }
        InputStream is = null;
        RandomAccessFile raf = null;
        try {
            //从网络上获取下载文件的大小
            long contentLenght = getFileLengthForNet(downloadPath);
            //比对文件大小 根据文件大小和已下载的文件大小判断是否需要继续加载
            if (contentLenght == 0) {
                return TYPE_FAIL;
            } else if (contentLenght == downloadLength) {
                return TYPE_SUCCESS;
            }
            OkHttpClient okHttpClient = new OkHttpClient();
            Request request = new Request.Builder()
                    .addHeader("RANGE", "bytes=" + downloadPath + "-")//断点下载
                    .url(downloadPath)
                    .build();
            Response execute = okHttpClient.newCall(request).execute();
            if (execute != null) {
                is = execute.body().byteStream();
                raf = new RandomAccessFile(file, "rw");
                raf.seek(downloadLength);
                byte[] b = new byte[1024];
                int total = 0;
                int len;
                while ((len = is.read(b)) != -1) {
                    total += len;
                    raf.write(b, 0, len);
                    int progress = ((int) ((total + downloadLength) * 100 / contentLenght));
                    publishProgress(progress);
                }
                execute.body().close();
                return TYPE_SUCCESS;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
                if (raf != null) {
                    raf.close();
                }

            } catch (Exception e) {

            }
        }

        return TYPE_FAIL;
    }

    private long getFileLengthForNet(String downloadUrl) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(downloadUrl)
                .build();
        Response execute = okHttpClient.newCall(request).execute();
        if (execute != null && execute.isSuccessful()) {
            long contentLength = execute.body().contentLength();
            return contentLength;
        }
        return 0;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        int progress = values[0];
        if (downloadListener != null) {
            downloadListener.onProgress(progress);
        }
    }

    @Override
    protected void onPostExecute(Integer integer) {
        switch (integer) {
            case TYPE_SUCCESS:
                if (downloadListener != null) {
                    downloadListener.onSuccess();
                }
                break;
            case TYPE_FAIL:
                if (downloadListener != null) {
                    downloadListener.onFail();
                }
                break;
        }
    }
}
