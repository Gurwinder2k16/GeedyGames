package com.assignment.imageloader.DownloadImage.downloadimage

import java.io.Serializable

data class CacheStatergy(
    var pCachedDisk: ArrayList<CacheDataItem> = ArrayList()
) : Serializable