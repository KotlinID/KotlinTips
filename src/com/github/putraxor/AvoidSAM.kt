package com.github.putraxor

/**
 * Class ini adalah contoh penggunaan lambda untuk
 * menghindari Single Abstract Method (SAM) agar lebih
 * sederhana dan lebih rapi.
 *
 * Property [data] milik Samy
 * Kita ingin jika [data] berubah dan Samy diberi [listener]
 * untuk men-triger suatu aksi jika terjadi perubahan [data] tersebut
 *
 * Created by putraxor on 22/06/17.
 */

class Samy {
    var data: String = ""
        set(value) {
            field = value
            listener?.invoke(value)
        }

    private var listener: ((String) -> Unit)? = null

    fun setOnDataChangeListener(listener: (data: String) -> Unit) {
        this.listener = listener
    }
}

/**
 * Contoh class lain untuk case Kalkulator
 */
class Kalkulator {
    private var angkaSatu = 0.0
    private var angkaDua = 0.0

    fun setAngkat(satu: Double, dua: Double) {
        angkaSatu = satu
        angkaDua = dua
        operasiMatematis()
        println("")
    }

    private fun operasiMatematis() {
        tambahListener?.invoke(angkaSatu, angkaDua)
        kurangListener?.invoke(angkaSatu, angkaDua)
        kaliListener?.invoke(angkaSatu, angkaDua)
        bagiListener?.invoke(angkaSatu, angkaDua)
    }

    var tambahListener: ((Double, Double) -> Unit)? = null
    var kurangListener: ((Double, Double) -> Unit)? = null
    var kaliListener: ((Double, Double) -> Unit)? = null
    var bagiListener: ((Double, Double) -> Unit)? = null

}


fun main(args: Array<String>) {
    val sam = Samy()
    sam.setOnDataChangeListener {
        println("Wew, Samy has new data = $it")
    }
    sam.data = "Give Samy some data"
    sam.data = "What about another one"
    sam.data = "Greate! Samy listen to you"
    println("\n\n-------------------------\n\n")

    val kalkulator = Kalkulator()

    //listener operasi tambah
    kalkulator.tambahListener = { satu, dua ->
        run {
            println("$satu + $dua = ${satu + dua}")
        }
    }

    //listener operasi kurang
    kalkulator.kurangListener = { satu, dua ->
        run {
            println("$satu - $dua = ${satu - dua}")
        }
    }

    //listener operasi kali
    kalkulator.kaliListener = { satu, dua ->
        run {
            println("$satu * $dua = ${satu * dua}")
        }
    }

    //listener operasi bagi
    kalkulator.bagiListener = { satu, dua ->
        run {
            println("$satu : $dua = ${satu / dua}")
        }
    }

    kalkulator.setAngkat(satu = 10.0, dua = 21.0)
    kalkulator.setAngkat(satu = 11.0, dua = 20.0)
    kalkulator.setAngkat(satu = 12.0, dua = 19.0)
}