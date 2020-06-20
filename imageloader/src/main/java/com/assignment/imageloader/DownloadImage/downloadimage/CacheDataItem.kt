package com.assignment.imageloader.DownloadImage.downloadimage

import android.graphics.Bitmap
import java.io.Serializable

data class CacheDataItem(
    var pUrl: String,
    var pBitmap: Bitmap
) : Serializable