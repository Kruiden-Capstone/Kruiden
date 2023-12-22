package id.ac.ukdw.kruidentapps.data.model

import com.google.gson.annotations.SerializedName

data class PenyakitResponse(

	@field:SerializedName("penyakit")
	val penyakit: String
)
