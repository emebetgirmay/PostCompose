package com.example.postscompose.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.postscompose.model.Post
import com.example.postscompose.model.UIState
import com.example.postscompose.repository.PostsRepository
import kotlinx.coroutines.launch


class PostsViewModel: ViewModel() {
    val postsRepository = PostsRepository()
    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>> = _posts

    private val _uiState = MutableLiveData(UIState())
    val uiState: LiveData<UIState> = _uiState



    fun fetchPosts(){
        viewModelScope.launch {
            _uiState.value = _uiState.value?.copy(isLoading = true)
            val response = postsRepository.fetchPosts()

            if(response.isSuccessful){
                _uiState.value = _uiState.value.copy(isLoading = false, success = "Posts fetched successfully")
                _posts.value = response.body()
            }else{
                _uiState.value =
                    _uiState.value?.copy(isLoading = false, error = response.errorBody()?.string())

            }
        }

    }
}