package edu.mason.a.turner.addressbooker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import edu.mason.a.turner.addressbooker.data.Contact;
import edu.mason.a.turner.addressbooker.data.ContactDatabase;
import edu.mason.a.turner.addressbooker.databinding.ActivityUpdateContactBinding;
import edu.mason.a.turner.addressbooker.ui.main.MainActivity;

public class UpdateContactActivity extends AppCompatActivity {

    public static final String CONTACT_ID_KEY = "contact_id";
    private ActivityUpdateContactBinding binding;
    private ContactDatabase db;
    private Contact contact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUpdateContactBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // retrieve the contact id passed to the activity
        int contactId = getIntent().getIntExtra(CONTACT_ID_KEY, -1);

        db = ContactDatabase.getInstance(this);
        contact = db.contactDAO().getContactById(contactId);
        displayContact(contact);
    }

    private void displayContact(Contact contact) {
        binding.nameTextView.setText(contact.getName());
        binding.addressTextView.setText(contact.getAddress());
        binding.phoneTextView.setText(contact.getNumber());
        binding.notesTextView.setText(contact.getNotes());
        binding.emailTextView.setText(contact.getEmail());
    }

   /* public void saveContact(View view) {
        Contact contact = getUpdatedContactDetails();
        db.contactDAO().updateContact(contact);
        setResult(Activity.RESULT_OK);
        finish();
    }

    public Contact getUpdatedContactDetails() {
        contact.setName(binding.nameTextView.getText().toString());
        contact.setAddress(binding.addressTextView.getText().toString());
        contact.setNumber(binding.phoneTextView.getText().toString());
        contact.setEmail(binding.emailTextView.getText().toString());
        contact.setNotes(binding.notesTextView.getText().toString());
        return contact;
    }*/

    public void editContact (View view) {

    }

    public void deleteContact(View view) {
        // removes contact from db
        db.contactDAO().deleteContact(contact);
        setResult(Activity.RESULT_OK);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setResult(Activity.RESULT_CANCELED);
        finish();
    }
}