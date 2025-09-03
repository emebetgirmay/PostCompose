package com.example.postscompose.repository

import com.example.postscompose.api.ApiClient
import com.example.postscompose.api.ApiInterface
import com.example.postscompose.model.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class PostsRepository {
    val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun fetchPosts(): Response<List<Post>>{
        return withContext(Dispatchers.IO){
            retrofit.fetchPosts()
        }
    }
}