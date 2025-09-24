package com.example.postscompose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.postscompose.model.Comment
import com.example.postscompose.viewmodel.PostsViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun viewPostScreen(postId: Int, viewModel: PostsViewModel= koinViewModel()
){
    LaunchedEffect(Unit) {
        viewModel.fetchPostById(postId)
        viewModel.fetchPostComments(postId)
    }

    val post by viewModel.post.observeAsState()
    val comments by viewModel.comments.observeAsState()

    Column (modifier = Modifier.fillMaxSize().padding(16.dp)){
        post?.let{
        Text(text = it.title)
        Spacer(Modifier.height(8.dp))
        Text(text = it.body)
    }
    if (comments!=null){

        Text(text = "COMMENTS", fontWeight = FontWeight.Bold)
        LazyColumn {
            items(comments!!){comment-> CommentRow(comment)}
        }
    }
    }

}



@Composable
fun CommentRow(comment: Comment){
    Column (modifier = Modifier.padding(30.dp, 10.dp)){

        Text(text = comment.name)
        Spacer(Modifier.height(8.dp))
        Text(text = comment.email)
        Spacer(Modifier.height(8.dp))
        Text(text = comment.body)
        Spacer(Modifier.height(8.dp))
        HorizontalDivider(thickness = 1.dp, color = Color.LightGray)

    }
}