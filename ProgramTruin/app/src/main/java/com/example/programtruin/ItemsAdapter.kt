package com.example.programtruin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.programtruin.ItemsAdapter.ItemsAdapterVH
import kotlinx.android.synthetic.main.row_items.view.*

class ItemsAdapter
    (var clickListener: ClickListener)
    : RecyclerView.Adapter<ItemsAdapterVH>(), Filterable {

    var itemsModalList = ArrayList<itemsModal>();
    var itemsModalListFilter = ArrayList<itemsModal>();

    fun setData(itemsModalList: ArrayList<itemsModal>){
        this.itemsModalList = itemsModalList;
        this.itemsModalListFilter = itemsModalList;
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsAdapterVH {
        return ItemsAdapterVH(LayoutInflater.from(parent.context).inflate(R.layout.row_items,parent,false))
    }

    override fun onBindViewHolder(holder: ItemsAdapterVH, position: Int) {

        val itemsModal = itemsModalList[position];
        holder.name.text = itemsModal.name
        holder.desc.text = itemsModal.desc
        holder.image.setImageResource(itemsModal.image)

        holder.itemView.setOnClickListener{
            clickListener.ClickedItem(itemsModal)
        }
    }

    override fun getItemCount(): Int {
        return itemsModalList.size
    }

    class  ItemsAdapterVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.tvName
        val desc = itemView.tvDesc
        val image = itemView.imageView
    }

    interface ClickListener{
        fun ClickedItem(itemsModal: itemsModal)
    }

    override fun getFilter(): Filter {
        return  object : Filter(){
            override fun performFiltering(charsequence: CharSequence?): FilterResults {
                val filterResults = FilterResults();
                if(charsequence == null || charsequence.length < 0){
                    filterResults.count = itemsModalListFilter.size
                    filterResults.values = itemsModalListFilter
                }else{
                    var searchChr = charsequence.toString().toLowerCase()

                    val itemModal = ArrayList<itemsModal>()

                    for(item in itemsModalListFilter){
                        if(item.name.contains(searchChr)|| item.desc.contains(searchChr)){
                            itemModal.add(item)
                        }
//                        if(item.desc.contains(searchChr)){
//                            itemModal.add(item)
//                        }
                    }
                    filterResults.count = itemModal.size
                    filterResults.values = itemModal
                }
                return  filterResults
            }

            override fun publishResults(constraint: CharSequence?, filterResults: FilterResults?) {
                itemsModalList = filterResults!!.values as ArrayList<itemsModal>
                notifyDataSetChanged()
            }

        }
    }
}