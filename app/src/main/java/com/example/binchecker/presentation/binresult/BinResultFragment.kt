package com.example.binchecker.presentation.binresult

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
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

        view.findViewById<TextView>(R.id.textViewBin).text =
            getString(R.string.bin_number, args.binNumber.ifBlank { "?" })
        view.findViewById<TextView>(R.id.textViewCountry).text =
            getString(R.string.country, args.countryName.ifBlank { "?" })
        view.findViewById<TextView>(R.id.textViewType).text =
            getString(R.string.type, args.type.ifBlank { "?" })
        view.findViewById<TextView>(R.id.textViewScheme).text = args.scheme.ifBlank { "?" }

        val bankName = args.bankName.ifBlank { "?" }
        val bankCity = args.bankCity.ifBlank { "?" }
        val bankPhone = args.bankPhone.ifBlank { "?" }
        val bankUrl = args.bankUrl.ifBlank { "?" }

        val bankInfo = getString(
            R.string.bank_info,
            bankName,
            bankCity,
            bankPhone,
            bankUrl
        )

        view.findViewById<TextView>(R.id.textViewBankInfo).text = bankInfo
    }
}