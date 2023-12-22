package id.ac.ukdw.kruidentapps.data.model

import com.google.gson.annotations.SerializedName

data class PenangananResponse(

	@field:SerializedName("PenangananResponse")
	val penangananResponse: List<PenangananResponseItem>
)

data class PenangananResponseItem(

	@field:SerializedName("khasiat")
	val khasiat: String,

	@field:SerializedName("herbal")
	val herbal: String,

	@field:SerializedName("saran_penyajian")
	val saranPenyajian: String,
)
