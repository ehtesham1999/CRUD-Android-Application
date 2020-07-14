package com.example.crudapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    Button b6;
    EditText e5id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        myDb = new DatabaseHelper(this);

        b6 = findViewById(R.id.button5);
        e5id = findViewById(R.id.editText);

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int deletedrows = myDb.deleteData(e5id.getText().toString());
                if(deletedrows>0)
                    Toast.makeText(getApplicationContext(),"Deleted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(),"Record Not Found",Toast.LENGTH_LONG).show();
            }
        });
    }
}
