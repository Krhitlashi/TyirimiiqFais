package aih.iikrhia.tyirimiiqfais

import aih.iikrhia.tyirimiiqfais.ui.theme.CepaiCatsiina
import aih.iikrhia.tyirimiiqfais.ui.theme.Kef
import aih.iikrhia.tyirimiiqfais.ui.theme.Tahaq
import aih.iikrhia.tyirimiiqfais.ui.theme.Thala
import aih.iikrhia.tyirimiiqfais.ui.theme.ThalaCiihii
import android.content.Context
import android.graphics.Bitmap
import android.media.MediaPlayer
import android.net.Uri
import android.util.Log
import android.view.animation.AnimationUtils
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

/* class FefrhiSwikerh(
    private val context: Context,
    private var kiitseswikerh: ArrayList<Swikerh>,
    private val malookwek: Sasweswikerh
) :
    RecyclerView.Adapter<FefrhiSwikerh.ShemaXi>() {
    private var sasaka = Iixakanoi(kiitseswikerh, this)
    private var kalaswikerh = false
    private var mediaPlayer: MediaPlayer? = null

    inner class ShemaXi(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val ksaka: TextView = itemView.findViewById(R.id.ksaka)
        val tahaq: ImageView = itemView.findViewById(R.id.tahaq)
        val makfii: TextView = itemView.findViewById(R.id.makfii)
        val koocaq: TextView = itemView.findViewById(R.id.koocaq)

        val sashe: Button = itemView.findViewById(R.id.sashe)

        init {
            itemView.setOnClickListener(this)
            }

        override fun onClick(v: View?) {
            malookwek.tsiinakef(kiitseswikerh[adapterPosition])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShemaXi {
        val view = LayoutInflater.from(context).inflate(R.layout.swikerh, parent, false)
        return ShemaXi(view)
    }

    override fun onBindViewHolder(mashema: ShemaXi, araq: Int) {
        mashema.itemView.animation = AnimationUtils.loadAnimation(mashema.itemView.context, R.anim.chelesaitahalaqarh)
        val audio = kiitseswikerh[araq]
        mashema.ksaka.text = audio.ksaka
        mashema.tahaq.setImageBitmap(audio.tahaq)
        mashema.makfii.text = audio.makfii
        mashema.koocaq.text = audio.koocaq
        mashema.itemView.setOnClickListener {
            malookwek.tsiinakef(kiitseswikerh[araq])
        }
        mashema.sashe.setOnClickListener {
            if (kalaswikerh) {
                koliiswikerh()
                mashema.sashe.text = "\\"
            } else {
                sasheswikerh(context, Uri.parse(audio.rooza), araq)
                mashema.sashe.text = "ɭɭ"
            }
            notifyItemChanged(araq)
        }
    }

    override fun getItemCount(): Int = kiitseswikerh.size

    fun kfiiKef(sefaukiitsewikerh: ArrayList<Swikerh>) {
        kiitseswikerh = sefaukiitsewikerh
        notifyDataSetChanged()
    }

    fun sakaKef(query: String) {
        sasaka.filter(query)
    }

    private fun sasheswikerh(context: Context, rooza: Uri, araq: Int) {
        Log.d("ſɟᴜ j͑ʃп́ꞇ ſɭɔƴ", "$rooza")
        mediaPlayer = MediaPlayer().apply {
            try {
                setDataSource(context, rooza)
                prepareAsync()
                setOnPreparedListener {
                    start()
                    this@FefrhiSwikerh.kalaswikerh = true
                }
                setOnCompletionListener {
                    this@FefrhiSwikerh.kalaswikerh = false
                    notifyItemChanged(araq)
                }
                setOnErrorListener { _, eskek, inak ->
                    Log.e("ſɟᴜ j͑ʃп́ꞇ ſɭɔƴ", "ſ͕ȷɜ j͑ʃ'ɔ j͑ʃп́ꞇ ſɭɔƴ - $eskek, $inak")
                    this@FefrhiSwikerh.kalaswikerh = false
                    false
                }
            }
            catch (e: Exception) {
                Log.e("ſɟᴜ j͑ʃп́ꞇ ſɭɔƴ", "ſ͕ȷɜ ſ͕ɭw ŋᷠw - ${e.message}")
            }
        }
    }
    private fun koliiswikerh() {
        mediaPlayer?.pause()
        kalaswikerh = false
    }

    interface Sasweswikerh {
        fun tsiinakef(swikerh: Swikerh)
    }
} */

class FefrhiSwikerh : ViewModel() {
    private val _kiihiikiitseswikerh = mutableStateListOf<Swikerh>()
    private val _kiitseswikerh = MutableLiveData<ArrayList<Swikerh>>()
    val kiitseswikerh: LiveData<ArrayList<Swikerh>> = _kiitseswikerh

    private val _kalaswikerh = MutableLiveData<Boolean>()
    val kalaswikerh: LiveData<Boolean> = _kalaswikerh

    private var hiinyiikkef = ""

    // MediaPlayer object
    var mediaPlayer: MediaPlayer? = null

    fun kfiiSwikerh(sefaukiitsewikerh: ArrayList<Swikerh>) {
        _kiitseswikerh.value = sefaukiitsewikerh
        _kiihiikiitseswikerh.clear()
        _kiihiikiitseswikerh.addAll(sefaukiitsewikerh)
    }

    fun sakaKalani(sefaukalaswikerh: Boolean) {
        _kalaswikerh.value = sefaukalaswikerh
    }

    fun sakaSwikerh(query: String) {
        if (query.isBlank()) {
            _kiitseswikerh.value = ArrayList(_kiihiikiitseswikerh)
        }
        else {
            val neswikakpaa = query.length < hiinyiikkef.length
            val filteredList = _kiitseswikerh.value?.filter { swikerh ->
                if (neswikakpaa) {
                    _kiitseswikerh.value = ArrayList(_kiihiikiitseswikerh)
                }
                swikerh.ksaka.contains(query, ignoreCase = true)

            } as? ArrayList<Swikerh>?: arrayListOf()
            _kiitseswikerh.value = filteredList
        }
        hiinyiikkef = query
    }
    fun sasheswikerh(context: Context, rooza: Uri) {
        Log.d("ſɟᴜ j͑ʃп́ꞇ ſɭɔƴ", "$rooza")
        mediaPlayer = MediaPlayer().apply {
            try {
                setDataSource(context, rooza)
                prepareAsync()
                setOnPreparedListener {
                    start()
                    sakaKalani(true)
                }
                setOnCompletionListener {
                    sakaKalani(false)
                }
                setOnErrorListener { _, eskek, inak ->
                    Log.e("ſɟᴜ j͑ʃп́ꞇ ſɭɔƴ", "ſ͕ȷɜ j͑ʃ'ɔ j͑ʃп́ꞇ ſɭɔƴ - $eskek, $inak")
                    sakaKalani(false)
                    false
                }
            }
            catch (e: Exception) {
                Log.e("ſɟᴜ j͑ʃп́ꞇ ſɭɔƴ", "ſ͕ȷɜ ſ͕ɭw ŋᷠw - ${e.message}")
            }
        }
    }
    fun koliiswikerh() {
        mediaPlayer?.pause()
        sakaKalani(false)
    }

    override fun onCleared() {
        super.onCleared()
        mediaPlayer?.release()
        mediaPlayer = null
    }

}


@Composable
fun Catsara(
    kiitseswikerh: List<Swikerh>,
    malookwek: (Swikerh) -> Unit
) {
    val animation = AnimationUtils.loadAnimation(LocalContext.current, R.anim.chelesaitahalaqarh)
    LazyColumn(
        modifier = Modifier
            .background(colorResource(id = R.color.Shaqa)),
        contentPadding = PaddingValues(
            dimensionResource(id = R.dimen.Chelesai),
            dimensionResource(id = R.dimen.Sorha),
            dimensionResource(id = R.dimen.Chelesai),
            dimensionResource(id = R.dimen.Chelesai)
        ),
    ) {
        items(kiitseswikerh.size) { swikerh ->
            val animatedProgress = remember { Animatable(0f) }
            LaunchedEffect(key1 = swikerh) {
                animatedProgress.animateTo(
                    targetValue = 1f,
                    animationSpec = tween(durationMillis = animation.duration.toInt()))
            }
            Swikerh(
                modifier = Modifier
                    .graphicsLayer {
                        translationX = animation.interpolator.getInterpolation(animatedProgress.value)
                        translationY = animation.interpolator.getInterpolation(animatedProgress.value)
                        alpha = animatedProgress.value
                        scaleX = animatedProgress.value
                        scaleY = animatedProgress.value
                    },
                kiitseswikerh[swikerh],
                malookwek
            )
        }
    }
}
@Composable
fun Swikerh(
    modifier: Modifier = Modifier,
    swikerh: Swikerh,
    malookwek: (Swikerh) -> Unit
) {
    IixaSwikerh(
        modifier = modifier
            .clickable {
            malookwek(swikerh)
        },
        fefrhiSwikerh = FefrhiSwikerh(),
        context = LocalContext.current,
        swikerh.ksaka,
        swikerh.tahaq,
        swikerh.makfii,
        swikerh.koocaq,
        swikerh.rooza
    )
}

@Preview
@Composable
fun IixaSwikerh(
    modifier: Modifier = Modifier,
    fefrhiSwikerh: FefrhiSwikerh = FefrhiSwikerh(),
    context: Context = LocalContext.current,
    ksaka: String = "ksaka",
    tahaq: Bitmap? = null,
    makfii: String = "makfii",
    koocaq: String = "koocaq",
    rooza: String = "rooza"
) {
    Thala(
        modifier = modifier
        .fillMaxWidth()
        .height(IntrinsicSize.Min),
        ciihii = {
        Row {
            Tahaq(
                modifier = Modifier
                    .height(80.dp)
                    .width(80.dp)
                    .align(Alignment.CenterVertically),
                tahaq = tahaq,
                areqyiik4 = 0.dp,
            )
            Column(modifier = Modifier.weight(1f)) {
                ThalaCiihii(
                    areqyiik1 = dimensionResource(id = R.dimen.ChelesaiCiihii),
                    ciihii = {
                    Column {
                        Kef(
                            kef = ksaka,
                            areqyiik1 = dimensionResource(id = R.dimen.ChelesaiMii),
                            areqyiik2 = 0.dp
                        )
                        Kef(
                            kef = makfii,
                            palaa = 12.sp,
                            areqyiik1 = 0.dp,
                            areqyiik2 = 0.dp
                        )
                        Kef(
                            kef = koocaq,
                            palaa = 12.sp,
                            areqyiik1 = 0.dp,
                            areqyiik2 = dimensionResource(id = R.dimen.ChelesaiMii)
                        )
                    }
                })
            }
            var kef by remember { mutableStateOf("ɭɭ") }
            CepaiCatsiina(
                modifier = Modifier
                    .width(48.dp),
                tsiina = {
                    if (fefrhiSwikerh.kalaswikerh.value == true) {
                        fefrhiSwikerh.koliiswikerh()
                        kef = "ɭɭ"
                    } else {
                        fefrhiSwikerh.sasheswikerh(context, Uri.parse(rooza))
                        kef = "\\"
                    }
                },
                areqyiik3 = 0.dp,
                ciihii = {
                    Text(
                        modifier = Modifier,
                        text = kef,
                        fontSize = 12.sp,
                        color = colorResource(id = R.color.Kpaa),
                        textAlign = TextAlign.Center
                    )
                }
            )
        }
    })
}