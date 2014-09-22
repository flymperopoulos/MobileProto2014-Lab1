package com.example.flymperopoulos.myapplication;

 import android.app.Activity;
 import android.app.AlertDialog;
 import android.content.DialogInterface;
 import android.widget.EditText;
 import android.widget.Toast;


/**
 * Created by flymperopoulos on 9/22/14.
 */

public class ChangeUsername {

    public static void changeUsername(final Activity activity){
        final EditText input = new EditText(activity);
        new AlertDialog.Builder(activity)
                .setTitle("Changing Username")
                .setView(input)
                .setPositiveButton(R.string.change, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String newName = input.getText().toString();
                        if (newName.equals("")) {
                            Toast.makeText(activity, "Your username cannot be blank!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        MyFragment frag = (MyFragment) activity.getFragmentManager().findFragmentById(R.id.container);
                        frag.setUsername(newName);
                        Toast.makeText(activity, "Your username is now " + newName, Toast.LENGTH_SHORT).show();
                        dialogInterface.dismiss();
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).show();
    }



}