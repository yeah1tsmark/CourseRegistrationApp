package com.example.courseregistrationapp

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesHelper(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("CourseRegistration", Context.MODE_PRIVATE)

    companion object {
        const val KEY_LAST_COURSE = "last_course"
        const val KEY_LAST_STUDENT_ID = "last_student_id"
    }

    // Save registration data
    fun saveRegistration(courseName: String, studentId: String) {
        sharedPreferences.edit().apply {
            putString(KEY_LAST_COURSE, courseName)
            putString(KEY_LAST_STUDENT_ID, studentId)
            apply()
        }
    }

    // Retrieve last registered course
    fun getLastCourse(): String? {
        return sharedPreferences.getString(KEY_LAST_COURSE, null)
    }

    // Retrieve last student ID
    fun getLastStudentId(): String? {
        return sharedPreferences.getString(KEY_LAST_STUDENT_ID, null)
    }

    // Clear all saved data
    fun clearData() {
        sharedPreferences.edit().clear().apply()
    }
}
