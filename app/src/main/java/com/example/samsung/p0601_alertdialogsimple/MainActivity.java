package com.example.samsung.p0601_alertdialogsimple;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity {

    final int DIALOG_EXIT = 1;

    private DialogInterface.OnClickListener myClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                //button of positive ansver
                case Dialog.BUTTON_POSITIVE :
                    saveData();
                    finish();
                    break;
                case Dialog.BUTTON_NEGATIVE :
                    finish();
                    break;
                case Dialog.BUTTON_NEUTRAL :
                    break;
            }
        }
    };

    private void saveData() {
        Toast.makeText(this, R.string.saved, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void onClickButton(View view) {
        //dialog call
        showDialog(DIALOG_EXIT);
    }

    public void onBackPressed() {
        //dialog call
        showDialog(DIALOG_EXIT);
    }

    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_EXIT) {
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            //title
            adb.setTitle(R.string.exit);
            //message
            adb.setMessage(R.string.save_data);
            //icon
            adb.setIcon(android.R.drawable.ic_dialog_info);
            //button of positive ansver
            adb.setPositiveButton(R.string.yes, myClickListener);
            //button of negative ansver
            adb.setNegativeButton(R.string.no, myClickListener);
            //button of neutral ansver
            adb.setNeutralButton(R.string.cancel, myClickListener);
            //do not exit when pressing back button
            adb.setCancelable(false);
            //create dialog
            return adb.create();
        }
    return super.onCreateDialog(id);
    }
}
