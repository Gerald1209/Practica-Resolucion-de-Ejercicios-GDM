package ni.edu.uca.adivinarnum
/*Realice una aplicación que permita simular un juego de adivinar un numero entre un rango
predeterminado por el usuario, se tendrán máximo 3 intentos para adivinar dicho número.*/

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ni.edu.uca.adivinarnum.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var numSel= 0
    var intentos= 3
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Adivinar()

    }

    private fun Adivinar() {

        val btnConf = binding.btnConfirmarRangos.setOnClickListener(View.OnClickListener {
            intentos= 3
            val men: Int = binding.etRangMen.text.toString().toInt()
            val may: Int = binding.etRangMay.text.toString().toInt()
            if (men > may){
                binding.tvResp.setText("Valores incorrectos")
            }else if (men < may){
                numSel = (men..may).random()
                binding.tvResp.setText("")
            }
            binding.tvResp.setText("$numSel")
            binding.btnAdivinar.isEnabled=true
        })

        val btnAdiv = binding.btnAdivinar.setOnClickListener(View.OnClickListener {
            val num :Int = binding.etAdvNum.text.toString().toInt()
            if (intentos != 0 && num == numSel){
                binding.tvResp.setText("Felicidades, acertastes!!!")
                binding.btnAdivinar.isEnabled=false
            } else if(intentos != 0 && num != numSel){
                intentos = intentos - 1
                binding.tvResp.setText("Fallo, le  queda $intentos intentos")
            }
            if(intentos == 0){
                binding.btnAdivinar.isEnabled=false
                binding.tvResp.setText("A finalizado sus 3 intentos")
            }
        })
    }
}
