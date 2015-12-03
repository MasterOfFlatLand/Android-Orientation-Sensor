package com.golshadi.orientationSensor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import com.golshadi.orientationSensor.sensors.Orientation;
import com.golshadi.orientationSensor.utils.OrientationSensorInterface;

/**
 * Created by majidGolshadi on 9/22/2014.
 */
public class TestActivity extends Activity implements OrientationSensorInterface{
	private Orientation orientationSensor;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
        orientationSensor = new Orientation(this.getApplicationContext(), this);
	}

    @Override
    protected void onResume() {
        super.onResume();

        //------Turn Orientation sensor ON-------
        // set tolerance for any directions
        orientationSensor.init(1.0, 1.0, 1.0);

        // set output speed and turn initialized sensor on
        // 0 Normal
        // 1 UI
        // 2 GAME
        // 3 FASTEST
        orientationSensor.on(2);
        //---------------------------------------


        // return true or false
        orientationSensor.isSupport();

    }
    
    @Override
    protected void onPause() {
        // turn orientation sensor off
        orientationSensor.off();
        
    	super.onPause();
    }

    @Override
    public void orientation(Double AZIMUTH, Double PITCH, Double ROLL) {
        Log.d("Azimuth",String.valueOf(AZIMUTH));
        Log.d("PITCH",String.valueOf(PITCH));
        Log.d("ROLL",String.valueOf(ROLL));
    }
}
