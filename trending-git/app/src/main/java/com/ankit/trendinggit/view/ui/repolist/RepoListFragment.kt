package com.ankit.trendinggit.view.ui.repolist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ankit.trendinggit.databinding.FragmentRepoListBinding
import com.ankit.trendinggit.view.adapter.RepoListAdapter
import kotlinx.android.synthetic.main.fragment_repo_list.*
import org.jetbrains.anko.longToast
import org.koin.androidx.viewmodel.ext.android.viewModel

class RepoListFragment : Fragment() {
    // Lazy Inject ViewModel
    private val repoListViewModel: RepoListViewModel by viewModel()
    private lateinit var viewDataBinding: FragmentRepoListBinding
    private lateinit var adapter: RepoListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        viewDataBinding = FragmentRepoListBinding.inflate(inflater, container, false).apply {
            viewModel = repoListViewModel
            lifecycleOwner = viewLifecycleOwner
        }

        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = this.arguments
        if (bundle != null) {
            when (bundle.getInt("type")) {
                1 -> {
                    bundle.getString("username")?.let { viewDataBinding.viewModel?.fetchUserRepoList(it) }
                }
                else -> {
                    viewDataBinding.viewModel?.fetchTrendingRepoList()
                }
            }
        }
        else {
            viewDataBinding.viewModel?.fetchTrendingRepoList()
        }

        setupAdapter()
        setupObservers()
    }

    private fun setupObservers() {
        viewDataBinding.viewModel?.repoListLive?.observe(viewLifecycleOwner, Observer {
            adapter.updateRepoList(it)
        })

        viewDataBinding.viewModel?.toastMessage?.observe(viewLifecycleOwner, Observer {
            activity?.longToast(it)
        })
    }

    private fun setupAdapter() {
        val viewModel = viewDataBinding.viewModel
        if (viewModel != null) {
            adapter = RepoListAdapter(viewDataBinding.viewModel!!)
            val layoutManager = LinearLayoutManager(activity)
            repo_list_rv.layoutManager = layoutManager
            repo_list_rv.addItemDecoration(DividerItemDecoration(activity, layoutManager.orientation))
            repo_list_rv.adapter = adapter
        }
    }
}
