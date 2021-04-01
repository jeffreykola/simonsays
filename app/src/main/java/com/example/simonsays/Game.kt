package com.example.simonsays

import java.util.*
import kotlin.collections.ArrayList

class Game(var level: Int=0) {
    var showStaus: Boolean = true;

    companion object{
        const val COLORS: Int =  3
        const val START: Int = 0
    }




    public fun getNextLevelSequence(): LinkedList<Int>{
        val sequence:LinkedList<Int> = LinkedList()
        this.level++;
        for (i in 1..level){
            sequence.add((START..COLORS).random())
        }
        return sequence
    }


    fun restartGame(){
        this.level = 0
    }


}