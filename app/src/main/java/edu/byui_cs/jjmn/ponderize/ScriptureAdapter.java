package edu.byui_cs.jjmn.ponderize;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.byui_cs.jjmn.ponderize.R;
import java.util.ArrayList;

/**
 * Created by Joseph on 2/24/17.
 */

public class ScriptureAdapter extends ArrayAdapter<ScriptureContainer> {

    /*************************************************************************************
     * Constructor
     ************************************************************************************/
    public ScriptureAdapter(Context context, ArrayList<ScriptureContainer> scriptures) {
        super(context, 0, scriptures);
    }

    /*************************************************************************************
     * View - returns view
     ************************************************************************************/
@Override
    public View getView(int position, View convertView, ViewGroup parent) {

    // get the data item for position
    ScriptureContainer scripture = getItem(position);

    // Check if an existing view is being reused, otherwise inflate a new view from custom row layout
    if (convertView == null) {

        convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_row, parent, false);
    }

    // Grab References
    TextView scriptureTitle = (TextView) convertView.findViewById(R.id.list_item_scripture_title);
    TextView scriptureText = (TextView) convertView.findViewById(R.id.list_item_scripture_text);

    // Make the data appear
    scriptureTitle.setText(scripture.toString());
    scriptureText.setText("Scripture Text Here"); // Implement Later

    // Returns View
    return convertView;
    }
}
