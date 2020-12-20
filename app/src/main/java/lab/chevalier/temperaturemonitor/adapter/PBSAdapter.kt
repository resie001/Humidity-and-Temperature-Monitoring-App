package lab.chevalier.temperaturemonitor.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import lab.chevalier.temperaturemonitor.R
import lab.chevalier.temperaturemonitor.databinding.ItemTemperatureHumidityBinding
import lab.chevalier.temperaturemonitor.model.Feed

class PBSAdapter : RecyclerView.Adapter<PBSAdapter.PBSViewHolder>() {

    private val listData = mutableListOf<Feed>()

    fun setData(data: List<Feed>) {
        this.listData.clear()
        this.listData.addAll(data)
        this.notifyDataSetChanged()
    }

    inner class PBSViewHolder(private val itemTemperatureHumidityBinding: ItemTemperatureHumidityBinding) :
        RecyclerView.ViewHolder(itemTemperatureHumidityBinding.root) {
        fun bind(data: Feed) {
            this.itemTemperatureHumidityBinding.apply {
                tvDate.text = "Tanggal: ${data.createdAt}"
                tvHumidity.text = "Humidity: ${data.field1}"
                tvTemperature.text = "Temperature: ${data.field2}"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PBSViewHolder =
        PBSViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_temperature_humidity,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: PBSViewHolder, position: Int) {
        holder.bind(this.listData[position])
    }

    override fun getItemCount(): Int = this.listData.size

}