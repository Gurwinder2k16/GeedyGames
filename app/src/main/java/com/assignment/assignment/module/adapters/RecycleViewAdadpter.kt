package com.assignment.assignment.module.adapters

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.assignment.assignment.R
import com.assignment.assignment.model.response.ChildrenItem
import com.assignment.assignment.model.response.CrosspostParentListItem
import com.assignment.assignment.module.activity.DetailActivity
import com.assignment.imageloader.DownloadImage.DownloadImagefactory
import kotlinx.android.synthetic.main.content_user_header.view.*


class RecycleViewAdadpter(private var pUserList: ArrayList<ChildrenItem>) :
    RecyclerView.Adapter<UserViewHolder>() {
    lateinit var mNestedPreviewRecycleViewAdadpter: NestedPreviewRecycleViewAdadpter
    override fun onCreateViewHolder(pParent: ViewGroup, pViewType: Int): UserViewHolder {
        return UserViewHolder(
            pItemView = LayoutInflater.from(pParent.context).inflate(
                R.layout.item_view_users,
                pParent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return pUserList.size
    }

    override fun onBindViewHolder(pHolder: UserViewHolder, pPosition: Int) {
        pHolder.mItemView.tv_title.text =pHolder.mItemView.context.getString(R.string.user_type_s,pUserList[pPosition].data?.authorFullname ?: "No Name")
        DownloadImagefactory().apply {
            pUserList[pPosition].data?.url?.let { setUrl(it) }
            setImageView(pHolder.mItemView.iv_users)
        }.download()
        mNestedPreviewRecycleViewAdadpter =
            NestedPreviewRecycleViewAdadpter(pUserList = pUserList[pPosition].data?.crosspostParentList!!)
        pHolder.mItemView.rvNestedImages.layoutManager =
            LinearLayoutManager(pHolder.mItemView.context)
        pHolder.mItemView.rvNestedImages.adapter = mNestedPreviewRecycleViewAdadpter
        mNestedPreviewRecycleViewAdadpter.notifyDataSetChanged()
        pHolder.mItemView.setOnClickListener {
            onClickItems(pHolder = pHolder, pPosition = pPosition)
        }
    }

    private fun onClickItems(pHolder: UserViewHolder, pPosition: Int) {
        when (pHolder.mItemView.context != null && pPosition < pUserList.size) {
            true -> {
                val listItem = CrosspostParentListItem()
                listItem.url = pUserList[pPosition].data?.url!!
                val bundle = Bundle()
                bundle.putSerializable(
                    DetailActivity::class.java.simpleName,
                    listItem
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

class UserViewHolder(var pItemView: View) : RecyclerView.ViewHolder(pItemView) {
    var mItemView = pItemView
}