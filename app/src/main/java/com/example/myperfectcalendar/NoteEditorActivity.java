package com.example.myperfectcalendar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashSet;

public class NoteEditorActivity extends AppCompatActivity {
    int noteId;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editor);

        EditText editText = findViewById(R.id.editTextTextMultiLine);

        Intent intent = getIntent();
        noteId = intent.getIntExtra("noteId", -1);

        if (noteId != -1) {
            editText.setText(DiaryActivity.notes.get(noteId));
        } else {
            DiaryActivity.notes.add("");
            noteId = DiaryActivity.notes.size() - 1;
            DiaryActivity.arrayAdapter.notifyDataSetChanged();
        }

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                DiaryActivity.notes.set(noteId, String.valueOf(charSequence));
                DiaryActivity.arrayAdapter.notifyDataSetChanged();
                save();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isEmpty(DiaryActivity.notes.get(noteId))) {
            DiaryActivity.notes.remove(noteId);
        }
        DiaryActivity.arrayAdapter.notifyDataSetChanged();

        save();
    }

    private void save() {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.example.myperfectcalendar", Context.MODE_PRIVATE);
        HashSet<String> set = new HashSet<>(DiaryActivity.notes);
        sharedPreferences.edit().putStringSet("Notes", set).apply();
    }

    private boolean isEmpty(String note) {
        return note.trim().length() <= 0;
    }
}