package com.example.lore;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class NO1 extends AppCompatActivity implements View.OnClickListener{


    private int notificationId = 1;
    Button Home;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no1);
        Home=findViewById(R.id.Home);
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),HS1.class);
                startActivity(intent);
                finish();
            }

        });



        //set onclick listener
        findViewById(R.id.setBtn).setOnClickListener(this);
        findViewById(R.id.cancelBtn).setOnClickListener(this);


        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Remind Me");




        }



    @Override
    public void onClick(View view) {
        EditText editText = findViewById(R.id.editText);
        TimePicker timePicker = findViewById(R.id.timePicker);


        //set notificationId and text.
        Intent intent = new Intent(NO1.this, ALARMRECIEVER.class);
        intent.putExtra("notificationId",notificationId);
        intent.putExtra("todo", editText.getText().toString());

        // getBroadcast()

        PendingIntent alarmIntent = PendingIntent.getBroadcast(NO1.this,0,intent,PendingIntent.FLAG_CANCEL_CURRENT);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        switch (view.getId()){
            case R.id.setBtn:
                //set alarm
                int hour = timePicker.getCurrentHour();
                int minute = timePicker.getCurrentMinute();

                //create time
                Calendar startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, hour);
                startTime.set(Calendar.MINUTE,minute);
                startTime.set(Calendar.SECOND,0);
                long alarmStartTime = startTime.getTimeInMillis();

                //set alarm
                alarmManager.set(AlarmManager.RTC_WAKEUP, alarmStartTime, alarmIntent);

                Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();
                break;

            case R.id.cancelBtn:
                //cancel Btn
                alarmManager.cancel(alarmIntent);
                Toast.makeText(this,"Cancelled",Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
