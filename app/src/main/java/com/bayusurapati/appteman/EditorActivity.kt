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
import kotlinx.android.synthetic.main.activity_editor.view.*

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
        val intent = intent.extras

        if(intent!=null){
            val id =  intent.getInt("id",0)
            var user = database.userDao().get(id)

            fullName.setText(user.fullName)
            email.setText(user.email)
            telp.setText(user.telp)
            alamat.setText(user.alamat)
        }

        btnSave.setOnClickListener {
            if (fullName.text.isNotEmpty() && email.text.isNotEmpty() && kelamin.isNotEmpty() && telp.text.isNotEmpty() && alamat.text.isNotEmpty()) {
                if(intent!=null){
                    //Logic edit data
                    database.userDao().update(
                        User(
                            intent.getInt("id",0),
                            fullName.text.toString(),
                            email.text.toString(),
                            kelamin.selectedItem.toString(),
                            telp.text.toString(),
                            alamat.text.toString()
                        )
                    )
                }else {
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
                }
                finish()
            } else {
                Toast.makeText(applicationContext, "Isi Data sampai lengkap", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}

