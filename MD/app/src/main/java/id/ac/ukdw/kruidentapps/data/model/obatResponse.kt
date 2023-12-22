package id.ac.ukdw.kruidentapps.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


data class ObatResponse(
    val listObat: List<Obat>
)

data class Obat(
    @field:SerializedName("herbal")
    val herbal:String,
    @field:SerializedName("khasiat")
    val khasiat:String,
    @field:SerializedName("saran_penyajian")
    val saranPenyajian:String
)
