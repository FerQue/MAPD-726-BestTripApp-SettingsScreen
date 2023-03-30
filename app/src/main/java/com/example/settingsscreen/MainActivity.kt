package com.example.settingsscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.preference.PreferenceManager
import com.example.settingsscreen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        mySettings()

    }

    private fun mySettings(){

        val prefs = PreferenceManager.getDefaultSharedPreferences(this)

        val signature = prefs.getString("signature","")
        val switch = prefs.getBoolean("switch", true)
        val checkbox= prefs.getBoolean("checkbox", false)

        binding.apply {

            if (checkbox) {
                tvCheckbox.text = "Checkbox is checked and\n this text will be visible..."

            }else{
                tvCheckbox.visibility = View.GONE
            }

            tvSignature.text = signature

            if (switch) {
                tvSwitch.text = "Switch is On..."
            }else{
                tvSwitch.text = "Switch is Off..."
            }

        }

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.settings_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.action_settings -> {
                val intent = Intent(this,
                        SettingsActivity::class.java)

                startActivity(intent)
            }
        }

        return super.onOptionsItemSelected(item)
    }
}