package id.ac.ukdw.kruidentapps.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.ukdw.kruidentapps.data.api.ApiConfig
import id.ac.ukdw.kruidentapps.data.model.Obat
import id.ac.ukdw.kruidentapps.untils.data
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel: ViewModel() {
    private val _listHerbal = MutableLiveData<List<Obat>>()
    val listHerbal: LiveData<List<Obat>> = _listHerbal


    internal fun getHerbal(penyakit: String){
        _listHerbal.value = emptyList()
        val requestBody = mapOf("penyakit" to penyakit)
        val client = ApiConfig.getApiService().getObat(requestBody)

        client.enqueue(object : Callback<List<Obat>> {
            override fun onResponse(call: Call<List<Obat>>, response: Response<List<Obat>>) {
                if (response.isSuccessful){
                    val responseBody:List<Obat>? = response.body()
                    if (responseBody != null){
                        val listObat = ArrayList<Obat>()
                        for (i in responseBody.indices){
                            val obat = Obat(
                                responseBody[i].herbal,
                                responseBody[i].khasiat,
                                responseBody[i].saranPenyajian
                            )

                            listObat.add(obat)
                        }
                        _listHerbal.value = listObat
                        data.listObat = listObat
                    }
                }
                else {
                    Log.e("Response Failed", "MainActivity on Failure : ${response.message()}")
                }
            }

            override fun onFailure(call: Call<List<Obat>>, t: Throwable) {
                Log.e("Failure","On Failure Get Obat : ${t.message}")
            }

        })
    }

}