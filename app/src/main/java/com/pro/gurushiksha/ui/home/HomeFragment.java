package com.pro.gurushiksha.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.pro.gurushiksha.GridViewAdapterItems;
import com.pro.gurushiksha.Profession;
import com.pro.gurushiksha.R;
import com.pro.gurushiksha.Splash_screen;
import com.pro.gurushiksha.adapter.GridViewAdapter;
import com.pro.gurushiksha.categoryAdapterDruvy;
import com.pro.gurushiksha.categoryModelDruvy;
import com.pro.gurushiksha.common_category_subjects;

import java.net.URL;
import java.util.ArrayList;

public class HomeFragment extends Fragment {
    FirebaseAuth firebaseAuth;

    ImageView add1,add2;
    private HomeViewModel homeViewModel;
    private GridView gridView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText("Logout");
            }
        });
        firebaseAuth= FirebaseAuth.getInstance();
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                Intent intent=new Intent(container.getContext(), Profession.class);
                startActivity(intent);
            }
        });

        add1=root.findViewById(R.id.add1);
        add2=root.findViewById(R.id.add2);

        try{
            URL image_url=new URL(Splash_screen.adds.get(0).getImageUrl());
            //Log.d("image url", "");

            RequestOptions options=new RequestOptions().centerCrop().placeholder(R.mipmap.ic_launcher_round).error(R.mipmap.ic_launcher_round);

            Glide.with(container.getContext()).load(image_url).apply(options).into(add1);
           // Glide.with(container.getContext()).load(image_url).apply(options).into(add2);


        }catch (Exception e)
        {
            Toast.makeText(container.getContext(),""+e, Toast.LENGTH_SHORT).show();
        }

        try{
            URL image_url=new URL(Splash_screen.adds.get(1).getImageUrl());
            //Log.d("image url", "");

            RequestOptions options=new RequestOptions().centerCrop().placeholder(R.mipmap.ic_launcher_round).error(R.mipmap.ic_launcher_round);

            Glide.with(container.getContext()).load(image_url).apply(options).into(add2);
            // Glide.with(container.getContext()).load(image_url).apply(options).into(add2);


        }catch (Exception e)
        {
            Toast.makeText(container.getContext(),""+e, Toast.LENGTH_SHORT).show();
        }

        /////// grid view

        gridView = root.findViewById(R.id.grid_view);
        GridViewAdapter gridViewAdapter = new GridViewAdapter(Splash_screen.gridViewAdapterItems,root.getContext());
        gridView.setAdapter(gridViewAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(root.getContext(),"Clicked on "+position+" Grid",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(root.getContext(), common_category_subjects.class);
                startActivity(intent);
            }
        });

        //////// grid view

        ///////////recyclew view
        /*ArrayList<categoryModelDruvy>categoryModelDruvyArrayList;
        categoryModelDruvyArrayList=new ArrayList<>();
        categoryModelDruvyArrayList.add(new categoryModelDruvy("https://firebasestorage.googleapis.com/v0/b/gurushiksha-67bb6.appspot.com/o/Component%208%20(1)%20(1).png?alt=media&token=28db771e-825c-4e99-b7f6-83a2462c9f80","one"));
        categoryModelDruvyArrayList.add(new categoryModelDruvy("https://firebasestorage.googleapis.com/v0/b/gurushiksha-67bb6.appspot.com/o/Component%208%20(1)%20(1).png?alt=media&token=28db771e-825c-4e99-b7f6-83a2462c9f80","one"));
        categoryModelDruvyArrayList.add(new categoryModelDruvy("https://firebasestorage.googleapis.com/v0/b/gurushiksha-67bb6.appspot.com/o/Component%208%20(1)%20(1).png?alt=media&token=28db771e-825c-4e99-b7f6-83a2462c9f80","one"));
        categoryModelDruvyArrayList.add(new categoryModelDruvy("https://firebasestorage.googleapis.com/v0/b/gurushiksha-67bb6.appspot.com/o/Component%208%20(1)%20(1).png?alt=media&token=28db771e-825c-4e99-b7f6-83a2462c9f80","one"));
        categoryModelDruvyArrayList.add(new categoryModelDruvy("https://firebasestorage.googleapis.com/v0/b/gurushiksha-67bb6.appspot.com/o/Component%208%20(1)%20(1).png?alt=media&token=28db771e-825c-4e99-b7f6-83a2462c9f80","one"));
*/
        RecyclerView  category_recyclerview;
        category_recyclerview=root.findViewById(R.id.cata_recycler_druvy);
        RecyclerView.LayoutManager layoutManager_catagory=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        category_recyclerview.setLayoutManager(layoutManager_catagory);


        categoryAdapterDruvy categoryAdapterDruvy=new categoryAdapterDruvy(Splash_screen.categoryModelDruvyArrayList,getContext());
        category_recyclerview.setAdapter(categoryAdapterDruvy);
        categoryAdapterDruvy.notifyDataSetChanged();
        categoryAdapterDruvy.setOnItemClickedLisner(new categoryAdapterDruvy.OnItemClickLisner() {
            @Override
            public void onItemClick(int position) {

                Toast.makeText(container.getContext(), ""+position, Toast.LENGTH_SHORT).show();

            }
        });

        ////////////////recycler view


        return root;
    }
}
