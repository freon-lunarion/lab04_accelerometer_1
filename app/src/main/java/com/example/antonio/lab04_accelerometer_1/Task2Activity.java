package com.example.antonio.lab04_accelerometer_1;

import android.content.Context;
import android.hardware.Sensor;

import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Task2Activity extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mSensor;
    private TextView txt;

    private float[] gravity;
    private float[] linear_acceleration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        setContentView(R.layout.activity_task2);

        txt = findViewById(R.id.txt_x);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        final float alpha = (float) 0.8;


        synchronized (this) {


            switch (event.sensor.getType()){

                case Sensor.TYPE_LINEAR_ACCELERATION:

                    txt.setText(
                            "acceleration x:"+Float.toString(event.values[0])+"\n"+
                            "acceleration y:"+Float.toString(event.values[1]) + "\n" +
                            "acceleration z:"+Float.toString(event.values[2]));

                    break;

            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION), mSensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }




}
