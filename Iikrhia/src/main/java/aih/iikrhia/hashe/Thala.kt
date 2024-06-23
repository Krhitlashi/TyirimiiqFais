package aih.iikrhia.hashe

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Thala(
    modifier: Modifier = Modifier,
    color: Color = colorResource(R.color.Piisa),
    border: Color = colorResource(R.color.Catsiina),
    ciihii: @Composable () -> Unit = {}
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(vertical = dimensionResource(id = R.dimen.ChelesaiCiihii) / 2),
        color = color,
        shape = iitxePaaksiica(),
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
    areqyiik1: Dp = 0.dp,
    ciihii: @Composable () -> Unit = {}
) {
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
        shape = iitxeCiihii(),
        border = BorderStroke(
            width = 1.dp,
            color = border
        )
    ) {
        ciihii()
    }
}
