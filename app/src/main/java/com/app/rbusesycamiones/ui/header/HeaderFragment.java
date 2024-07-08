package com.app.rbusesycamiones.ui.header;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.rbusesycamiones.R;
import com.app.rbusesycamiones.databinding.FragmentHeaderBinding;
import com.app.rbusesycamiones.databinding.FragmentHomeBinding;
import com.app.rbusesycamiones.ui.home.HomeViewModel;

public class HeaderFragment extends Fragment {

    private FragmentHeaderBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HeaderViewModel headerViewModel =
                new ViewModelProvider(this).get(HeaderViewModel.class);

        binding = FragmentHeaderBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textViewHeader;
        headerViewModel.getText().observe(getViewLifecycleOwner(), textView :: setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}