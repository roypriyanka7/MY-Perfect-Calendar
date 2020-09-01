package com.example.myperfectcalendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.zip.Inflater;

public class DescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        TextView mTittleWindow = (TextView) findViewById(R.id.tittleWindow);
        TextView mMessageWindow = (TextView) findViewById(R.id.messageWindow);

        mTittleWindow.setText("Application Description!");
        StringBuilder stringBuilder = new StringBuilder();
        String someMessage = " Hello from the developer. Are you trying to find a guide who can direct you to the right direction? Then, you’re in the right section.\n" +
                " Start clicking the hamburger icon placed right on the left top of your screen. By clicking in the up-left dashboard icon, access Menu and you’ll find all the Menu Items list.\n\n" +
                " 1. For accessing the Calendar. Click on any particular date and it’ll be showing the date on the upper front section. Use the button “Yearly View” at the bottom of the Calendar to have a yearly view. You can use the “Back” icon to get back to the Calendar activity.\n\n" +
                " 2. Click on the hand watch icon for accessing the digital clock.\n\n" +
                " 3. In the list, there you’ll find the stopwatch menu. Click on “Go” to have access to Countdown, Pause and Reset the stopwatch.\n\n" +
                " 4. 4th in the list there is the Notification bar. Clicking that you’ll be led to a page where by clicking the bell icon you will find a new section for setting one time notification at a time.\n\n" +
                " 5. Toggle the navigation bar to access My To-Do List. Their clicking on the “Go” button will lead you to your To-Do list.  There you’ll find “New Task” and “Clear All” buttons to add and clear all the data respectively. Again, if you wish to delete any particular one, you can just long press on it and it’ll show you the option to delete.\n" +
                " \n" +
                " 6. Save to my diary is another option there only for you to create and save data on your own virtual diary. By clicking on the longitudinal dots (:) placed over the right top corner you’ll get the “Add item” option and it’ll take you to your virtual page where you can share your random thoughts. If you're too bored to do these and find it troublesome, you can directly click the 'Add' button to write your random thoughts. Thus, those notes will be saved automatically. Interesting, isn't it? \n\n" +
                " 7. Tap the spinning-double arrow icon to open ‘the Spin It’ game. Wait, is it showing loading? Then don’t wait, just click on the ‘Go’ button to have some thrill!\n\n" +
                " 8. To know more about us click on “About Us”. There you’ll find a brief description about us :-)\n\n" +
                " 9. If you need any kinda help, we’re always there to help you! How? Click on the Help icon...  You will find the way to interact with us via email with the default mail address provided. And to get directions use me from the Description menu ;-)\n\n" +
                " Thanks for being with me till now. And now you’re all set to explore… All the best fella!\n";


        stringBuilder.append(someMessage);
        mMessageWindow.setText(stringBuilder.toString());

        


        }

    }

