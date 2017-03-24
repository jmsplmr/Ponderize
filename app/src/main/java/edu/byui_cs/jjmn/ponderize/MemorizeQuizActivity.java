package edu.byui_cs.jjmn.ponderize;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

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
  }
}
