package com.example.calculate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var inputNamber = ""
    var inputType=""
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
        Log.i("hawraa",inputType)
        when (inputType){
            "Decimal"->{
                val binary = findViewById<TextView>(R.id.binaryResult)
                binary.text = decimalToBinary(inputNamber.toInt())
                val octal = findViewById<TextView>(R.id.octResult)
                octal.text = decimalToOctal(inputNamber.toInt())
                val decimal = findViewById<TextView>(R.id.decimalResult)
                decimal.text = inputNamber
                val hexa = findViewById<TextView>(R.id.hexaResult)
                hexa.text = decimalToHex(inputNamber.toInt())
            }
            "Octal"->{
                val binary = findViewById<TextView>(R.id.binaryResult)
                binary.text = octalToBinary(inputNamber)
                val octal = findViewById<TextView>(R.id.octResult)
                octal.text = inputNamber
                val decimal = findViewById<TextView>(R.id.decimalResult)
                decimal.text = octTodecimal(inputNamber)
                val hexa = findViewById<TextView>(R.id.hexaResult)
                hexa.text = octalTohexa(inputNamber)

            }
            "HexaDecimal"->{
                val binary = findViewById<TextView>(R.id.binaryResult)
                binary.text = hexToBinary(inputNamber)
                val octal = findViewById<TextView>(R.id.octResult)
                octal.text = hexaToOct(inputNamber)
                val decimal = findViewById<TextView>(R.id.decimalResult)
                decimal.text = hexatodecimal(inputNamber)
                val hexa = findViewById<TextView>(R.id.hexaResult)
                hexa.text = inputNamber

            }
            "Binary"-> {
                val binary = findViewById<TextView>(R.id.binaryResult)
                binary.text = (inputNamber)
                val octal = findViewById<TextView>(R.id.octResult)
                octal.text = binaryToOctal(inputNamber)
                val decimal = findViewById<TextView>(R.id.decimalResult)
                decimal.text = binaryToDecimal(inputNamber)
                val hexa = findViewById<TextView>(R.id.hexaResult)
                hexa.text = binaryToHex(inputNamber)
            }
            }
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
    fun binaryToOctal(binary: String):String {

        val decimal = binary?.toInt(2)

        return decimal?.toString(8).toString()

    }

    fun decimalToOctal(decimalNumber: Int): String {
        return Integer.toString(decimalNumber, 8)
    }
    fun hexToOct(hex: String): String {
        val decimal = hex.toInt(16)
        return decimal.toString(8)

    }
   fun inputType(view: View){
       inputType=(view as TextView).text.toString()
   }
    fun decimalToHex(decimal: Int): String {
        return decimal.toString(16).uppercase()
    }
    fun octalTohexa(octal: String): String {
        val decimal = octal.toInt(8)
        return decimal.toString(16).uppercase()
    }
    fun hexaToOct(hex: String): String {
        val decimal = hex.toLong(16) // Convert hexadecimal to decimal
        val octal = java.lang.Long.toOctalString(decimal) // Convert decimal to octal
        return octal
    }
    fun octTodecimal(octal: String): String {
        return  octal.toInt(8).toString()
    }
    fun hexatodecimal(hex: String): String {
        return hex.toInt(16).toString()
    }
    fun binaryToDecimal(binary: String):String {
        return binary.toInt(2).toString()
    }
    fun binaryToHex(binary: String): String {
        val decimal = binary.toInt(2)
        return decimal.toString(16).uppercase()
    }


}