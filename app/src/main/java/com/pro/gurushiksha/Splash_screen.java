package com.pro.gurushiksha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class Splash_screen extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    public static ArrayList<GridViewAdapterItems> gridViewAdapterItems;
    public static ArrayList<GridViewAdapterItems> adds;
    public static ArrayList<categoryModelDruvy>categoryModelDruvyArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        firebaseAuth= FirebaseAuth.getInstance();
        firebaseFirestore= FirebaseFirestore.getInstance();



        categoryModelDruvyArrayList=new ArrayList<>();
        firebaseFirestore.collection("Category").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {

                for (QueryDocumentSnapshot queryDocumentSnapshot:task.getResult())
                {
                    String url=queryDocumentSnapshot.get("url").toString();
                    String name=queryDocumentSnapshot.get("name").toString();
                    categoryModelDruvyArrayList.add(new categoryModelDruvy(url,name));

                }

            }
        });


        gridViewAdapterItems = new ArrayList<>();
        firebaseFirestore.collection("Topics").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {

                for (QueryDocumentSnapshot queryDocumentSnapshot:task.getResult())
                {
                    String url=queryDocumentSnapshot.get("url").toString();
                    String name=queryDocumentSnapshot.get("name").toString();
                    gridViewAdapterItems.add(new GridViewAdapterItems(url,name));


                }

            }
        });



        adds=new ArrayList<>();
        firebaseFirestore.collection("Adds").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {

                for (QueryDocumentSnapshot queryDocumentSnapshot:task.getResult())
                {
                    String url=queryDocumentSnapshot.get("url").toString();
                    String name=queryDocumentSnapshot.get("name").toString();
                    adds.add(new GridViewAdapterItems(url,name));


                }

            }
        });

        final Handler handler=new Handler();
        Runnable run=new Runnable() {
            @Override
            public void run() {

                handler.postDelayed(this,2000);
                if(gridViewAdapterItems.size()>0 && adds.size()>0 && categoryModelDruvyArrayList.size()>0)
                {
                    handler.removeCallbacksAndMessages(null);
                    if(firebaseAuth.getCurrentUser()!=null)
                    {
                        check();
                    }else
                    {
                        Intent intent=new Intent(Splash_screen.this,Profession.class);
                        startActivity(intent);
                    }
                }
            }
        };
        handler.post(run);



    }
    public void check()
    {
        final String id=firebaseAuth.getCurrentUser().getUid();

        DocumentReference docref=firebaseFirestore.collection("users").document(id);

        docref.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                if(documentSnapshot.exists())
                {
                    Intent intent=new Intent(Splash_screen.this,HomeScreen_and_fragments_navigation.class);
                    //intent.putExtra("phone",num);
                    startActivity(intent);
                }else
                {
                    Intent intent=new Intent(Splash_screen.this,details.class);
                    startActivity(intent);
                }

            }
        });
    }
}
