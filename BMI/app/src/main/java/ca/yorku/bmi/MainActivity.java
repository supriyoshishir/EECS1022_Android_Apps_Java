// Student Name: Supriyo Ghosh
// Student ID#: 215318728
// Lab D1 done individually
// https://youtu.be/Uj5MADIajRA

package ca.yorku.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ca.yorku.bmi.BMIMODEL.BMIModel;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClicked(View v)
    {
        EditText weightView = (EditText) findViewById(R.id.weightBox);
        String wS = weightView.getText().toString();
        EditText heightView = (EditText) findViewById(R.id.heightBox);
        String hS = heightView.getText().toString();

        double wD = BMIModel.toDouble(wS);
        double hD = BMIModel.toDouble(hS);
        double bmiD = BMIModel.getBMI(wD, hD);
        String bmiS = BMIModel.formatBMI(bmiD);
        ((TextView) findViewById(R.id.answer)).setText(bmiS);
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(getApplicationContext(), "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(getApplicationContext(), "portrait", Toast.LENGTH_SHORT).show();
        }
    }
}