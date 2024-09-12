package com.example.androidtestnutapos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.androidtestnutapos.databinding.ActivityMainBinding
import com.example.androidtestnutapos.ui.daftaruangmasuk.DaftarUangMasukFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentManager = supportFragmentManager
        val daftarUangMasukFragment = DaftarUangMasukFragment()
        val fragment = fragmentManager.findFragmentByTag(DaftarUangMasukFragment::class.java.simpleName)

        if (fragment !is DaftarUangMasukFragment) {
            fragmentManager
                .beginTransaction()
                .add(R.id.frame_container, daftarUangMasukFragment, DaftarUangMasukFragment::class.java.simpleName)
                .commit()
        }
    }


}