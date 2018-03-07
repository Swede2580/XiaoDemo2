package com.example.administrator.xiaodemo2.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.xiaodemo2.R;
import com.example.administrator.xiaodemo2.adapter.MybeanAdapter;
import com.example.administrator.xiaodemo2.clazz.Mybean;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class LeiFragment extends Fragment {


    private RecyclerView recycler;

    public LeiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_lei, container, false);

        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        OkHttpClient okHttpClient = new OkHttpClient();

        Request build = new Request.Builder().url("http://172.16.54.15:8080/json/data.json").build();

        Call call = okHttpClient.newCall(build);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                getActivity().runOnUiThread(new Runnable() {

                    private List<Mybean.StudentsBean.StudentBean> student;

                    @Override
                    public void run() {
                        Mybean mybean = new Gson().fromJson(string, Mybean.class);
                        student = mybean.getStudents().getStudent();

                        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
                        MybeanAdapter adapter = new MybeanAdapter(student, getActivity());

                        recycler.setLayoutManager(manager);
                        recycler.setAdapter(adapter);
                    }
                });
            }
        });
    }

    private void initView(View inflate) {
        recycler = (RecyclerView) inflate.findViewById(R.id.recycler);
    }
}
