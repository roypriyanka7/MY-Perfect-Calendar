package com.example.myperfectcalendar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class NotifyActivity extends AppCompatActivity implements View.OnClickListener {

    private int notificationId = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify);

        findViewById(R.id.save).setOnClickListener(this);
        findViewById(R.id.cancel).setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        EditText editText = findViewById(R.id.editText);
        TimePicker timePicker = findViewById(R.id.timePicker);

        Intent intent3 = new Intent(NotifyActivity.this, AlarmReceiver.class);
        intent3.putExtra("notificationId", notificationId);
        intent3.putExtra("todo", editText.getText().toString());

        PendingIntent alarmIntent = PendingIntent.getBroadcast(NotifyActivity.this, 0,
                intent3, PendingIntent.FLAG_CANCEL_CURRENT);


        AlarmManager alarm = (AlarmManager) getSystemService(ALARM_SERVICE);
        switch (view.getId()) {

            case R.id.save:

                if(TextUtils.isEmpty(editText.getText().toString().trim())){
                    Toast.makeText(NotifyActivity.this, "No", Toast.LENGTH_SHORT).show();
                } else{

                int hour = timePicker.getCurrentHour();
                int minute = timePicker.getCurrentMinute();

                Calendar startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, hour);
                startTime.set(Calendar.MINUTE, minute);
                startTime.set(Calendar.SECOND, 0);
                long alarmStartTime = startTime.getTimeInMillis();


                alarm.set(AlarmManager.RTC_WAKEUP, alarmStartTime, alarmIntent);

                Toast.makeText(this, "Done!", Toast.LENGTH_SHORT).show();   }
                break;


            case R.id.cancel:

                if(TextUtils.isEmpty(editText.getText().toString().trim())){
                    Toast.makeText(NotifyActivity.this,"Enter a task name to continue!",Toast.LENGTH_SHORT).show();
                } else{
                alarm.cancel(alarmIntent);
                Toast.makeText(this, "Cancelled.", Toast.LENGTH_SHORT).show();   }
                break;


        }
    }

}