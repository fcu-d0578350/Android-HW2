package com.example;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hong.homework2.R;

public class MainActivity extends AppCompatActivity {

    private EditText EditText;
    private Button Button;
    static final String KEY_ET_NAME = "KEY_ET_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



        EditText = (EditText)findViewById(R.id.EditText);
        Button = (Button)findViewById(R.id.Button);

        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input_str = EditText.getText().toString();
                EditText.setText("");
                input_str = input_str + " Say Hello!!";

                Toast.makeText(MainActivity.this,input_str,Toast.LENGTH_SHORT).show();
                /*
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,HelloActivity.class);
                intent.putExtra(KEY_ET_NAME,input_str);
                startActivity(intent);
*/


            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch(item.getItemId()){
            case R.id.action_about:
                AlertDialog.Builder ad = new AlertDialog.Builder(this);
                ad.setTitle("About this APP");
                ad.setMessage("Author: Wei-Cheng Hung");

                DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                };
                ad.setPositiveButton("OK",listener);
                ad.show();
                break;
            case R.id.action_settings:
                break;
            case R.id.action_reset:
                EditText.setText("");
                break;

        }
        /*
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }
}
