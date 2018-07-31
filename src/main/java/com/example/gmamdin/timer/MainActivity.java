package com.example.gmamdin.timer;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.CountDownTimer;
import android.support.design.widget.Snackbar;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

import static com.example.gmamdin.timer.Services.BROADCAST_ACTION;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private EditText input;
    private Button start;
    //private BroadcastReceiver message;
    private IntentFilter filter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LocalBroadcastManager.getInstance(MainActivity.this).registerReceiver(message, new IntentFilter(
                BROADCAST_ACTION));

        start=(Button)findViewById(R.id.button);
        input=(EditText)findViewById(R.id.etTimer);
        display=(TextView)findViewById(R.id.textView);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(MainActivity.this, Services.class);
                    intent.putExtra("time", input.getText().toString());
                    display.setText("");
                    long TIME_GIVEN = (Long.parseLong(input.getText().toString()) * 60000);
                    startService(intent);
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Enter the time",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    @Override
    protected void onPause() {
        if(filter != null) {
            unregisterReceiver(message);
            filter = null;
        }

        super.onPause();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
    private BroadcastReceiver message = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String content=intent.getStringExtra("timer");
            display.setText(content);
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(content.equals("00:00")){
                Toast.makeText(getApplicationContext(),"TIME OUT",Toast.LENGTH_SHORT).show();
            }
            else{
                intent = new Intent(MainActivity.this,Services.class);
                intent.putExtra("time",content);
                startService(intent);
            }
        }
    };

}
