package com.example.myperfectcalendar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class TodoActivity extends AppCompatActivity {

    final List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        final ListView listView = findViewById(R.id.ListView);
        final TextAdapter adapter = new TextAdapter();

        readInfo();

        adapter.setData(list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                    AlertDialog dialog = new AlertDialog.Builder(TodoActivity.this)
                        .setTitle("Delete this task?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                list.remove(position);
                                adapter.setData(list);
                            }
                        }).setNegativeButton("No", null)
                        .create();
                dialog.show();
            }
        });


        final Button newTaskButton = findViewById(R.id.new_task_btn);

        newTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText taskInput = new EditText(TodoActivity.this);
                taskInput.setSingleLine();
                int maxLimit=20;
                taskInput.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLimit)});
                AlertDialog dialog = new AlertDialog.Builder(TodoActivity.this)
                        .setTitle("Add a new task (Maximum character limit: 20)")
                        .setMessage("What is your new task?")
                        .setView(taskInput)
                        .setPositiveButton("Add Task", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                if (TextUtils.isEmpty(taskInput.getText().toString().trim())) {

                                    Toast.makeText(TodoActivity.this, "Enter a task to continue!", Toast.LENGTH_LONG).show();
                                }
                                 else{
                                    list.add(taskInput.getText().toString());
                                     adapter.setData(list);
                                }
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .create();
                dialog.show();

            }
        });
        final Button deleteAll = findViewById(R.id.delete_all_task);
        deleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int count= list.size();
                if(count==0){
                    Toast.makeText(TodoActivity.this, "The list is already empty!", Toast.LENGTH_SHORT).show();
                } else{
                    AlertDialog dialog = new AlertDialog.Builder(TodoActivity.this)
                            .setTitle("Delete All Tasks?")
                            .setMessage("Are you sure?")
                            .setPositiveButton("I'm Sure", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    list.clear();
                                    adapter.setData(list);
                                    saveInfo();
                                }
                            }).setNegativeButton("Cancel", null)
                            .create();
                    dialog.show();}
                }
            });
                }





    @Override
    protected void onPause() {
        super.onPause();
        saveInfo();
    }


    private void saveInfo() {
        try {
            File file = new File(this.getFilesDir(), "Saved");

            FileOutputStream fOut = new FileOutputStream(file);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fOut));

            for (int i = 0; i < list.size(); i++) {
                bw.write(list.get(i));
                bw.newLine();
            }
            bw.close();
            fOut.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readInfo() {

        File file = new File(this.getFilesDir(), "Saved");
        if (!file.exists()) {
            return;
        }
        try {
            FileInputStream is = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line = reader.readLine();
            while (line != null) {
                list.add(line);
                line = reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    class TextAdapter extends BaseAdapter {

        List<String> list = new ArrayList<>();

        void setData(List<String> mList) {
            list.clear();
            list.addAll(mList);
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) TodoActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.item, parent, false);
            }

            final TextView textView = convertView.findViewById(R.id.task);
            textView.setText(list.get(position));
            return convertView;
        }
    }


}