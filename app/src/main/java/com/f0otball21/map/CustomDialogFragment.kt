package com.f0otball21.map

import android.app.Dialog
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.hbb20.countrypicker.models.CPCountry

class CustomDialogFragment(private val selectedCountry: CPCountry?) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(
                it,
            )
            // Get the layout inflater
            val inflater = requireActivity().layoutInflater;

            // Inflate and set the layout for the dialog
            // Pass null as the parent view because its going in the dialog layout
            val view = inflater.inflate(R.layout.fragment_custom_dialog, null)
            view.findViewById<TextView>(R.id.country).text = selectedCountry?.name
            builder.setView(view)
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}