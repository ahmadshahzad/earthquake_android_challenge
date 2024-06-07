package com.ebay.earthquake.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ebay.earthquake.data.remote.model.Feature
import com.ebay.earthquake.databinding.EarthQuakeItemBinding
import java.text.SimpleDateFormat
import java.util.Locale

class EarthQuakeAdapter(
    private val onItemClick: (Feature) -> Unit
) : ListAdapter<Feature, EarthQuakeAdapter.EarthquakeViewHolder>(DiffCallback()) {

    inner class EarthquakeViewHolder(private val binding: EarthQuakeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(feature: Feature) {
            with(binding) {
                root.setOnClickListener {
                    onItemClick.invoke(feature)
                }
                binding.title.text = feature.properties.title
                binding.magnitude.text = feature.properties.mag.toString()
                binding.time.text =
                    SimpleDateFormat("dd/MM/yyyy:HH:mm:ss", Locale.getDefault()).format(feature.properties.time)
                binding.place.text = feature.properties.place
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EarthquakeViewHolder {
        val binding =
            EarthQuakeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EarthquakeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EarthquakeViewHolder, position: Int) {
        val earthquake = getItem(position)
        holder.bind(earthquake)
    }

    class DiffCallback : DiffUtil.ItemCallback<Feature>() {
        override fun areItemsTheSame(oldItem: Feature, newItem: Feature): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Feature, newItem: Feature): Boolean =
            oldItem == newItem
    }
}