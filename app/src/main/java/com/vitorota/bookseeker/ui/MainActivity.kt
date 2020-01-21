package com.vitorota.bookseeker.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.vitorota.bookseeker.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val navController get() = findNavController(R.id.navHostFragment)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()
    }

    private fun setupView() {
        bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_readingNow -> navController.navigate(R.id.nav_readingNow)
                R.id.menu_library -> navController.navigate(R.id.nav_library)
                R.id.menu_book_store -> navController.navigate(R.id.nav_bookStore)
                R.id.menu_search -> navController.navigate(R.id.nav_search)
            }

            supportActionBar?.title = navController.currentDestination?.label

            true
        }

        bottomNav.setOnNavigationItemReselectedListener {
            //do nothing, since the item is already selected
        }
    }
}