package com.example.gautam.googlesamplesfetcher.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.gautam.googlesamplesfetcher.databinding.RvItemRespositoryBinding
import com.example.gautam.googlesamplesfetcher.uimodel.Repository

class RepositoryRecyclerViewAdapter(
    private var items: ArrayList<Repository>,
    private var listener: OnItemClickListener
) : RecyclerView.Adapter<RepositoryRecyclerViewAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position], listener)

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val binding = RvItemRespositoryBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun replaceData (arrayList : ArrayList<Repository>) {
        items = arrayList
        notifyDataSetChanged()
    }

    class ViewHolder(private var binding: RvItemRespositoryBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(repo: Repository, listener: OnItemClickListener) {
            binding.repository = repo
            if (listener != null) {
                binding.root.setOnClickListener ({ _ -> listener.onItemClick(layoutPosition) })
            }
            binding.executePendingBindings()
        }

    }

}