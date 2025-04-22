package com.example.bookingkonsultasi

import android.app.DatePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.bookingkonsultasi.R
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var etNama: EditText
    private lateinit var etNim: EditText
    private lateinit var etFakultas: EditText
    private lateinit var etPhone: EditText
    private lateinit var btnPilihTanggal: Button
    private lateinit var btnSubmit: Button
    private lateinit var tvTanggal: TextView
    private var selectedDate: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Connect to the XML layout

        // Initialize views
        etNama = findViewById(R.id.etNama)
        etNim = findViewById(R.id.etNim)
        etFakultas = findViewById(R.id.etFakultas)
        etPhone = findViewById(R.id.etPhone)
        btnPilihTanggal = findViewById(R.id.btnPilihTanggal)
        btnSubmit = findViewById(R.id.btnSubmit)
        tvTanggal = findViewById(R.id.tvTanggal)

        // Set click listener for date picker button
        btnPilihTanggal.setOnClickListener {
            showDatePickerDialog()
        }

        // Set click listener for submit button
        btnSubmit.setOnClickListener {
            showConfirmationDialog()
        }
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        // Create and show the date picker dialog
        val datePickerDialog = DatePickerDialog(this,
            { _, selectedYear, selectedMonth, selectedDay ->
                selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                tvTanggal.text = selectedDate // Update the TextView with the selected date
            }, year, month, day)
        datePickerDialog.show()
    }

    private fun showConfirmationDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Konfirmasi Pemesanan")
            .setMessage("Apakah Anda yakin ingin memesan konsultasi pada tanggal $selectedDate?")
            .setPositiveButton("Ya") { _: DialogInterface, _: Int ->
                Toast.makeText(this, "Pemesanan berhasil!", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Tidak") { dialog: DialogInterface, _: Int ->
                dialog.dismiss() // Dismiss the dialog
            }

        val alertDialog = builder.create()
        alertDialog.show() // Show the confirmation dialog
    }
}