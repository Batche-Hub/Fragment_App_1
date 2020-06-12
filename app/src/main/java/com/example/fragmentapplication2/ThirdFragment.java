package com.example.fragmentapplication2;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;

public class ThirdFragment extends Fragment {

    private OnFragmentCommunicationListener mListener;
    private static final String TAG = "ThirdFragment";
     private TextView ageTextview;
    private TextView phraseBienvenue;
    private TextView titreChange;
    private Button boutonchanger;

    public ThirdFragment() {
        // Required empty public constructor
    }


    public static ThirdFragment newInstance() {
        return new ThirdFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_third, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ageTextview = view.findViewById(R.id.textViewAge);
        phraseBienvenue = view.findViewById(R.id.textViewPhraseAccroche);
        titreChange = view.findViewById(R.id.editTextChangerTitre);

        titreChange.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mListener.onTitleChange(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        boutonchanger = view.findViewById(R.id.button);
        boutonchanger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(titreChange.getText()!= null)
                    onTitleChange(titreChange.getText().toString());
            }
        });
    }

    public void onAgeChange(String age){
        ageTextview.setText(age+"an(s)");
    }

    public void onTitleChange(String title){
        getActivity().setTitle(title);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {
            mListener = (ThirdFragment.OnFragmentCommunicationListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentCommunicationListener");
        }
    }

    public interface OnFragmentCommunicationListener {
        void onTitleChange(String title);
    }
}
