package edu.mason.a.turner.addressbooker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import edu.mason.a.turner.addressbooker.data.Contact;
import edu.mason.a.turner.addressbooker.data.ContactDatabase;
import edu.mason.a.turner.addressbooker.databinding.ActivityEditContactBinding;

public class EditContactActivity extends AppCompatActivity {

    private ActivityEditContactBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        //displayCurrentData();
    }

    private void displayCurrentData(Contact contact) {
        binding.editTextPersonName2.setText(contact.getName());
        binding.editPostalAddress.setText(contact.getAddress());
        binding.editNumber.setText(contact.getNumber());
        binding.editEmail.setText(contact.getEmail());
        binding.editNotes.setText(contact.getNotes());
    }

    public Contact getUpdatedContactDetails(Contact contact) {

        contact.setName(binding.editTextPersonName2.getText().toString());
        contact.setAddress(binding.editPostalAddress.getText().toString());
        contact.setNumber(binding.editNumber.getText().toString());
        contact.setEmail(binding.editEmail.getText().toString());
        contact.setNotes(binding.editNotes.getText().toString());
        return contact;
    }

    public void saveContact(View view) {
//        Contact contact = getUpdatedContactDetails(contact);
//        db.contactDAO().updateContact(contact);
//        finish();
    }

    public void cancelContact(View view) { // returns to viewContact menu
        finish();
    }
}