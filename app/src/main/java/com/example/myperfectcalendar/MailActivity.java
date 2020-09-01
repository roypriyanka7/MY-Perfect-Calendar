package com.example.myperfectcalendar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MailActivity extends AppCompatActivity {

    TextView mRecipientEt, mSubejectEt, mMessageEt;
    Button mSendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);

        mRecipientEt = findViewById(R.id.reciEt);
        mSubejectEt = findViewById(R.id.subjectEt);
        mMessageEt = findViewById(R.id.messageEt);

        mSendEmail = (Button) findViewById(R.id.sendEmail);

        mSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //String recipient = mRecipientEt.getText().toString().trim();
                String subject = mSubejectEt.getText().toString().trim();
                String message = mMessageEt.getText().toString().trim();

                sendEmail(subject, message);
            }
        });

    }

    private void sendEmail(String subject, String message) {
        Intent mEmailIntent = new Intent(Intent.ACTION_SEND);
        mEmailIntent.setData(Uri.parse("mailto:"));
        mEmailIntent.setType("text/plain");

        mEmailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"roypriyankajaya@gmail.com"});
        mEmailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        mEmailIntent.putExtra(Intent.EXTRA_TEXT, message);

        try {

            startActivity(Intent.createChooser(mEmailIntent, "Choose an Email Client!"));
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();

        }


    }

}