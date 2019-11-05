package com.uhc.presentation.client

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.uhc.domain.model.Client
import com.uhc.presentation.R
import com.uhc.presentation.databinding.ClientListItemBinding

/**
 * Created by Constancio on 2019-07-07.
 */
class ClientAdapter : RecyclerView.Adapter<ClientAdapter.ViewHolder>() {

    private val clients = mutableListOf<Client>()

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.client_list_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = clients.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(clients[position])
    }

    fun notifyChanged(clients: List<Client>) {
        this.clients.clear()
        this.clients.addAll(clients)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ClientListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(client: Client) {
            binding.client = client
            binding.executePendingBindings()
        }
    }
}