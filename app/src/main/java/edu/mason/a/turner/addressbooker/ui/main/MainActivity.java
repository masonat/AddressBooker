package edu.mason.a.turner.addressbooker.ui.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import edu.mason.a.turner.addressbooker.ViewContactActivity;
import edu.mason.a.turner.addressbooker.data.Contact;
import edu.mason.a.turner.addressbooker.data.ContactDatabase;
import edu.mason.a.turner.addressbooker.databinding.ActivityMainBinding;
import edu.mason.a.turner.addressbooker.ui.AddContactActivity;

public class MainActivity extends AppCompatActivity implements ContactAdapter.ContactSelectCallback {
    private final static int REQUEST_CODE_ADD_CONTACT = 1212;
    private final static String RESPONSE_KEY_ADD_CONTACT = "added_contact";
    private static final int REQUEST_CODE_UPDATE_CONTACT = 1214;


    private ActivityMainBinding binding;
    private ContactAdapter contactAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        List<Contact> contacts = ContactDatabase.getInstance(this).contactDAO().viewAllContacts();
        contactAdapter = new ContactAdapter(contacts, this);
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
        if (resultCode == Activity.RESULT_OK) {
            refreshData();
        }
    }

    @Override
    public void onSelectContact(Contact contact) {
        // open up details for proper row in database
        Intent updateIntent = new Intent(MainActivity.this, ViewContactActivity.class)
                .putExtra(ViewContactActivity.CONTACT_ID_KEY, contact.getId());

        startActivityForResult(updateIntent, REQUEST_CODE_UPDATE_CONTACT);
    }
}