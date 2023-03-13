package com.example.calculate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var inputNamber = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)
    }

    fun decimalToBinary(decimal: Int): String {
        var quotient = decimal
        var binary = ""

        while (quotient > 0) {
            val remainder = quotient % 2
            binary = "$remainder$binary"
            quotient /= 2
        }

        return binary
    }

    fun hexToBinary(hexa: String) = hexa.toInt(16).toString(2)


    fun octalToBinary(octal: String): String {

        val decimal = octal.toInt(8)

        return Integer.toBinaryString(decimal)
    }

    fun onClickEqual(view: View) {
        val binary = findViewById<TextView>(R.id.binaryResult)
        binary.text = decimalToBinary(inputNamber.toInt())
    }

    fun onClickNumber(view: View) {
      inputNamber+=(view as TextView).text.toString()
    var inputnum=findViewById<TextView>(R.id.inputNumber)
        inputnum.text=inputNamber

    }
    fun onClickDelete(view: View){
        inputNamber=""
        var inputnum=findViewById<TextView>(R.id.inputNumber)
        inputnum.text=inputNamber
    }
}