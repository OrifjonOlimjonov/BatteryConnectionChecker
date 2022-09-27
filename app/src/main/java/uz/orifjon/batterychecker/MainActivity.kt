package uz.orifjon.batterychecker

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import uz.orifjon.batterychecker.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var batteryChecker: BatteryChecker
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        batteryChecker = BatteryChecker(binding.root)

        val iFilter = IntentFilter()
        iFilter.addAction(Intent.ACTION_POWER_CONNECTED)
        iFilter.addAction(Intent.ACTION_POWER_DISCONNECTED)
        registerReceiver(batteryChecker, iFilter)


    }

    override fun onResume() {
        super.onResume()
        val iFilter = IntentFilter()
        iFilter.addAction(Intent.ACTION_POWER_CONNECTED)
        iFilter.addAction(Intent.ACTION_POWER_DISCONNECTED)
        registerReceiver(batteryChecker, iFilter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(batteryChecker)
    }
}