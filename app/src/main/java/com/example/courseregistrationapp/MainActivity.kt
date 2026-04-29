package com.example.courseregistrationapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var courseSpinner: Spinner
    private lateinit var studentIdEditText: EditText
    private lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI elements
        courseSpinner = findViewById(R.id.courseSpinner)
        studentIdEditText = findViewById(R.id.studentIdEditText)
        registerButton = findViewById(R.id.registerButton)

        // Set up course options in spinner
        val courses = arrayOf(
            "ICT Project Management",
            "Embedded Systems and Mobile programming",
            "Compiler Construction",
            "Network and Distributed Programming",
            "Business Intelligence and Analytics",
            "Computer Network Security"
        )

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            courses
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        courseSpinner.adapter = adapter

        // Handle Register button click
        registerButton.setOnClickListener {
            handleRegistration()
        }
    }

    private fun handleRegistration() {
        val selectedCourse = courseSpinner.selectedItem.toString()
        val studentId = studentIdEditText.text.toString()

        // Validation
        if (selectedCourse == "Select a Course") {
            Toast.makeText(this, "Please select a course", Toast.LENGTH_SHORT).show()
            return
        }

        if (studentId.isEmpty()) {
            Toast.makeText(this, "Please enter your Student ID", Toast.LENGTH_SHORT).show()
            return
        }

        // Optional: Validate Student ID format (e.g., must be alphanumeric)
        if (!isValidStudentId(studentId)) {
            Toast.makeText(this, "Invalid Student ID format", Toast.LENGTH_SHORT).show()
            return
        }

        // Create intent and pass data to ConfirmationActivity
        val intent = Intent(this, ConfirmationActivity::class.java)
        intent.putExtra("COURSE_NAME", selectedCourse)
        intent.putExtra("STUDENT_ID", studentId)
        startActivity(intent)
    }

    private fun isValidStudentId(studentId: String): Boolean {
        // Simple validation: Student ID should be at least 3 characters and alphanumeric
        return studentId.length >= 3 && studentId.matches(Regex("^[a-zA-Z0-9]+$"))
    }
}
