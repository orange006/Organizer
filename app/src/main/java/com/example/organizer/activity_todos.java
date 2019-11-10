package com.example.organizer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.google.android.material.navigation.NavigationView;

public class activity_todos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos);



        setTitle("All to-dos");

        setColorBar();
    }

    private void setColorBar() {
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(12, 68, 248)));

        StatusBarColor statusBarColor = new StatusBarColor();
        Window window = getWindow();

        statusBarColor.changeStatusBarColor("blue", window);
    }

    public void openMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }

    public void openAddToDoActivity(View view) {
        Intent intent = new Intent(this, activity_add_todo.class);

        startActivity(intent);
    }
}
