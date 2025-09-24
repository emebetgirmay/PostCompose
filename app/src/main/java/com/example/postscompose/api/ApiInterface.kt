package com.example.postscompose.api

import com.example.postscompose.model.Post
import org.w3c.dom.Comment
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/posts")
    suspend fun fetchPosts(): Response<List<Post>>

    @GET("/posts/{postId}")
    suspend fun fetchPostById(@Path("postId") postId: Int):Response<Post>

    @GET("/posts/{postId}/comments")
    suspend fun fetchPostComments(@Path("postId") postId: Int): Response<List<com.example.postscompose.model.Comment>>
}