package com.example.programtruin


import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_menu.*


class MenuActivity : AppCompatActivity(), ItemsAdapter.ClickListener {
    val imagesName = arrayOf(
            itemsModal("Angkot 07", "Jalan T. Amplas – Teladan-Letda Sujono / Batas Kota – PP07 Amplas – Jl. Sisingamangaraja – Aksara – Jl. Pancing – Tembung", R.drawable.angkot),
            itemsModal("Angkot 23", "Jalan T. Pinang Baris – B. Katamso / Bts Kota – PP", R.drawable.angkot),
            itemsModal("Angkot 46", "Jalan Tj. Selamat- Sei Serayu- Jl Darusalam- Gatot Subroto- Berastagi Swalayan – Letda Sujono- Tembung – PP", R.drawable.angkot),
            itemsModal("Angkot 47", "Jalan T. Pinang Baris – Letda Sujono / Bts Kota – PP", R.drawable.angkot),
            itemsModal("Angkot 37", "Jalan Johor / Pasar V / Bts Kota – T.Belawan – PP", R.drawable.angkot),
            itemsModal("Angkot 38", "Jalan Rs. Adam Malik – Desa Martoba / Bts Kota – PP", R.drawable.angkot),
            itemsModal("Angkot 39", "Jalan T. P.Baris – Pertiwi / SMU XI / Bts Kota – PP", R.drawable.angkot),
            itemsModal("Angkot 40", "Jalan Kelambir Lima / Bts Kota – P. Mandala – PP", R.drawable.angkot),
            itemsModal("Angkot 46", "Jalan Tj. Selamat- Sei Serayu- Jl Darusalam- Gatot Subroto- Berastagi Swalayan – Letda Sujono- Tembung – PP", R.drawable.angkot),
            itemsModal("Angkot 47", "Jalan T. Pinang Baris – Letda Sujono / Bts Kota – PP", R.drawable.angkot),
            itemsModal("Angkot 50", "Jalan T. Pinang Baris – Jermal XI / Bts Kota- PP", R.drawable.angkot),
            itemsModal("Angkot 51", "Jalan T. Pinang Baris – Desa Jambu / Bts Kota – PP", R.drawable.angkot),
            itemsModal("Angkot 52", "Jalan Padang Bulan – Titi Kuning – Pringgan – Pinang Baris", R.drawable.angkot),
            itemsModal("Angkot 55", "Jalan T. Amplas – Letda Sujono / Bts Kota – PP", R.drawable.angkot),
            itemsModal("Angkot 57", "Jalan Tj. Selamat / Bts Kota – P. Mandala – PP", R.drawable.angkot),
            itemsModal("Angkot 59", "Jalan P. Mandala – B. Katamso / Bts Kota – PP", R.drawable.angkot),
            itemsModal("Angkot 60", "Jalan P. Simalingkar Martoba / Bts Kota – PP", R.drawable.angkot),
            itemsModal("Angkot 64", "Jalan Amplas- Sp. Limun- Sun Plaza-Pringgan", R.drawable.angkot),
            itemsModal("Angkot 65", "Jalan Kelambir V / Bts Kota – T. Pinang Baris – PP", R.drawable.angkot),
            itemsModal("Angkot 91", "Jalan Sentis Bw / Batas Kota – T. Amplas – PP", R.drawable.angkot),
            itemsModal("Angkot 108", "Jalan Pasar II- Pajak Sore - P. Bulan- Pringgan- Petisah- Plaza Medan Fair - Gaperta - Gatot Subroto – PP", R.drawable.angkot),
            itemsModal("Angkot 109", "Jalan T. Morawa / Batas Kota – Tj.Selamat / Bts Kota – PP", R.drawable.angkot),
            itemsModal("Angkot 110", "Jalan Kolam Renang Morina – Klumpang / Bts Kota – PP", R.drawable.angkot),
            itemsModal("Angkot 123", "Jalan Medan Permai / Bts Kota – Perum G.Martubung – PP", R.drawable.angkot),
            itemsModal("Angkot 136", "Jalan T. Pinang Baris- Jl Gatot Subroto – Sei Rotan / Batas Kota – PP", R.drawable.angkot),
            itemsModal("Angkot 137", "Jalan T. Morawa / Bts Kota – Tj Anom / Batas Kota – PP", R.drawable.angkot),
            itemsModal("Angkot 168", "Jalan B. Katamso / Bts Kota – Belawan – PP", R.drawable.angkot),
            itemsModal("Angkot 42", "Jalan RSU.A.Malik – Pringgan- Komp.IKIP/M.Estate/Bts Kota. PP", R.drawable.angkot),
            itemsModal("Angkot 43", "Jalan P. Simalingkar / Bts Kota – P. Mandala / Bts Kota. PP", R.drawable.angkot),
            itemsModal("Angkot 54", "Jalan Desa Simalingkar - Kebun Binatang Simalingkar - USU - Pringgan - Komp.IKIP/M.Estate PP", R.drawable.angkot),
            itemsModal("Angkot 58", "Jalan Tj. Anom / Bts Kota – Tembung / Bts Kota. PP", R.drawable.angkot),
            itemsModal("Angkot 103", "Jalan Ikip / Medan Estate – Pancur Batu – PP", R.drawable.angkot),
            itemsModal("Angkot 105", "Jalan Terminal Amplas – Marelan – Pancing – Aksara – Komplek Uka Terjun – PP", R.drawable.angkot),
            itemsModal("Angkot 120", "Jalan T. Pinang Baris – Setia Budi- USU - Pd. Bulan – Titi Kuning - Amplas - PP", R.drawable.angkot),
            itemsModal("Angkot 125", "Jalan Medan Amplas- Martubung- Medan Labuhan", R.drawable.angkot),
    )
    val itemModalList = ArrayList<itemsModal>()
    var itemsAdapter : ItemsAdapter? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        for(items in imagesName){
            itemModalList.add(items)
        }
        itemsAdapter = ItemsAdapter(this);
        itemsAdapter!!.setData(itemModalList);
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = itemsAdapter
    }

    override fun ClickedItem(itemsModal: itemsModal) {
        Log.e("TAG", itemsModal.name);

        when(itemsModal.name){
            "Angkot 07" ->
                startActivity(Intent(this@MenuActivity, angkot07::class.java))
            "Angkot 23" ->
                startActivity(Intent(this@MenuActivity, angkot23::class.java))

            else -> {
                Toast.makeText(this, "Maintenance!! We'll back soon", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        val menuItem = menu!!.findItem(R.id.searchView)

        val searchView = menuItem.actionView as SearchView

        searchView.maxWidth = Int.MAX_VALUE
        searchView.setOnQueryTextListener(object  : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(filterString: String?): Boolean {
                itemsAdapter!!.filter.filter(filterString)
                return true
            }

            override fun onQueryTextChange(filterString: String?): Boolean {
                itemsAdapter!!.filter.filter(filterString)
                return true
            }

        })
        return true
    }
}