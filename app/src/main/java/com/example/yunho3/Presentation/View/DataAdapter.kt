package com.example.yunho3.Presentation.View

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yunho3.DataSource.Entity.DataEntity
import com.example.yunho3.databinding.ItemDataBinding

class DataAdapter : RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    private var DataList = listOf<DataEntity>()
    private lateinit var ItemListener: (DataEntity) -> Unit
    inner class ViewHolder(
        private val binding: ItemDataBinding,
        private val Listener: (DataEntity) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {

            fun bindData(entity: DataEntity) = with(binding){
                titleItem.text = entity.Data

                root.setOnClickListener {
                    Listener(entity)
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataAdapter.ViewHolder {
        val view = ItemDataBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view,ItemListener)
    }

    override fun onBindViewHolder(holder: DataAdapter.ViewHolder, position: Int) {
        holder.bindData(DataList[position])
    }

    override fun getItemCount(): Int = DataList.size

    fun setData(list:List<DataEntity>,Listener: (DataEntity) -> Unit){
        DataList = list
        ItemListener = Listener
        notifyDataSetChanged()
    }

}