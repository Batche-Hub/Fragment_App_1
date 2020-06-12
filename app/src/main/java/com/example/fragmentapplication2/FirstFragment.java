package com.example.fragmentapplication2;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.fragmentapplication2.R;
import com.google.android.material.textfield.TextInputEditText;

public class FirstFragment extends Fragment {

    private OnFragmentCommunicationListener mListener;
    public FirstFragment() {
        // Required empty public constructor
    }
    /**
     * Create a new instance of this fragment
     *
     * @return A new instance of fragment FirstFragment.
     */
    public static FirstFragment newInstance() {
        return new FirstFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        TextInputEditText nameEditText = view.findViewById(R.id.textInputTextName);
        TextInputEditText emailEditText = view.findViewById(R.id.textInputTextEmail);
        TextInputEditText ageEditText = view.findViewById(R.id.textInputTextAge);

        nameEditText.addTextChangedListener(new TextWatcher() {

            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mListener.onNameChange(charSequence.toString());
            }

            @Override public void afterTextChanged(Editable editable) {
            }
        });

        emailEditText.addTextChangedListener(new TextWatcher() {

            @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mListener.onEmailChange(charSequence.toString());
            }

            @Override public void afterTextChanged(Editable editable) {
            }
        });

        ageEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mListener.onAgeChange(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentCommunicationListener) {
            mListener = (OnFragmentCommunicationListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentCommunicationListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity
     */
    public interface OnFragmentCommunicationListener {
        void onNameChange(String name);
        void onEmailChange(String email);
        void onAgeChange(String age);
    }
}