package com.example.postscompose

import com.example.postscompose.model.Comment
import com.example.postscompose.model.Post
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response

object TestData {
    val mockPosts = listOf(
        Post(
            userId = 1,
            id = 1,
            title = "Title 1",
            body = "Body 1"
        ),
        Post(
            userId = 2,
            id = 2,
            title = "Title 2",
            body = "Body 2"
        )
    )
    val mockPost =Post(

            userId = 1,
            id = 1,
            title = "Title 1",
            body = "Body 1"
    )

    val mockComment=listOf(
        Comment(
            id = 1,
            postId = 1,
            name = "Habtamnesh",
            email = "habtamnesh@gmail.com",
            body = "Comment body 1"
        ),
        Comment(
            id = 2,
            postId = 2,
            name = "Emebet",
            email = "abed@gmail.com",
            body = "Comment body 2"
        )
    )

    val errorResponse = Response.error<List<Post>>(
        404,
        "{\"error\": \"Not found\"}".toResponseBody()
    )
}