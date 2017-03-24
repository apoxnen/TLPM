package fi.me.tlpm;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.*;

import java.util.ArrayList;



public class MainActivity extends ListActivity {


        //LIST OF ARRAY STRINGS WHICH WILL SERVE AS LIST ITEMS
        ArrayList<String> listItems=new ArrayList<String>();


        //DEFINING A STRING ADAPTER WHICH WILL HANDLE THE DATA OF THE LISTVIEW
        ArrayAdapter<String> adapter;

        //RECORDING HOW MANY TIMES THE BUTTON HAS BEEN CLICKED
        int clickCounter=0;

        @Override
        public void onCreate(Bundle icicle) {
            super.onCreate(icicle);
            setContentView(R.layout.activity_main);
            adapter=new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1,
                    listItems);
            setListAdapter(adapter);
        }

        //METHOD WHICH WILL HANDLE DYNAMIC INSERTION
        public void addItems(View v) {

            final String[] m_Text1 = {""};
            final String[] m_Text2 = {""};
            final String[] m_Text3 = {""};

            AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
            builder.setTitle("Add new Password for safekeeping");

            Context context = v.getContext();
            LinearLayout layout = new LinearLayout(context);
            layout.setOrientation(LinearLayout.VERTICAL);

            // Set up the input
            final EditText input1 = new EditText(this);
            input1.setInputType(InputType.TYPE_CLASS_TEXT);
            layout.addView(input1);

            final EditText input2 = new EditText(this);
            input2.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
            layout.addView(input2);

            final EditText input3 = new EditText(this);
            // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
            input3.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
            layout.addView(input3);

            builder.setView(layout);

            // Set up the buttons
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    m_Text1[0] = input1.getText().toString();
                    m_Text2[0] = input2.getText().toString();
                    m_Text3[0] = input3.getText().toString();
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            builder.show();




            adapter.add(m_Text1[0]);
//            adapter.add(m_Text[1]);
//            adapter.add(m_Text[2]);
        }
    }

