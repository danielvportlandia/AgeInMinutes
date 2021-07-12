package com.example.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dateButton.setOnClickListener { view ->
            clickDatePicker(view)
//            Toast.makeText(this, "Button works", Toast.LENGTH_LONG).show()
        }

    }

    fun clickDatePicker(view: View) {
        val myCalendar = Calendar.getInstance();
        val year = myCalendar.get(Calendar.YEAR);
        val month = myCalendar.get(Calendar.MONTH);
        val day = myCalendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog(this, DatePickerDialog.OnDateSetListener {
                view, selectedYear, selectedMonth, selectedDayOfMonth ->
            Toast.makeText(this, "The chosen year is $selectedYear, the month is ${selectedMonth+1}, the day is $selectedDayOfMonth", Toast.LENGTH_LONG).show()
            val selectedDate = "${selectedMonth + 1}/$selectedDayOfMonth/$selectedYear"
            val sdf = SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH)
            val theDate = sdf.parse(selectedDate)
            tvSelectedDate.setText(selectedDate)
        },
            year,
            month,
            day).show()
    }
}