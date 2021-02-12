package com.pro.gurushiksha;

import android.content.Context;
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

public class categoryAdapterDruvy extends RecyclerView.Adapter<categoryAdapterDruvy.MyViewHolder> {

    ArrayList<categoryModelDruvy> categoryModelDruvies;
    Context context;
    private categoryAdapterDruvy.OnItemClickLisner mlistener;


    public interface OnItemClickLisner {
        void onItemClick(int position);
    }

    public void setOnItemClickedLisner(categoryAdapterDruvy.OnItemClickLisner listener)
    {
        mlistener=listener;
    }



    public categoryAdapterDruvy(ArrayList<categoryModelDruvy> categoryModelDruvies, Context context) {
        this.categoryModelDruvies = categoryModelDruvies;
        this.context = context;
    }

    @NonNull
    @Override
    public categoryAdapterDruvy.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater li= LayoutInflater.from(parent.getContext());
        View view=li.inflate(R.layout.category_design,parent,false);
        categoryAdapterDruvy.MyViewHolder myViewHolder=new categoryAdapterDruvy.MyViewHolder(view,mlistener);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull categoryAdapterDruvy.MyViewHolder holder, int position) {

        ImageView product_url=holder.product_url_druvy;
        TextView product_title=holder.product_name_druvy;

        product_title.setText(categoryModelDruvies.get(position).getTitle_category());

        try{
            URL image_url=new URL(categoryModelDruvies.get(position).getImage_url_category());
            //Log.d("image url", "");

            RequestOptions options=new RequestOptions().centerCrop().placeholder(R.mipmap.ic_launcher_round).error(R.mipmap.ic_launcher_round);

            Glide.with(context).load(image_url).apply(options).into(product_url);


        }catch (Exception e)
        {
            Toast.makeText(context, "Error in loading image", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public int getItemCount() {
        return categoryModelDruvies.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView product_url_druvy;
        TextView product_name_druvy;
        public MyViewHolder(@NonNull View itemView,final categoryAdapterDruvy.OnItemClickLisner lisner) {
            super(itemView);

            this.product_url_druvy=itemView.findViewById(R.id.category_image);
            this.product_name_druvy=itemView.findViewById(R.id.category_title);

            itemView.setOnClickListener(new View.OnClickListener() {
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


}
