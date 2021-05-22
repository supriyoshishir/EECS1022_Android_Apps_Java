// Student Name: Supriyo Ghosh
// Student ID#: 215318728
// Lab D3 is done individually
// https://youtu.be/bF01Xbz1Nn8

package ca.yorku.mcalcpro;

import androidx.appcompat.app.AppCompatActivity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import ca.roumani.i2c.MPro;

public class MCalcPro_Activity extends AppCompatActivity implements TextToSpeech.OnInitListener, SensorEventListener {

    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mcalcpro_layout);
        this.tts = new TextToSpeech(this, this);
        SensorManager sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        sm.registerListener(this, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void buttonClicked(View v) {
        String cash_price = ((EditText) findViewById(R.id.pBox)).getText().toString();
        String amortization = ((EditText) findViewById(R.id.aBox)).getText().toString();
        String interest = ((EditText) findViewById(R.id.iBox)).getText().toString();

        try {
            MPro mp = new MPro();
            mp.setPrinciple(cash_price);
            mp.setAmortization(amortization);
            mp.setInterest(interest);

            String s = "Monthly Payment = " + mp.computePayment("%,.2f");
            String voiceOutput = s;
            tts.speak(voiceOutput, TextToSpeech.QUEUE_FLUSH, null);
            s += "\n\n";
            s += "By making this payments monthly for " + amortization + " years, " +
                    "the mortgage will be paid in full. But if you terminate the mortgage " +
                    "on its nth anniversary, the balance still owing depends on n as described below:";
            s += "\n\n";
            s += String.format("%8s", "n") + String.format("%16s", "Balance");
            s += "\n\n";
            // Iterate over an ArrayList using 'for each loop' instead of repeating the same lines of code.
            // Initializing ArrayList
            List<Integer> numbers = Arrays.asList(0,1,2,3,4,5,10,15,20);
            // For Each Loop for iterating ArrayList
            for (Integer i : numbers) {
                s += String.format("%8d", i) + mp.outstandingAfter(i, "%,16.0f");
                s += "\n\n";
            }
            /*s += String.format("%8d", 0) + mp.outstandingAfter(0, "%,16.0f");
            s += "\n\n";
            s += String.format("%8d", 1) + mp.outstandingAfter(1, "%,16.0f");
            s += "\n\n";
            s += String.format("%8d", 2) + mp.outstandingAfter(2, "%,16.0f");
            s += "\n\n";
            s += String.format("%8d", 3) + mp.outstandingAfter(3, "%,16.0f");
            s += "\n\n";
            s += String.format("%8d", 4) + mp.outstandingAfter(4, "%,16.0f");
            s += "\n\n";
            s += String.format("%8d", 5) + mp.outstandingAfter(5, "%,16.0f");
            s += "\n\n";
            s += String.format("%8d", 10) + mp.outstandingAfter(10, "%,16.0f");
            s += "\n\n";
            s += String.format("%8d", 15) + mp.outstandingAfter(15, "%,16.0f");
            s += "\n\n";
            s += String.format("%8d", 20) + mp.outstandingAfter(20, "%,16.0f");
            s += "\n\n";*/
            ((TextView) findViewById(R.id.output)).setText(s);
        }

        catch (Exception e) {
            //display e.getMessage();
            Toast label = Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT);
            label.show();
        }
    }

    public void onInit(int initStatus) {
        this.tts.setLanguage(Locale.US);
    }

    public void onAccuracyChanged(Sensor arg0, int arg1) {
    }

    public void onSensorChanged(SensorEvent event) {
        double ax = event.values[0];
        double ay = event.values[1];
        double az = event.values[2];
        double a = Math.sqrt(ax*ax + ay*ay + az*az);
        if (a > 10)
        {
            ((EditText) findViewById(R.id.pBox)).setText("");
            ((EditText) findViewById(R.id.aBox)).setText("");
            ((EditText) findViewById(R.id.iBox)).setText("");
            ((TextView) findViewById(R.id.output)).setText("");
        }
    }
}