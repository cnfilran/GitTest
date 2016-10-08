package com.test.fanglun.gittest;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by fanglun on 2016/10/8.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private List<String> list;
    private MyClickListener myClickListener;

    public MyAdapter(List<String> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(parent.getContext(),R.layout.recycle,null);
        ViewHolder holder = new ViewHolder(view,myClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setMyClickListener(MyClickListener myClickListener){
        this.myClickListener = myClickListener;
    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView tv;
        private MyClickListener listener;

        public ViewHolder(View itemView,MyClickListener listener) {
            super(itemView);
            //初始化view
            tv = (TextView) itemView.findViewById(R.id.tv);
            //点击事件
            itemView.setOnClickListener(this);
            this.listener = listener;
        }

        public void setData(int position) {
            tv.setText(list.get(position));
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view,getPosition());
        }
    }
}
