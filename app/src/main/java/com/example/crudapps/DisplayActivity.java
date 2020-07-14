package com.example.crudapps;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class DisplayActivity extends AppCompatActivity {

    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        myDb = new DatabaseHelper(this);

        Cursor res = myDb.getAllData();

        if(res.getCount()==0)
        {
            Toast.makeText(getApplicationContext(),"No Data",Toast.LENGTH_LONG).show();
        }
        else
        {
            StringBuffer buffer = new StringBuffer();
            while(res.moveToNext())    //it is like rs.next()
            {
                buffer.append("ID : "+res.getString(0));
                buffer.append("\nName : "+res.getString(1));
                buffer.append("\nAddress : "+res.getString(2));
                buffer.append("\nPhone : "+res.getString(3));
                buffer.append("\nEmail : "+res.getString(4)+"\n\n");
                showMessage("Data",buffer.toString());
            }
        }
    }

    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
