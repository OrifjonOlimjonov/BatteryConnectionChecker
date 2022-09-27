package uz.orifjon.batterychecker

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import org.w3c.dom.Text
import uz.orifjon.batterychecker.databinding.ActivityMainBinding

class BatteryChecker(binding: ConstraintLayout): BroadcastReceiver() {
    private var root:ConstraintLayout = binding

    override fun onReceive(context: Context, intent: Intent) {

        if (intent.action.equals(Intent.ACTION_POWER_CONNECTED)) {
            root.setBackgroundColor(Color.parseColor("#14FD2B"))
            Toast.makeText(context, "The device is charging", Toast.LENGTH_SHORT).show()

        } else {
            intent.action.equals(Intent.ACTION_POWER_DISCONNECTED)
            root.setBackgroundColor(Color.parseColor("#FD2C36"))
            Toast.makeText(context, "The device is not charging", Toast.LENGTH_SHORT).show()

        }
    }
}