package com.example.binchecker.presentation.binresult

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.binchecker.R

class BinResultFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bin_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val args = BinResultFragmentArgs.fromBundle(requireArguments())

        view.findViewById<TextView>(R.id.textViewCountry).text = args.countryName
        view.findViewById<TextView>(R.id.textViewBankName).text = args.bankName
        view.findViewById<TextView>(R.id.textViewScheme).text = args.scheme
        // и тд
    }
}