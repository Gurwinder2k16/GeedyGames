package com.assignment.imageloader.DownloadImage

import android.widget.ImageView
import com.assignment.imageloader.DownloadImage.downloadimage.CacheStatergy
import com.assignment.imageloader.DownloadImage.downloadimage.DownloadImage

open class DownloadImagefactory() {
    private var mUrl: String = ""
    private lateinit var mImageView: ImageView


    companion object {
        var mCacheStatergy=CacheStatergy()
        fun getInstance() = this
    }

    fun setUrl(pUrl: String): Companion {
        mUrl = pUrl
        return getInstance()
    }

    fun setImageView(pView: ImageView): Companion {
        mImageView = pView
        return getInstance()
    }

    fun download() {
        when (mUrl.isNotEmpty() && ::mImageView.isInitialized) {
            true -> DownloadImage(mImageView, getInstance()).execute(mUrl)
        }
    }
}