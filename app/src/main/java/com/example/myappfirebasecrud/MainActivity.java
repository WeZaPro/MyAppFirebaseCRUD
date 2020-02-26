package com.example.myappfirebasecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText etInsert,etInsertNumber;
    Button btnInsert, btnSortData,btnRefresh,btnFilterData;
    FirebaseDatabase database;
    DatabaseReference myRef;
    MyModelData myModelData;
    public static String PathFolder = "user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInsert = findViewById(R.id.etInsert);
        etInsertNumber = findViewById(R.id.etInsertNumber);
        btnInsert = findViewById(R.id.btnInsert);
        btnSortData = findViewById(R.id.btnSortData);
        btnRefresh = findViewById(R.id.btnRefresh);
        btnFilterData = findViewById(R.id.btnFilterData);


        // Write a message to the database
        myRef = FirebaseDatabase.getInstance().getReference(PathFolder);

        MainFragment mainFragment = new MainFragment();
        if (savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction().add(R.id.contentContainer, mainFragment).commit();

        }

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(etInsert.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please insert data ",Toast.LENGTH_LONG).show();
                }else {
                    String key = myRef.push().getKey();
                    myModelData = new MyModelData(key,etInsertNumber.getText().toString(), etInsert.getText().toString());
                    myRef.child(key).setValue(myModelData);

                    Toast.makeText(getApplicationContext(), "insert success..." + myModelData.getName(), Toast.LENGTH_LONG).show();
                    etInsertNumber.setText("");
                    etInsert.setText("");
                }


            }
        });

        btnSortData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SortDataFragment sortDataFragment = new SortDataFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentContainer, sortDataFragment).commit();


            }
        });

        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainFragment mainFragment = new MainFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentContainer, mainFragment).commit();

            }
        });

        btnFilterData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FilerDataFragment filerDataFragment = new FilerDataFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentContainer, filerDataFragment).commit();

            }
        });

    }

}
