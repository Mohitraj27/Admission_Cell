package com.example.se_firebase;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

//
//    //Google Signin Authentication
//    SignInButton GoogleSigin;
//         GoogleSignInClient mGoogleSiginClient;

    TextInputEditText etLoginEmail;
    TextInputEditText etLoginPassword;
    Button tvRegisterHere;
    Button btnLogin;
ImageView Erp_login;
    ImageView login_otp;

    //Admin Login / SignUp
    ImageView Admin_login_signUp_intent;



    // //For automatic image flipping/movement this widget is used
   // ViewFlipper v_flippper;
    FirebaseAuth mAuth;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


//        processrequest();
//
//        GoogleSigin=(SignInButton) findViewById(R.id.google_sigin);
//
//      GoogleSigin.setOnClickListener(new View.OnClickListener() {
//          @Override
//          public void onClick(View view) {
//              processLogin();
//          }
//      });
//
//









//        //For flipping the images in main page
//        int images[]={R.drawable.bitm,R.drawable.programs,R.drawable.bitmesra,R.drawable.nriadmission,R.drawable.bitdeoghar,R.drawable.bitaward,R.drawable.awards12};
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


        //ERp Login

//        Erp_login=findViewById(R.id.erp_login);
//        Erp_login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(LoginActivity.this,contact_web.class);
//            }
//        });
//

        //Otp login
        login_otp=findViewById(R.id.login_otp);
        login_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,OTP_login.class);
                startActivity(intent);
            }
        });




//Admin intent
        Admin_login_signUp_intent=findViewById(R.id.Admin_btnLogin);
        Admin_login_signUp_intent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,Admin_login.class);
                startActivity(intent);
            }
        });

        //firebase codes
        etLoginEmail=findViewById(R.id.etLoginEmail);
        etLoginPassword = findViewById(R.id.etLoginPass);
        tvRegisterHere = findViewById(R.id.tvRegisterHere);
        btnLogin = findViewById(R.id.btnLogin);

        mAuth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(view -> {
            loginUser();
        });
        tvRegisterHere.setOnClickListener(view ->{
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        });
    }
//
//    private void processLogin() {
//        Intent siginIntent=mGoogleSiginClient.getSignInIntent();
//        startActivityForResult(siginIntent,101);
//    }
//
//
//    //Google Sigin
//    private void processrequest(){
//
//        GoogleSignInOptions gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestIdToken(getString(R.string.default_web_client_id))
//                .requestEmail()
//                .build();
//
//
//        //Build a googlesigin Client with the options specified by gso
//        mGoogleSiginClient = GoogleSigin.getClient(this,gso);
//
//    }
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data)
//    {
//        super.onActivityResult(requestCode,resultCode,data);
//        //Result returned from launching the Intent from GoogleSigin.getSiginIntent(..);
//
//        if(requestCode ==101){
//            Task<GoogleSignInAccount> task=GoogleSigin.getSignedInAccountFromIntent(data);
//            try{
//                GoogleSignInAccount account=task.getResult(ApiException.class);
//                firebaseAuthWithGoogle(account.getIdToken());
//            }
//            catch (ApiException e){
//
//            }
//        }
//    }

    private void loginUser(){
        String email = etLoginEmail.getText().toString();
        String password = etLoginPassword.getText().toString();

        if (TextUtils.isEmpty(email)){
            etLoginEmail.setError("Email cannot be empty");
            etLoginEmail.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            etLoginPassword.setError("Password cannot be empty");
            etLoginPassword.requestFocus();
        }else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(LoginActivity.this, "User logged in successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }else{
                        Toast.makeText(LoginActivity.this, "Log in Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
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