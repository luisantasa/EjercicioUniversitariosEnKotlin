package com.luistabada.logica14

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //Referencia a la interfaz grafica (EditText, Button, TextView)
        val divide = findViewById<EditText>(R.id.dividendo)
        val diviso = findViewById<EditText>(R.id.divisor)
        val boto = findViewById<Button>(R.id.btn)
        val respu = findViewById<TextView>(R.id.respuesta)
        //Accion que se ejecuta cuando se presiona el boton
        boto.setOnClickListener {
            // Convertimos el contenido de los campos divide y diviso a texto, eliminando espacios al inicio y al final
            val didendo = divide.text.toString().trim()
            val disor = diviso.text.toString().trim()
            // Verificamos que el usuario haya ingresado valores en ambos campos antes de continuar
            if (didendo.isEmpty() || disor.isEmpty()){
                Toast.makeText(this, "por favor ingrese un numero", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            //Convertir los EditText a Int
            val dividendoo = didendo.toIntOrNull()
            val divisoor = disor.toIntOrNull()
            //Verificando correcion correcta
            if (dividendoo == null || divisoor == null){
                Toast.makeText(this, "Por favor ingrese un numero valido", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            //evitar divisioción entre cero
            if (divisoor == 0){
                Toast.makeText(this, "El divisor no puede ser cero", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            //Llamada a la funcion divisicionresta
            val resultado = divisionResta(dividendoo,divisoor)
            respu.text = "Cociente: ${resultado.cociente}, Residuo: ${resultado.residuo} "
        }
    }
}