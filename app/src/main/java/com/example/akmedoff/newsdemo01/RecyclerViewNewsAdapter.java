package com.example.akmedoff.newsdemo01;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewNewsAdapter extends RecyclerView.Adapter<RecyclerViewNewsAdapter.ViewHolder> {


    private String TAG = "RecyclerViewBannerAdapter";

    private ArrayList<Integer> mBannerImg = new ArrayList<>();
    private Context mContext;

    public RecyclerViewNewsAdapter(ArrayList<Integer> mBannerImg, Context mContext) {
        this.mBannerImg = mBannerImg;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerViewNewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.banner_list, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.banner.setImageResource(mBannerImg.get(position));

        holder.banner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, mBannerImg.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mBannerImg.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView banner;

        public ViewHolder(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner_img_id);
        }
    }
}
