package com.example.simonsays

import android.media.Image
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_start_game.*


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
        val navController = this.findNavController()
        start_game_button.setOnClickListener{
            navController.navigate(R.id.action_startGameFragment_to_inGameFragment)
        }

    }

}