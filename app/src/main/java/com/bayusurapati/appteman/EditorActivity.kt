package com.bayusurapati.appteman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.core.view.isEmpty
import androidx.core.view.isNotEmpty
import com.bayusurapati.appteman.data.AppDatabase
import com.bayusurapati.appteman.data.entiy.User
import kotlinx.android.synthetic.main.activity_editor.*

class EditorActivity : AppCompatActivity() {
    private lateinit var fullName: EditText
    private lateinit var email: EditText
    private lateinit var kelamin: Spinner
    private lateinit var telp: EditText
    private lateinit var alamat: EditText

    private lateinit var database: AppDatabase
    private lateinit var btnSave: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editor)

        fullName = edit_fullname
        email = edit_email
        kelamin = spinnerGender
        telp = edit_telp
        alamat = edit_alamat
        btnSave = btn_save

        database = AppDatabase.getInstance(applicationContext)

        btnSave.setOnClickListener {
            if (fullName.text.isNotEmpty() && email.text.isNotEmpty() && kelamin.isNotEmpty() && telp.text.isNotEmpty() && alamat.text.isNotEmpty()) {
                database.userDao().insertAll(
                    User(
                        null,
                        fullName.text.toString(),
                        email.text.toString(),
                        kelamin.selectedItem.toString(),
                        telp.text.toString(),
                        alamat.text.toString()
                    )
                )
                finish()
            } else {
                Toast.makeText(applicationContext, "Isi Data sampai lengkap", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}