package com.example.testproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button btnAddToList;
    EditText etTitle, etDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvContainer);

        View newtodo = LayoutInflater.from(this).inflate(R.layout.newtodo, null);
        btnAddToList = newtodo.findViewById(R.id.btnAddToList);
        etTitle = newtodo.findViewById(R.id.etTitle);
        etDescription = newtodo.findViewById(R.id.etDescription);

        List<Items> items = new ArrayList<Items>();

        btnAddToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString();
                String desc = etDescription.getText().toString();

                items.add(new Items(title, desc));
                recyclerView.getAdapter().notifyDataSetChanged();
            }
        });

        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        recyclerView.setAdapter(new Adapter(getApplicationContext(), items));
    }

    public void btnPopUp(View view){
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View viewpopup = layoutInflater.inflate(R.layout.newtodo, null);
        PopupWindow popupWindow = new PopupWindow(viewpopup, 1000, 700, true);
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
    }

}