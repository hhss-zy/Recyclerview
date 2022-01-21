package com.example.myrecyclerview;


import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.viewholder> {
    private List<Bean> data;
    private Context context;
    private onclick_RecyclerView onclick_recyclerView;

    public adapter(List<Bean> data, Context context,onclick_RecyclerView onclick_recyclerView) {
        this.data = data;
        this.context = context;
        this.onclick_recyclerView=onclick_recyclerView;
    }
    @NonNull
    @Override
    public int getItemViewType(int position) {
        if(position%2==0){
            return 0;
        }else {
            return 1;
        }
    }

    public viewholder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {

            View view = View.inflate(context, R.layout.recycleritem, null);
            return new viewholder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
           holder.textView1.setText("原神"+data.get(position).getName());
            if(position%2==0){
               holder.imageView.setImageResource(R.drawable.iamge2);
            }else {
               holder.imageView.setImageResource(R.drawable.image1);
            }
            holder.imageView2.setImageResource(R.drawable.pm);
         holder.textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclick_recyclerView.oncliiick(position);
            }
        });
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclick_recyclerView.oncliiick(position);
            }
        });
        Log.e("test", "onBindViewHolder: "+position );
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
    private TextView textView1;
    private ImageView imageView,imageView2;
        public viewholder(@NonNull  View itemView) {
            super(itemView);
            textView1=itemView.findViewById(R.id.textitem_view);
            imageView=itemView.findViewById(R.id.recycler_iamge);
            imageView2=itemView.findViewById(R.id.recycler2_iamge);
        }
    }

    public  interface onclick_RecyclerView{
        void oncliiick(int  pos);
    }
}




