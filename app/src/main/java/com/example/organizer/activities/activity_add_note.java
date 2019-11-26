package com.example.organizer.activities;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class activity_add_note extends AppCompatActivity {

    private long idNote;

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

        Query query = Constants.DATABASE_REFERENCE_NOTES.orderByKey().limitToLast(1);

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    idNote = (long) Objects.requireNonNull(child.child("iD").getValue()) + 1;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w(null, databaseError.toException());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.check_mark_menu, menu);
        return true;
    }

    @SuppressLint("SimpleDateFormat")
    private String setDateToTextView() {
        return new SimpleDateFormat("MMM d, yyyy h:mm a").format(new Date());
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
                Note note = new Note(idNote, content, category, (String) timeNote.getText());

                Constants.DATABASE_REFERENCE_NOTES.child("note_" + idNote).setValue(note);
            }
        }

        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void setColorBar() {
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(Color.rgb(12, 68, 248)));

        new StatusBarColor().changeStatusBarColor(getWindow());
    }
}
