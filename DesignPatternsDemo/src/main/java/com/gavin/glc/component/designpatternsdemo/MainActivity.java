package com.gavin.glc.component.designpatternsdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gavin.glc.component.designpatternsdemo.FactoryPattern.FactoryActivity;
import com.gavin.glc.component.designpatternsdemo.SingletonPattern.SingletonActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ArrayList<DetailItem> arrayList;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = (RecyclerView) findViewById(R.id.rv);
        arrayList = initList();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(linearLayoutManager);
        myAdapter = new MyAdapter(arrayList);
        rv.setAdapter(myAdapter);
        myAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                enterActivity(arrayList.get(position).getActivityClass());
            }
        });
    }

    private void enterActivity(Class<? extends Activity> activity) {
        startActivity(new Intent(this, activity));
    }

    private ArrayList<DetailItem> initList() {
        ArrayList<DetailItem> arrayList = new ArrayList<>();
        arrayList.add(new DetailItem("单例模式", SingletonActivity.class));
        arrayList.add(new DetailItem("工厂模式", FactoryActivity.class));
        return arrayList;
    }


    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ItemViewHolder> {

        private ArrayList<DetailItem> list;

        private OnItemClickListener onItemClickListener;

        public MyAdapter(ArrayList<DetailItem> list) {
            this.list = list;
        }

        public void setOnItemClickListener(OnItemClickListener listener) {
            this.onItemClickListener = listener;
        }


        @Override
        public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
            ItemViewHolder itemViewHolder = new ItemViewHolder(inflate);
            return itemViewHolder;
        }

        @Override
        public void onBindViewHolder(ItemViewHolder holder, final int position) {
            holder.tvName.setText(list.get(position).getName());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(v, position);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return list != null ? list.size() : 0;
        }

        class ItemViewHolder extends RecyclerView.ViewHolder {

            TextView tvName;

            public ItemViewHolder(View itemView) {
                super(itemView);
                tvName = (TextView) itemView.findViewById(R.id.tv_name);
            }
        }

    }
}
