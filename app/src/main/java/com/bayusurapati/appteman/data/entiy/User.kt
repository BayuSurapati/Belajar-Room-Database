package com.bayusurapati.appteman.data.entiy

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User (
    @PrimaryKey(autoGenerate = true) val uid: Int? = null,
    @ColumnInfo(name = "full_name") var fullName: String?,
    @ColumnInfo(name = "email") var email: String?,
    @ColumnInfo(name = "kelamin") var kelamin: String?,
    @ColumnInfo(name = "telp") var telp: String?,
    @ColumnInfo(name = "alamat") var alamat: String?

)
