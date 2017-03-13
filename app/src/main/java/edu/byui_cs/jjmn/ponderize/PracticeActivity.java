package edu.byui_cs.jjmn.ponderize;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import com.byui_cs.jjmn.ponderize.R;

import java.util.Iterator;
import java.util.Random;
import java.util.Stack;

public class PracticeActivity extends AppCompatActivity {

    private Stack indexStack = new Stack();
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

                int removeCompare = (int) ((progress / 100.0) * displayVerse.length);

                if ( removeCompare > indexStack.size() ) {
                    int removeCount = removeCompare - indexStack.size();
                    removeWords(removeCount);
                } else if ( removeCompare < indexStack.size() ) {
                    int addCount = indexStack.size() - removeCompare;
                    addWords(addCount);
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
            int wordIndex = random.nextInt(orignalVerse.length);
            Iterator<Integer> it = indexStack.iterator();

            //Make sure that the random int we remove it not already removed.
            while (it.hasNext()) {
                if (it.next() == wordIndex) {
                    wordIndex = random.nextInt(orignalVerse.length);
                    it = indexStack.iterator();
                }
            }

            //Remove word.
            String word = displayVerse[wordIndex];
            char [] charArray = word.toCharArray();

            for (int x = 1; x < charArray.length; x++)
                charArray[x] = '_';

            //Add modified word back.
            word = new String(charArray);
            displayVerse[wordIndex] = word;

            indexStack.push(wordIndex);

            return;
        }

    }

    /**********************************
     * addWords
     * add words back to the string to
     * check your self.
     *********************************/
    public void addWords(int addCount) {
        for (int i = 0; i < addCount; i++) {
            int wordIndex = (int) indexStack.pop();
            displayVerse[wordIndex] = orignalVerse[wordIndex];
        }

        return;
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
