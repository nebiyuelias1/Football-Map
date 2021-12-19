package com.f0otball21.map

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.hbb20.countrypicker.models.CPCountry

class CustomDialogFragment(private val selectedCountry: CPCountry?) : DialogFragment() {
    lateinit var customView: View

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(
                it,
            )
            // Get the layout inflater
            val inflater = requireActivity().layoutInflater;

            // Inflate and set the layout for the dialog
            // Pass null as the parent view because its going in the dialog layout
            customView = inflater.inflate(R.layout.fragment_custom_dialog, null)
            customView.findViewById<TextView>(R.id.country).text = selectedCountry?.name

            val tabLayout: TabLayout = customView.findViewById(R.id.tab_layout)
            val viewPager: ViewPager = customView.findViewById(R.id.view_pager)

            viewPager.adapter = CustomAdapter(childFragmentManager)
            tabLayout.setupWithViewPager(viewPager)

            builder.setView(customView)
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return customView
    }
}