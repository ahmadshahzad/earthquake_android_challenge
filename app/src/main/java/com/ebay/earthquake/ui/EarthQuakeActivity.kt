package com.ebay.earthquake.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ebay.earthquake.databinding.EarthQuakeActivityBinding
import com.ebay.earthquake.ui.list.EarthQuakeListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EarthQuakeActivity : AppCompatActivity() {

    private lateinit var binding: EarthQuakeActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = EarthQuakeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportFragmentManager.beginTransaction().apply {
            replace(binding.fragmentContainer.id, EarthQuakeListFragment())
            addToBackStack(null)
            commit()
        }
    }
}