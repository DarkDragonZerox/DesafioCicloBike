package cl.desafiolatam.ciclobike

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cl.desafiolatam.ciclobike.databinding.ItemListBikeBinding
import com.example.ciromine.ciclobike.Ciclovia
import com.example.ciromine.ciclobike.SetupCiclovias

class CicloviaAdapter: RecyclerView.Adapter<CicloviaAdapter.VH>() {

    val cicloviasSetUp = SetupCiclovias()
    var listaCiclovias = cicloviasSetUp.getCiclovias()


    class VH(var binding:ItemListBikeBinding) : RecyclerView.ViewHolder(binding.root) {



        fun bind(lC: Ciclovia) {
            binding.tvCicloVia.text=lC.nombre
            binding.tvComuna.text = lC.comuna

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {

        val binding=ItemListBikeBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return VH(binding)

    }

    override fun onBindViewHolder(holder: VH, position: Int) {

        val lC = listaCiclovias.get(position)
        holder.bind(lC)

    }

    override fun getItemCount(): Int {
        return listaCiclovias.size
    }

    fun updateAdapterFilter(){
        listaCiclovias.clear()
        listaCiclovias=cicloviasSetUp.getListaFiltrada()
        notifyDataSetChanged()
    }
    fun updateAdapterNoFilter(){
        listaCiclovias.clear()
        listaCiclovias=cicloviasSetUp.getCiclovias()
        notifyDataSetChanged()
    }

}