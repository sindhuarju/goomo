package com.example.gmamdin.timer;

import android.app.Service;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;


import java.util.Locale;

public class Services extends Service {

    private long TIME_GIVEN;
    private long result;
    Intent intent;
    private int flag=0;
    static final public String BROADCAST_ACTION ="action";


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        intent = new Intent(BROADCAST_ACTION);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String input=intent.getStringExtra("time");
        try {
            String[] values = input.split(":");
            TIME_GIVEN=(Long.parseLong(values[0])*60000)+(Long.parseLong(values[1])*1000);
        }
        catch (Exception e){
            TIME_GIVEN=(Long.parseLong(input)*60000);
        }

        if(TIME_GIVEN>0){
            startTimer(TIME_GIVEN);
        }

        return super.onStartCommand(intent, flags, startId);

    }

    private void startTimer(long time) {
        if(flag==0){
            result=time;
            flag=1;
        }
        else{
            result= time-1000;
        }

        TIME_GIVEN=result;
        int minutes=(int) (result/1000)/60;
        int seconds=(int) (result/1000)%60;
        String timeLeft=String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        intent.putExtra("timer",timeLeft);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);

    }


    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}
