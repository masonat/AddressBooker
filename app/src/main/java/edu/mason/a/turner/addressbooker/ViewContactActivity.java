package edu.mason.a.turner.addressbooker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ViewContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_contact);
    }

    public void mainMenu(View view) {
        Intent mainMenu = new Intent (this, MainActivity.class);
        startActivity (mainMenu);
    }
}