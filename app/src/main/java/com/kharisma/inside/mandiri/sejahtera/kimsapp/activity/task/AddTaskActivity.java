package com.kharisma.inside.mandiri.sejahtera.kimsapp.activity.task;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.kharisma.inside.mandiri.sejahtera.kimsapp.R;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.adapter.AdapterParticipan;
import com.kharisma.inside.mandiri.sejahtera.kimsapp.model.ModelParticipan;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class AddTaskActivity extends AppCompatActivity implements View.OnClickListener {
    TextView deadLineTask;
    TextView deadLineParticipan;
    private SimpleDateFormat dateFormatter;
    Toolbar toolbar;
    TextView txtTitle;
    Button btnAdd;
    EditText valName, valNote;
    RecyclerView listParticipan;
    RecyclerView.Adapter adapterParticipan;
    RecyclerView.LayoutManager layoutManagerParticipan;
    List<ModelParticipan> modelParticipanList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        deadLineTask = findViewById(R.id.inputDate);
        deadLineParticipan = findViewById(R.id.inputDeadLine);
        btnAdd = findViewById(R.id.btnAdd);
        valName = findViewById(R.id.inputName);
        valNote = findViewById(R.id.inputNote);
        listParticipan = findViewById(R.id.listParticipan);
        modelParticipanList = new ArrayList<>();
        layoutManagerParticipan = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        adapterParticipan = new AdapterParticipan(this, modelParticipanList);
        listParticipan.setAdapter(adapterParticipan);
        listParticipan.setLayoutManager(layoutManagerParticipan);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        toolbar = findViewById(R.id.toolbar);
        txtTitle = findViewById(R.id.textViewTitle);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setHomeButtonEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        txtTitle.setText(getString(R.string.add_task));

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentListContent = new Intent();
                finish();
            }
        });

        deadLineTask.setOnClickListener(this);
        deadLineParticipan.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.inputDate :
                showDateDialog(deadLineTask);
                break;

            case R.id.inputDeadLine :
                showDateDialog(deadLineParticipan);
                break;

            case R.id.btnAdd:
                ModelParticipan modelParticipan = new ModelParticipan(
                        valName.getText().toString(),
                        valNote.getText().toString(),
                        Objects.requireNonNull(deadLineParticipan.getText()).toString());
                modelParticipanList.add(modelParticipan);
                adapterParticipan.notifyDataSetChanged();
                listParticipan.setItemAnimator(new DefaultItemAnimator());
                valName.getText().clear();
                valNote.getText().clear();
                deadLineParticipan.setText("dd-mm-yyyy");
                break;
        }
    }

    private void showDateDialog(final TextView text){
        Calendar newCalendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                text.setText(dateFormatter.format(newDate.getTime()));
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }
}
