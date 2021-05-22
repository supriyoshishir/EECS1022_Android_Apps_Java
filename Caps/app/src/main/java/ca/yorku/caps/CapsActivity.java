// Student Name: Supriyo Ghosh
// Student ID#: 215318728
// Lab D5 is done individually
// https://youtu.be/bF01Xbz1Nn8

package ca.yorku.caps;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CapsActivity extends AppCompatActivity {

    private Game game;
    private String question;
    private String answer;
    private int score;
    private int qNum;
    private String log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caps_layout);
        this.game = new Game();
        this.score = 0;
        this.qNum = 1;
        this.log = "";
        ask();
    }

    private void ask() {
        String qa = game.qa();
        String[] pieces = qa.split("[\\n]+");
        this.question = pieces[0];
        this.answer = pieces[1];
        ((TextView) findViewById(R.id.question)).setText(this.question);
    }

    public void onDone(View v)
    {
        if (qNum > 10) {
            this.finish();
        }
        else {
            String userAnswer = ((EditText) findViewById(R.id.answer)).getText().toString().trim();

            if (userAnswer.equalsIgnoreCase(this.answer)) {
                this.score ++;
            }
            String logs;
            logs = "Q# " + this.qNum + ": " + this.question + "\n";
            logs += "Your answer: " + userAnswer.toUpperCase() + "\n";
            logs += "Correct Answer: " + this.answer + "\n";
            this.log = logs + "\n" + this.log;
            this.qNum++;
            String scoreString = "SCORE " + this.score;
            ((TextView) findViewById(R.id.score)).setText(scoreString);
            ((TextView) findViewById(R.id.log)).setText(this.log);

            if(qNum > 10) {
                String gameOver = "Game Over!";
                ((TextView) findViewById(R.id.qNum)).setText(gameOver);
                findViewById(R.id.done).setEnabled(false);
            }
            else {
                String qNumString = "Q# " + this.qNum;
                ((TextView) findViewById(R.id.qNum)).setText(qNumString);
                ask();
            }
        }
    }
}