package com.ankit.trendinggit.model

import com.ankit.trendinggit.model.api.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepoRepositoryImpl : RepoRepository {

    // GET Trending repository list
    override fun getTrendingRepositories(onResult: (isSuccess: Boolean, response: GitResponse?) -> Unit) {

        ApiClient.instance.getRepo().enqueue(object : Callback<GitResponse> {
            override fun onResponse(call: Call<GitResponse>?, response: Response<GitResponse>?) {
                if (response != null && response.isSuccessful)
                    onResult(true, response.body()!!)
                else
                    onResult(false, null)
            }

            override fun onFailure(call: Call<GitResponse>?, t: Throwable?) {
                onResult(false, null)
            }

        })
    }

    // GET User repository list
    override fun getUserRepositories(username: String, onResult: (isSuccess: Boolean, response: List<Item>?) -> Unit) {

        ApiClient.instance.getReposOfUser(username).enqueue(object : Callback<List<Item>> {
            override fun onResponse(call: Call<List<Item>>?, response: Response<List<Item>>?) {
                if (response != null && response.isSuccessful)
                    onResult(true, response.body()!!)
                else
                    onResult(false, null)
            }

            override fun onFailure(call: Call<List<Item>>?, t: Throwable?) {
                onResult(false, null)
            }
        })
    }
}