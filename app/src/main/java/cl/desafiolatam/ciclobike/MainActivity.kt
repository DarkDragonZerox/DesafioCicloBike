package cl.desafiolatam.ciclobike

import android.app.PendingIntent.getActivity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import cl.desafiolatam.ciclobike.databinding.ActivityMainBinding
import com.example.ciromine.ciclobike.SetupCiclovias

/*
Version1.0
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
Version 2.0

     [x]1. Actualizar la Activity del desafío 1, usando los view bindings.
     [X]2. Actualizar los listener de los botones a las funciones lambdas de kotlin.
     [] 3. Modificar la interfaz a lo nuevo requerido que incluye spinner
     [] 4. Ahora usar la función filter para filtrar.
     [] 5. Agregar botón que invierte el orden de la lista.
     Opcional

     []6. Agregar EditText más botón filtrar, que filtra según lo escrito en el editText.
     []7. Hacer que el filtro anterior no sea sensible a mayúsculas y minúsculas.
     []8. Hacer otro filtro igual que el anterior, pero que filtre por el nombre de la ciclovía.
     []9. Hacer otro filtro igual que el anterior, pero donde se ingrese un número y se filtrara si la
          comuna tiene un largo mayor a ese que se ingresó, además la app no debe caerse si se
          ingresa un valor no numérico.
     []10.Hacer otro filtro igual que el anterior, pero donde se ingrese un número y se filtrara si la
          nombre de la ciclovía.


 */
class MainActivity : AppCompatActivity() {
    val cicloviaAdapter = CicloviaAdapter()
    val setupCiclovias=SetupCiclovias()
    val listaSpinner= setupCiclovias.getListaSpinner()

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvLista.adapter = cicloviaAdapter
        binding.rvLista.layoutManager = LinearLayoutManager(this)
        val spinAdapter= ArrayAdapter(this,android.R.layout.simple_spinner_item,listaSpinner)
        binding.spinnerBike.adapter=spinAdapter
        binding.spinnerBike.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                when (listaSpinner[position]) {
                    "Mostrar todo" -> cicloviaAdapter.updateAdapterNoFilter()
                    else -> cicloviaAdapter.updateAdapterFilter(listaSpinner[position])

                }
              //  Toast.makeText(applicationContext, "Item seleccionado ${listaSpinner[position]}" , Toast.LENGTH_SHORT).show()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

    }/*
            Si el valor es mostrar todo, se muestra la lista sin filtrar
            en otro caso se muestra la lista filtrada por el valor
            */
}