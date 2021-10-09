package com.ankit.trendinggit.model

interface RepoRepository {
    fun getTrendingRepositories(onResult: (isSuccess: Boolean, response: GitResponse?) -> Unit)

    fun getUserRepositories(username: String, onResult: (isSuccess: Boolean, response: List<Item>?) -> Unit)
}