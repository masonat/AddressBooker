package edu.mason.a.turner.addressbooker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import edu.mason.a.turner.addressbooker.data.Contact;
import edu.mason.a.turner.addressbooker.data.ContactDatabase;
import edu.mason.a.turner.addressbooker.ui.main.MainActivity;
import edu.mason.a.turner.addressbooker.databinding.ActivityEditContactBinding;

public class EditContactActivity extends AppCompatActivity {

    private ActivityEditContactBinding binding;

    public void saveContact (View view) {

        String name = binding.editTextPersonName2.getText().toString();
        String address = binding.editTextPostalAddress2.getText().toString();
        String phone = binding.editTextPhone2.getText().toString();
        String email = binding.editTextEmailAddress2.getText().toString();
        String notes = binding.editTextNotes2.getText().toString();

        if (name.equals("")) {
            Toast.makeText(this, "Please enter name.", Toast.LENGTH_LONG).show();
        }
        else if (phone.equals("")) {
            Toast.makeText(this, "Please enter phone number.", Toast.LENGTH_LONG).show();
        }
        else {
            // name, address, number, email, notes
            Contact contact = new Contact(name, address, phone, email, notes);

            // get reference to db and save record
            ContactDatabase.getInstance(this).contactDAO().updateContact(contact);

            setResult(Activity.RESULT_OK);
            finish();
        }

    }

    public void cancelContact (View view) {
        Intent MainActivity = new Intent (this, MainActivity.class);
        startActivity (MainActivity);
    }

}
