package com.example.customdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Dialog resetPassDialog;
    private Button btnClose, btnResetPass;
    private EditText editEmail;
    private ImageView imgClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void showCustomDialog(View view){
        showResetPasswordDialog();

    }

    private void showResetPasswordDialog(){
        resetPassDialog=new Dialog(this);
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.copyFrom(resetPassDialog.getWindow().getAttributes());//pencererey kopyaladı
        params.width=WindowManager.LayoutParams.WRAP_CONTENT;
        params.height=WindowManager.LayoutParams.WRAP_CONTENT;
        resetPassDialog.setCancelable(false);
        resetPassDialog.setContentView(R.layout.customdialog_resetpass);


        btnClose=resetPassDialog.findViewById(R.id.customdialog_resetpass_btnClose);
        btnResetPass=resetPassDialog.findViewById(R.id.customdialog_resetpass_btnResetPass);
        imgClose=resetPassDialog.findViewById(R.id.customdialog_resetpass_imageView);
        editEmail=resetPassDialog.findViewById(R.id.customdialog_resetpass_editText);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetPassDialog.dismiss();
            }
        });
        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetPassDialog.dismiss();
            }
        });
        btnResetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(editEmail.getText().toString()))
                    Toast.makeText(getApplicationContext(),"Şifre sıfırlama gönderildi",Toast.LENGTH_LONG).show();
            }
        });
        resetPassDialog.getWindow().setAttributes(params);
        resetPassDialog.show();
    }
}