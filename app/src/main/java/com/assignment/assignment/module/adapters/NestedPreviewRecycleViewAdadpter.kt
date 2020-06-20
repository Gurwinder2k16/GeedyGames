package com.assignment.assignment.module.adapters

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.RecyclerView
import com.assignment.assignment.R
import com.assignment.assignment.model.response.CrosspostParentListItem
import com.assignment.assignment.module.activity.DetailActivity
import com.assignment.imageloader.DownloadImage.DownloadImagefactory
import kotlinx.android.synthetic.main.item_view_nested_preview.view.*


class NestedPreviewRecycleViewAdadpter(private var pUserList: List<CrosspostParentListItem>) :
    RecyclerView.Adapter<NestedPreviewUserViewHolder>() {

    override fun onCreateViewHolder(
        pParent: ViewGroup,
        pViewType: Int
    ): NestedPreviewUserViewHolder {
        return NestedPreviewUserViewHolder(
            pItemView = LayoutInflater.from(pParent.context).inflate(
                R.layout.item_view_nested_preview,
                pParent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return pUserList.size
    }

    override fun onBindViewHolder(pHolder: NestedPreviewUserViewHolder, pPosition: Int) {
        DownloadImagefactory().apply {
            setUrl(pUserList[pPosition].url)
            setImageView(pHolder.mItemView.ivImage)
        }.download()
        pHolder.mItemView.setOnClickListener {
            onClickItems(pHolder = pHolder, pPosition = pPosition)
        }
    }

    private fun onClickItems(pHolder: NestedPreviewUserViewHolder, pPosition: Int) {
        when (pHolder.mItemView.context != null && pPosition < pUserList.size) {
            true -> {
                val bundle = Bundle()
                bundle.putSerializable(
                    DetailActivity::class.java.simpleName,
                    pUserList.get(pPosition)
                )
                val intent = Intent(pHolder.mItemView.context, DetailActivity::class.java)
                intent.putExtras(bundle)
                val transitionName: String =
                    pHolder.mItemView.context.getString(R.string.transition)
                val options =
                    ActivityOptionsCompat.makeSceneTransitionAnimation(
                        pHolder.mItemView.context as Activity,
                        pHolder.mItemView,
                        transitionName
                    )
                ActivityCompat.startActivity(pHolder.mItemView.context, intent, options.toBundle())
            }
        }
    }
}

class NestedPreviewUserViewHolder(var pItemView: View) : RecyclerView.ViewHolder(pItemView) {
    var mItemView = pItemView
}