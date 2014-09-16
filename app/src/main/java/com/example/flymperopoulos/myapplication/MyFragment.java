package com.example.flymperopoulos.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by flymperopoulos on 9/11/2014.
 */
public class MyFragment extends Fragment {

        public MyFragment() {}

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_my, container, false);

            final EditText myText = (EditText) rootView.findViewById(R.id.text_to_add);

            Button myButton = (Button) rootView.findViewById(R.id.add_button);

            final ListView leftListView = (ListView) rootView.findViewById(R.id.left_list_view);
            final ListView rightListView = (ListView) rootView.findViewById(R.id.right_list_view);

            final ArrayList<String> leftchat = new ArrayList<String>();
            final ArrayList<String> rightchat = new ArrayList<String>();
            final ChatAdapter leftAdapter = new ChatAdapter(getActivity(),R.layout.chat_items,leftchat);
            final ChatAdapter rightAdapter = new ChatAdapter(getActivity(),R.layout.chat_items,rightchat);

            myButton.setText(R.string.button_press);
            myButton.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    leftAdapter.add(myText.getText().toString());
                    rightAdapter.add(myText.getText().toString());
                    myText.setText("");
                    leftAdapter.notifyDataSetChanged();
                    rightAdapter.notifyDataSetChanged();
                    leftListView.setSelection(leftchat.size());
                    rightListView.setSelection(rightchat.size());
                }
            });

            leftListView.setAdapter(leftAdapter);
            rightListView.setAdapter(rightAdapter);
            return rootView;
        }
}
