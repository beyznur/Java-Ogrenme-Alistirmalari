package com.example.firebasedeneme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    EditText editEmail, editSifre,editIsim;
    private String txtEmail,txtSifre,txtIsim;
    private FirebaseAuth mAuth;
    private FirebaseUser muser;
    private DatabaseReference mReference;
    private HashMap<String ,Object> mData;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editEmail=findViewById(R.id.kayit_ol_editEmail);
        editSifre=findViewById(R.id.kayit_ol_editPassword);
        editIsim=findViewById(R.id.kayit_ol_editIsim);
        mAuth= FirebaseAuth.getInstance();
        mReference= FirebaseDatabase.getInstance().getReference();//root kısmını getirir.
    }
    public void kayitOl(View v){
        txtEmail=editEmail.getText().toString();
        txtSifre=editSifre.getText().toString();
        txtIsim=editIsim.getText().toString();

        if(!TextUtils.isEmpty(txtEmail) && !TextUtils.isEmpty(txtSifre) && !TextUtils.isEmpty(txtIsim)){
            mAuth
                    .createUserWithEmailAndPassword(txtEmail,txtSifre)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {
                                muser=mAuth.getCurrentUser();

                                mData = new HashMap<>();
                                mData.put("kullaniciAdi",txtIsim);
                                mData.put("kullaniciEmal",txtEmail);
                                mData.put("kullaniciSifresi",txtSifre);
                                mData.put("kullaniciId",muser.getUid());

                                mReference.child("kullanicilar").child(muser.getUid())//son kısmı ekleyince uidnin altına ekledi
                                                .setValue(mData)
                                                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<Void>() {
                                                            @Override
                                                            public void onComplete(@NonNull Task<Void> task) {
                                                           if(task.isSuccessful()){
                                                               Toast.makeText(MainActivity.this, "Kayit islemi basarılı", Toast.LENGTH_SHORT).show();
                                                           }
                                                           else
                                                               Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                                            }
                                                        });

                            }
                            else
                                Toast.makeText(MainActivity.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            //hatayı döner
                        }
                    });
        }else{
            Toast.makeText(this,"Email ve sifre bos olmaz",Toast.LENGTH_SHORT).show();
        }

    }
}