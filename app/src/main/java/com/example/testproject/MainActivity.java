package com.example.testproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnAddToList, btnAdd;
    EditText etTitle, etDescription;

    //testing
    public String title;
    public String desc;
    public int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //activity_main layout elements
        RecyclerView recyclerView = findViewById(R.id.rvContainer);
        btnAdd = findViewById(R.id.btnAdd);

        //newtodo layout elements
        LayoutInflater inflater = LayoutInflater.from(this);
        View newtodo = inflater.inflate(R.layout.newtodo, null);
        btnAddToList = newtodo.findViewById(R.id.btnAddTo);
        etTitle = newtodo.findViewById(R.id.etTitle);
        etDescription = newtodo.findViewById(R.id.etDescription);
        btnAddToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNew();
            }
        });
        List<Items> items = new ArrayList<Items>();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new Adapter(getApplicationContext(), items));
    }

    public void btnPopUp(View view) {
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View viewpopup = layoutInflater.inflate(R.layout.newtodo, null);
        PopupWindow popupWindow = new PopupWindow(viewpopup, 1000, 700, true);
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
        addNew();
    }

    public void addNew() {
        RecyclerView recyclerView = findViewById(R.id.rvContainer);
        List<Items> items = new ArrayList<Items>();

        items.add(new Items("Product " + i, "Sample product " + i + " description"));
        i++;
        recyclerView.getAdapter().notifyDataSetChanged();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new Adapter(getApplicationContext(), items));
    }

}