package edu.mason.a.turner.addressbooker.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import edu.mason.a.turner.addressbooker.ui.main.MainActivity;
import edu.mason.a.turner.addressbooker.data.Contact;
import edu.mason.a.turner.addressbooker.data.ContactDatabase;
import edu.mason.a.turner.addressbooker.databinding.ActivityAddContactBinding;

public class AddContactActivity extends AppCompatActivity {

    private ActivityAddContactBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddContactBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }

    public void saveContact (View view) {

//        Intent mainMenuActivity = new Intent (this, MainActivity.class);

        String name = binding.editTextPersonName.getText().toString();
        String address = binding.editTextPostalAddress.getText().toString();
        String phone = binding.editTextPhone.getText().toString();
        String email = binding.editTextEmailAddress.getText().toString();
        String notes = binding.editTextNotes.getText().toString();

        // name, address, number, email, notes
        Contact contact = new Contact(name, address, phone, email, notes);

        // get reference to db and save record
        ContactDatabase.getInstance(this).contactDAO().insertContact(contact);

        setResult(Activity.RESULT_OK);
        finish();
    }

    public void cancelContact (View view) {
        Intent MainActivity = new Intent (this, MainActivity.class);
        startActivity (MainActivity);
    }

    public void clearFields(View view) {
        binding.editTextPersonName.setText("");
        binding.editTextPostalAddress.setText("");
        binding.editTextPhone.setText("");
        binding.editTextEmailAddress.setText("");
        binding.editTextNotes.setText("");
    }

}