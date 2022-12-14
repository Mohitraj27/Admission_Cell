package com.example.se_firebase;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity<v_flippper, images> extends AppCompatActivity {

    //activity intent
    CardView Notification_intent;
    CardView Programes_offered;
    CardView document_verify;
    CardView counselling_details;
    CardView NRI_Admission;
    CardView Admission_withdrawal;
    CardView Application_form;
    CardView allotment_list;
    CardView Lateral_entry;
    CardView contact_us;
    //Firebase
    Button btnLogOut;
    FirebaseAuth mAuth;
CardView ERP_Login;


    CardView Cutoff;
//    Button chatbot;


    //Social Links
    ImageView Youtube,insta,linkedin,fb,web_page;

    // //For automatic image flipping/movement this widget is used
    //    ViewFlipper v_flippper;
    @SuppressLint({"MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);


//
//        chatbot=findViewById(R.id.chatbot);
//        chatbot.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(MainActivity.this,voiceFlow_chatbit.class);
//                startActivity(intent);
//            }
//        });



        web_page=findViewById(R.id.web_page);
        web_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,webPage_view.class);
                startActivity(intent);
            }
        });




        fb=findViewById(R.id.facebook_view);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,fb_web_view.class);
                startActivity(intent);
            }
        });



        linkedin=findViewById(R.id.linkedin_view);
        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Linkedin.class);
                startActivity(intent);
            }
        });



        insta=findViewById(R.id.insta_web);
        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,insta_web.class);
                startActivity(intent);
            }
        });



        //Youtube webpage intent
        Youtube=findViewById(R.id.youtube_web);
        Youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,youtube_web.class);
                startActivity(intent);
            }
        });



        //Activity Intent
        Cutoff=(CardView) findViewById(R.id.cut_off);
        Cutoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,cutoff_analysis.class);
                startActivity(intent);
            }
        });


        //Activity Intent
        ERP_Login=(CardView) findViewById(R.id.erp_login);
        ERP_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,contact_web.class);
                startActivity(intent);
            }
        });





        //Activity Intent
        Notification_intent=(CardView) findViewById(R.id.btn_start_web_view);
        Notification_intent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,web_notification.class);
                startActivity(intent);
            }
        });


        Programes_offered=findViewById(R.id.programs_offered);
        Programes_offered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Programs_offered.class);
                startActivity(intent);
            }
        });

        document_verify=findViewById(R.id.document_verify);
        document_verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Document_verfication.class);
                startActivity(intent);
            }
        });


        counselling_details=findViewById(R.id.Couselling_details);
        counselling_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Counselling.class);
                startActivity(intent);
            }
        });

        NRI_Admission=findViewById(R.id.NRI_Admission);
        NRI_Admission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,NRI_Admission.class);
                startActivity(intent);
            }
        });

        Admission_withdrawal=findViewById(R.id.admission_withdrawal);
        Admission_withdrawal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,admission_withdrawal.class);
                startActivity(intent);
            }
        });
        Application_form=findViewById(R.id.registration_form);
        Application_form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Application_Form.class);
                startActivity(intent);
            }
        });

        allotment_list=findViewById(R.id.allotment_list);
        allotment_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Allotment_list.class);
                startActivity(intent);
            }
        });


        Lateral_entry=findViewById(R.id.lateral_entry);
        Lateral_entry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Lateral_entry.class);
                startActivity(intent);
            }
        });


//        chatbot=findViewById(R.id.chat_bot);
//        chatbot.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(MainActivity.this,Chatbot_main.class);
//                startActivity(intent);
//            }
//        });

        contact_us=findViewById(R.id.contact_us);
        contact_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,contact_us.class);
                startActivity(intent);
            }
        });


        //Firebase Code
        btnLogOut = findViewById(R.id.btnLogout);
        mAuth = FirebaseAuth.getInstance();

        btnLogOut.setOnClickListener(view ->{
            mAuth.signOut();
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        });

//        //For flipping the images in main page
//        int images[]={R.drawable.bitm,R.drawable.programs,R.drawable.bitmesra,R.drawable.bitaw,R.drawable.bitdeoghar,R.drawable.bitaward,R.drawable.bitawards,R.drawable.nriadmission};
//
//
//        v_flippper=findViewById(R.id.v_flipper);
////for loop
//     /*   for(int i=0;i<image.length;i++){
//            flipperImages(image(i));
//        }*/
////but I prefer Forreach
//        for(int image: images)
//        {
//            flipperImages(image);
//        }
//
//
    }
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null){
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }
    }

//
//    public  void flipperImages(int image){
//        ImageView imageView=new ImageView(this);
//        imageView.setBackgroundResource(image);
//
//
//
//        v_flippper.addView(imageView);
//        v_flippper.setFlipInterval(1500);//2sec
//        v_flippper.setAutoStart(true);
//
//
//
//        //animation
//        v_flippper.setInAnimation(this, android.R.anim.slide_in_left);
//        v_flippper.setOutAnimation(this, android.R.anim.slide_out_right);
//    }


    //Are you sure you want to exit dialog interface
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Exit Application")
                .setMessage("Are you sure you want to exit ? ")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }
}