package com.example.book;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.book.databinding.ActivityMain4Binding;
import com.example.book.databinding.ActivityMain6Binding;

public class MainActivity6 extends AppCompatActivity {

    ActivityMain6Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain6Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        replaceFragment(new HomeFragment());
        View bottomNav3 = findViewById(R.id.btv3);
        binding.btv3.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.home_menu) {
                replaceFragment(new HomeFragment());
            } else if (item.getItemId() == R.id.receipt_menu) {
                replaceFragment(new ReceiptFragment());
            } else if (item.getItemId() == R.id.profile_menu) {
                replaceFragment(new ProfileFragment());
            } else if (item.getItemId() == R.id.favorites_menu) {
                replaceFragment(new FavoritesFragment());
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl3, fragment).commit();
    }
}