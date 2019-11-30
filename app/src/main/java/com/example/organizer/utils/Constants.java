package com.example.organizer.utils;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public final class Constants {
    public static final DatabaseReference DATABASE_REFERENCE_NOTES = FirebaseDatabase
            .getInstance()
            .getReference()
            .child("Notes");
}
