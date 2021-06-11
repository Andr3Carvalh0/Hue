package pt.andre.hue.views

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LampItemView(
    title: String,
    isOn: Boolean,
    brightness: Int
) {
    Text(text = title)
}

@Composable
@Preview
fun LampItemViewPreview() {
    LampItemView(
        title = "Bedroom",
        isOn = false,
        brightness = 128
    )
}
