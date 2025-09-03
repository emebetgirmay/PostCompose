package com.example.postscompose.api

import com.example.postscompose.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/posts")
    suspend fun fetchPosts(): Response<List<Post>>

    @GET("/posts/{postId}")
    suspend fun fetchPostById(@Path("postId") postId: Int):Response<Post>
}