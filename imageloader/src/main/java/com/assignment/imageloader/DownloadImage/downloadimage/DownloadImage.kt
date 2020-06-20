package com.assignment.imageloader.DownloadImage.downloadimage

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.widget.ImageView
import com.assignment.imageloader.DownloadImage.DownloadImagefactory
import java.io.InputStream

class DownloadImage(
    var pView: ImageView?,
    var pDownloadImagefactory: DownloadImagefactory.Companion
) : AsyncTask<String, String, Bitmap>() {
    var imageURL: String = ""

    protected override fun doInBackground(vararg URL: String?): Bitmap? {
        imageURL = URL[0]!!
        var bitmap: Bitmap? = null
        try {
            if (!isAlreadycahed()) {
                // Download Image from URL
                val input: InputStream = java.net.URL(imageURL).openStream()
                // Decode Bitmap
                bitmap = BitmapFactory.decodeStream(input)
                pDownloadImagefactory.getInstance().mCacheStatergy.pCachedDisk.add(
                    CacheDataItem(
                        imageURL,
                        bitmap
                    )
                )
            } else {
                bitmap = getChachedBitmap()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return bitmap
    }

    protected override fun onPostExecute(result: Bitmap?) {
        when (result != null && pView != null) {
            true -> {
                pView?.setImageBitmap(result)
            }
        }
    }

    private fun isAlreadycahed(): Boolean {
        pDownloadImagefactory.getInstance().mCacheStatergy.pCachedDisk.forEach {
            if (it.pUrl.equals(imageURL) && it.pBitmap != null) {
                return true
            }
        }
        return false
    }

    private fun getChachedBitmap(): Bitmap? {
        pDownloadImagefactory.getInstance().mCacheStatergy.pCachedDisk.forEach {
            if (it.pUrl.equals(imageURL)) {
                return it.pBitmap
            }
        }
        return null
    }
}

