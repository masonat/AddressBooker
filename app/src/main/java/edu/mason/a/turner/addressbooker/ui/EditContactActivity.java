package edu.mason.a.turner.addressbooker.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import edu.mason.a.turner.addressbooker.data.Contact;
import edu.mason.a.turner.addressbooker.data.ContactDatabase;
import edu.mason.a.turner.addressbooker.databinding.ActivityEditContactBinding;

public class EditContactActivity extends AppCompatActivity {

    private ActivityEditContactBinding binding;
    private Contact contact;
    private ContactDatabase db;
    private final String CONTACT_ID_KEY = "contact_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditContactBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        int contactId = getIntent().getIntExtra(CONTACT_ID_KEY, -1);


        db = ContactDatabase.getInstance(this);
        contact = db.contactDAO().getContactById(contactId);
        displayCurrentData(contact);

    }

    private void displayCurrentData(Contact contact) {
        binding.editName.setText(contact.getName());
        binding.editPostalAddress.setText(contact.getAddress());
        binding.editNumber.setText(contact.getNumber());
        binding.editEmail.setText(contact.getEmail());
        binding.editNotes.setText(contact.getNotes());
    }

    public Contact getUpdatedContactDetails() {
        contact.setName(binding.editName.getText().toString());
        contact.setAddress(binding.editPostalAddress.getText().toString());
        contact.setNumber(binding.editNumber.getText().toString());
        contact.setEmail(binding.editEmail.getText().toString());
        contact.setNotes(binding.editNotes.getText().toString());
        return contact;
    }

    public void saveContact(View view) {
        Contact contact = getUpdatedContactDetails();
        db.contactDAO().updateContact(contact);
        setResult(Activity.RESULT_OK);
        finish();
    }

    public void cancelContact(View view) { // returns to viewContact menu
        finish();
    }
}