package aih.iikrhia.tyirimiiqfais

import aih.iikrhia.hashe.Kef
import aih.iikrhia.hashe.Thala
import aih.iikrhia.tyirimiiqfais.ui.theme.IikrhiaTyirimiiqfais
import android.Manifest
import android.app.Application
import android.content.ContentUris
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.util.Size
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import java.io.FileNotFoundException
import aih.iikrhia.hashe.R as CaH

class TyilibunFais : Application() {
    var rooza: String = "rooza"
    var ksaka: String = "ksaka"
    var tahaq: Bitmap? = null
    var makfii: String = "makfii"
    var koocaq: String = "koocaq"
}

class MainActivity : ComponentActivity() {

    private val fefrhiSwikerh: FefrhiSwikerh by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            IikrhiaTyirimiiqfais {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    IixaAraswikerh()
                    Iixakanoi(
                        modifier = Modifier
                            .align(Alignment.BottomCenter),
                        fefrhiSwikerh
                    )
                }
            }
        }

        // ꞁȷ̀ᴜ ſᶘᴜ ꞁȷ̀ɜƣ̋ ꞁȷ̀ɹ ʃᴜ j͑ʃп́ꞇ ſɭɔƴ ſɭᴜ j͑ʃᴜ ſɭᴜ j͐ʃᴜ
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_MEDIA_AUDIO)
            != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissionLauncher.launch(Manifest.permission.READ_MEDIA_AUDIO)
        } else {
            val audioFiles = fetchAudioData(this)
            fefrhiSwikerh.kfiiSwikerh(audioFiles)
        }
    }

    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                val audioFiles = fetchAudioData(this)
                fefrhiSwikerh.kfiiSwikerh(audioFiles)
            } else {
                Manifest.permission.READ_MEDIA_AUDIO
            }
        }

    private fun fetchAudioData(context: Context): ArrayList<Swikerh> {
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

    private fun getAlbumArtFromUri(context: Context, albumArtUri: Uri): Bitmap {
        return context.contentResolver.loadThumbnail(
            albumArtUri,
            Size(2048, 2048),
            null
        )
    }

    @Composable
    fun IixaAraswikerh() {
        val kiitseswikerh by fefrhiSwikerh.kiitseswikerh.observeAsState(initial = emptyList())

        // j͑ʃᴜ ı],ɔ ſɭɹ ɽ͑ʃ'ɔ j͐ʃ ꞁȷ̀ɔ ſ͕ɭᴎɹƽ ſɟᴜ ſᶘᴜ ɽ͑ʃ'ᴜ
        Catsara(
            kiitseswikerh = kiitseswikerh.reversed(),
            malookwek = { swikerh ->
                // Handle click on Swikerh
                val intent = Intent(this@MainActivity, Sweswikerh::class.java)
                val zopii = applicationContext as TyilibunFais
                zopii.rooza = swikerh.rooza
                zopii.ksaka = swikerh.ksaka
                zopii.tahaq = swikerh.tahaq
                zopii.makfii = swikerh.makfii
                zopii.koocaq = swikerh.koocaq
                startActivity(intent)
            }
        )
    }
}

@Preview
@Composable
fun Iixakanoi(
    modifier: Modifier = Modifier,
    fefrhiSwikerh: FefrhiSwikerh = FefrhiSwikerh()
) {
    var kef by remember { mutableStateOf("") }
    Thala(
        modifier = modifier
            .padding(
                dimensionResource(id = CaH.dimen.Chelesai),
                dimensionResource(id = CaH.dimen.Sorha),
                dimensionResource(id = CaH.dimen.Chelesai),
                dimensionResource(id = CaH.dimen.Chelesai)
            ),
        ciihii = {
        TextField(
            value = kef,
            onValueChange = {
                kef = it
                fefrhiSwikerh.sakaSwikerh(it)
            },
            placeholder = {
                Kef(
                    kef = stringResource(id = R.string.iixakanoi),
                    areqyiik = 0.dp,
                    areqyiik1 = 0.dp,
                    areqyiik2 = 0.dp
                )
            },
            textStyle = TextStyle(
                textAlign = TextAlign.Center
            )
        )
    })
}