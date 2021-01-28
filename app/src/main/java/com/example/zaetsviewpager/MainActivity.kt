package com.example.zaetsviewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.zaetsviewpager.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val countryList: ArrayList<Country> = getCountryList()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.viewPager.adapter = CountryPagerAdapter(this, countryList)
        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = countryList[position].name
        }.attach()
    }

    private fun getCountryList(): ArrayList<Country> {
        val list = ArrayList<Country>()
        list.add(Country("Norge", 5367580, 385207))
        list.add(Country("Canada", 37602103, 9984670))
        list.add(Country("New Zealand", 4848477, 268680))
        list.add(Country("Ísland", 357050, 103125))
        list.add(Country("England", 55977000, 133396))
        return list
    }
}