package com.example.finefettle.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.finefettle.CourseAdapter;
import com.example.finefettle.CourseModel;
import com.example.finefettle.R;
import com.example.finefettle.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<String> facts = Arrays.asList(
            "The amount of carbon in the human body is enough to fill about 9,000 lead pencils",
            " The human body has less muscles in it than a caterpillar",
            "Human teeth are almost as hard as rocks!",
            " Women have a keener sense of smell than men",
            "Brown eggs are not more nutritious than white eggs — it just means they came from a difference breed",
            "20% of all airline passengers catch a cold after a two-hour flight!",
            "A tip for mindful eating — make sure every meal is at least half veggies and/or fruit",
            "Cucumbers are 96% water and keep you hydrated",
            "Good posture when sitting increases your self-confidence — try it!"
    );


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        RecyclerView courseRV = root.findViewById(R.id.idRVCourse);

        // Here, we have created new array list and added data to it
        ArrayList<CourseModel> courseModelArrayList = new ArrayList<CourseModel>();
        courseModelArrayList.add(new CourseModel("The amount of carbon in the human body is enough to fill about 9,000 lead pencils", 4, R.drawable.fact_));
        courseModelArrayList.add(new CourseModel( " The human body has less muscles in it than a caterpillar", 3, R.drawable.fact_));
        courseModelArrayList.add(new CourseModel("Human teeth are almost as hard as rocks!", 4, R.drawable.fact_));
        courseModelArrayList.add(new CourseModel( " Women have a keener sense of smell than men", 4, R.drawable.fact_));
        courseModelArrayList.add(new CourseModel("Brown eggs are not more nutritious than white eggs — it just means they came from a difference breed", 4, R.drawable.fact_));
        courseModelArrayList.add(new CourseModel( "20% of all airline passengers catch a cold after a two-hour flight!", 4, R.drawable.fact_));
        courseModelArrayList.add(new CourseModel("Good posture when sitting increases your self-confidence — try it!", 4, R.drawable.fact_));

        // we are initializing our adapter class and passing our arraylist to it.
        CourseAdapter courseAdapter = new CourseAdapter(getContext(), courseModelArrayList);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        courseRV.setLayoutManager(linearLayoutManager);
        courseRV.setAdapter(courseAdapter);


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}