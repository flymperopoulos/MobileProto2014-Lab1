package com.example.flymperopoulos.myapplication;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.lang.reflect.Array;
import java.util.List;

/**
 * Created by flymperopoulos on 9/11/2014.
 */
public class ChatAdapter extends ArrayAdapter<String> {
    public ChatAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
    }
}
