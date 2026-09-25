package com.ute.studentprofile

import android.content.Context
import android.widget.Toast

// Extension xep loai hoc luc theo GPA
fun Double.toAcademicRanking(): String = when {
    this >= 3.6 -> "Xuat sac!!"
    this >= 3.2 -> "Gioi"
    this >= 2.5 -> "Kha"
    else -> "Trung binh"
}

// Extension hien thi Toast nhanh cho Context/Activity
fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}