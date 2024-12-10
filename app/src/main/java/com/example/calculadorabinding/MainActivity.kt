package com.example.calculadorabinding

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadorabinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.botonSuma.setOnClickListener {
            val primerNum = binding.primerNumero.text.toString().toInt()
            val segundoNum = binding.segundoNumero.text.toString().toInt()

            val suma = primerNum + segundoNum

            binding.resultado.text = "Resultado: ${suma}"
        }

        binding.botonResta.setOnClickListener {
            val primerNum = binding.primerNumero.text.toString().toInt()
            val segundoNum = binding.segundoNumero.text.toString().toInt()

            val resta = primerNum - segundoNum

            binding.resultado.text = "Resultado: ${resta}"
        }

        binding.botonMultiplicacion.setOnClickListener {
            val primerNum = binding.primerNumero.text.toString().toInt()
            val segundoNum = binding.segundoNumero.text.toString().toInt()

            val multiplicacion = primerNum * segundoNum

            binding.resultado.text = "Resultado: ${multiplicacion}"
        }

        binding.botonDivision.setOnClickListener {
            val primerNum = binding.primerNumero.text.toString().toInt()
            val segundoNum = binding.segundoNumero.text.toString().toInt()

            val division : Int = if (primerNum < 1 || segundoNum < 1) {
                0
            } else {
                primerNum / segundoNum
            }

            binding.resultado.text = "Resultado: ${division}"
        }
    }
}