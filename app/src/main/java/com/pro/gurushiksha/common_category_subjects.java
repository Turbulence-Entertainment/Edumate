package com.pro.gurushiksha;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class common_category_subjects extends AppCompatActivity {

    public RecyclerView common_recyclerview1,common_recyclerview2,common_recyclerview3,common_recyclerview4,common_recyclerview5,common_recyclerview6,common_recyclerview7,common_recyclerview8,common_recyclerview9;
    public RecyclerView.LayoutManager common_layout_maneger1,common_layout_maneger2,common_layout_maneger3,common_layout_maneger4,common_layout_maneger5,common_layout_maneger6,common_layout_maneger7,common_layout_maneger8,common_layout_maneger9;
    public ArrayList<CategoryProducts> categoryProductsArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_category_subjects);


        categoryProductsArrayList=new ArrayList<>();

        categoryProductsArrayList.add(new CategoryProducts("https://firebasestorage.googleapis.com/v0/b/shopping-from.appspot.com/o/Component%209.png?alt=media&token=01846811-d717-4ec7-b8e5-51d06a68df26","total"));
        categoryProductsArrayList.add(new CategoryProducts("https://firebasestorage.googleapis.com/v0/b/shopping-from.appspot.com/o/Component%209.png?alt=media&token=01846811-d717-4ec7-b8e5-51d06a68df26","total"));
        categoryProductsArrayList.add(new CategoryProducts("https://firebasestorage.googleapis.com/v0/b/shopping-from.appspot.com/o/Component%209.png?alt=media&token=01846811-d717-4ec7-b8e5-51d06a68df26","total"));
        categoryProductsArrayList.add(new CategoryProducts("https://firebasestorage.googleapis.com/v0/b/shopping-from.appspot.com/o/Component%209.png?alt=media&token=01846811-d717-4ec7-b8e5-51d06a68df26","total"));
        categoryProductsArrayList.add(new CategoryProducts("https://firebasestorage.googleapis.com/v0/b/shopping-from.appspot.com/o/Component%209.png?alt=media&token=01846811-d717-4ec7-b8e5-51d06a68df26","total"));
        categoryProductsArrayList.add(new CategoryProducts("https://firebasestorage.googleapis.com/v0/b/shopping-from.appspot.com/o/Component%209.png?alt=media&token=01846811-d717-4ec7-b8e5-51d06a68df26","total"));




        common_recyclerview1=findViewById(R.id.common_recyclerview1);
        common_layout_maneger1=new LinearLayoutManager(common_category_subjects.this,RecyclerView.HORIZONTAL,false);
        common_recyclerview1.setLayoutManager(common_layout_maneger1);
        CategoryAdapter categoryAdapter1=new CategoryAdapter(categoryProductsArrayList,this);
        common_recyclerview1.setAdapter(categoryAdapter1);
        categoryAdapter1.notifyDataSetChanged();
        categoryAdapter1.setOnItemClickedLisner(new CategoryAdapter.OnItemClickLisner() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(common_category_subjects.this, "1"+"khela", Toast.LENGTH_SHORT).show();
            }
        });

        common_recyclerview2=findViewById(R.id.common_recyclerview2);
        common_layout_maneger2=new LinearLayoutManager(common_category_subjects.this,RecyclerView.HORIZONTAL,false);
        common_recyclerview2.setLayoutManager(common_layout_maneger2);
        CategoryAdapter categoryAdapter2=new CategoryAdapter(categoryProductsArrayList,this);
        common_recyclerview2.setAdapter(categoryAdapter2);
        categoryAdapter2.notifyDataSetChanged();
        categoryAdapter2.setOnItemClickedLisner(new CategoryAdapter.OnItemClickLisner() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(common_category_subjects.this, "2"+"khela", Toast.LENGTH_SHORT).show();
            }
        });


        common_recyclerview3=findViewById(R.id.common_recyclerview3);
        common_layout_maneger3=new LinearLayoutManager(common_category_subjects.this,RecyclerView.HORIZONTAL,false);
        common_recyclerview3.setLayoutManager(common_layout_maneger3);
        CategoryAdapter categoryAdapter3=new CategoryAdapter(categoryProductsArrayList,this);
        common_recyclerview3.setAdapter(categoryAdapter3);
        categoryAdapter3.notifyDataSetChanged();
        categoryAdapter3.setOnItemClickedLisner(new CategoryAdapter.OnItemClickLisner() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(common_category_subjects.this, "3"+"khela", Toast.LENGTH_SHORT).show();
            }
        });




        common_recyclerview4=findViewById(R.id.common_recyclerview4);
        common_layout_maneger4=new LinearLayoutManager(common_category_subjects.this,RecyclerView.HORIZONTAL,false);
        common_recyclerview4.setLayoutManager(common_layout_maneger4);
        CategoryAdapter categoryAdapter4=new CategoryAdapter(categoryProductsArrayList,this);
        common_recyclerview4.setAdapter(categoryAdapter4);
        categoryAdapter4.notifyDataSetChanged();
        categoryAdapter4.setOnItemClickedLisner(new CategoryAdapter.OnItemClickLisner() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(common_category_subjects.this, "4"+"khela", Toast.LENGTH_SHORT).show();
            }
        });




        common_recyclerview5=findViewById(R.id.common_recyclerview5);
        common_layout_maneger5=new LinearLayoutManager(common_category_subjects.this,RecyclerView.HORIZONTAL,false);
        common_recyclerview5.setLayoutManager(common_layout_maneger5);
        CategoryAdapter categoryAdapter5=new CategoryAdapter(categoryProductsArrayList,this);
        common_recyclerview5.setAdapter(categoryAdapter5);
        categoryAdapter5.notifyDataSetChanged();
        categoryAdapter5.setOnItemClickedLisner(new CategoryAdapter.OnItemClickLisner() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(common_category_subjects.this, "5"+"khela", Toast.LENGTH_SHORT).show();
            }
        });




        common_recyclerview6=findViewById(R.id.common_recyclerview6);
        common_layout_maneger6=new LinearLayoutManager(common_category_subjects.this,RecyclerView.HORIZONTAL,false);
        common_recyclerview6.setLayoutManager(common_layout_maneger6);
        CategoryAdapter categoryAdapter6=new CategoryAdapter(categoryProductsArrayList,this);
        common_recyclerview6.setAdapter(categoryAdapter6);
        categoryAdapter6.notifyDataSetChanged();
        categoryAdapter6.setOnItemClickedLisner(new CategoryAdapter.OnItemClickLisner() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(common_category_subjects.this, "6"+"khela", Toast.LENGTH_SHORT).show();
            }
        });




        common_recyclerview7=findViewById(R.id.common_recyclerview7);
        common_layout_maneger7=new LinearLayoutManager(common_category_subjects.this,RecyclerView.HORIZONTAL,false);
        common_recyclerview7.setLayoutManager(common_layout_maneger7);
        CategoryAdapter categoryAdapter7=new CategoryAdapter(categoryProductsArrayList,this);
        common_recyclerview7.setAdapter(categoryAdapter7);
        categoryAdapter7.notifyDataSetChanged();
        categoryAdapter7.setOnItemClickedLisner(new CategoryAdapter.OnItemClickLisner() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(common_category_subjects.this, "7"+"khela", Toast.LENGTH_SHORT).show();
            }
        });




        common_recyclerview8=findViewById(R.id.common_recyclerview8);
        common_layout_maneger8=new LinearLayoutManager(common_category_subjects.this,RecyclerView.HORIZONTAL,false);
        common_recyclerview8.setLayoutManager(common_layout_maneger8);
        CategoryAdapter categoryAdapter8=new CategoryAdapter(categoryProductsArrayList,this);
        common_recyclerview8.setAdapter(categoryAdapter8);
        categoryAdapter8.notifyDataSetChanged();
        categoryAdapter8.setOnItemClickedLisner(new CategoryAdapter.OnItemClickLisner() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(common_category_subjects.this, "8"+"khela", Toast.LENGTH_SHORT).show();
            }
        });




        common_recyclerview9=findViewById(R.id.common_recyclerview9);
        common_layout_maneger9=new LinearLayoutManager(common_category_subjects.this,RecyclerView.HORIZONTAL,false);
        common_recyclerview9.setLayoutManager(common_layout_maneger9);
        CategoryAdapter categoryAdapter9=new CategoryAdapter(categoryProductsArrayList,this);
        common_recyclerview9.setAdapter(categoryAdapter9);
        categoryAdapter9.notifyDataSetChanged();
        categoryAdapter9.setOnItemClickedLisner(new CategoryAdapter.OnItemClickLisner() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(common_category_subjects.this, "9"+"khela", Toast.LENGTH_SHORT).show();
            }
        });









    }
}
