package com.jorgetranin.recursosnativosandroid.contatos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jorgetranin.recursosnativosandroid.R


class AdapterContatos(private val contatosList: ArrayList<Contato>) :
    RecyclerView.Adapter<AdapterContatos.ViewHolder>() {


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_contato, parent, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(contatosList[position])
    }


    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = contatosList.size

    class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        fun bindItem(contato: Contato) {
            val nome = itemView.findViewById<TextView>(R.id.contact_name)
            val phone = itemView.findViewById<TextView>(R.id.contact_phone)

            nome.text = contato.nome
            phone.text = contato.phone
        }
    }
}


