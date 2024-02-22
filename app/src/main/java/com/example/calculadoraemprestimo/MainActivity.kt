package com.example.calculadoraemprestimo

import android.health.connect.datatypes.units.Length
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.makeText
import android.widget.Toast.LENGTH_SHORT
import java.text.DecimalFormat
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalc = findViewById<Button>(R.id.btnCalc)
        btnCalc.setOnClickListener{
            val df = DecimalFormat(".##")
            val empr = findViewById<EditText>(R.id.editEmpr)
            val tempo = findViewById<EditText>(R.id.edtTempo)
            val taxa = findViewById<EditText>(R.id.edtTaxa)
            val resultado =  findViewById<TextView>(R.id.resultado)
            if(tempo.text.isEmpty()){
                makeText(this,"Dividir valor do emprestimo",LENGTH_SHORT).show()
            }
            if(tempo.text.isEmpty()){
                makeText(this,"Digite o tempo de emprestimo", LENGTH_SHORT).show()
        }
            if(taxa.text.isEmpty()) {
                makeText(this,"digite a taxa de juros%",LENGTH_SHORT).show()
            }

            val nempr = empr.text.toString().toDouble()
            val ntempo = tempo.text.toString().toDouble()
            val ntaxa = taxa.text.toString().toDouble()/100.0
            val nresultado = nempr*((((1+ntaxa).pow(ntempo))*ntaxa)/(((1+ntaxa).pow(ntempo))-1))
            //val ntotal = ntempo * nresultado
                    //resultado.setText("$ntempo")
                    resultado.setText("${df.format(nresultado)} x $ntempo = ${df.format(resultado)}")
        }
    }
}