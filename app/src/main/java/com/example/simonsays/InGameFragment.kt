package com.example.simonsays

import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.widget.ImageButton
import kotlinx.android.synthetic.main.fragment_in_game.*
import java.util.*
import kotlin.collections.ArrayList


class InGameFragment : Fragment() {
    private lateinit var buttonAnimation: AnimationDrawable
    val currentGame: Game = Game()
    // This should be a property of game?
    val correctSequence: Queue<Int> = currentGame.getNextLevelSequence()

    private fun getColor(level: Int): String{
        return when(level) {
            0 -> "Red"
            1 -> "Blue"
            2 -> "Green"
            3 -> "Yellow"
            else ->{
                "Could not find color..."
            }
        };
    }

    private fun getNumberFromButton(view: ImageButton): Int{
        return when(view.id){
            red_button.id -> 0
            blue_button.id -> 1
            green_button.id -> 2
            yellow_button.id -> 3

            else -> {
                -1
            }
        }
    }


    private fun getButtonFromNumber(number: Int):ImageButton?{
        return when(number){
            0 -> red_button
            1 -> blue_button
            2 -> green_button
            3 -> yellow_button

            else -> {
                null
            }
        }
    }

    private lateinit var buttons: ArrayList<ImageButton>;
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_in_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        level.setText(currentGame.level.toString())

        buttons = ArrayList(listOf<ImageButton>(red_button, blue_button, green_button, yellow_button))
        setOnClickListeners()


        // All of this only runs once
        // Would like this to be an interruptive event
        showChoices()
        toggleButtonEnabledBasedOnShowStatus()



    }

    override fun onResume() {
        super.onResume()
        // Toggle and receive & check color choices
        // restart game or invoke interruptive event again
    }

    override fun onPause() {
        super.onPause()
    }

    private fun showChoices(){
        currentGame.showStaus = false
        toggleButtonEnabledBasedOnShowStatus()
    }

    // I think this should be in the Game class
    // This was correctSequenceQueue.isEmpty()
    private fun checkChoice(view: ImageButton): Boolean{
        return getNumberFromButton(view) == correctSequence.remove()
    }



    private fun setOnClickListeners(){
        for(button in buttons){
            button.setOnClickListener {
                val choice: Boolean = checkChoice(it as ImageButton)
                if(!choice) currentGame.restartGame()
            }
        }
    }

    // Wouldn't need to do this if showChoices() blocked the UI thread?
    private fun toggleButtonEnabledBasedOnShowStatus(){

    }

    private fun getAnimation(view: ImageButton){
        view.setImageResource(when (view.id) {
            red_button.id -> R.drawable.red_button_animate
            blue_button.id -> R.drawable.blue_button_animate
            green_button.id -> R.drawable.green_button_animate
            yellow_button.id -> R.drawable.yellow_button_animate
            else -> {
                -1
            }
        })
        buttonAnimation = (view.drawable as AnimationDrawable)
    }


}