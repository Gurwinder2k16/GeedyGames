package com.assignment.assignment.module.activity

import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.assignment.assignment.R
import com.assignment.assignment.model.response.CrosspostParentListItem
import com.assignment.assignment.model.response.Preview
import com.assignment.assignment.module.fragments.DetailFragment

class DetailActivity : BaseActivity() {


    private var mDefaultFragment: DetailFragment = DetailFragment.newInstance()
    private lateinit var mPreview: CrosspostParentListItem
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)
        getDataFromPrevIntent()
        if (savedInstanceState == null && ::mPreview.isInitialized) {
            mDefaultFragment.setFetchWikiResponse(mPreview)
            setDefaultView(pFragment = mDefaultFragment)
        }
    }

    private fun setDefaultView(pFragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, pFragment)
            .commitNow()
    }

    private fun getDataFromPrevIntent() {
        when (intent.hasExtra(DetailActivity::class.java.simpleName)) {
            true -> {
                mPreview = intent.getSerializableExtra(DetailActivity::class.java.simpleName)!! as CrosspostParentListItem
            }
        }
    }

    override fun onBackPressed() {
        ActivityCompat.finishAfterTransition(this)
    }
}
