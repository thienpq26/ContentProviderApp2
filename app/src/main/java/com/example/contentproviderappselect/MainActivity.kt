package com.example.contentproviderappselect

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val contentResolver = contentResolver
        val uri = Uri.parse("content://com.example.sqlitedemo1.Provider.StudentsProvider/students")
        //Select theo ID:
        //val cursor = contentResolver.query(uri, null, "students_id=?", arrayOf("3"), null)

        //Select 1 columns:
        //val cursor = contentResolver.query(uri, arrayOf("students_address"), null, null, null)

        //Select all:
        val cursor = contentResolver.query(uri, null, null, null, null)
        if (cursor!!.moveToFirst()) {
            do {
                Log.d("D/d", "ID: " + cursor.getInt(0))
                Log.d("D/d", "Name: " + cursor.getString(1))
            } while (cursor.moveToNext())
        }
    }
}
