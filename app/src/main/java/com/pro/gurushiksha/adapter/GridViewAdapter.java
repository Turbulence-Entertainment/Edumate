package com.pro.gurushiksha.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.pro.gurushiksha.GridViewAdapterItems;
import com.pro.gurushiksha.R;

import java.net.URL;
import java.util.ArrayList;

public class GridViewAdapter extends BaseAdapter {

    ArrayList<GridViewAdapterItems> gridViewAdapterItems;
    private Context context;
    LayoutInflater inflater;

    public GridViewAdapter(ArrayList<GridViewAdapterItems> gridViewAdapterItems, Context context) {
        this.gridViewAdapterItems = gridViewAdapterItems;
        this.context = context;
    }

    @Override
    public int getCount() {
        return gridViewAdapterItems.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater==null){
            inflater = LayoutInflater.from(parent.getContext());
        }
        if(convertView==null){
            convertView = inflater.inflate(R.layout.grid_view,parent,false);
        }
        ImageView imageView = convertView.findViewById(R.id.image_view);
        TextView textView = convertView.findViewById(R.id.text_view);


        try{
            URL image_url=new URL(gridViewAdapterItems.get(position).getImageUrl());
            //Log.d("image url", "");

            RequestOptions options=new RequestOptions().centerCrop().placeholder(R.mipmap.ic_launcher_round).error(R.mipmap.ic_launcher_round);

            Glide.with(context).load(image_url).apply(options).into(imageView);


        }catch (Exception e)
        {
            Toast.makeText(context, "Error in loading image", Toast.LENGTH_SHORT).show();
        }


        //imageView.setImageResource();
        textView.setText(gridViewAdapterItems.get(position).getTitle());
        return convertView;
    }
}
