package com.example.jojo.ui.function;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.jojo.R;

public class FunctionFragment extends Fragment {

    private FunctionViewModel functionViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        functionViewModel =
                ViewModelProviders.of(this).get(FunctionViewModel.class);
        View root = inflater.inflate(R.layout.fragment_function, container, false);
        final TextView textView = root.findViewById(R.id.text_function);
        functionViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}