package id.ac.ukdw.kruidentapps.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar

import androidx.lifecycle.ViewModelProvider
import id.ac.ukdw.kruidentapps.databinding.ActivityMainBinding
import id.ac.ukdw.kruidentapps.ui.result.ResultActivity
import id.ac.ukdw.kruidentapps.untils.data

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    var cekData = true
    private var isLoading = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.show()

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]


        binding.btSubmit.setOnClickListener {
            isLoading = true
            showLoading(true)
            if (binding.tiePenyakit.text != null){
                mainViewModel.getHerbal(binding.tiePenyakit.text.toString().lowercase())
                mainViewModel.listHerbal.observe(this){
                    data.listObat = it
                    if (it != null){
                        data.name = binding.tiePenyakit.text.toString()
                        startActivity(Intent(this,ResultActivity::class.java))
                    }else{
                        binding.error.visibility = android.view.View.VISIBLE
                    }
                    showLoading(false)
                }

                if (!cekData){
                    binding.error.visibility = android.view.View.VISIBLE
                }else{
                    binding.error.visibility = android.view.View.GONE
                }

            }
        }


    }

    private fun showLoading(isTrue : Boolean){
        if (!isTrue){
            binding.loadingProgressBar.visibility = ProgressBar.VISIBLE
        }else{
            binding.loadingProgressBar.visibility = ProgressBar.GONE
        }
    }
}