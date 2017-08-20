package com.example.chint.contentproviders;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v4.content.ContentResolverCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Contacts extends AppCompatActivity {

    List<String> array = new ArrayList<>();
    ListView listView;
    String[] columns = new String[]{ContactsContract.Contacts.DISPLAY_NAME};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        listView = (ListView)findViewById(R.id.lview);

        ContentResolver cr = getContentResolver();
        Cursor cursor = cr.query((ContactsContract.Contacts.CONTENT_URI), columns, null, null, null);
        if(cursor != null && cursor.getCount() > 0 ){
            while (cursor.moveToNext()){
                StringBuffer sb = new StringBuffer();
                sb = sb.append(cursor.getString(0));
                array.add(sb.toString());
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array);
            listView.setAdapter(adapter);
        }
        else
            Toast.makeText(this, "You Have no Contacts", Toast.LENGTH_SHORT).show();
    }
}
