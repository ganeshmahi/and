package com.example.ganesh.inventory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText input;
    TextView listTV;
    myDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input=(EditText)findViewById(R.id.input);
        listTV=(TextView)findViewById(R.id.listTV);
        dbHelper=new myDBHelper(this,null,null,1);
        printDatabase();
    }

    public void addButtonClicked(View v){
        if(v.getId() == R.id.addButton) {
            Items item = new Items(input.getText().toString());
            dbHelper.addItem(item);
            printDatabase();
        }
        }
    public void deleteButtonClicked(View v) {
        if (v.getId() == R.id.deleteButton) {
            String ip = input.getText().toString();
            dbHelper.deleteItem(ip);
            printDatabase();
        }
    }

    public void printDatabase(){
        String dataBase=dbHelper.dbToString();
        listTV.setText(dataBase);
        input.setText("");
    }
}
