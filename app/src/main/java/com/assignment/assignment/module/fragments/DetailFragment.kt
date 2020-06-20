package com.assignment.assignment.module.fragments;

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.assignment.assignment.R
import com.assignment.assignment.model.response.CrosspostParentListItem
import com.assignment.assignment.module.fragments.viewmodels.DetailViewModel
import com.assignment.imageloader.DownloadImage.DownloadImagefactory
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.detail_fragment.*
import kotlinx.android.synthetic.main.layout_actionbar.*
import javax.inject.Inject

class DetailFragment : Fragment() {

    companion object {
        fun newInstance() = DetailFragment()
    }

    @Inject
    lateinit var mViewModel: DetailViewModel

    @Inject
    internal lateinit var mViewModelFactory: ViewModelProvider.Factory

    private lateinit var mFetchWikiResponse: CrosspostParentListItem

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewModel = ViewModelProvider(this, mViewModelFactory).get(DetailViewModel::class.java)
        iv_back.setOnClickListener { activity?.onBackPressed() }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setDataToView()
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    fun setFetchWikiResponse(pFetchWikiResponse: CrosspostParentListItem) {
        mFetchWikiResponse = pFetchWikiResponse
    }

    private fun setDataToView() {
        when (::mFetchWikiResponse.isInitialized) {
            true -> {
                DownloadImagefactory().apply {
                    setUrl(mFetchWikiResponse.url)
                    setImageView(ivFullView)
                }.download()
            }
        }
    }
}
