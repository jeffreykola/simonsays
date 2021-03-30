package com.example.simonsays

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import kotlinx.android.synthetic.main.fragment_in_game.*
import kotlinx.android.synthetic.main.fragment_in_game.view.*


class InGameFragment : Fragment() {

    private fun getColor(level: Int): String{
        when(level) {
            0 -> return "Red"
            1 -> return "Blue"
            2-> return "Green"
            3 -> return "Yellow"
            else ->{
                return "Color not found.."
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
        buttons = ArrayList(listOf<ImageButton>(red_button, blue_button, green_button))

}


    private fun showColor(view: ImageButton, on: Boolean){
        if(on) view.background.alpha = 255
        else view.background.alpha = 128
    }

    private fun reset(view: ImageButton){
        for(button in this.buttons){
            showColor(button, false)
        }
    }

    private fun getChoices(){

    }


}