package edu.byui_cs.jjmn.ponderize;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.byui_cs.jjmn.ponderize.R;

import java.sql.Array;
import java.util.Stack;

public class PracticeActivity extends AppCompatActivity {

    private Stack indexRemove = new Stack();
    private String testVerse = "and it came to pass that the lord flooded the earth.";
    private String [] orignalVerse;
    private String [] displayVerse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        TextView aView = (TextView) findViewById(R.id.practiceView);
        aView.setText(testVerse);



        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                orignalVerse = testVerse.trim().split("\\s+");
                displayVerse = testVerse.trim().split("\\s+");

                CharSequence text = "Display array size: " + displayVerse.length;

                Toast toast = Toast.makeText(getApplicationContext(), text, 1);
                toast.show();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Auto generated, don't need.
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //Auto generated, don't need.
            }
        });
    }

    /**************************************
     * removeWords
     * Removes word from the verse to
     * practice memorizing.
     *************************************/

    public void removeWords() {

    }

    /**********************************
     * addWords
     * add words back to the string to
     * check your self.
     *********************************/
    public void addWords() {

    }
}
