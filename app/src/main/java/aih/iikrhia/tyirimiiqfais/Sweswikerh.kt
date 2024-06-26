package aih.iikrhia.tyirimiiqfais

import aih.iikrhia.hashe.Catsiina
import aih.iikrhia.hashe.Kef
import aih.iikrhia.hashe.Paaksiica
import aih.iikrhia.hashe.Thala
import aih.iikrhia.hashe.ThalaCiihii
import aih.iikrhia.tyirimiiqfais.ui.theme.IikrhiaTyirimiiqfais
import aih.iikrhia.tyirimiiqfais.ui.theme.Tahaq
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import aih.iikrhia.hashe.R as CaH

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
            IikrhiaTyirimiiqfais {
                IixaSweswikerh(zopii)
            }
        }
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


    @Composable
    fun IixaSweswikerh(zopii: TyilibunFais) {
        Paaksiica {
            Kef(
                kef = zopii.ksaka,
                areqyiik1 = 0.dp,
                areqyiik2 = dimensionResource(id = aih.iikrhia.hashe.R.dimen.ChelesaiMii)
            )
            Thala(
                ciihii = {
                    Tahaq(tahaq = zopii.tahaq)
                })
            Thala(
                ciihii = {
                    Column {
                        Kef(kef = stringResource(id = R.string.chelesai))
                        ThalaCiihii (
                            ciihii = {
                                Kef(kef = zopii.ksaka)
                            })
                    }
                })
            Thala(
                ciihii = {
                    Column {
                        Kef(kef = stringResource(id = R.string.sweswikerh))
                        ThalaCiihii (
                            ciihii = {
                                Kef(kef = zopii.makfii)
                            })
                        ThalaCiihii (
                            ciihii = {
                                Kef(kef = zopii.koocaq)
                            })
                    }
                })
            Catsiina(
                tsiina = {
                    sakaswikerh(
                        Uri.parse(zopii.rooza),
                        zopii.ksaka,
                        zopii.makfii,
                        zopii.koocaq
                    )
                },
                ciihii = {
                    Kef(
                        kef = stringResource(id = R.string.zetlaq),
                        areqyiik1 = dimensionResource(id = CaH.dimen.ChelesaiMii),
                        areqyiik2 = dimensionResource(id = CaH.dimen.ChelesaiMii)
                    )
                },
                areqyiik = 0.dp,
                areqyiik1 = dimensionResource(id = CaH.dimen.ChelesaiCiihii) / 2
            )
        }
    }
}
