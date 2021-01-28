package com.example.zaetsviewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.zaetsviewpager.databinding.PagerFragmentBinding
import kotlin.math.roundToInt

class CountryFragment: Fragment() {
    private lateinit var binding: PagerFragmentBinding

    companion object {
        const val COUNTRY_NAME = "COUNTRY_NAME"
        const val POPULATION = "POPULATION"
        const val SQUARE = "SQUARE"

        fun newInstance(countryName: String, population: Int, square: Int): CountryFragment {
            val countryFragment = CountryFragment()
            val bundle = Bundle().apply {
                putString(COUNTRY_NAME, countryName)
                putInt(POPULATION, population)
                putInt(SQUARE, square)
            }
            countryFragment.arguments = bundle

            return countryFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PagerFragmentBinding.inflate(inflater, container, false)

        setupData()
        return binding.root
    }

    private fun setupData() {
        val countryName = arguments?.getString(COUNTRY_NAME)
        val population = arguments?.getInt(POPULATION) as Int
        val square = arguments?.getInt(SQUARE) as Int
        val density = (population.toDouble() / square * 100.0).roundToInt() / 100.0

        binding.tvName.text = countryName
        binding.tvPopulation.text = population.toString()
        binding.tvSquare.text = square.toString()
        binding.tvPopulationDensity.text = density.toString()
    }

}