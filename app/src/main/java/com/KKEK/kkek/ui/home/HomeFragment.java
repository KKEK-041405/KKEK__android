package com.KKEK.kkek.ui.home;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.KKEK.kkek.MainActivity;
import com.KKEK.kkek.R;
import com.KKEK.kkek.databinding.FragmentHomeBinding;
import com.google.android.material.snackbar.Snackbar;

import org.checkerframework.common.returnsreceiver.qual.This;

public class HomeFragment extends Fragment {


    public static int Count = 0;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        LinearLayout list = binding.list;
        for (int i = 0; i < 1000; i++) {
            TextView mes = new TextView(getContext());
            mes.setText(Integer.toString(i));
            list.addView(mes);
        }
        final ScrollView chat = binding.scrollView;

        final Button send = binding.send;
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView newmes = new TextView(getContext());
                String mes = binding.editTextText.getEditableText().toString();
                if (!mes.equals("")) {
                    Toast.makeText(getContext(), mes + "d", Toast.LENGTH_LONG);
                    newmes.setText(mes);
                    list.addView(newmes);

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                        chat.scrollToDescendant(newmes);
                    }
                    binding.editTextText.setText("");
                } else {
                    return;
                }
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