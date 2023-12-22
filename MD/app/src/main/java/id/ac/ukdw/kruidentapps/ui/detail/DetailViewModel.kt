package id.ac.ukdw.kruidentapps.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.ukdw.kruidentapps.data.api.ApiConfig
import id.ac.ukdw.kruidentapps.data.model.ObatResponse
import id.ac.ukdw.kruidentapps.data.model.PenyakitResponse
import id.ac.ukdw.kruidentapps.untils.Results
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
//
//class DetailViewModel: ViewModel() {
//
//    val resultDetailObat = MutableLiveData<ObatResponse>()
//    val detailObat : LiveData<ObatResponse> = resultDetailObat
//
//    companion object {
//        const val TAG = "DetailViewModel"
//    }
//
//    init {
//        getDetailDisease(name = String())
//    }
//    fun getDetailDisease(name: String) {
//        val client = ApiConfig
//            .getApiService()
//            .getDiseases(name)
//        client.enqueue(object: Callback<ObatResponse> {
//            override fun onResponse(call: Call<ObatResponse>, response: Response<ObatResponse>) {
//                if (response.isSuccessful) {
//                    val responseBody = response.body()
//                    if (responseBody != null) {
//                        resultDetailObat.value = response.body()
//                    }
//                } else {
//                    Log.e(TAG, "onFailure: ${response.message()}")
//                }
//            }
//
//            override fun onFailure(call: Call<ObatResponse>, t: Throwable) {
//                Log.e(TAG, "onFailure: ${t.message}")
//            }
//
//        })
//    }
//}