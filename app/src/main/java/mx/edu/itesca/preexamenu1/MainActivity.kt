package mx.edu.itesca.preexamenu1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val numCelsius=findViewById<EditText>(R.id.etC)
        val numFah=findViewById<EditText>(R.id.etF)
        val calcCelsius=findViewById<Button>(R.id.btnGC)
        val calcFah=findViewById<Button>(R.id.btnGF)
        calcCelsius.setOnClickListener {
            val fahr = numFah.text.toString().toDoubleOrNull()
            if(fahr !== null){
                val celsius = (fahr - 32) / 1.8
                numCelsius.setText(celsius.toString())
            } else {
                numCelsius.setText("")
            }
        }

        calcFah.setOnClickListener {
            val celsius = numCelsius.text.toString().toDoubleOrNull()
            if(celsius!==null){
                val fahr = celsius * 1.8 + 32
                numFah.setText(fahr.toString())
            } else {
                numFah.setText("")
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}