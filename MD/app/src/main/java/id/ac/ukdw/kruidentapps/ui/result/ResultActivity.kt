package id.ac.ukdw.kruidentapps.ui.result

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.ukdw.kruidentapps.data.adapter.ObatAdapter
import id.ac.ukdw.kruidentapps.databinding.ActivityResultBinding
import id.ac.ukdw.kruidentapps.untils.data

class ResultActivity : AppCompatActivity() {

    private lateinit var binding : ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvName.text = data.name
        binding.rvObat.layoutManager = LinearLayoutManager(this)
        binding.rvObat.setHasFixedSize(true)

        val obatAdapter = ObatAdapter(data.listObat)
        binding.rvObat.apply {
            layoutManager = LinearLayoutManager(this@ResultActivity)
            adapter = obatAdapter
            addItemDecoration(DividerItemDecoration(this@ResultActivity, LinearLayoutManager.VERTICAL))
        }

    }
}

