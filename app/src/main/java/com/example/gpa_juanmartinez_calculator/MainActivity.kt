package com.example.gpa_juanmartinez_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var grade1 : EditText
    lateinit var grade2 : EditText
    lateinit var grade3 : EditText
    lateinit var grade4 : EditText
    lateinit var grade5 : EditText
    lateinit var computedGpa : TextView
    lateinit var computeGpaButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        grade1 = findViewById(R.id.grade_one)
        grade2 = findViewById(R.id.grade_two)
        grade3 = findViewById(R.id.grade_three)
        grade4 = findViewById(R.id.grade_four)
        grade5 = findViewById(R.id.grade_five)
        computedGpa = findViewById(R.id.gpa)
        computeGpaButton = findViewById(R.id.button)
        computeGpaButton.setOnClickListener(View.OnClickListener() {
            computedGpa.setText("test")
        })
    }


}