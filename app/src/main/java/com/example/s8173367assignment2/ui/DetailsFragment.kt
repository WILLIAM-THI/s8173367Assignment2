package com.example.s8173367assignment2.ui

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.s8173367assignment2.R

class DetailsFragment : Fragment(R.layout.fragment_details) {

    // HERE IS THE ARGUMENT CODE: This delegate handles extracting the safe args bundle from the nav graph
    private val args: DetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Bind our layout views using standard findViewById
        val tvDetailProp1 = view.findViewById<TextView>(R.id.tvDetailProp1)
        val tvDetailProp2 = view.findViewById<TextView>(R.id.tvDetailProp2)
        val tvDetailDescription = view.findViewById<TextView>(R.id.tvDetailDescription)

        // Grab the actual entity argument object sent over by the Dashboard
        val entity = args.entity

        // Populate all data fields clearly as requested by assignment requirements
        tvDetailProp1.text = entity.property1
        tvDetailProp2.text = entity.property2
        tvDetailDescription.text = entity.description
    }
}
