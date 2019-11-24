package com.example.organizer.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import com.example.organizer.MainActivity;
import com.example.organizer.R;
import com.example.organizer.utils.StatusBarColor;
import java.util.Objects;

public class activity_todos extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos);

        setTitle("All to-dos");

        setColorBar();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void setColorBar() {
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(Color.rgb(12, 68, 248)));

        new StatusBarColor().changeStatusBarColor(getWindow());
    }

    public void openMainActivity(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void openAddToDoActivity(View view) {
        startActivity(new Intent(this, activity_add_todo.class));
    }
}
