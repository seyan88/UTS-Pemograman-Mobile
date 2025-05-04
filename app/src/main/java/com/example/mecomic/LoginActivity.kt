package com.example.mecomic

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Mengaktifkan layout edge-to-edge (fit layar penuh)
        setContentView(R.layout.activity_main) // Menghubungkan layout XML dengan activity ini

        // Mengambil referensi komponen input dan tombol dari layout
        val usernameInput = findViewById<EditText>(R.id.username_login)
        val passwordInput = findViewById<EditText>(R.id.password_login)
        val loginButton = findViewById<Button>(R.id.login_button)
        val textViewRegister = findViewById<TextView>(R.id.textViewRegister)

        // Membuat teks "Daftar di sini" menjadi tautan yang bisa diklik
        val fullText = "Belum punya akun? Daftar di sini"
        val spannable = SpannableString(fullText)
        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                // Pindah ke halaman Register saat teks diklik
                startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = false // Menghapus garis bawah pada teks link
                ds.color = Color.BLUE // Mengubah warna teks link
            }
        }
        val start = fullText.indexOf("Daftar di sini") // Posisi awal teks yang akan dijadikan link
        val end = start + "Daftar di sini".length // Posisi akhir teks link
        spannable.setSpan(clickableSpan, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        // Mengatur teks yang bisa diklik dan properti visualnya
        textViewRegister.text = spannable
        textViewRegister.movementMethod = LinkMovementMethod.getInstance() // Mengaktifkan klik pada teks
        textViewRegister.highlightColor = Color.TRANSPARENT // Menghapus warna highlight saat diklik

        // Aksi ketika tombol login diklik
        loginButton.setOnClickListener {
            val username = usernameInput.text.toString().trim() // Ambil input username
            val password = passwordInput.text.toString().trim() // Ambil input password

            // Mengambil data yang tersimpan di SharedPreferences
            val sharedPref = getSharedPreferences("UserData", Context.MODE_PRIVATE)
            val savedUsername = sharedPref.getString("username", null)
            val savedPassword = sharedPref.getString("password", null)

            // Validasi login
            when {
                username.isEmpty() || password.isEmpty() -> {
                    Toast.makeText(this, "Username dan Password harus diisi!", Toast.LENGTH_SHORT).show()
                }
                savedUsername == null || savedPassword == null -> {
                    Toast.makeText(this, "Belum ada akun terdaftar!", Toast.LENGTH_SHORT).show()
                }
                username == savedUsername && password == savedPassword -> {
                    // Jika login berhasil, pindah ke Dashboard
                    startActivity(Intent(this, DashboardActivity::class.java))
                    finish()
                }
                username != savedUsername -> {
                    Toast.makeText(this, "Username belum terdaftar!", Toast.LENGTH_SHORT).show()
                }
                password != savedPassword -> {
                    Toast.makeText(this, "Password salah!", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(this, "Username atau Password salah!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
