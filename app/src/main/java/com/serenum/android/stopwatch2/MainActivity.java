package com.serenum.android.stopwatch2;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int seconds;
    private boolean running;
    private boolean wasRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runtimer();
    }

    public void startStopwatch(View view) {
        running = true;
    }

    public void stopStopwatch(View view) {
        running = false;
    }

    public void resetStopwatch(View view) {
        running = false;
        seconds = 0;
    }

    private void runtimer(){
        final TextView timerDisplay = (TextView) findViewById(R.id.timer);
        final Handler timer = new Handler();
        timer.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int min = (seconds%3600)/60;
                int sec = seconds%60;
                String time = String.format("%d:%02d:%02d", hours, min, sec);
                timerDisplay.setText(time);
                if (running) {
                    seconds++;
                }
                timer.postDelayed(this, 1000);
            }
        });
    }
}
