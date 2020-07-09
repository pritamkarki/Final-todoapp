package com.example.todoapp.tasks;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.icu.text.DateFormat;
import android.os.Build;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;



import java.util.Calendar;
import java.util.Date;

import static com.example.todoapp.addedittask.AddEditTaskActivity.populateSetDateText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Date_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Date_Fragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    @RequiresApi(api = Build.VERSION_CODES.N)
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            String currentDateString = DateFormat.getDateInstance().format(c.getTime());
        }
        return new DatePickerDialog(getActivity(),this,year,month,day);
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        populateSetDateText(year,month+1,dayOfMonth);

    }


}