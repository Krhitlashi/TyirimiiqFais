package aih.iikrhia.tyirimiiqfais

import aih.iikrhia.tyirimiiqfais.ui.theme.Catsiina
import aih.iikrhia.tyirimiiqfais.ui.theme.Kef
import aih.iikrhia.tyirimiiqfais.ui.theme.Tahaq
import aih.iikrhia.tyirimiiqfais.ui.theme.Thala
import aih.iikrhia.tyirimiiqfais.ui.theme.ThalaCiihii
import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.ContentUris
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.MediaPlayer
import android.media.session.MediaSession
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import android.util.Size
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.NotificationCompat
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import java.io.FileNotFoundException
import java.util.*


class FefrhiSwikerh(
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
}

fun fetchAudioData(context: Context): ArrayList<Swikerh> {
    val audioList = ArrayList<Swikerh>()
    val projection = arrayOf(
        MediaStore.Audio.Media._ID,
        MediaStore.Audio.Media.TITLE,
        MediaStore.Audio.Media.ALBUM_ID,
        MediaStore.Audio.Media.ARTIST,
        MediaStore.Audio.Media.ALBUM
    )

    val cursor = context.contentResolver.query(
        MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
        projection,
        null,
        null,
        null
    )

    cursor?.use {
        val idColumn = it.getColumnIndexOrThrow(MediaStore.Audio.Media._ID)
        val titleColumn = it.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE)
        val albumIdColumn = it.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM_ID)
        val artistColumn = it.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST)
        val albumColumn = it.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM)

        while (it.moveToNext()) {
            val id = it.getLong(idColumn)
            val uri = ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, id).toString()
            val title = it.getString(titleColumn)
            val albumId = it.getLong(albumIdColumn)
            val albumArtUri = ContentUris.withAppendedId(
                MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI,
                albumId
            )
            val albumArt = try {
                getAlbumArtFromUri(context, albumArtUri)
            } catch (e: FileNotFoundException) {
                Log.e("FetchAudioData", "Album art not found", e)
                BitmapFactory.decodeResource(
                    context.resources,
                    R.drawable.tyilibun
                )
            }
            val artist = it.getString(artistColumn)
            val album = it.getString(albumColumn)
            audioList.add(Swikerh(uri, title, albumArt, artist, album))
        }
    }

    return audioList
}

fun getAlbumArtFromUri(context: Context, albumArtUri: Uri): Bitmap {
    return context.contentResolver.loadThumbnail(
        albumArtUri,
        Size(80, 80),
        null
    )
}

@Composable
fun Catsara(siicatsara: ArrayList<Swikerh>) {
    LazyColumn {
        items(siicatsara.size) { swikerh ->
            Swikerh()
        }
    }
}
@Preview
@Composable
fun Swikerh(
    ksaka: String = "Ksaka",
    // tahaq: Bitmap = null,
    makfii: String = "Makfii",
    koocaq: String = "Koocaq"
) {
    Thala({
        Row {
            Tahaq(
                modifier = Modifier
                    .height(80.dp)
                    .width(80.dp)
                    .align(Alignment.CenterVertically)
            )
            Column {
                Kef(kef = ksaka, areqyiik1 = dimensionResource(id = R.dimen.ChelesaiCiihii), areqyiik2 = dimensionResource(id = R.dimen.ChelesaiCiihii))
                ThalaCiihii({
                    Column {
                        Kef(kef = makfii, palaa = 12.sp, areqyiik2 = dimensionResource(id = R.dimen.ChelesaiCiihiiMii))
                        Kef(kef = koocaq, palaa = 12.sp, areqyiik1 = dimensionResource(id = R.dimen.ChelesaiCiihiiMii))
                    }
                })
            }
            Catsiina(kef = "")
        }
    })
}