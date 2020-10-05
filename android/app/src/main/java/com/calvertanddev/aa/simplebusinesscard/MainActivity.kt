package com.calvertanddev.aa.simplebusinesscard

import android.app.Application
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.calvertanddev.aa.simplebusinesscard.databinding.ActivityMainBinding
import com.calvertanddev.aa.simplebusinesscard.ui.debugdrawer.ServerOptionModule
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import io.palaima.debugdrawer.DebugDrawer
import io.palaima.debugdrawer.commons.BuildModule
import io.palaima.debugdrawer.commons.DeviceModule
import io.palaima.debugdrawer.commons.NetworkModule
import io.palaima.debugdrawer.commons.SettingsModule
import io.palaima.debugdrawer.logs.LogsModule
import io.palaima.debugdrawer.okhttp3.OkHttp3Module
import io.palaima.debugdrawer.timber.TimberModule
import java.io.File
import java.util.concurrent.TimeUnit
import kotlinx.android.synthetic.main.app_bar_main.view.toolbar
import okhttp3.Cache
import okhttp3.OkHttpClient

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var okHttpClient: OkHttpClient

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.inclAppBar.toolbar)

        if (BuildConfig.DEBUG) {
            okHttpClient = createOkHttpClientDebugDrawer(this.application).build()
            setupDebugDrawer()
        }

        addKoinModules()

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(

            ), binding.drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = (findNavController(R.id.nav_host_fragment))
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }


    private fun createOkHttpClientDebugDrawer(application: Application): OkHttpClient.Builder {
        val cacheDir = File(application.cacheDir, "okhttp3-cache")
        val cache = Cache(cacheDir, 30 * 1024 * 1024)

        return OkHttpClient.Builder()
            .cache(cache)
            .addInterceptor(LogsModule.chuckInterceptor(application))
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
    }

    private fun setupDebugDrawer() {
        DebugDrawer.Builder(this)
            .modules(
                ServerOptionModule(),
                TimberModule(),
                OkHttp3Module(okHttpClient),
                LogsModule(),
                DeviceModule(),
                BuildModule(),
                NetworkModule(),
                SettingsModule()
            ).build()
    }

    private fun addKoinModules() {

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}