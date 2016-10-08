package com.test.fanglun.gittest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.test.fanglun.gittest.utils.LogManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyClickListener {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("我是小猪" + i + "号");
        }


        recyclerView = (RecyclerView) findViewById(R.id.rv);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(manager);
        MyAdapter adapter = new MyAdapter(list);

        recyclerView.addItemDecoration(new Mydivider(
                this, LinearLayoutManager.VERTICAL));
        adapter.setMyClickListener(this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onClick(View view, int position) {
        Toast.makeText(this,"点击" + position,Toast.LENGTH_SHORT).show();

        LogManager.getLogger().e("点击了%s",position);
    }
}
