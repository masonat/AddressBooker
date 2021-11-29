package edu.mason.a.turner.addressbooker;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

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
}