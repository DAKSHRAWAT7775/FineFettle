package com.example.finefettle.ui.dashboard;



import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.finefettle.AlarmReceiver;
import com.example.finefettle.MainActivity3;
import com.example.finefettle.R;
import com.example.finefettle.databinding.FragmentDashboardBinding;

import java.util.Calendar;

public class DashboardFragment extends Fragment {
    private FragmentDashboardBinding binding;
    private TextView textView1;
    private EditText desc;
    private EditText medicine_name;
    private TimePicker timePicker;
    private Button buttonSetTime;

    private Button startButton;
    private Button stopButton;
    private PendingIntent pendingIntent;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        timePicker = root.findViewById(R.id.timePicker);
        startButton = root.findViewById(R.id.startButton);

        textView1 = root.findViewById(R.id.select_time_txt);
        medicine_name=root.findViewById(R.id.editText_med_name);
        desc=root.findViewById(R.id.optional_desc_input);


        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY, timePicker.getCurrentHour());
                calendar.set(Calendar.MINUTE, timePicker.getCurrentMinute());
                calendar.set(Calendar.SECOND, 0);

                Intent intent = new Intent(getContext(), AlarmReceiver.class);
                pendingIntent = PendingIntent.getBroadcast(getContext(), 0, intent, PendingIntent.FLAG_IMMUTABLE);
                MainActivity3.AlarmHolder.pendingIntent = pendingIntent;

                AlarmManager alarmManager = (AlarmManager) requireContext().getSystemService(Context.ALARM_SERVICE);
                alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

                String med_name=medicine_name.getText().toString();
                String med_desc=desc.getText().toString();
                int hour=timePicker.getHour();
                int minute=timePicker.getMinute();

                String msg="Reminder set for "+med_name+" at "+hour+":"+minute;
                Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();


            }
        });
        stopButton = root.findViewById(R.id.stopButton);
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // cancel the alarm
                AlarmManager alarmManager = (AlarmManager) requireContext().getSystemService(Context.ALARM_SERVICE);
                alarmManager.cancel(pendingIntent);




                // show a message and navigate back to home screen
                Toast.makeText(getContext(), "Reminder stopped", Toast.LENGTH_SHORT).show();
                Navigation.findNavController(v).navigate(R.id.home);
            }
        });



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public String getCurrentTime() {
        String currentTime = "Selected Time: " + timePicker.getHour() + ":" + timePicker.getMinute();
        return currentTime;
    }
}
