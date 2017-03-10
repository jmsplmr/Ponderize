package edu.byui_cs.jjmn.ponderize;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.byui_cs.jjmn.ponderize.R;

import java.util.Stack;

public class PracticeActivity extends AppCompatActivity {

    private Stack indexRemove = new Stack();
    private String verse = "and it came to pass that the lord flooded the earth.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        TextView aView = (TextView) findViewById(R.id.practiceView);
        aView.setText(verse);
    }
}
