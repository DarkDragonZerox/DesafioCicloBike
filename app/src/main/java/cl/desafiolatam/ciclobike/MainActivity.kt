package cl.desafiolatam.ciclobike

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import cl.desafiolatam.ciclobike.databinding.ActivityMainBinding

/*
    Recursos
        []view binding (activado)

        []recycler view
        [x]cardview
    requisitos
        [x] creacion de botones 2
            [x]implementacion
        [] filtro con sentencia when (Las Condes)
        [x] convertir clases a kotlin
        [x] creacion de proyecto


 */
class MainActivity : AppCompatActivity() {
    val cicloviaAdapter = CicloviaAdapter()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvLista.adapter = cicloviaAdapter
        binding.rvLista.layoutManager = LinearLayoutManager(this)
        binding.btFiltrar.setOnClickListener {
            Log.d(TAG, "onCreate: Haciendo click en filtrar")
            cicloviaAdapter.updateAdapterFilter()
        }
        binding.btLista.setOnClickListener {
            Log.d(TAG, "onCreate: Haciendo click en filtrar")
            cicloviaAdapter.updateAdapterNoFilter()
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}