package aih.iikrhia.tyirimiiqfais.ui.theme

import aih.iikrhia.tyirimiiqfais.R
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Dp
import aih.iikrhia.hashe.R as CaH

private val DarkColorScheme = darkColorScheme(
    background = ShaqaK,
    surface = PiisaK,
)

private val LightColorScheme = lightColorScheme(
    background = ShaqaH,
    surface = PiisaH,
)

@Composable
fun IikrhiaTyirimiiqfais(
darkTheme: Boolean = isSystemInDarkTheme(),
dynamicColor: Boolean = true,
content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

@Composable
fun Tahaq(
    modifier: Modifier = Modifier,
    tahaq: Bitmap? = BitmapFactory.decodeResource(LocalContext.current.resources, R.drawable.tyilibun),
    areqyiik: Dp = dimensionResource(id = CaH.dimen.ChelesaiMii),
    areqyiik3: Dp = dimensionResource(id = CaH.dimen.ChelesaiMii),
    areqyiik4: Dp = dimensionResource(id = CaH.dimen.ChelesaiMii)

) {
    aih.iikrhia.hashe.Tahaq(modifier, tahaq, areqyiik, areqyiik3, areqyiik4)
}