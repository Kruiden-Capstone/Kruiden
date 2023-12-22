package id.ac.ukdw.kruidentapps.data.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import id.ac.ukdw.kruidentapps.data.model.Obat
import id.ac.ukdw.kruidentapps.databinding.ItemResultBinding
import id.ac.ukdw.kruidentapps.untils.data

class ObatAdapter(private var listObat: List<Obat>): RecyclerView.Adapter<ObatAdapter.ObatViewHolder>(){
    class ObatViewHolder(private val v:ItemResultBinding) : RecyclerView.ViewHolder(v.root) {
        fun bind(item: Obat){
            v.tvNama.text = item.herbal
            v.tvKhasiat.text = item.khasiat
            v.tvPenyajian.text = item.saranPenyajian

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObatAdapter.ObatViewHolder =
        ObatViewHolder(ItemResultBinding.inflate(LayoutInflater.from(parent.context),parent,false))


    override fun onBindViewHolder(holder: ObatAdapter.ObatViewHolder, position: Int) {
        val obat = listObat[position]
        holder.bind(obat)
        holder.itemView.setOnClickListener {
            val alertDialogBuilder = AlertDialog.Builder(holder.itemView.context)
            alertDialogBuilder.setTitle(obat.herbal)
            alertDialogBuilder.setMessage("Khasiat:\n${obat.khasiat}\n\nSaran Penyajian:\n${obat.saranPenyajian}")

            val alertDialog = alertDialogBuilder.create()
            alertDialog.show()
        }


    }

    override fun getItemCount(): Int = listObat.size


}