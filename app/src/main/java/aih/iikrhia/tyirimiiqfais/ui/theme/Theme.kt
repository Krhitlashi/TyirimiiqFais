package aih.iikrhia.tyirimiiqfais.ui.theme

import aih.iikrhia.tyirimiiqfais.R
import android.graphics.Bitmap
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val DarkColorScheme = darkColorScheme(
    background = ShaqaK,
    surface = PiisaK,
)

private val LightColorScheme = lightColorScheme(
    background = ShaqaH,
    surface = PiisaH,
)

@Composable
fun Iikrhia(
darkTheme: Boolean = isSystemInDarkTheme(),
// Dynamic color is available on Android 12+
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
    SideEffect {
    }
}

@Preview
@Composable
fun EriihaThala() {
    Thala({
        Column {
            Kef()
            ThalaCiihii({
                Kef()
            })
        }
    })
}


@Composable
fun Paaksiica(function: @Composable () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.Shaqa))
            .padding(
                dimensionResource(id = R.dimen.Chelesai),
                dimensionResource(id = R.dimen.Sorha),
                dimensionResource(id = R.dimen.Chelesai),
                dimensionResource(id = R.dimen.Chelesai)
            )
            .verticalScroll(rememberScrollState())
    ) {
        function()
    }
}

@Composable
fun Thala(
    function: @Composable () -> Unit = {},
    color: Color = colorResource(R.color.Piisa),
    border: Color = colorResource(R.color.Catsiina),
    corner1: Dp = dimensionResource(id = R.dimen.Paaksiica),
    corner2: Dp = dimensionResource(R.dimen.PaaksiicaMii),
) {
    val Iitxe = RoundedCornerShape(
        corner1,
        corner2,
        corner1,
        corner2
    )
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(vertical = dimensionResource(id = R.dimen.ChelesaiMii)),
        color = color,
        shape = Iitxe,
        border = BorderStroke(
            width = 0.75.dp,
            color = border
        )
    ) {
        function()
    }
}
@Composable
fun ThalaCiihii(
    function: @Composable () -> Unit = {},
    color: Color = colorResource(R.color.Tiisha),
    border: Color = colorResource(R.color.Tawa),
    corner1: Dp = dimensionResource(id = R.dimen.Ciihii),
    corner2: Dp = dimensionResource(R.dimen.CiihiiMii)
) {
    val Iitxe = RoundedCornerShape(
        corner1,
        corner2,
        corner1,
        corner2
    )
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(
                dimensionResource(id = R.dimen.ChelesaiCiihii),
                0.dp,
                dimensionResource(id = R.dimen.ChelesaiCiihii),
                dimensionResource(id = R.dimen.ChelesaiCiihii)
            ),
        color = color,
        shape = Iitxe,
        border = BorderStroke(
            width = 0.75.dp,
            color = border
        )
    ) {
        function()
    }
}

@Preview
@Composable
fun Catsiina(modifier: Modifier = Modifier, kef: String = stringResource(id = R.string.app_name)) {
    val Iitxe = RoundedCornerShape(
        dimensionResource(id = R.dimen.Catsiina),
        dimensionResource(id = R.dimen.CatsiinaMii),
        dimensionResource(id = R.dimen.Catsiina),
        dimensionResource(id = R.dimen.CatsiinaMii)
    )
    Button(
        colors = ButtonColors(
            containerColor = colorResource(R.color.Catsiina),
            contentColor = colorResource(R.color.Catsiina),
            disabledContainerColor = colorResource(R.color.Catsiina),
            disabledContentColor = colorResource(R.color.Catsiina)),
        shape = Iitxe,
        onClick = { /*TODO*/ }
    ) {
        Kef(kef = kef)
    }
}
@Composable
fun Tahaq(
    modifier: Modifier = Modifier,
    tahaq: Bitmap? = null
) {
    val aritahaq = if (tahaq != null) {
        BitmapPainter(tahaq.asImageBitmap())
    } else {
        painterResource(id = R.drawable.tyilibun)
    }
    Image(
        modifier = modifier
            .padding(all = dimensionResource(id = R.dimen.ChelesaiMii)),
        painter = aritahaq,
        contentDescription = stringResource(id = R.string.app_name)
    )
}
@Composable
fun Kef(
    kef: String = stringResource(id = R.string.app_name),
    palaa: TextUnit = 16.sp,
    areqyiik: Dp = dimensionResource(id = R.dimen.Chelesai),
    areqyiik1: Dp = dimensionResource(id = R.dimen.Chelesai),
    areqyiik2: Dp = dimensionResource(id = R.dimen.Chelesai),
) {
    Text(
        text = kef,
        textAlign = TextAlign.Center,
        color = colorResource(id = R.color.Kpaa),
        fontSize = palaa,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                areqyiik,
                areqyiik1,
                areqyiik,
                areqyiik2
            ),
    )
}
@Composable
fun Osakakef() {
    TextField(
        value = "",
        onValueChange = {},
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.Chelesai)),
    )
}