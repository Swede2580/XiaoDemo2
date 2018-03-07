package com.example.administrator.xiaodemo2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.xiaodemo2.R;
import com.example.administrator.xiaodemo2.clazz.Shou;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2018/3/6.
 */

public class ShouAdapter extends RecyclerView.Adapter<ShouAdapter.ViewHolder> {
    private List<Shou> shous;
    private Context mContext;
    Onclick onclick;
    public ShouAdapter(List<Shou> shous, Context mContext) {
        this.shous = shous;
        this.mContext = mContext;
    }

    @Override
    public ShouAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.shou, parent, false);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(ShouAdapter.ViewHolder holder, final int position) {
        Picasso.with(mContext).load(shous.get(position).getImg()).into(holder.img);
        holder.name.setText(shous.get(position).getName());
        holder.content.setText(shous.get(position).getContent());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclick.onclick(position);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onclick.onlongclick(position);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return shous.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView content;
        private final ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            content = itemView.findViewById(R.id.content);
            img = itemView.findViewById(R.id.img);
        }
    }
    public interface Onclick{
        void onclick(int position);
        void onlongclick(int position);
    }
    public void setOnclick(Onclick onclick){
        this.onclick=onclick;
    }
}
