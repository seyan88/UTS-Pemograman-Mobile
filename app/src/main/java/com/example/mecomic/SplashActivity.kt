package com.example.mecomic

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Mengaktifkan tampilan edge-to-edge (layar penuh)
        setContentView(R.layout.activity_splash) // Mengatur layout splash sebagai tampilan awal

        // Menunda eksekusi selama 3 detik (3000 milidetik)
        Handler(Looper.getMainLooper()).postDelayed({
            // Setelah 3 detik, pindah ke LoginActivity
            startActivity(Intent(this, LoginActivity::class.java))
            finish() // Menutup SplashActivity agar tidak bisa kembali ke sini dengan tombol back
        }, 3000)
    }
}
