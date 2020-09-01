package com.example.myperfectcalendar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DigitalClockAlarmActivity extends AppCompatActivity {

    EditText mHourEditText;
    EditText mMinuteEditText;
    Button mSetAlarmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digital_clock_alarm);

        mHourEditText = (EditText) findViewById(R.id.edOne);
        mMinuteEditText = (EditText) findViewById(R.id.edTwo);
        mSetAlarmButton = (Button) findViewById(R.id.alarmBtn);


        mSetAlarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mHourEditText.getText().toString().trim().isEmpty()) {
                    Toast.makeText(DigitalClockAlarmActivity.this, "Enter time to continue :-|", Toast.LENGTH_LONG).show();
                } else {
                    int hour = Integer.parseInt(mHourEditText.getText().toString());
                    int minute = Integer.parseInt(mMinuteEditText.getText().toString());

                    Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                    intent.putExtra(AlarmClock.EXTRA_HOUR, hour);
                    intent.putExtra(AlarmClock.EXTRA_MINUTES, minute);

                    if (hour <= 24 && minute <= 60) {
                        startActivity(intent);
                    }

                    else {
                        Toast.makeText(DigitalClockAlarmActivity.this, "Please Enter a valid time\n and try again :-)!", Toast.LENGTH_LONG).show();
                    }

                }


            }
        });


    }
}