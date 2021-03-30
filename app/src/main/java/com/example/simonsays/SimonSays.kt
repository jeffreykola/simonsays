package com.example.simonsays

class SimonSays(val level: Int, var sequence:ArrayList<Int> = ArrayList()) {
    init {
        for (i in 1..level){
            sequence.add((START..COLORS).random())
        }
    }
    companion object{
        const val COLORS: Int =  4
        const val START: Int = 0
    }


}

