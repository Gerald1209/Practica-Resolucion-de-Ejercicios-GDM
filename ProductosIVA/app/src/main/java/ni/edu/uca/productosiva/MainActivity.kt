package ni.edu.uca.productosiva

/*Calcular el total a pagar por la compra de productos en una tienda, la aplicación debe permitir
aplicar IVA del 15% del monto de compra, al igual que mostrar el total a pagar neto por dicha
compra.*/


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ni.edu.uca.productosiva.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        calIva()
    }

    private fun calIva() {
        val btn = binding.btnAplicar.setOnClickListener(View.OnClickListener {
            var st =0.0

            var p1 = Lista("Camisas",100.0,3, 0.0)
            var p2 = Lista("Pantalon",400.0,2, 0.0)
            var p3 = Lista("Calcetines",50.0,4, 0.0)
            val factura = arrayListOf<Lista>(p1,p2,p3)

            binding.tvfact1.setText("\n${factura[0].prod} \t\t\t\t ${factura[0].pre} \t\t\t\t\t\t ${factura[0].cant} \t\t\t\t\t\t\t ${factura[0].costo}")
            binding.tvfact2.setText("\n${factura[1].prod} \t\t\t\t ${factura[1].pre} \t\t\t\t\t\t ${factura[1].cant} \t\t\t\t\t\t\t ${factura[1].costo}")
            binding.tvfact3.setText("\n${factura[2].prod} \t\t\t\t ${factura[2].pre} \t\t\t\t\t\t ${factura[2].cant} \t\t\t\t\t\t\t ${factura[2].costo}")

            for(elemento in factura) {
                elemento.costo = elemento.pre * elemento.cant
                st = st + elemento.costo
            }

            val iva = st * 0.15
            val neto = st + iva
            binding.tvMonto.setText("SubTotal de las compras: $st")
            binding.tvIva.setText("IVA: $iva")
            binding.tvNeto.setText("Valor Neto: $neto")
        })

    }

    data class Lista(
        var prod: String,
        var pre: Double,
        var cant: Int,
        var costo: Double)
}