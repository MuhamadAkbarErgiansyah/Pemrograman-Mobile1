Penjelasan Implmentasi input dalam codingan
1)	Date Time
Fitur ini memungkinkan pengguna memilih tanggal konsultasi.
•	val datePickerDialog = DatePickerDialog(this,
    { _, selectedYear, selectedMonth, selectedDay ->
        selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
        tvTanggal.text = selectedDate
    }, year, month, day)

•	Komponen digunakan: DatePickerDialog
•	Implementasi dilakukan pada tombol Pilih Tanggal Konsultasi
•	Setelah tanggal dipilih, hasilnya ditampilkan di TextView

2)	Alert Dialog
Fitur ini digunakan untuk memberikan konfirmasi pemesanan konsultasi.
•	builder.setTitle("Konfirmasi Pemesanan")
    .setMessage("Apakah Anda yakin ingin memesan konsultasi pada tanggal $selectedDate?")
    .setPositiveButton("Ya") { _, _ ->
        Toast.makeText(this, "Pemesanan berhasil!", Toast.LENGTH_SHORT).show()
    }
    .setNegativeButton("Tidak") { dialog, _ ->
        dialog.dismiss()
    }

•	Komponen digunakan: AlertDialog.Builder
•	Akan muncul saat tombol Submit Booking ditekan
•	Jika pengguna memilih "Ya", maka akan muncul Toast sebagai respon

3)	Toast
Menampilkan notifikasi singkat (popup) di layar
•	.setPositiveButton("Ya") { _: DialogInterface, _: Int ->
    Toast.makeText(this, "Pemesanan berhasil!", Toast.LENGTH_SHORT).show()
}


untuk codingan full dan gambar aplikasi ada di file
