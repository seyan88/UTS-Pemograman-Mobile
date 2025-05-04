package com.example.mecomic

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log // Import untuk logging
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register) // Menghubungkan layout XML dengan activity ini

        // Mengambil referensi komponen input dari layout
        val usernameInput = findViewById<EditText>(R.id.username_register)
        val passwordInput = findViewById<EditText>(R.id.password_register)
        val confirmPasswordInput = findViewById<EditText>(R.id.confirm_password_register)
        val registerButton = findViewById<Button>(R.id.register_button)

        // Menangani klik pada tombol register
        registerButton.setOnClickListener {
            Log.d("RegisterActivity", "Register button clicked") // Log ketika tombol diklik

            val username = usernameInput.text.toString().trim() // Mengambil teks username
            val password = passwordInput.text.toString().trim() // Mengambil teks password
            val confirmPassword = confirmPasswordInput.text.toString().trim() // Mengambil teks konfirmasi password

            // Validasi input kosong
            if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Semua field harus diisi!", Toast.LENGTH_SHORT).show()
                Log.w("RegisterActivity", "Field kosong saat register") // Log jika ada field kosong
                return@setOnClickListener
            }

            // Validasi kecocokan password
            if (password != confirmPassword) {
                Toast.makeText(this, "Konfirmasi password tidak cocok!", Toast.LENGTH_SHORT).show()
                Log.w("RegisterActivity", "Password dan konfirmasi tidak cocok") // Log jika password tidak cocok
                return@setOnClickListener
            }

            // Menyimpan data ke SharedPreferences
            val sharedPref = getSharedPreferences("UserData", Context.MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putString("username", username) // Simpan username
            editor.putString("password", password) // Simpan password
            editor.apply() // Terapkan perubahan

            Log.i("RegisterActivity", "User $username berhasil didaftarkan") // Log saat registrasi sukses

            Toast.makeText(this, "Registrasi berhasil!", Toast.LENGTH_SHORT).show()

            // Pindah ke LoginActivity setelah registrasi berhasil
            startActivity(Intent(this, LoginActivity::class.java))
            finish() // Menutup RegisterActivity agar tidak bisa kembali dengan tombol back
        }
    }
}
