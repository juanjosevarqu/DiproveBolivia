package com.varqulabs.diproveboliviapp.core.presentation.utils.context

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

fun Context.copyToClipboard(
    text: String,
    desc: String = "",
) {
    val clipboard = getSystemService(AppCompatActivity.CLIPBOARD_SERVICE) as? ClipboardManager
    val clip = ClipData.newPlainText(text, text)
    clipboard?.setPrimaryClip(clip)
    Toast.makeText(applicationContext, "Número copiado", Toast.LENGTH_SHORT).show()
}

fun Context.launchExternalIntent(
    uri: String,
    packageName: String? = null,
    extras: Bundle? = null,
    action: String = Intent.ACTION_VIEW
) {
    val intent = Intent(action, Uri.parse(uri)).apply {
        packageName?.let { setPackage(it) }
        extras?.let { putExtras(it) }
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    if (intent.resolveActivity(packageManager) != null) {
        startActivity(intent)
    } else {
        Toast.makeText(applicationContext, "No se encontró la aplicación para abrir.", Toast.LENGTH_SHORT).show()
    }
}

fun Context.launchWhatsApp(phone: String, message: String) {
    val url = "https://wa.me/$phone?text=${Uri.encode(message)}"
    launchExternalIntent(uri = url, packageName = "com.whatsapp")
}