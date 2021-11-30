package edu.mason.a.turner.addressbooker.ui.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.mason.a.turner.addressbooker.R;
import edu.mason.a.turner.addressbooker.UpdateContactActivity;
import edu.mason.a.turner.addressbooker.data.Contact;
import edu.mason.a.turner.addressbooker.data.ContactDatabase;
import edu.mason.a.turner.addressbooker.databinding.ActivityMainBinding;
import edu.mason.a.turner.addressbooker.ui.AddContactActivity;

public class MainActivity extends AppCompatActivity {
    private final static int REQUEST_CODE_ADD_CONTACT = 1212;
    private final static String RESPONSE_KEY_ADD_CONTACT = "added_contact";


    private ActivityMainBinding binding;
    private ContactAdapter contactAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        List<Contact> contacts = ContactDatabase.getInstance(this).contactDAO().viewAllContacts();
        contactAdapter = new ContactAdapter(contacts);
        setupView();
    }

    private void setupView() {
        binding.recyclerView.setAdapter(contactAdapter);
        binding.addButton.setOnClickListener(v -> MainActivity.this.startActivityForResult(
                new Intent( MainActivity.this, AddContactActivity.class),
                REQUEST_CODE_ADD_CONTACT

        ));
    }

    private void refreshData() {
        List<Contact> contacts = ContactDatabase.getInstance(this).contactDAO().viewAllContacts();
        contactAdapter.updateContactList(contacts);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_ADD_CONTACT && resultCode == Activity.RESULT_OK) {
            refreshData();
        }
    }

    public void goToDetails(View view) {
        Button Button = findViewById(R.id.detailsButton);
        // open up details for proper row in database
        Button.setOnClickListener(v -> startActivity
                (new Intent(MainActivity.this, UpdateContactActivity.class)));
    }
}