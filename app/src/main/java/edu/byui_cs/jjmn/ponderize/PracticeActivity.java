package edu.byui_cs.jjmn.ponderize;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.byui_cs.jjmn.ponderize.R;

import java.sql.Array;
import java.util.Iterator;
import java.util.Random;
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

        orignalVerse = testVerse.trim().split("\\s+");
        displayVerse = testVerse.trim().split("\\s+");

        TextView aView = (TextView) findViewById(R.id.practiceView);
        aView.setText(toString(displayVerse));



        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                CharSequence text = "Display array size: " + displayVerse.length;

                Toast toast = Toast.makeText(getApplicationContext(), text, 1);
                toast.show();

                int removeCompare = Math.round((progress / 100)) * displayVerse.length;
                Log.i("PraticeActivity", "Remove Compare: " + (progress / 100.0));

                if ( removeCompare > indexRemove.size()) {
                    Log.i("PractiveActivity", "indexReomve Size: " + indexRemove.size());

                    int removeCount = removeCompare - indexRemove.size();
                    removeWords(removeCount);
                }

                TextView aView = (TextView) findViewById(R.id.practiceView);
                String stringVerse = PracticeActivity.this.toString(displayVerse);
                aView.setText(stringVerse);

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

    public void removeWords(int wordRemoval) {

        //Remove a certain amount of words.
        for (int i = 0; i < wordRemoval; i++) {
            Random random = new Random();

            //Delete a random word.
            int wordIndex = random.nextInt(orignalVerse.length) + 1;
            Iterator<Integer> it = indexRemove.iterator();

            //Make sure that the random int we remove it not already removed.
            while (it.hasNext()) {
                if (it.next() == wordIndex) {
                    wordIndex = random.nextInt(orignalVerse.length) + 1;
                    it = indexRemove.iterator();
                }
            }

            //Remove word.
            String word = displayVerse[wordIndex];
            char [] charArray = word.toCharArray();

            for (int x = 1; i < charArray.length; i++)
                charArray[x] = '_';

            //Add modified word back.
            word = new String(charArray);
            displayVerse[wordIndex] = word;

            indexRemove.push(wordIndex);

            return;
        }

    }

    /**********************************
     * addWords
     * add words back to the string to
     * check your self.
     *********************************/
    public void addWords() {

    }

    /*******************************
     * toString
     * changes an array to string.
     *******************************/
    public String toString(String [] words) {
        StringBuilder builder = new StringBuilder();

        for(String word : words) {
            builder.append(word + " ");
        }

        return builder.toString();
    }
}
