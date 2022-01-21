package com.example.myrecyclerview;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Bean> data= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i=0;i<5;i++){
            Bean bean=new Bean();
            bean.setName(""+i);
            data.add(bean);
        }
        RecyclerView recyclerView=findViewById(R.id.recyclerview);
        //线性布局
//        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);//调整视图结构
        //网格布局
//        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,4,RecyclerView.VERTICAL,false);
        //瀑布布局
        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);//确定布局
        //设置分割线
//        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2,5,true,3));
//        recyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(MainActivity.this).margin(15).build());
        recyclerView.setAdapter(new adapter(data, this, new adapter.onclick_RecyclerView() {
            @Override
            public void oncliiick(int pos) {
                Toast.makeText(MainActivity.this,"onclik"+pos,Toast.LENGTH_SHORT).show();
                if(pos==4){
                    Intent intent=new Intent(MainActivity.this,test.class);
                    startActivity(intent);
                }

            }
        }));
    }
    class  mydecoration extends  RecyclerView.ItemDecoration{  //修改图片参数

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view,  RecyclerView parent, RecyclerView.State state) {

            super.getItemOffsets(outRect, view, parent, state);
        }
    }
}