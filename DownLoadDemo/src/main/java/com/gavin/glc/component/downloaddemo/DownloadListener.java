package com.gavin.glc.component.downloaddemo;

/**
 * Created by Gaoliangchao on 2018/6/12.
 * <p>
 * Description : 下载过程中的监听回调
 */

public interface DownloadListener {
    /**
     * 下载过程中的进度值
     *
     * @param progress 下载进度值
     */
    void onProgress(int progress);

    /**
     * 成功的回调
     */
    void onSuccess();

    /**
     * 失败的回调
     */
    void onFail();

}
