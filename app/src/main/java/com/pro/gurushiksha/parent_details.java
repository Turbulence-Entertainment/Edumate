package com.pro.gurushiksha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class parent_details extends AppCompatActivity {

    EditText name,phone,birth,address,email;
    TextView name_view,phone_view,birth_view,address_view,email_view;
    FirebaseFirestore firebaseFirestore;
    ProgressBar lets_rock_progressbar;
    //StorageReference reference;
    TextView prof,lets_go_text;
    Uri uri;
    String uid="",ph,birth_date,add,emai,pay;
    //Bitmap bitmap;
    FirebaseAuth firebaseAuth;
    CheckBox male,female,others;
    ImageView lets_rock_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_details);

        name_view=findViewById(R.id.name_view);
        phone_view=findViewById(R.id.phone_view);
        birth_view=findViewById(R.id.dob_view);
        address_view=findViewById(R.id.address_view);
        email_view=findViewById(R.id.mail_view);



        lets_rock_image=findViewById(R.id.lets_rock_stu);
        lets_rock_progressbar=findViewById(R.id.lets_rock_progressbar);
        lets_go_text=findViewById(R.id.lets_rock_text_stu);
        prof=findViewById(R.id.profession_title_details);
        phone=(EditText)findViewById(R.id.phone);
        name=(EditText)findViewById(R.id.name);
        birth=(EditText)findViewById(R.id.dob);
        address=(EditText)findViewById(R.id.address);
        email=(EditText)findViewById(R.id.mail);
        firebaseAuth= FirebaseAuth.getInstance();
        uid=firebaseAuth.getCurrentUser().getUid();
        firebaseFirestore= FirebaseFirestore.getInstance();
        male=findViewById(R.id.m);
        female=findViewById(R.id.f);
        others=findViewById(R.id.o);

        lets_go_text.setVisibility(View.VISIBLE);
        lets_rock_progressbar.setVisibility(View.INVISIBLE);
        lets_rock_image.setVisibility(View.VISIBLE);

        prof.setText(MainActivity.str);


        name_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name_view.setVisibility(View.INVISIBLE);
                name.setVisibility(View.VISIBLE);
            }
        });

        phone_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phone_view.setVisibility(View.INVISIBLE);
                phone.setVisibility(View.VISIBLE);
            }
        });

        birth_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                birth_view.setVisibility(View.INVISIBLE);
                birth.setVisibility(View.VISIBLE);
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

    }

    public void submit(View view) {

        lets_go_text.setVisibility(View.INVISIBLE);
        lets_rock_progressbar.setVisibility(View.VISIBLE);
        lets_rock_image.setVisibility(View.INVISIBLE);

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
        pay="na";
        if (gen!=null && name.getText().toString() != null && ph!=null && birth_date!=null && add!=null && emai!=null && pay !=null ) {
            Map<String, Object> users = new HashMap<>();
            users.put("uid",uid);
            users.put("profession","parent");
            users.put("Name", name.getText().toString());
            users.put("phone", ph);
            users.put("dob", "na");
            users.put("address",add);
            users.put("email", emai);
            users.put("payment","na");
            users.put("gender",gen);
            users.put("college",pay);
            users.put("name_of_son_daughter",birth_date);
            firebaseFirestore.collection("users").document(uid).set(users).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {

                    if (task.isSuccessful()) {
                        Toast.makeText(parent_details.this, "Details saved successfully", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(parent_details.this,HomeScreen_and_fragments_navigation.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(parent_details.this, "faild", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }else
        {
            Toast.makeText(this, "Fill all the details", Toast.LENGTH_SHORT).show();
        }
    }

}
