package com.example.finefettle.ui.maps;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.finefettle.R;
import com.example.finefettle.databinding.FragmentMapsBinding;
import com.example.finefettle.ui.shop.ShopViewModel;

public class maps extends Fragment {

    private FragmentMapsBinding binding;
    private ImageButton button1;
    private ImageButton button2;
    private ImageButton button3;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MapsViewModel mapViewModel = new ViewModelProvider(this).get(MapsViewModel.class);

        binding = FragmentMapsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        button1 = root.findViewById(R.id.imageButton6);
        button2= root.findViewById(R.id.imageButton7);
        button3 = root.findViewById(R.id.imageButton8);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.google.com/maps/search/healthcare+facilities+near+me/@28.6883733,77.2892228,14z/data=!3m1!4b1";
                Intent intent1 = new Intent(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse(url));
                startActivity(intent1);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.google.com/maps/search/pharmacies+near+me/@28.6883733,77.2892228,14z/data=!3m1!4b1";
                Intent intent2 = new Intent(Intent.ACTION_VIEW);
                intent2.setData(Uri.parse(url));
                startActivity(intent2);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.google.com/maps?client=firefox-b-d&q=emergency+services+near+me&um=1&ie=UTF-8&sa=X&ved=2ahUKEwjpyMel6bz-AhUSSWwGHWawCggQ_AUoAXoECAEQAw";
                Intent intent3 = new Intent(Intent.ACTION_VIEW);
                intent3.setData(Uri.parse(url));
                startActivity(intent3);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
