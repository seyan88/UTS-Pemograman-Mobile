package com.example.mecomic

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard)

        // inisialsisasi recyclerview
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.setHasFixedSize(true)

        val itemLists = listOf(
            ItemList("Solo Leveling","Sinopsis: " +
                    "Dunia diserang monster! Muncullah \"hunter\" untuk menyerang monster-monster itu. Di kalangan hunter, ada yang disebut hunter terlemah di dunia. Itulah julukan Seong Jin-woo. Masuk rumah sakit adalah kebiasaannya setelah masuk ke dungeon. Suatu hari, saat melakukan raid, suatu peristiwa tragis menimpanya. Peristiwa itu hampir merenggut nyawanya. Namun, saat tersadar, dia mendapati dirinya masih hidup dan melihat sesuatu yang tidak bisa dilihat orang lain. Sejak saat itu, kehidupan Seong Jin-woo berubah. Inilah perjalanan Seong Jin-woo untuk menjadi hunter terkuat di dunia!",
                "Link: " + "https://komikninja.com/read/solo-leveling",
                "https://th.bing.com/th/id/OIP.B2OgXsLHCBi0RDDqY3WsZgHaKc?w=115&h=180&c=7&r=0&o=5&dpr=1.5&pid=1.7"),

            ItemList("Kimetsu No Yaiba","Sinopsis: " +"Tanjirou menemukan keluarganya dibantai dan satu-satunya yang selamat, saudara perempuannya Nezuko, berubah menjadi iblis. Menambah kesedihan ini, seorang pemburu iblis bernama Tomioka Giyuu tiba dan akan menghabisi Nezuko, tetapi yang mengejutkan dia dan Tanjiro mulai melindungi satu sama lain. Melihat keanehan ini dan kemampuan bertarung Tanjiro yang menjanjikan, Giyuu memutuskan untuk mengirim mereka ke mentor lamanya untuk dilatih.",
                "Link: " + "https://komikninja.com/read/kimetsu-no-yaiba",
                "https://tse2.mm.bing.net/th/id/OIP.17ZUf2b5bXS4k0a_TomL1wHaLH?rs=1&pid=ImgDetMain"),
            ItemList("Captain America", " captain-america-vol-1-scans",
                "Link: " + "https://archive.org/details/captain-america-vol-1-scans/Captain%20America%27s%20Bicentennial%20Battles%20%281-shot%29%20%281976%29%20%28c2c%29/",
                "https://ia801606.us.archive.org/BookReader/BookReaderImages.php?zip=/6/items/captain-america-vol-1-scans/Captain%20America%27s%20Bicentennial%20Battles%20%281-shot%29%20%281976%29%20%28c2c%29_jp2.zip&file=Captain%20America%27s%20Bicentennial%20Battles%20%281-shot%29%20%281976%29%20%28c2c%29_jp2/Captain%20America%27s%20Bicentennial%20Battles%20%281-shot%29%20%281976%29%20%28c2c%29_0000.jp2&id=captain-america-vol-1-scans&scale=2&rotate=0")
        )

        val  adapter = AdapterList(itemLists)
        recyclerView.adapter = adapter

    }
}