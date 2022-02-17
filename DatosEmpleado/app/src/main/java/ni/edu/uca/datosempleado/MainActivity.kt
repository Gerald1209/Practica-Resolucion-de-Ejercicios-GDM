package ni.edu.uca.datosempleado
/*Dado los datos un empleado: nombre, cargo, salario. Aumentar el salario de dicho empleado
en un 20% si salario es menor a C$ 5,000.00; en un 15% si esta entre el rango de C$ 5000.01
a C$ 10,000.00 y en un 10% si es mayor o igual a C$ 10,000.01
*/
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ni.edu.uca.datosempleado.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Empleado()
    }

    private fun Empleado() {
        val btn = binding.btnAumentar.setOnClickListener(View.OnClickListener {
            val nomb:String = binding.etNomb.text.toString()
            val cargo:String = binding.etCargo.text.toString()
            val sal:Double = binding.etSalario.text.toString().toDouble()
            val aum: Double

            if(sal <= 5000){
                aum = sal * 1.20
                binding.tvMensaje.setText("Nombre: $nomb Cargo:  $cargo Salario: $sal  Aumento: $aum")
            }else if(sal >= 5000.01 && sal <= 10000){
                aum = sal * 1.15
                binding.tvMensaje.setText("Nombre: $nomb Cargo:  $cargo Salario: $sal  Aumento: $aum")
            }else if(sal >= 10000.01) {
                aum = sal * 1.10
                binding.tvMensaje.setText("Nombre: $nomb Cargo:  $cargo Salario: $sal  Aumento: $aum")
            }

        })

    }
}