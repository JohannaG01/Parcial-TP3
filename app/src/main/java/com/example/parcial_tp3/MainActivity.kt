package com.example.parcial_tp3

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavView: BottomNavigationView
    private lateinit var navHostFragment: NavHostFragment
    lateinit var navigationView: NavigationView
    lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val premierrentLogo = findViewById<ImageView>(R.id.premier_rent_logo)
        val txtConfiguration = findViewById<TextView>(R.id.txt_configuration)
        val imgMenu = findViewById<ImageView>(R.id.open_drawer)

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
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

        imgMenu.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.nav_view)

        setUpDrawerLayout()

    }

    fun getUsername(): String? {
        return intent.getStringExtra("username")
    }

    private fun setUpDrawerLayout() {
        val navController = navHostFragment.navController

        navigationView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, _, _ ->
            supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)
        }
    }
}