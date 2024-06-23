package aih.iikrhia.hashe

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

// ꞁȷ̀ɹ ɭʃɀɔ
@Composable
fun iitxe(cixe1: Dp, cixe2: Dp): RoundedCornerShape {
    val iitxe = RoundedCornerShape(cixe1, cixe2, cixe1, cixe2)
    return iitxe
}
@Composable
fun iitxePaaksiica(): RoundedCornerShape {
    return iitxe(dimensionResource(id = R.dimen.Paaksiica), dimensionResource(id = R.dimen.PaaksiicaMii))
}
@Composable
fun iitxeCiihii(): RoundedCornerShape {
    return iitxe(dimensionResource(id = R.dimen.Ciihii), dimensionResource(id = R.dimen.CiihiiMii))
}
@Composable
fun iitxeCatsiina(): RoundedCornerShape {
    return iitxe(dimensionResource(id = R.dimen.Catsiina), dimensionResource(id = R.dimen.CatsiinaMii))
}

// ſɭɔƽ j͑ʃᴜ ֭ſɭᴜ ı],ɔ

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
fun Tahaq(
    modifier: Modifier = Modifier,
    tahaq: Bitmap? = BitmapFactory.decodeResource(LocalContext.current.resources, R.drawable.hashe),
    areqyiik: Dp = dimensionResource(id = R.dimen.ChelesaiMii),
    areqyiik3: Dp = dimensionResource(id = R.dimen.ChelesaiMii),
    areqyiik4: Dp = dimensionResource(id = R.dimen.ChelesaiMii)
) {
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
        if (tahaq != null) {
            Image(
                modifier = Modifier.clip(iitxeCiihii()),
                painter = BitmapPainter(tahaq.asImageBitmap()),
                contentDescription = "ɭʃᴜ ֭ſɭᴜȝ"
            )
        }
    }
}

