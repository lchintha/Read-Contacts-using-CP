package com.example.chint.contentproviders;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int READ_CONTACTS = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClicked(View view) {
        askPermission(Manifest.permission.READ_CONTACTS,READ_CONTACTS);
    }

    private void askPermission(String permission, int requestCode){
        if(ContextCompat.checkSelfPermission(this,permission)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{permission}, requestCode);
        }else{
            //Toast.makeText(this, "Permission has already granted", Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, Contacts.class));
        }
    }
}
