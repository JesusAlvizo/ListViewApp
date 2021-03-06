package com.jesusalvizo.listview1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;
    private EditText textInput;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                evaluar();
                adapter.notifyDataSetChanged();
                textInput.setText("");

            }

            public void evaluar() {
                if (textInput.getText().toString().isEmpty()) {
                    return;
                }else{
                    String newItem = textInput.getText().toString();
                    arrayList.add(newItem);
                }
            }
        });

        final ListView listView = (ListView) findViewById(R.id.listView);
        String[] items = {"E.g. Apple", "E.g. Banana"};
        arrayList = new ArrayList<>(Arrays.asList(items));
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.textInput, arrayList);
        listView.setAdapter(adapter);
        textInput = (EditText) findViewById(R.id.textInput);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                listView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(intent);
                    }
                });

            }


        });

    }
}