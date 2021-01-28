package com.example.zaetsviewpager

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class CountryPagerAdapter(fragment: AppCompatActivity, private val items: ArrayList<Country>): FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun createFragment(position: Int): Fragment {
        val country = items[position]
        return CountryFragment.newInstance(country.name, country.population, country.square)
    }
}