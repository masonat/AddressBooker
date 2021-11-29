package edu.mason.a.turner.addressbooker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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

        Intent viewContactActivity = new Intent (this, ViewContactActivity.class);

        String name = binding.editTextPersonName.getText().toString();
        String address = binding.editTextPostalAddress.getText().toString();
        String phone = binding.editTextPhone.getText().toString();
        String email = binding.editTextEmailAddress.getText().toString();
        String notes = binding.editTextNotes.getText().toString();

        viewContactActivity.putExtra ("name", name);
        viewContactActivity.putExtra ("address", address);
        viewContactActivity.putExtra ("phone", phone);
        viewContactActivity.putExtra ("email", email);
        viewContactActivity.putExtra ("notes", notes);

        startActivity (viewContactActivity);

    }

    public void cancelContact (View view) {
        Intent mainMenuActivity = new Intent (this, MainActivity.class);
        startActivity (mainMenuActivity);
    }

    public void clearFields(View view) {
        binding.editTextPersonName.setText("");
        binding.editTextPostalAddress.setText("");
        binding.editTextPhone.setText("");
        binding.editTextEmailAddress.setText("");
        binding.editTextNotes.setText("");
    }

}