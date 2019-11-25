package com.example.organizer.activities;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import com.example.organizer.MainActivity;
import com.example.organizer.R;
import com.example.organizer.utils.StatusBarColor;
import java.util.Objects;

public class activity_edit_note extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setColorBar();

        getIncomingIntent();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.check_mark_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        startActivityForResult(new Intent(getApplicationContext(), MainActivity.class), 0);
        return true;
    }

    private void getIncomingIntent(){
        if(
                getIntent().hasExtra("content_name") &&
                getIntent().hasExtra("date_name") &&
                getIntent().hasExtra("category_name")
        ){
            String content = getIntent().getStringExtra("content_name");
            EditText editText = findViewById(R.id.noteTextArea_edit);
            editText.setText(content);

            String date = getIntent().getStringExtra("date_name");
            TextView textView = findViewById(R.id.timeNotes_edit);
            textView.setText(date);

            String category = getIntent().getStringExtra("category_name");
            Spinner spinner = findViewById(R.id.spinnerCategoryNotes_edit);

            ArrayAdapter<CharSequence> adapter = ArrayAdapter
                    .createFromResource(this, R.array.category_list, android.R.layout.simple_spinner_item);

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);

            if (category != null) {
                int spinnerPosition = adapter.getPosition(category);
                spinner.setSelection(spinnerPosition);
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void setColorBar() {
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(Color.rgb(12, 68, 248)));

        new StatusBarColor().changeStatusBarColor(getWindow());
    }
}
