package com.example.courseregistrationapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ConfirmationActivity : AppCompatActivity() {
    private lateinit var confirmationTextView: TextView
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        // Initialize UI elements
        confirmationTextView = findViewById(R.id.confirmationTextView)
        backButton = findViewById(R.id.backButton)

        // Retrieve data from Intent
        val courseName = intent.getStringExtra("COURSE_NAME") ?: "Unknown Course"
        val studentId = intent.getStringExtra("STUDENT_ID") ?: "Unknown ID"

        // Display confirmation message
        val confirmationMessage = """
            Registration Successful!
            
            Course Registered: $courseName
            Student ID: $studentId
            
            Thank you for registering.
        """.trimIndent()

        confirmationTextView.text = confirmationMessage

        // Handle Back button click
        backButton.setOnClickListener {
            // Navigate back to MainActivity
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }
    }
}
