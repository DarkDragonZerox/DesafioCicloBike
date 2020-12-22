package cl.desafiolatam.ciclobike

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}