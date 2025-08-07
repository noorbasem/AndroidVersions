package com.example.androidversionsass;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.androidversionsass.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    List<AndroidVersion> versionList;
    AndroidVersionAdapter adapter;
    boolean sortByName = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        binding.recyclerViewVersions.setLayoutManager(new LinearLayoutManager(this));


        versionList = new ArrayList<>();
        versionList.add(new AndroidVersion(R.drawable.donut, "Donut", "1.6"));
        versionList.add(new AndroidVersion(R.drawable.eclair, "Éclair", "2.0 – 2.1"));
        versionList.add(new AndroidVersion(R.drawable.froyo, "Froyo", "2.2 – 2.2.3"));
        versionList.add(new AndroidVersion(R.drawable.gingerbread, "Gingerbread", "2.3 – 2.3.7"));
        versionList.add(new AndroidVersion(R.drawable.honeycomb, "Honeycomb", "3.0 – 3.2.6"));
        versionList.add(new AndroidVersion(R.drawable.icecream, "Ice Cream Sandwich", "4.0 – 4.0.4"));
        versionList.add(new AndroidVersion(R.drawable.jellybean, "Jelly Bean", "4.1 – 4.3.1"));
        versionList.add(new AndroidVersion(R.drawable.kitkat, "KitKat", "4.4 – 4.4.4"));
        versionList.add(new AndroidVersion(R.drawable.lollipop, "Lollipop", "5.0 – 5.1.1"));
        versionList.add(new AndroidVersion(R.drawable.marshmallow, "Marshmallow", "6.0 – 6.0.1"));
        versionList.add(new AndroidVersion(R.drawable.nouget, "Nougat", "7.0 – 7.1.2"));
        versionList.add(new AndroidVersion(R.drawable.oreo, "Oreo", "8.0 – 8.1"));


        adapter = new AndroidVersionAdapter(this, versionList);
        binding.recyclerViewVersions.setAdapter(adapter);


        binding.buttonSort.setOnClickListener(v -> {
            if (sortByName) {
                versionList.sort((v1, v2) -> v1.codeName.compareToIgnoreCase(v2.codeName));
                binding.buttonSort.setText("Sort by Version");
            } else {
                versionList.sort((v1, v2) -> v1.version.compareToIgnoreCase(v2.version));
                binding.buttonSort.setText("Sort by Name");
            }
            sortByName = !sortByName;
            adapter.notifyDataSetChanged();
        });
    }
}