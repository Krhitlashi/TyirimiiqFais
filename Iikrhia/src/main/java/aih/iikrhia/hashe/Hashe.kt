package aih.iikrhia.hashe

import android.graphics.Bitmap
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Hashe {
}

@Composable
fun Paaksiica(ciihii: @Composable () -> Unit = {}) {
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
        ciihii()
    }
}


@Composable
fun Thala(
    modifier: Modifier = Modifier,
    color: Color = colorResource(R.color.Piisa),
    border: Color = colorResource(R.color.Catsiina),
    ciihii: @Composable () -> Unit = {}
) {
    val Iitxe = RoundedCornerShape(
        dimensionResource(id = R.dimen.Paaksiica),
        dimensionResource(R.dimen.PaaksiicaMii),
        dimensionResource(id = R.dimen.Paaksiica),
        dimensionResource(R.dimen.PaaksiicaMii)
    )
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(vertical = dimensionResource(id = R.dimen.ChelesaiCiihii) / 2),
        color = color,
        shape = Iitxe,
        border = BorderStroke(
            width = 1.dp,
            color = border
        )
    ) {
        ciihii()
    }
}
@Composable
fun ThalaCiihii(
    color: Color = colorResource(R.color.Tiisha),
    border: Color = colorResource(R.color.Tawa),
    corner1: Dp = dimensionResource(id = R.dimen.Ciihii),
    corner2: Dp = dimensionResource(R.dimen.CiihiiMii),
    areqyiik1: Dp = 0.dp,
    ciihii: @Composable () -> Unit = {}
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
                areqyiik1,
                dimensionResource(id = R.dimen.ChelesaiCiihii),
                dimensionResource(id = R.dimen.ChelesaiCiihii)
            ),
        color = color,
        shape = Iitxe,
        border = BorderStroke(
            width = 1.dp,
            color = border
        )
    ) {
        ciihii()
    }
}


@Composable
fun Catsiina(
    modifier: Modifier = Modifier,
    tsiina: () -> Unit = {},
    areqyiik: Dp = dimensionResource(id = R.dimen.ChelesaiCiihii),
    areqyiik1: Dp = 0.dp,
    areqyiik2: Dp = dimensionResource(id = R.dimen.ChelesaiCiihii),
    ciihii: @Composable () -> Unit = {}
) {
    val Iitxe = RoundedCornerShape(
        dimensionResource(id = R.dimen.Catsiina),
        dimensionResource(id = R.dimen.CatsiinaMii),
        dimensionResource(id = R.dimen.Catsiina),
        dimensionResource(id = R.dimen.CatsiinaMii)
    )
    Button(
        modifier = modifier
            .wrapContentWidth(Alignment.CenterHorizontally)
            .padding(
                areqyiik,
                areqyiik1,
                areqyiik,
                areqyiik2
            ),
        colors = ButtonColors(
            containerColor = colorResource(R.color.Catsiina),
            contentColor = colorResource(R.color.Catsiina),
            disabledContainerColor = colorResource(R.color.Catsiina),
            disabledContentColor = colorResource(R.color.Catsiina)
        ),
        shape = Iitxe,
        border = BorderStroke(
            width = 1.dp,
            color = colorResource(id = R.color.Tawa)
        ),
        onClick = { tsiina() }

    ) {
        ciihii()
    }
}
@Composable
fun CepaiCatsiina(
    modifier: Modifier = Modifier,
    tsiina: () -> Unit = {},
    areqyiik: Dp = dimensionResource(id = R.dimen.ChelesaiCiihii),
    areqyiik3: Dp = dimensionResource(id = R.dimen.ChelesaiCiihii),
    areqyiik4: Dp = dimensionResource(id = R.dimen.ChelesaiCiihii),
    ciihii: @Composable () -> Unit = {}
) {
    val Iitxe = RoundedCornerShape(
        dimensionResource(id = R.dimen.Catsiina),
        dimensionResource(id = R.dimen.CatsiinaMii),
        dimensionResource(id = R.dimen.Catsiina),
        dimensionResource(id = R.dimen.CatsiinaMii)
    )
    Box(
        modifier = modifier
            .padding(
                areqyiik3,
                areqyiik,
                areqyiik4,
                areqyiik
            )
            .fillMaxHeight()
            .width(32.dp)
            .background(
                color = colorResource(R.color.Catsiina), shape = Iitxe
            )
            .border(
                width = 1.dp,
                color = colorResource(id = R.color.Tawa),
                shape = Iitxe
            )
            .clickable { tsiina() }
    ) {
        Box(modifier = Modifier.align(Alignment.Center)) {
            ciihii()
        }
    }
}
@Composable
fun Tahaq(
    modifier: Modifier = Modifier,
    tahaq: Bitmap? = null,
    areqyiik: Dp = dimensionResource(id = R.dimen.ChelesaiMii),
    areqyiik3: Dp = dimensionResource(id = R.dimen.ChelesaiMii),
    areqyiik4: Dp = dimensionResource(id = R.dimen.ChelesaiMii)
) {
    val aritahaq = if (tahaq != null) {
        BitmapPainter(tahaq.asImageBitmap())
    } else {
        painterResource(id = R.drawable.hashe)
    }
    val Iitxe = RoundedCornerShape(
        dimensionResource(id = R.dimen.Ciihii),
        dimensionResource(id = R.dimen.CiihiiMii),
        dimensionResource(id = R.dimen.Ciihii),
        dimensionResource(id = R.dimen.CiihiiMii)
    )
    Box(
        modifier = modifier
            .padding(
                areqyiik3,
                areqyiik,
                areqyiik4,
                areqyiik
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.clip(Iitxe),
            painter = aritahaq,
            contentDescription = "ɭʃᴜ ֭ſɭᴜȝ"
        )
    }

}
@Composable
fun Kef(
    modifier: Modifier = Modifier,
    kef: String = "",
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
        modifier = modifier
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