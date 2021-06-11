package pt.andre.hue

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import pt.andre.hue.views.LampItemView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                LampItemView(
                    title = "Bedroom",
                    isOn = false,
                    brightness = 128
                )
            }
        }
    }
}
