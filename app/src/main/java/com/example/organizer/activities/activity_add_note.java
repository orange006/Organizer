package com.example.organizer.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import com.example.organizer.MainActivity;
import com.example.organizer.R;
import com.example.organizer.model.Note;
import com.example.organizer.utils.Constants;
import com.example.organizer.utils.StatusBarColor;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class activity_add_note extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        setTitle("Add note");

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        startActivityForResult(new Intent(getApplicationContext(), MainActivity.class), 0);

        if (item.getItemId() == R.id.save_note) {
            Spinner spinner = findViewById(R.id.spinnerCategoryNotes);
            String category = spinner.getSelectedItem().toString();

            EditText editText = findViewById(R.id.textAreaNote);
            String content = editText.getText().toString();

            TextView timeNote = findViewById(R.id.timeNotes);

            if (content.length() > 0) {
                String activeId = Constants.DATABASE_REFERENCE_NOTES.push().getKey();

                Note note = new Note(activeId, content, category, (String) timeNote.getText());

                assert activeId != null;
                Constants.DATABASE_REFERENCE_NOTES.child(activeId).setValue(note);
            }
        }

        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void setColorBar() {
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(Color.rgb(12, 68, 248)));

        new StatusBarColor().changeStatusBarColor(getWindow());
    }

    @SuppressLint("SimpleDateFormat")
    private String setDateToTextView() {
        return new SimpleDateFormat("MMM d, yyyy h:mm a").format(new Date());
    }
}
