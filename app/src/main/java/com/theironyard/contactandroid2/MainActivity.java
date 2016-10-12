package com.theironyard.contactandroid2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    ListView listView;
    EditText name;
    EditText phoneNumber;
    Button onAdd;

    ArrayAdapter<Contact> contacts;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        name = (EditText) findViewById(R.id.name);
        phoneNumber = (EditText) findViewById(R.id.phoneNumber);
        onAdd = (Button) findViewById(R.id.onAdd);
        contacts = new ArrayAdapter<Contact>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(contacts);

        onAdd.setOnClickListener(this);
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String contactName = name.getText().toString();
        String contactNumber = phoneNumber.getText().toString();
        if (!contactName.isEmpty() && !contactNumber.isEmpty()) {
            Contact contact = new Contact(contactName,contactNumber);
            contacts.add(contact);
            name.setText("");
            phoneNumber.setText("");
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Contact contact = contacts.getItem(position);
        contacts.remove(contact);
        return true;
    }
}
