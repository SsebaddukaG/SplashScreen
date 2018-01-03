package com.example.luckygilbert.splashscreen;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    /*SQLiteOpenHelper dbhelper;
    SQLiteDatabase db;
    Cursor cursor;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText _txtUserName = findViewById(R.id.username);
        final EditText _txtpassword = findViewById(R.id.passwad);
        Button _logBtn = findViewById(R.id.login_btn);

        _logBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                if(_txtUserName.getText().toString().trim().length()==0)
                {
                    _txtUserName.setError("you have entered a wrong user name");
                    _txtUserName.requestFocus();
                }

                if(_txtpassword.getText().toString().trim().length()==0)
                {
                    _txtpassword.setError("you have entered a wrong password");
                    _txtpassword.requestFocus();
                }
                else
                    {
                        Intent intent = new Intent(getApplicationContext(),LoginSucessActivity.class);
                        startActivity(intent);
                    }


            }
        });











   /* dbhelper = new SQLiteDBHelper(this);
       *//*SQLiteDatabase db = new dbhelper.getReadableDatabase();*/


       /* _logBtn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {

            }
        });
*/

    }
}
