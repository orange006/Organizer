package com.example.organizer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;

public class activity_add_todo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);

        setTitle("Edit to-do");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setColorBar();
    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), activity_todos.class);
        startActivityForResult(myIntent, 0);
        return true;
    }

    private void setColorBar() {
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(12, 68, 248)));

        StatusBarColor statusBarColor = new StatusBarColor();
        Window window = getWindow();

        statusBarColor.changeStatusBarColor("blue", window);
    }
}
