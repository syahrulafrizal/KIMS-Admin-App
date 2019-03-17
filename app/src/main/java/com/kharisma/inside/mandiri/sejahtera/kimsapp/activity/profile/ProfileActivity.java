package com.kharisma.inside.mandiri.sejahtera.kimsapp.activity.profile;

import android.app.Dialog;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.TextView;

import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;

import java.util.Objects;

public class ProfileActivity extends AppCompatActivity {

    Toolbar toolbar;
    Intent intentData;
    String title;
    TextView txtTitle, txtName, txtPhone, txtEmail, txtPosition, txtBank, txtBranch, txtAccountNumber, txtAccountName;
    private Dialog dialog;
    TextInputEditText valName, valPhone, valEmail, valBank, valBranch, valAccountNumber, valAccountName;
    RadioButton valPositionAdmin, valPositionNonAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        intentData = getIntent();
        title = intentData.getStringExtra("title");
        toolbar = findViewById(R.id.toolbar);
        txtTitle = findViewById(R.id.textViewTitle);

        txtName = findViewById(R.id.value_name);
        txtPhone = findViewById(R.id.value_hp);
        txtEmail = findViewById(R.id.value_email);
        txtPosition = findViewById(R.id.value_potition);
        txtBank = findViewById(R.id.value_bank);
        txtBranch = findViewById(R.id.value_branch);
        txtAccountNumber = findViewById(R.id.value_no_rek);
        txtAccountName = findViewById(R.id.value_account_name);

        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setHomeButtonEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        txtTitle.setText(title.toUpperCase());

        dialog = new Dialog(this);
        dialog.setCanceledOnTouchOutside(false);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentListContent = new Intent();
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.editProfile:
                dialog.setContentView(R.layout.activity_edit_profile);
                dialog.show();
                valName = dialog.findViewById(R.id.inputNama);
                valPhone = dialog.findViewById(R.id.inputPhone);
                valEmail= dialog.findViewById(R.id.inputEmail);
                valPositionAdmin = dialog.findViewById(R.id.admin);
                valPositionNonAdmin = dialog.findViewById(R.id.nonAdmin);
                valBank = dialog.findViewById(R.id.inputBank);
                valBranch = dialog.findViewById(R.id.inputBranch);
                valAccountNumber = dialog.findViewById(R.id.inputAccountNo);
                valAccountName= dialog.findViewById(R.id.inputAccountName);
                valName.setText(txtName.getText().toString());
                valPhone.setText(txtPhone.getText().toString());
                valEmail.setText(txtEmail.getText().toString());
                if (txtPosition.getText().toString().equals("Admin")){
                    valPositionAdmin.setChecked(true);
                    valPositionNonAdmin.setChecked(false);
                    valPositionAdmin.setVisibility(View.VISIBLE);
                    valPositionNonAdmin.setVisibility(View.GONE);
                }else {
                    valPositionAdmin.setChecked(false);
                    valPositionAdmin.setVisibility(View.GONE);
                    valPositionNonAdmin.setVisibility(View.VISIBLE);
                    valPositionNonAdmin.setChecked(true);
                }
                valBank.setText(txtBank.getText().toString());
                valBranch.setText(txtBranch.getText().toString());
                valAccountNumber.setText(txtAccountNumber.getText().toString());
                valAccountName.setText(txtAccountName.getText().toString());
                break;

            case R.id.changePassword:
                break;
        }
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        return super.onOptionsItemSelected(item);
    }
}
