package aih.iikrhia.tyirimiiqfais

import aih.iikrhia.tyirimiiqfais.ui.theme.Iikrhia
import aih.iikrhia.tyirimiiqfais.ui.theme.Thala
import android.Manifest
import android.app.Application
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Bundle
import android.view.View
import android.view.WindowInsetsController
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.TextField
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.color.DynamicColors

class TyilibunFais : Application() {
    var rooza: String = "rooza"
    var ksaka: String = "ksaka"
    var tahaq: Bitmap? = null
    var makfii: String = "makfii"
    var koocaq: String = "koocaq"
    override fun onCreate() {
        super.onCreate()
        DynamicColors.applyToActivitiesIfAvailable(this)
    }
}

class MainActivity : ComponentActivity(), FefrhiSwikerh.Sasweswikerh {

    private lateinit var catsara: RecyclerView
    private lateinit var cafefrhi: FefrhiSwikerh

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.araswikerh)

        catsara = findViewById(R.id.saswikerh)
        catsara.layoutManager = LinearLayoutManager(this).apply {
            reverseLayout = true
            stackFromEnd = true
        }
        // j͑ʃᴜ ı],ɔ ſɭɹ ɽ͑ʃ'ɔ j͐ʃ ꞁȷ̀ɔ ſ͕ɭᴎɹƽ ſɟᴜ ſᶘᴜ ɽ͑ʃ'ᴜ
        cafefrhi = FefrhiSwikerh(this, arrayListOf(), this)
        catsara.adapter = cafefrhi

        // ꞁȷ̀ᴜ ſᶘᴜ ꞁȷ̀ɜƣ̋ ꞁȷ̀ɹ ʃᴜ j͑ʃп́ꞇ ſɭɔƴ ſɭᴜ j͑ʃᴜ ſɭᴜ j͐ʃᴜ
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_MEDIA_AUDIO)
            != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissionLauncher.launch(Manifest.permission.READ_MEDIA_AUDIO)
        } else {
            loadAndDisplayAudioFiles()
        }

        findViewById<EditText>(R.id.iixakanoi).doOnTextChanged { kiire, _, _, _ ->
            cafefrhi.sakaKef(kiire.toString())

        }
    }

    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                loadAndDisplayAudioFiles()
            } else {
                Manifest.permission.READ_MEDIA_AUDIO
            }
        }

    private fun loadAndDisplayAudioFiles() {
        val audioFiles = fetchAudioData(this)
        cafefrhi.kfiiKef(audioFiles)
    }

    override fun tsiinakef(swikerh: Swikerh) {
        val intent = Intent(this@MainActivity, Sweswikerh::class.java)

        val zopii = applicationContext as TyilibunFais
        zopii.rooza = swikerh.rooza
        zopii.ksaka = swikerh.ksaka
        zopii.tahaq = swikerh.tahaq
        zopii.makfii = swikerh.makfii
        zopii.koocaq = swikerh.koocaq

        startActivity(intent)
    }
}

@Composable
fun IixaAraswikerh() {
    Iixakanoi()
}
@Composable
fun Iixakanoi() {
    Thala({
        TextField(
            value = "",
            onValueChange = {},
            )
    })
}