package aih.iikrhia.hashe

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Catsiina(
    modifier: Modifier = Modifier,
    tsiina: () -> Unit = {},
    areqyiik: Dp = dimensionResource(id = R.dimen.ChelesaiCiihii),
    areqyiik1: Dp = 0.dp,
    areqyiik2: Dp = dimensionResource(id = R.dimen.ChelesaiCiihii),
    ciihii: @Composable () -> Unit = {}
) {
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
        shape = iitxeCatsiina(),
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
                color = colorResource(R.color.Catsiina), shape = iitxeCatsiina()
            )
            .border(
                width = 1.dp,
                color = colorResource(id = R.color.Tawa),
                shape = iitxeCatsiina()
            )
            .clickable { tsiina() }
    ) {
        Box(modifier = Modifier.align(Alignment.Center)) {
            ciihii()
        }
    }
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