package com.example.binchecker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class BinSearchFragment : Fragment(R.layout.fragment_bin_search) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonSearch = view.findViewById<MaterialButton>(R.id.buttonSearch)
        val editBin = view.findViewById<TextInputEditText>(R.id.editBin)
        val starImage = view.findViewById<ImageView>(R.id.starImage)

        buttonSearch.setOnClickListener {
            val inputText = editBin.text.toString().trim()
            if (inputText.isEmpty()) {
                Toast.makeText(requireContext(), "This field is empty", Toast.LENGTH_LONG).show()
            } else if (inputText.length == 6 || inputText.length == 8) {
                startAnimation(starImage)
            } else {
                Toast.makeText(requireContext(), "Please enter 6 or 8 digits", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun startAnimation(starImage: ImageView) {
        val rotateAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.rotate_star)
        starImage.startAnimation(rotateAnimation)
    }
}
