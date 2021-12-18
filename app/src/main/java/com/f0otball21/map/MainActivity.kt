package com.f0otball21.map

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hbb20.CountryPickerView
import com.hbb20.countrypicker.models.CPCountry

class MainActivity : AppCompatActivity() {
    var isCountryDialogOpened = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupCountryPickerView()
    }

    private fun setupCountryPickerView() {
        val countryPicker = findViewById<CountryPickerView>(R.id.countryPicker)


        // Modify CPViewConfig if you need. Access cpViewConfig through `cpViewHelper`
        countryPicker.cpViewHelper.cpViewConfig.viewTextGenerator = { cpCountry: CPCountry ->
            "${cpCountry.name} (${cpCountry.alpha3})"
        }

        val color = getColor(android.R.color.white);
        countryPicker.setBackgroundColor(color)
        countryPicker.tvCountryInfo.setPadding(8, 8, 8, 8)

        countryPicker.cpViewHelper.onCountryChangedListener = { selectedCountry: CPCountry? ->
            if (isCountryDialogOpened) {
                if (selectedCountry != null) {
                    CustomDialogFragment(selectedCountry).show(supportFragmentManager, null);
                }
            }
            isCountryDialogOpened = true;
        }

        // make sure to refresh view once view configuration is changed
        countryPicker.cpViewHelper.refreshView()
    }

}