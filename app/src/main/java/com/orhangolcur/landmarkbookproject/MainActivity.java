package com.orhangolcur.landmarkbookproject;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.orhangolcur.landmarkbookproject.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Landmark> landmarkArrayList;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //Initialize Binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        landmarkArrayList = new ArrayList<>();

        Landmark kizKulesi = new Landmark("Kız Kulesi", "Istanbul", R.drawable.kizkulesi);
        Landmark pisa = new Landmark("Pisa", "Italy", R.drawable.pisa);
        Landmark colesseum = new Landmark("Colleseum", "Italy", R.drawable.colesseum);
        Landmark eiffel = new Landmark("Eiffel", "France", R.drawable.eiffel);
        Landmark londonBridge = new Landmark("London Bridge", "UK", R.drawable.londonbridge);

        landmarkArrayList.add(kizKulesi);
        landmarkArrayList.add(pisa);
        landmarkArrayList.add(colesseum);
        landmarkArrayList.add(eiffel);
        landmarkArrayList.add(londonBridge);

        //RecyclerView
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LandmarkAdapter landmarkAdapter = new LandmarkAdapter(landmarkArrayList);
        binding.recyclerView.setAdapter(landmarkAdapter);

    }
}