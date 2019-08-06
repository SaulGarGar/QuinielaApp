package com.example.quinielaapp.modules.actualJourney.views


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.quinielaapp.R

class ActualJourneyFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_actual_journey, container, false)

        initViews(view)

        return view
    }

    fun initViews(view: View){

    }

    companion object {
        fun newInstance(): ActualJourneyFragment {

            val args = Bundle()
            val fragment = ActualJourneyFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
