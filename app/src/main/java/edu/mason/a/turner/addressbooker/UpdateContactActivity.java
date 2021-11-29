package edu.mason.a.turner.addressbooker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import edu.mason.a.turner.addressbooker.data.ContactDatabase;
import edu.mason.a.turner.addressbooker.databinding.ActivityUpdateContactBinding;

public class UpdateContactActivity extends AppCompatActivity {

    private ActivityUpdateContactBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUpdateContactBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

    }

    public void deleteContact(View view) {
        String deleteId = binding.nameTextView.getText().toString();
        ContactDatabase.getInstance(this).contactDAO().deleteUsingName(deleteId);
        setResult(Activity.RESULT_OK);
        finish();
    }

    public void goToMain(View view) { // implement Main Menu button
        finish();
    }
}