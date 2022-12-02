package com.example.firebasedeneme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;



public class Giris extends AppCompatActivity {

    EditText editEmail, editSifre;
    private String txtEmail,txtSifre;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private DatabaseReference mreference;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);

        editEmail=findViewById(R.id.giris_yap_editEmail);
        editSifre=findViewById(R.id.giris_yap_editPassword);
        mAuth= FirebaseAuth.getInstance();


    }
    public void girisYap(View v){
        txtEmail=editEmail.getText().toString();
        txtSifre=editSifre.getText().toString();
        if(!TextUtils.isEmpty(txtEmail) && !TextUtils.isEmpty(txtSifre)) {
            mAuth.signInWithEmailAndPassword(txtEmail,txtSifre)
                    .addOnSuccessListener(this, new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            mUser=mAuth.getCurrentUser();

                            mreference= FirebaseDatabase.getInstance().getReference("kullanicilar").child(mUser.getUid());
                            mreference.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    //System.out.println(snapshot.getValue());
                                    for(DataSnapshot snp: snapshot.getChildren()){
                                        System.out.println(snp.getKey() + " = " + snp.getValue());
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {
                                    Toast.makeText(Giris.this,error.getMessage(),Toast.LENGTH_SHORT).show();
                                }
                            });

                        }
                    }).addOnFailureListener(this, new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Giris.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    });
        }
        else
            Toast.makeText(this,"Email ve sifre bos olmaz",Toast.LENGTH_SHORT).show();

    }
}