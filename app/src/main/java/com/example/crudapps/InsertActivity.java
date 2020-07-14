package com.example.crudapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    Button b5;
    EditText e1name,e2address,e3phone,e4email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        myDb = new DatabaseHelper(this);
        b5 = findViewById(R.id.button5);

        e1name = findViewById(R.id.editText);
        e2address = findViewById(R.id.editText2);
        e3phone = findViewById(R.id.editText3);
        e4email = findViewById(R.id.editText4);

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean result = myDb.insertData(e1name.getText().toString(),e2address.getText().toString(),e3phone.getText().toString(),e4email.getText().toString());
                if(result==false)
                    Toast.makeText(getApplicationContext(),"Could not insert",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG).show();
            }
        });
    }
}
