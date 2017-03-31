package edu.byui_cs.jjmn.ponderize;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MemorizeQuizActivity extends AppCompatActivity {

  private String[] originalVerse;
  private String displayString;
  private List<String> testWords;
  int guessIndex;
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

    guessIndex = 0;
    Intent intent = getIntent();
    Verse = intent.getStringExtra(MainActivity.SCRIPTURE_TEXT);

    originalVerse = Verse.trim().split("\\s+");
    testWords = removeWords(originalVerse);
    displayString = toString(testWords);

    TextView title = (TextView) findViewById(R.id.quizTitle);
    title.setText(intent.getStringExtra(MainActivity.SCRIPTURE_TITLE));
    TextView quiz = (TextView) findViewById(R.id.quizContent);
    quiz.setText(displayString);
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

  public String toString(List<String> words) {
      StringBuilder stringBuilder = new StringBuilder();
      for (String word: words) {
          stringBuilder.append(word + " ");
      }
      return stringBuilder.toString();
  }

  public void updateQuiz(String answer) {
    answer = answer.toLowerCase();
    String compareWord = new String(originalVerse[guessIndex]);
    compareWord = compareWord.toLowerCase();

    if (answer.equals(compareWord)) {
      testWords.set(guessIndex, originalVerse[guessIndex]);
      guessIndex++;
      displayString = toString(testWords);
      TextView quiz = (TextView) findViewById(R.id.quizContent);
      quiz.setText(displayString);
    } else {
      Context context = getApplicationContext();
      CharSequence text = "Incorrect";
      int duration = Toast.LENGTH_SHORT;

      Toast toast = Toast.makeText(context, text, duration);
      toast.show();
    }
  }

  public void getAnswer(View view) {
    EditText editText = (EditText) findViewById(R.id.answerText);
    String answer = editText.getText().toString();
    editText.setText("");
    updateQuiz(answer);
  }
}
