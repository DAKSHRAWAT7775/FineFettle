package com.example.finefettle.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.finefettle.R;
import com.example.finefettle.databinding.FragmentNotificationsBinding;



public class NotificationsFragment extends Fragment {
private EditText user_input;
private Button submit;
private TextView bot_reply;
    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        user_input=root.findViewById(R.id.textView3);
        submit=root.findViewById(R.id.button4);
        bot_reply=root.findViewById(R.id.textView5);
        View layoutView = root.findViewById(R.id.layout3);
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


        String text=user_input.getText().toString();


            if (text.contains("hi")) { // input Checking
                bot_reply.setText(replyMeth("Hi there"));
            } else if (text.contains("how are you")) {
                bot_reply.setText(replyMeth("I'm Good :).Thankyou for asking"));

            } else if (text.contains("viral")) {
                bot_reply.setText(replyMeth("Here are some remedies:" + "\n" + "1.Drink fluids" + "\n" + "2.Take plenty of rest" + "\n" + "3.Take an over-the-counter medication like aspirin,ibuprofen,acetaminophen,etc." + "\n" + "4.If your fever is greater than 103°F(39°C),then consult a doctor."));

            } else if (text.contains("so what else can you do?")) {
                bot_reply.setText(replyMeth("Actually i can't do anything lol, i am still in development"));

            }else if (text.contains("fever")) {
                bot_reply.setText(replyMeth("Here are some remedies:" + "\n" + "Medications such as paracetamol and ibuprofen may help to ease discomfort. Avoid giving children aspirin because this may cause a rare, serious condition."));
            }
            else if (text.contains("headache")) {
                bot_reply.setText(replyMeth("Here are some remedies:" + "\n" + "1.Drink plenty of water" + "\n" + "2.Drink caffeinated tea or coffee" + "\n" + "3.Take adequate sleep" + "\n" + "4.Take an over-the-counter medication like aspirin or ibuprofen or naproxen sodium"));

            } else if (text.contains("common cold")) {
                bot_reply.setText(replyMeth("Here are some remedies:" + "\n" + "1.Sip warm liquid" + "\n" + "2.Drink plenty of water" + "\n" + "3.Take adequate sleep" + "\n" + "4.Take an over-the-counter medication like aspirin or ibuprofen or acetaminophen"));

            } else if (text.contains("cough")) {
                bot_reply.setText(replyMeth("Here are some remedies:" + "\n" + "1.Sip warm liquid" + "\n" + "2.Drink plenty of water" + "\n" + "3.Take adequate sleep" + "\n" + "4.Take an over-the-counter medication like aspirin or ibuprofen or acetaminophen"));

            } else if (text.contains("acidity")) {
                bot_reply.setText(replyMeth("Here are some remedies:" + "\n" + "1.Drink lukewarm water" + "\n" + "2.Take one teaspoon of saunf powder with glass of warm water" + "\n" + "3.Eat and drink slowly" + "\n" + "4.Take an over-the-counter medication like digestine or rantac or phazyme"));

            } else if (text.contains("indigestion")) {
                bot_reply.setText(replyMeth("Here are some remedies:" + "\n" + "1.Drink lukewarm water" + "\n" + "2.Take one teaspoon of saunf powder with glass of warm water" + "\n" + "3.Eat and drink slowly" + "\n" + "4.Take an over-the-counter medication like digestine or rantac or phazyme"));

            } else if (text.contains("pain in left hand")) {
                bot_reply.setText(replyMeth("It may be symptom of heart attack!!,Immediately consult a doctor"));

            } else if (text.contains("bye")) {
                bot_reply.setText(replyMeth("Too Soon :( AnyWays" + "\n" + "STAY HOME STAY SAFE "));

            } else {
                bot_reply.setText(replyMeth("I Can't Understand"));
            }

        layoutView.setVisibility(View.VISIBLE);
            }
        });






        return root;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    public String replyMeth(String s) { // Reply Method
        return ("Chatbot-->"+s + "\n");
    }
}