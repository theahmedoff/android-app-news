package com.example.akmedoff.newsdemo01;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerViewNews extends RecyclerView.Adapter<RecyclerViewNews.MyViewHolder> {

    List<News> data;
    Context context;

    public RecyclerViewNews(List<News> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        News item = data.get(position);

        holder.img_image.setImageResource(item.getImage());
        holder.tv_title.setText(item.getTitle());
        holder.tv_category.setText(item.getCategory());
        holder.tv_comment.setText(item.getComment());

        holder.img_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, data.get(position).getImage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView img_image;
        TextView tv_title, tv_category, tv_comment;

        public MyViewHolder(View itemView) {
            super(itemView);
            img_image = (ImageView)itemView.findViewById(R.id.news_img_id);
            tv_title = (TextView)itemView.findViewById(R.id.news_title_id);
            tv_comment = (TextView)itemView.findViewById(R.id.news_comment_id);
            tv_category = (TextView)itemView.findViewById(R.id.news_category_id);
        }
    }
}













