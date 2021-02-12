package com.pro.gurushiksha;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.net.URL;
import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {


    ArrayList<CategoryProducts> categoryProductsArrayList;
    Context context;
    private CategoryAdapter.OnItemClickLisner mlisner;

    public interface OnItemClickLisner{
        void onItemClick(int position);

    }

    public void setOnItemClickedLisner(CategoryAdapter.OnItemClickLisner listener)
    {
        mlisner=listener;
    }


    public CategoryAdapter( ArrayList<CategoryProducts> categoryProductsArrayList, Context context) {
        this.categoryProductsArrayList = categoryProductsArrayList;
        this.context = context;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView image_url;
        TextView name;
        MyViewHolder(View itemview, final CategoryAdapter.OnItemClickLisner lisner)
        {
            super(itemview);

            this.image_url=(ImageView)itemview.findViewById(R.id.imageView4);
            this.name=(TextView)itemview.findViewById(R.id.textView4);

            itemview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(lisner!=null)
                    {
                        int position=getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION)
                        {
                            lisner.onItemClick(position);
                        }
                    }
                }
            });

        }
    }

    @NonNull
    @Override
    public CategoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater li= LayoutInflater.from(parent.getContext());
        View view=li.inflate(R.layout.category_products,parent,false);
        CategoryAdapter.MyViewHolder myViewHolder=new CategoryAdapter.MyViewHolder(view,mlisner);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.MyViewHolder holder, int position) {

        ImageView img_thum=holder.image_url;
        TextView name=holder.name;

        name.setText(categoryProductsArrayList.get(position).name);

        try {

            URL imag_url=new URL(categoryProductsArrayList.get(position).image_url);

            RequestOptions options=new RequestOptions().centerCrop().placeholder(R.mipmap.ic_launcher_round).error(R.mipmap.ic_launcher_round);

            Glide.with(context).load(imag_url).apply(options).into(img_thum);


        }catch (Exception f)
        {
            Toast.makeText(context, ""+categoryProductsArrayList.size(), Toast.LENGTH_SHORT).show();
        }


    }


    @Override
    public int getItemCount() {

        return categoryProductsArrayList.size();
    }


}
