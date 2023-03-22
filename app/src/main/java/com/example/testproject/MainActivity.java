package com.example.testproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





    }

    public void btnPopUp(View view){
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

        View viewpopup = layoutInflater.inflate(R.layout.newtodo, null);

        PopupWindow popupWindow = new PopupWindow(viewpopup, 1000, 600, true);

        popupWindow.showAtLocation(view, Gravity.BOTTOM, -100, 0);
    }
}