package com.queens.amber

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.queens.amber.ui.main.SectionsPagerAdapter
import com.queens.amber.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = binding.tabs
        tabs.setupWithViewPager(viewPager)
        val fab: FloatingActionButton = binding.fab

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        override fun getItem(position: Int): Fragment {
            // Return a new fragment for the given tab position
            return when (position) {
                0 -> MapFragment()
                1 -> ConnectFragment()
                2 -> RegisterFragment()
                3 -> HistoryFragment()
                4 -> HomeFragment()
                5 -> ContactFragment()
                6 -> AboutFragment()
                else -> Fragment()
            }
        }

        override fun getPageTitle(position: Int): CharSequence? {
            // Return the tab title for the given position
            return when (position) {
                0 -> "Map"
                1 -> "Se Connecter"
                2 -> "S'enregistrer"
                3 -> "Historique d'ambulances"
                4 -> "Maison"
                5 -> "Contact"
                6 -> "A propos"
                else -> null
            }
        }

        override fun getCount(): Int {
            // Return the total number of tabs
            return 7
        }

    }
}