package ni.edu.uca.notafinal

/*Calcular la nota final de un estudiante que posee 2 sistemáticos de 20 puntos cada uno y un
examen de 60. Mostrar un mensaje al usuario que permita ver si aprobó o reprobó (aprobado
mayor a 85 pts.)*/

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ni.edu.uca.notafinal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        notaFinal()
    }

    private fun notaFinal() {
        val btn = binding.btnCalcular.setOnClickListener(View.OnClickListener {
            val nota = 20 + 20 + 60
            if(nota > 85){
                binding.tvMensaje.setText("Aprobado")
            }else{
                binding.tvMensaje.setText("Reprobado")
            }
        })
    }
}