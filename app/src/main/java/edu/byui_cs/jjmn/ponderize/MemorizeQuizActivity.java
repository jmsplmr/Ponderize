package edu.byui_cs.jjmn.ponderize;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MemorizeQuizActivity extends AppCompatActivity {

  private String[] originalVerse;
  private String[] displayVerse;
  String Verse;

  /**
   * {@inheritDoc}
   *
   * @param savedInstanceState
   */
  @Override
  protected void onCreate (Bundle savedInstanceState) {
    Log.v (getClass ().getSimpleName (), "Open MemorizeQuiz activity.");
    super.onCreate (savedInstanceState);
    setContentView (R.layout.activity_memorize_quiz);

    Intent intent = getIntent();
    Verse = intent.getStringExtra(MainActivity.SCRIPTURE_TEXT);

    originalVerse = Verse.trim().split("\\s+");
    List<String> testWords = removeWords(originalVerse);

    TextView title = (TextView) findViewById(R.id.quizTitle);
    title.setText(intent.getStringExtra(MainActivity.SCRIPTURE_TITLE));
  }

  private List<String> removeWords(String [] words) {
    List<String> testWords = new ArrayList<String>();
    char [] charWord;
    for (int i = 0; i < words.length; i++) {
        charWord = words[i].toCharArray();

      for (int j = 0; j < charWord.length; j++)
          charWord[j] = '_';
      testWords.add(new String(charWord));
    }
    return testWords;
  }

  
}
