package com.meterstoinches.seekbar;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private SeekBar seekBar;
    private TextView result_txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        result_txtView = (TextView) findViewById(R.id.result_ID);

        result_txtView.setText("Pain level: "+seekBar.getProgress()+ "/"+ seekBar.getMax());

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("sb","onProgress");
                result_txtView.setTextColor(Color.BLACK);
                result_txtView.setText("Pain level: "+seekBar.getProgress()+ "/"+ seekBar.getMax());

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d("sb","onStartTrackingTouch");

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d("sb","onStopTrackingTouch");
                if(seekBar.getProgress() >=7){
                    result_txtView.setTextColor(Color.RED);
                }
            }
        });
    }
}
