package com.example.parcial_tp3.Entities
import java.io.Serializable

class Car(name: String?, transmission: String?, fuel: String?, year: Int?, seats: Int?): Serializable {

    var name: String = ""
    var transmission: String = ""
    var fuel: String = ""
    var year: Int = 0
    private var seats: Int = 0

    init {
        this.name = name!!
        this.transmission = transmission!!
        this.fuel = fuel!!
        this.year = year!!
        this.seats = seats!!
    }

    class Constants {
        companion object {
            val transmissionA = "Automatic"
            val transmissionB = "Manual"
            val fuelA = "Electric"
            val fuelB = "Gas"
            val seatsA = "two seater"
            val seatsB = "four seater"
        }
    }

}