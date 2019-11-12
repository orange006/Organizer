package com.example.organizer;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import com.example.organizer.model.Note;
import java.text.SimpleDateFormat;
import java.util.Date;

public class activity_add_note extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        setTitle("Edit note");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setColorBar();

        TextView timeNote = findViewById(R.id.timeNotes);
        timeNote.setText(setDateToTextView());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.check_mark_menu, menu);
        return true;
    }

    private String setDateToTextView() {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy h:mm a");

        return dateFormat.format(new Date());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);

        if (item.getItemId() == R.id.save) {
            Spinner spinner = findViewById(R.id.spinnerCategoryNotes);
            String category = spinner.getSelectedItem().toString();

            EditText editText = findViewById(R.id.textAreaNote);
            String content = editText.getText().toString();

            Note note = new Note(setDateToTextView(), category, content);
            note.addNote();
        }

        return true;
    }

    private void setColorBar() {
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(12, 68, 248)));

        StatusBarColor statusBarColor = new StatusBarColor();
        Window window = getWindow();

        statusBarColor.changeStatusBarColor("blue", window);
    }
}
