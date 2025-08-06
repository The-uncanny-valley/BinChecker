package com.example.binchecker.presentation.binsearch

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.binchecker.R
import com.example.binchecker.data.RetrofitInstance
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BinSearchFragment : Fragment(R.layout.fragment_bin_search) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonSearch = view.findViewById<MaterialButton>(R.id.buttonSearch)
        val editBin = view.findViewById<TextInputEditText>(R.id.editBin)
        val buttonHistory = view.findViewById<TextView>(R.id.buttonHistory)

        buttonSearch.setOnClickListener {
            val inputText = editBin.text.toString().trim()
            if (inputText.isEmpty()) {
                Toast.makeText(requireContext(), "This field is empty", Toast.LENGTH_LONG).show()
            } else if (inputText.length == 6 || inputText.length == 8) {
                loadBinInfo(inputText)
            } else {
                Toast.makeText(requireContext(), "Please enter 6 or 8 digits", Toast.LENGTH_SHORT).show()
            }
        }

        buttonHistory.setOnClickListener {
            val action = BinSearchFragmentDirections.actionBinSearchFragmentToBinHistoryFragment()
            findNavController().navigate(action)
        }
    }

    private fun loadBinInfo(bin: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = RetrofitInstance.api.getBinInfo(bin)

                if (response.code() == 429) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(requireContext(), "Достигнут лимит запросов. Попробуйте завтра.", Toast.LENGTH_LONG).show()
                    }
                    return@launch // метка возврата
                }

                if (response.isSuccessful) {
                    val binInfo = response.body()

                    if (binInfo != null) {
                        // Переход к фрагменту с результатом
                        val action =
                            BinSearchFragmentDirections.actionBinSearchFragmentToBinResultFragment(
                                binInfo.bank?.url ?: "",
                                binInfo.bank?.name ?: "",
                                binInfo.bank?.phone ?: "",
                                binInfo.type ?: "",
                                binInfo.bank?.city ?: "",
                                binInfo.scheme ?: "",
                                binInfo.country?.longitude ?: 0,
                                binInfo.country?.latitude ?: 0,
                                binInfo.country?.name ?: "",
                                bin
                            )

                        withContext(Dispatchers.Main) {
                            findNavController().navigate(action)
                        }
                    }

                } else {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(requireContext(), "BIN не найден", Toast.LENGTH_SHORT).show()
                    }
                }

            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(requireContext(), "Ошибка сети", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}