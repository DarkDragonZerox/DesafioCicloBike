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


    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //Cambiar por binding
        val ciclovia = itemView.findViewById<TextView>(R.id.tv_cicloVia)
        val comuna = itemView.findViewById<TextView>(R.id.tv_comuna)

        fun bind(lC: Ciclovia) {
            ciclovia.text = lC.nombre
            comuna.text = lC.comuna

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {

        val binding=ItemListBikeBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        val view =binding.root
        return VH(view)

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