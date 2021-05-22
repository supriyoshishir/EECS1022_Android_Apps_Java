// Student Name: Supriyo Ghosh
// Student ID#: 215318728
// Lab D2 is done individually
// https://youtu.be/P9beGKv4cyo

package ca.yorku.mcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EntryForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mortgage_layout);
    }

    public void buttonClicked(View v) {
        String pS = ((EditText) findViewById(R.id.principleBox)).getText().toString();
        String aS = ((EditText) findViewById(R.id.amortizationBox)).getText().toString();
        String iS = ((EditText) findViewById(R.id.interestBox)).getText().toString();

        MortgageModel myModel = new MortgageModel(pS, aS, iS);
        String answer = myModel.computePayment();
        ((TextView) findViewById(R.id.answer)).setText(answer);
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(getApplicationContext(), "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(getApplicationContext(), "portrait", Toast.LENGTH_SHORT).show();
        }
    }
}