package com.example.parcial_tp3

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavView : BottomNavigationView
    private lateinit var navHostFragment : NavHostFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val premierrentLogo = findViewById<ImageView>(R.id.premier_rent_logo)
        val txtConfiguration = findViewById<TextView>(R.id.txt_configuration)

        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        bottomNavView = findViewById(R.id.bottom_bar)
        NavigationUI.setupWithNavController(bottomNavView, navHostFragment.navController)

        navHostFragment.navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.settingsFragment) {
                premierrentLogo.visibility = View.GONE
                txtConfiguration.visibility = View.VISIBLE
            } else {
                premierrentLogo.visibility = View.VISIBLE
                txtConfiguration.visibility = View.GONE
            }
        }
    }

    fun getUsername(): String? {
        return intent.getStringExtra("username")
    }
}