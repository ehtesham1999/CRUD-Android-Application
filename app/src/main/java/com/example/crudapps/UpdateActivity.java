package com.example.crudapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    Button b6;
    EditText e1name,e2address,e3phone,e4email,e5id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        myDb = new DatabaseHelper(this);

        b6 = findViewById(R.id.button5);

        e1name = findViewById(R.id.editText);
        e2address = findViewById(R.id.editText2);
        e3phone = findViewById(R.id.editText3);
        e4email = findViewById(R.id.editText4);
        e5id = findViewById(R.id.editText5);

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(e5id.getText().toString() == "")
                {
                    Toast.makeText(getApplicationContext(),"Enter ID",Toast.LENGTH_LONG).show();
                }
                boolean isupdated = myDb.updateData(e5id.getText().toString(),e1name.getText().toString(),e2address.getText().toString(),e3phone.getText().toString()
                ,e4email.getText().toString());

                if(isupdated==true)
                    Toast.makeText(getApplicationContext(),"Updated",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(),"Not Updated",Toast.LENGTH_LONG).show();

            }
        });

    }
}
