package com.example.akmedoff.newsdemo01;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

        import android.annotation.SuppressLint;
        import android.content.Context;
        import android.support.annotation.NonNull;
        import android.support.v7.widget.RecyclerView;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.ArrayList;

public class RecyclerViewCategory extends RecyclerView.Adapter<RecyclerViewCategory.ViewHolder> {

    private static final String TAG = "RecyclerViewCategoryAdapter";

    private ArrayList<String> mCategory = new ArrayList<>();
    private Context mContext;

    public RecyclerViewCategory(ArrayList<String> mCategory, Context mContext) {
        this.mCategory = mCategory;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_list, parent, false);

        return new ViewHolder(view);
    }

    @SuppressLint("LongLogTag")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onCreateViewHolder: called.");

        holder.category.setText(mCategory.get(position));

        holder.category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on an catagory: " + mCategory.get(position));
                Toast.makeText(mContext, mCategory.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCategory.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView category;

        public ViewHolder(View itemView) {
            super(itemView);
            category = itemView.findViewById(R.id.category_id);
        }
    }
}

