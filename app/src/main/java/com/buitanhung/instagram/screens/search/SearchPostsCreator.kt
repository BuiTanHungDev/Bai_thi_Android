package com.buitanhung.instagram.screens.search

import android.util.Log
import androidx.lifecycle.Observer
import com.buitanhung.instagram.common.BaseEventListener
import com.buitanhung.instagram.common.Event
import com.buitanhung.instagram.common.EventBus
import com.buitanhung.instagram.data.SearchRepository
import com.buitanhung.instagram.models.SearchPost

class SearchPostsCreator(searchRepo: SearchRepository) : BaseEventListener() {
    init {
        EventBus.events.observe(this, Observer {
            it?.let { event ->
                when (event) {
                    is Event.CreateFeedPost -> {
                        val searchPost = with(event.post) {
                            SearchPost(
                                    image = image,
                                    caption = caption,
                                    postId = id)
                        }
                        searchRepo.createPost(searchPost).addOnFailureListener {
                            Log.d(TAG, "Failed to create search post for event: $event", it)
                        }
                    }
                    else -> {
                    }
                }
            }
        })
    }

    companion object {
        const val TAG = "SearchPostsCreator"
    }
}