package com.ute.studentprofile

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ute.studentprofile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var currentStudent = Student(
        id = "2415141122111",
        name = "Le Kim Loi",
        className = "24SK1",
        email = "lekimloi.2415141122111@ute.udn.vn",
        gpa = 3.6
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bindStudentData(currentStudent)

        binding.btnUpdateGpa.setOnClickListener {
            val inputStr = binding.edtNewGpa.text.toString().trim()
            val newGpa = inputStr.toDoubleOrNull()

            if (newGpa == null || newGpa !in 0.0..4.0) {
                binding.edtNewGpa.error = "Vui long nhap GPA hop le (0.0 - 4.0)"
                toast("Diem GPA khong hop le!")
                return@setOnClickListener
            }

            currentStudent = currentStudent.copy(gpa = newGpa)
            bindStudentData(currentStudent)
            toast("Cap nhat diem thanh cong!")
        }
    }

    private fun bindStudentData(student: Student) {
        with(binding) {
            tvName.text = student.name
            tvStudentId.text = "MSSV: ${student.id} - Lop: ${student.className}"
            tvGpaBadge.text = "${student.gpa} GPA"

            val ranking = student.gpa.toAcademicRanking()
            tvRankBadge.text = ranking

            val rankColor = when (ranking) {
                "Xuat sac!!" -> "#34B469"
                "Gioi" -> "#3D8AFF"
                "Kha" -> "#FF8A3D"
                else -> "#E5484D"
            }
            cardRankBadge.setCardBackgroundColor(Color.parseColor(rankColor))

            edtNewGpa.setText(student.gpa.toString())
        }
    }
}