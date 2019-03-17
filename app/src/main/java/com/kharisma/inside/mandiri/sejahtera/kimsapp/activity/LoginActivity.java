package com.kharisma.inside.mandiri.sejahtera.kimsapp.activity;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.activity.product.ProductActivity;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    private Dialog dialog;
    private long backPressedTime;
    private Toast backToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.buttonLogin);

        dialog = new Dialog(this);
        dialog.setContentView(R.layout.loading);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawableResource(android.R.color.transparent);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                overridePendingTransition(R.anim.intent_in, R.anim.intent_out);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            finish();
        } else {
            backToast = Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }

        backPressedTime = System.currentTimeMillis();
    }
}
