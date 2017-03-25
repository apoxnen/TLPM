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
     public Item item2 = new Item("", "", "");
     public Item item3 = new Item("", "", "");


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



    public boolean passwordIsLegit(String password){
        boolean validLength = password.length() >= 8;
        int upperCounter = 0;
        int lowerCounter = 0;
        int specialCounter = 0;
        int upperCounter_whole = 0;
        int lowerCounter_whole = 0;
        int specialCounter_whole = 0;
        boolean validChars = false;
        for(int i = 0; i < password.length(); i++){
            if(Character.isUpperCase(password.charAt(i))){
                upperCounter ++;
                upperCounter_whole ++;
                lowerCounter = 0;
                specialCounter = 0;
            }else if(Character.isLowerCase(password.charAt(i))){
                lowerCounter ++;
                lowerCounter_whole ++;
                upperCounter = 0;
                specialCounter = 0;
            }else{
                specialCounter ++;
                specialCounter_whole ++;
                upperCounter = 0;
                lowerCounter = 0;
            }
            validChars = (upperCounter < 3) &&
                    (lowerCounter < 3) &&
                    (specialCounter < 3) &&
                    (upperCounter_whole >= password.length()/4) &&
                    (lowerCounter_whole >= password.length()/4) &&
                    (specialCounter_whole >= password.length()/4);
        }
        return validChars && validLength;
    }













    public void addItem1(View v) {
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
        input1.setHint("Name");
        input2.setHint("Password");
        input3.setHint("Password for the password");
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

                if (m_Text2.matches(m_Text3)) {
                    ((TextView) findViewById(R.id.textView1)).setText("Password and passpassword can't be the same!");
                } else if (passwordIsLegit(m_Text3)) {
                    item1 = new Item(m_Text1, m_Text2, m_Text3);
                    ((TextView) findViewById(R.id.textView1)).setText(m_Text1);
                } else {
                    ((TextView) findViewById(R.id.textView1)).setText("Password for password doesn't meet all it's requirements");
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


/*        boolean valid = !itemNames.contains(name);
        if (valid) {
            Item item1 = (new Item(name, password, passpassword));
            itemNames.add(name);
            }
  */      }

    public void showPass1(View v) {

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

                    ((TextView) findViewById(R.id.textView1)).setText(item1.password);
                } else {
                    ((TextView) findViewById(R.id.textView1)).setText("WRONG PASSWORD ITEM DELETED");
                    item1 = new Item("","","");
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

//ITEM2



    public void addItem2(View v) {
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
        input1.setHint("Name");
        input2.setHint("Password");
        input3.setHint("Password for the password");
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

                if (m_Text2.matches(m_Text3)) {
                    ((TextView) findViewById(R.id.textView2)).setText("Password and passpassword can't be the same!");
                } else if (passwordIsLegit(m_Text3)) {
                    item2 = new Item(m_Text1, m_Text2, m_Text3);
                    ((TextView) findViewById(R.id.textView2)).setText(m_Text1);
                } else {
                    ((TextView) findViewById(R.id.textView2)).setText("Password for password doesn't meet all it's requirements");
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


/*        boolean valid = !itemNames.contains(name);
        if (valid) {
            Item item1 = (new Item(name, password, passpassword));
            itemNames.add(name);
            }
  */      }

    public void showPass2(View v) {

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

                if ( item2.passpassword.matches( m_TextPass ) ) {

                    ((TextView) findViewById(R.id.textView2)).setText(item2.password);
                } else {
                    ((TextView) findViewById(R.id.textView2)).setText("WRONG PASSWORD ITEM DELETED");
                    item2 = new Item("","","");
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



    //ITEM 3



    public void addItem3(View v) {
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
        input1.setHint("Name");
        input2.setHint("Password");
        input3.setHint("Password for the password");
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

                if (m_Text2.matches(m_Text3)) {
                    ((TextView) findViewById(R.id.textView3)).setText("Password and passpassword can't be the same!");
                } else if (passwordIsLegit(m_Text3)) {
                    item3 = new Item(m_Text1, m_Text2, m_Text3);
                    ((TextView) findViewById(R.id.textView3)).setText(m_Text1);
                } else {
                    ((TextView) findViewById(R.id.textView3)).setText("Password for password doesn't meet all it's requirements");
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


/*        boolean valid = !itemNames.contains(name);
        if (valid) {
            Item item1 = (new Item(name, password, passpassword));
            itemNames.add(name);
            }
  */      }

    public void showPass3(View v) {

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

                    ((TextView) findViewById(R.id.textView3)).setText(item1.password);
                } else {
                    ((TextView) findViewById(R.id.textView3)).setText("WRONG PASSWORD ITEM DELETED");
                    item3 = new Item("","","");
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






