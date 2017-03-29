package edu.byui_cs.jjmn.ponderize;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MemorizeQuizActivity extends AppCompatActivity {
  
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

    TextView title = (TextView) findViewById(R.id.quizTitle);
    TextView quizContent = (TextView) findViewById(R.id.quizContent);

    title.setText(intent.getStringExtra(MainActivity.SCRIPTURE_TITLE));
    quizContent.setText(intent.getStringExtra(MainActivity.SCRIPTURE_TEXT));
  }
}
