package com.ankit.trendinggit.view.adapter.viewHolders

import android.os.Bundle
import android.widget.ImageView
import androidx.databinding.ViewDataBinding
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.ankit.trendinggit.BR
import com.ankit.trendinggit.R
import com.ankit.trendinggit.model.Item
import com.ankit.trendinggit.view.ui.repolist.RepoListViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.view_repo_list_item.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class RepoListViewHolder constructor(private val dataBinding: ViewDataBinding, private val repoListViewModel: RepoListViewModel)
    : RecyclerView.ViewHolder(dataBinding.root) {

    private val avatarImage: ImageView = itemView.item_avatar
    fun setup(itemData: Item) {
        dataBinding.setVariable(BR.itemData, itemData)
        dataBinding.executePendingBindings()

        Picasso.get().load(itemData.owner.avatar_url).into(avatarImage)

        itemView.onClick {
            val bundle = Bundle()
            bundle.putString("url", itemData.html_url)
            itemView.findNavController().navigate(R.id.action_repoListFragment_to_repoDetailFragment, bundle)
        }
    }
}