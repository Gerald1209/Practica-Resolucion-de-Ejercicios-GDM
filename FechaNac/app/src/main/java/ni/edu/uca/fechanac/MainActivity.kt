package ni.edu.uca.fechanac
/*Leer la fecha de nacimiento de una persona, calcular su edad. Si es menor de edad mostrar
la imagen de un juguete y si es menor de edad mostrar la imagen de una factura.*/

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ni.edu.uca.fechanac.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        calEdad()

        //binding.gifcalen.setImageResource(R.drawable.boxeador)
    }

    private fun calEdad() {
        val btn = binding.btnCalcular.setOnClickListener(View.OnClickListener {
            val fecha:String = binding.etFecha.text.toString()
            val fchNac:Date = SimpleDateFormat("dd/MM/yyy").parse(fecha)
            var fchActual = Date(System.currentTimeMillis())
            var difFechasMili = fchActual.time - fchNac.time
            var seg = difFechasMili/1000
            var min = seg/60
            var hr = min/60
            var dias = hr/24
            var años = dias/365

            if(años < 18){
                binding.ivImagen.setImageResource(R.drawable.cubo)
            }else if(años >= 18){
                binding.ivImagen.setImageResource(R.drawable.factura)
            }
        })
    }
}