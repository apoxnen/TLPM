package fi.me.tlpm;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ActivityChooserView;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.*;

import java.util.ArrayList;

import static android.R.id.list;

/**Created by Ari-Pekka Härkönen 24.3.2017
* */

public class MainActivity extends Activity {

        //LIST  FOR THE ITEMS:
        public Item item1 = new Item("", "", "");


    //LIST OF ARRAY STRINGS WHICH WILL SERVE AS LIST ITEMS
    ArrayList<String> itemNames=new ArrayList<String>();

    private String m_Text1 = "";
    private String m_Text2 = "";
    private String m_Text3 = "";
    private String m_TextPass = "";

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);

    }

    public void addItem(View v) {
        String name, password, passpassword;

        LinearLayout layout = new LinearLayout(v.getContext());
        layout.setOrientation(LinearLayout.VERTICAL);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Give name, password and passpassword");

        // Set up the input
        final EditText input1 = new EditText(this);
        final EditText input2 = new EditText(this);
        final EditText input3 = new EditText(this);
        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input1.setInputType(InputType.TYPE_CLASS_TEXT);
        input2.setInputType(InputType.TYPE_CLASS_TEXT);
        input3.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        layout.addView(input1);
        layout.addView(input2);
        layout.addView(input3);

        builder.setView(layout);


        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                m_Text1 = input1.getText().toString();
                m_Text2 = input2.getText().toString();
                m_Text3 = input3.getText().toString();

                item1 = new Item(m_Text1, m_Text2, m_Text3);

                ((TextView) findViewById(R.id.textView)).setText(m_Text1);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
        

/*        boolean valid = !itemNames.contains(name);
        if (valid) {
            Item item1 = (new Item(name, password, passpassword));
            itemNames.add(name);
            }
  */      }

    public void showPass(View v) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Password:");

        // Set up the input
        final EditText input = new EditText(this);
        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                m_TextPass = input.getText().toString();

                if ( item1.passpassword.matches( m_TextPass ) ) {

                    ((TextView) findViewById(R.id.textView)).setText(item1.password);
                } else {
                    ((TextView) findViewById(R.id.textView)).setText("WRONG PASSWORD ITEM DELETED");
                    //item1 = new Item("","","");
                }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();

    }



    }






