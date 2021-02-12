package com.pro.gurushiksha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class details extends AppCompatActivity {

    EditText name,phone,birth,address,email,payment;
    TextView name_view,phone_view,birth_view,address_view,email_view,payment_view;
    FirebaseFirestore firebaseFirestore;
    //StorageReference reference;
    TextView prof;
    Uri uri;
    String uid="",ph,birth_date,add,emai,pay;
    //Bitmap bitmap;
    FirebaseAuth firebaseAuth;
    CheckBox male,female,others;
    ImageView lets_rock_image_stu;
    TextView lets_go_text_stu;
    ProgressBar lets_rock_progressbar_stu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        prof=findViewById(R.id.profession_title_details);
        phone=(EditText)findViewById(R.id.phone);
        name=(EditText)findViewById(R.id.name);
        birth=(EditText)findViewById(R.id.dob);
        address=(EditText)findViewById(R.id.address);
        email=(EditText)findViewById(R.id.mail);
        payment=(EditText)findViewById(R.id.payment);
        firebaseAuth=FirebaseAuth.getInstance();
        uid=firebaseAuth.getCurrentUser().getUid();
        firebaseFirestore=FirebaseFirestore.getInstance();
        male=findViewById(R.id.m);
        female=findViewById(R.id.f);
        others=findViewById(R.id.o);


        payment_view=findViewById(R.id.payment_view);
        name_view=findViewById(R.id.name_view);
        birth_view=findViewById(R.id.dob_view);
        phone_view=findViewById(R.id.phone_view);
        email_view=findViewById(R.id.mail_view);
        address_view=findViewById(R.id.address_view);

        payment_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                payment_view.setVisibility(View.INVISIBLE);
                payment.setVisibility(View.VISIBLE);
            }
        });

        name_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name_view.setVisibility(View.INVISIBLE);
                name.setVisibility(View.VISIBLE);
            }
        });
        birth_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                birth_view.setVisibility(View.INVISIBLE);
                birth.setVisibility(View.VISIBLE);
            }
        });
        phone_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phone_view.setVisibility(View.INVISIBLE);
                phone.setVisibility(View.VISIBLE);
            }
        });
        email_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email_view.setVisibility(View.INVISIBLE);
                email.setVisibility(View.VISIBLE);
            }
        });
        address_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                address_view.setVisibility(View.INVISIBLE);
                address.setVisibility(View.VISIBLE);
            }
        });




        lets_rock_image_stu=findViewById(R.id.lets_rock_stu);
        lets_rock_progressbar_stu=findViewById(R.id.progressBar_teacher);
        lets_go_text_stu=findViewById(R.id.lets_rock_text_stu);

        lets_rock_image_stu.setVisibility(View.VISIBLE);
        lets_rock_progressbar_stu.setVisibility(View.INVISIBLE);
        lets_go_text_stu.setVisibility(View.VISIBLE);

        prof.setText(MainActivity.str);

        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(male.isChecked())
                {
                    female.setChecked(false);
                    others.setChecked(false);
                }else
                if(female.isChecked())
                {
                    male.setChecked(false);
                    others.setChecked(false);
                }else
                if(others.isChecked())
                {
                    male.setChecked(false);
                    female.setChecked(false);
                }
            }
        });

        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(male.isChecked())
                {
                    female.setChecked(false);
                    others.setChecked(false);
                }else
                if(female.isChecked())
                {
                    male.setChecked(false);
                    others.setChecked(false);
                }else
                if(others.isChecked())
                {
                    male.setChecked(false);
                    female.setChecked(false);
                }
            }
        });

        others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(male.isChecked())
                {
                    female.setChecked(false);
                    others.setChecked(false);
                }else
                if(female.isChecked())
                {
                    male.setChecked(false);
                    others.setChecked(false);
                }else
                if(others.isChecked())
                {
                    male.setChecked(false);
                    female.setChecked(false);
                }
            }
        });

        //firebaseAuth.signOut();
    }

    public void submit(View view) {

        lets_rock_image_stu.setVisibility(View.INVISIBLE);
        lets_rock_progressbar_stu.setVisibility(View.VISIBLE);
        lets_go_text_stu.setVisibility(View.INVISIBLE);


        String gen=null;
        if (male.isChecked()) {
            gen = "Male";
        } else if (female.isChecked()) {
            gen = "Female";
        } else if (others.isChecked())
        {
          gen="Others";
        }

        ph=phone.getText().toString();
        birth_date=birth.getText().toString();
        add=address.getText().toString();
        emai=email.getText().toString();
        pay=payment.getText().toString();
        if (gen!=null && name.getText().toString() != null && ph!=null && birth_date!=null && add!=null && emai!=null && pay !=null ) {
            Map<String, Object> users = new HashMap<>();
            users.put("uid",uid);
            users.put("profession","teacher");
            users.put("Name", name.getText().toString());
            users.put("phone", ph);
            users.put("dob", birth_date);
            users.put("address",add);
            users.put("email", emai);
            users.put("payment",pay);
            users.put("gender",gen);
            users.put("college","na");
            users.put("name_of_son_daughter","na");

            firebaseFirestore.collection("users").document(uid).set(users).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {

                    if (task.isSuccessful()) {
                        Toast.makeText(details.this, "Details saved successfully", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(details.this,HomeScreen_and_fragments_navigation.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(details.this, "faild", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }else
        {
            Toast.makeText(this, "Fill all the details", Toast.LENGTH_SHORT).show();
        }
    }
}
