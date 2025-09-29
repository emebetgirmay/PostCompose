package com.example.postscompose

import com.example.postscompose.api.ApiInterface
import com.example.postscompose.repository.PostsRepositoryImpl
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.runTest

import org.junit.Before
import org.junit.Test
import retrofit2.Response

class PostsRepositoryTest {
    lateinit var mockrepository: PostsRepositoryImpl
    lateinit var mockApiInterface: ApiInterface

    @Before
    fun setup(){
        mockApiInterface = mockk(relaxed = true)
        mockrepository = PostsRepositoryImpl(mockApiInterface)
    }
    @Test
    fun testFetchPosts(){
        runTest {
            //Given
            val expectedResponse = Response.success(TestData.mockPosts)
            coEvery { mockApiInterface.fetchPosts() } returns expectedResponse
        //When
            val result = mockrepository.fetchPosts()
//Then
            assertTrue(result.isSuccessful)
            assertEquals(result.body(), TestData.mockPosts)
        }
    }

    @Test
    fun testFetchPostsById(){
        runTest {
            val expected = Response.success(TestData.mockPost)
            coEvery { mockApiInterface.fetchPostById(1) } returns expected

            val result = mockrepository.fetchPostById(1)

            assertTrue(result.isSuccessful)
            assertEquals(result.body(), TestData.mockPost)
        }
    }
    @Test
    fun testFetchPostComments(){
        runTest {
            val expected = Response.success(TestData.mockComment)
            coEvery { mockApiInterface.fetchPostComments(1) }returns expected

            val result = mockrepository.fetchPostComments(1)


            assertTrue(result.isSuccessful)
            assertEquals(result.body(), TestData.mockComment)
        }
    }
}