package com.example.administrator.xiaodemo2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.xiaodemo2.MyApplication;
import com.example.administrator.xiaodemo2.R;
import com.example.administrator.xiaodemo2.clazz.Mybean;
import com.example.administrator.xiaodemo2.clazz.Shou;
import com.example.administrator.xiaodemo2.gen.ShouDao;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2018/3/6.
 */

public class MybeanAdapter extends RecyclerView.Adapter<MybeanAdapter.ViewHolder> {
    private List<Mybean.StudentsBean.StudentBean> student;
    private Context mContext;

    public MybeanAdapter(List<Mybean.StudentsBean.StudentBean> student, Context mContext) {
        this.student = student;
        this.mContext = mContext;
    }

    @Override
    public MybeanAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.iten_mybean, parent, false);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(MybeanAdapter.ViewHolder holder, final int position) {

        Picasso.with(mContext).load(student.get(position).getImg()).into(holder.img);
        holder.name.setText(student.get(position).getName());
        holder.content.setText(student.get(position).getContent());

        holder.rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radion:
                        ShouDao shouDao = MyApplication.getApplication().getDaoSession().getShouDao();
                        Shou shou = new Shou();
                        shou.setName(student.get(position).getName());
                        shou.setContent(student.get(position).getContent());
                        shou.setImg(student.get(position).getImg());
                        shouDao.insert(shou);

                        Toast.makeText(mContext, "插入成功", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return student.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView content;
        private final ImageView img;
        private final RadioButton radion;
        private final RadioGroup rg;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            content = itemView.findViewById(R.id.content);
            img = itemView.findViewById(R.id.img);
            radion = itemView.findViewById(R.id.radion);
            rg = itemView.findViewById(R.id.rg);
        }
    }
}
