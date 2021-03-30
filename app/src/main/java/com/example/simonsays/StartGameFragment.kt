package com.example.simonsays

import android.media.Image
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton



class StartGameFragment : Fragment() {
    private lateinit var buttons: ArrayList<ImageButton>;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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