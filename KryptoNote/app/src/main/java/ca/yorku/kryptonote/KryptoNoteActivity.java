// Student Name: Supriyo Ghosh
// Student ID#: 215318728
// Lab D4 is done individually
// https://youtu.be/Qw_0-hKNpjI

package ca.yorku.kryptonote;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class KryptoNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kryptonote_layout);
    }

    public void onEncrypt(View v) {
        try
        {
            String key = ((EditText) findViewById(R.id.key)).getText().toString();
            Cipher cipher = new Cipher(key);
            String note = ((EditText) findViewById(R.id.data)).getText().toString();
            String encrypted = cipher.encrypt(note);
            ((EditText) findViewById(R.id.data)).setText(encrypted);
            Toast.makeText(this,"Note Encrypted.",Toast.LENGTH_LONG).show();
        }
        catch (Exception e)
        {
            Toast label = Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG);
            label.show();
        }

    }

    public void onDecrypt(View v) {
        try {
            String key = ((EditText) findViewById(R.id.key)).getText().toString();
            Cipher cipher = new Cipher(key);
            String note = ((EditText) findViewById(R.id.data)).getText().toString();
            String decrypted = cipher.decrypt(note);
            ((EditText) findViewById(R.id.data)).setText(decrypted);
            Toast.makeText(this,"Note Decrypted.",Toast.LENGTH_LONG).show();
        }
        catch (Exception e)
        {
            Toast label = Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG);
            label.show();
        }
    }

    public void onSave(View v) {
        try
        {
            String name = ((EditText) findViewById(R.id.file)).getText().toString();
            File dir = this.getFilesDir();
            File file = new File(dir, name);
            FileWriter fw = new FileWriter(file);
            fw.write(((EditText) findViewById(R.id.data)).getText().toString());
            fw.close();
            Toast.makeText(this,"Note Saved.",Toast.LENGTH_LONG).show();
        }
        catch (Exception e)
        {
            Toast label = Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG);
            label.show();
        }
    }

    public void onLoad(View V) {
        try
        {
            String name = ((EditText) findViewById(R.id.file)).getText().toString();
            File dir = this.getFilesDir();
            File file = new File(dir, name);
            FileReader fr = new FileReader(file);
            String show ="";
            for (int c = fr.read();c!=-1;c=fr.read())
            {
                show+= (char) c;
            }
            fr.close();
            ((EditText) findViewById(R.id.data)).setText(show);
            Toast.makeText(this,"Note Loaded.",Toast.LENGTH_LONG).show();
        }
        catch (Exception e)
        {
            Toast label = Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG);
            label.show();
        }
    }
}