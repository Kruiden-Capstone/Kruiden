package id.ac.ukdw.kruidentapps.data.api

import id.ac.ukdw.kruidentapps.data.model.Obat
import id.ac.ukdw.kruidentapps.data.model.ObatResponse
import id.ac.ukdw.kruidentapps.data.model.PenangananResponse
import id.ac.ukdw.kruidentapps.data.model.PenyakitResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface ApiService {
    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    )

    @FormUrlEncoded
    @POST("register")
    fun register(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    )

    @GET("diseases")
    fun getDiseases(
        @Query("page") page: Int = 1,
        @Query("size") size: Int = 25,
    ): Call<PenangananResponse>


    @POST("/recommend")
    fun getObat(@Body penyakit: Map<String, String>):Call<List<Obat>>

    @POST("/recomend")
    fun getListObat(
        @Query("q") query: String
    ): Call<ObatResponse>
}