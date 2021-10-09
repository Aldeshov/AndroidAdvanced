package com.ankit.trendinggit.view.ui.repolist

import androidx.lifecycle.MutableLiveData
import com.ankit.trendinggit.model.Item
import com.ankit.trendinggit.model.RepoRepository
import com.ankit.trendinggit.view.base.BaseViewModel

class RepoListViewModel(private val repo: RepoRepository) : BaseViewModel() {
    val repoListLive = MutableLiveData<List<Item>>()

    fun fetchTrendingRepoList() {
        dataLoading.value = true
        repo.getTrendingRepositories { isSuccess, response ->
            dataLoading.value = false
            if (isSuccess) {
                repoListLive.value = response?.items
                empty.value = false
            } else {
                empty.value = true
            }
        }
    }

    fun fetchUserRepoList(username: String) {
        dataLoading.value = true
        repo.getUserRepositories(username) { isSuccess, response ->
            dataLoading.value = false
            if (isSuccess) {
                empty.value = true
                if (response != null) {
                    repoListLive.value = response
                    empty.value = false
                }
            } else {
                empty.value = true
            }
        }
    }
}