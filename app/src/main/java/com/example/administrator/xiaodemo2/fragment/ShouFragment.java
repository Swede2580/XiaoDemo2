package com.example.administrator.xiaodemo2.fragment;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.xiaodemo2.MyApplication;
import com.example.administrator.xiaodemo2.R;
import com.example.administrator.xiaodemo2.XiangActivity;
import com.example.administrator.xiaodemo2.adapter.ShouAdapter;
import com.example.administrator.xiaodemo2.clazz.Shou;
import com.example.administrator.xiaodemo2.gen.ShouDao;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShouFragment extends Fragment {


    private RecyclerView recycler;
    private ShouDao shouDao;
    private List<Shou> shous;
    private ShouAdapter adapter;

    public ShouFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_shou, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        shouDao = MyApplication.getApplication().getDaoSession().getShouDao();
        shous = shouDao.loadAll();

        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        adapter = new ShouAdapter(shous, getActivity());

        recycler.setLayoutManager(manager);
        recycler.setAdapter(adapter);

        initLIstener();

    }

    private void initLIstener() {
        adapter.setOnclick(new ShouAdapter.Onclick() {
            @Override
            public void onclick(int position) {
                Intent intent = new Intent(getActivity(), XiangActivity.class);
                intent.putExtra("name",shous.get(position).getName());
                intent.putExtra("img",shous.get(position).getImg());
                intent.putExtra("content",shous.get(position).getContent());
                startActivity(intent);
            }

            @Override
            public void onlongclick(final int position) {
                new AlertDialog.Builder(getActivity()).setMessage("是否删除")
                        .setNegativeButton("否",null)
                        .setPositiveButton("是", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Long id = shous.get(position).getId();

                                shouDao.deleteByKey(id);
                                initData();
                            }
                        })
                        .create()
                        .show();
            }
        });

    }

    private void initView(View inflate) {
        recycler = (RecyclerView) inflate.findViewById(R.id.recycler);
    }
}
