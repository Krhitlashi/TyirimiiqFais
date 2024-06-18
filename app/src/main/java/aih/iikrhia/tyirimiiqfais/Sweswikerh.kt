package aih.iikrhia.tyirimiiqfais

import aih.iikrhia.tyirimiiqfais.ui.theme.Iikrhia
import aih.iikrhia.tyirimiiqfais.ui.theme.Kef
import aih.iikrhia.tyirimiiqfais.ui.theme.Paaksiica
import aih.iikrhia.tyirimiiqfais.ui.theme.Tahaq
import aih.iikrhia.tyirimiiqfais.ui.theme.Thala
import aih.iikrhia.tyirimiiqfais.ui.theme.ThalaCiihii
import android.app.RecoverableSecurityException
import android.content.ContentUris
import android.content.ContentValues
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

class Sweswikerh : AppCompatActivity() {
    private lateinit var rooza: Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val zopii = applicationContext as TyilibunFais
        val ararooza = Uri.parse(zopii.rooza).lastPathSegment!!.toLong()
        if (ararooza != -1L) {
            rooza =
                ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, ararooza)
        }

        enableEdgeToEdge()
        setContent {
            Iikrhia {
                IixaSweswikerh(zopii)
            }
        }

        /*findViewById<Button>(R.id.zetlaq).setOnClickListener {
            sakaswikerh(
                rooza,
                ksaka.text.toString(),
                makfii.text.toString(),
                koocaq.text.toString()
            )
        }*/
    }

    private fun sakaswikerh(
        musicFileUri: Uri,
        newTitle: String? = null,
        newArtist: String? = null,
        newAlbum: String? = null
    ) {
        val values = ContentValues().apply {
            if (newTitle != null) put(MediaStore.Audio.Media.TITLE, newTitle)
            if (newArtist != null) put(MediaStore.Audio.Media.ARTIST, newArtist)
            if (newAlbum != null) put(MediaStore.Audio.Media.ALBUM, newAlbum)
        }
        try {
            contentResolver.update(musicFileUri, values, null, null)
        } catch (e: RecoverableSecurityException) {
            Log.e("ſ͕ȷɜ ſɭᴜ j͐ʃᴜ", "$e.message")
        }
    }
}

@Composable
fun IixaSweswikerh(zopii: TyilibunFais) {
    Paaksiica {
        Kef()
        Thala({
            Tahaq(modifier = Modifier.fillMaxWidth(), tahaq = zopii.tahaq)
        })
        Thala({
            Column {
                Kef(kef = stringResource(id = R.string.chelesai))
                ThalaCiihii ({
                    Kef(kef = zopii.ksaka)
                })
            }
        })
        Thala({
            Column {
                Kef(kef = stringResource(id = R.string.sweswikerh))
                ThalaCiihii ({
                    Kef(kef = zopii.makfii)
                })
                ThalaCiihii ({
                    Kef(kef = zopii.koocaq)
                })
            }
        })
    }
}