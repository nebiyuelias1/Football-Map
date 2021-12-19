package com.f0otball21.map

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class CustomAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence = when (position) {
        0 -> "Teams"
        1 -> "Events"
        else -> ""
    }

    override fun getItem(position: Int): Fragment = when (position) {
        0 -> TeamsFragment.newInstance()
        1 -> EventsFragment.newInstance()

        else -> TeamsFragment.newInstance()
    }
}