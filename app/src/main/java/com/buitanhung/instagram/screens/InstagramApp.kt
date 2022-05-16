package com.buitanhung.instagram.screens

import android.app.Application
import com.buitanhung.instagram.common.firebase.FirebaseAuthManager
import com.buitanhung.instagram.data.firebase.FirebaseFeedPostsRepository
import com.buitanhung.instagram.data.firebase.FirebaseNotificationsRepository
import com.buitanhung.instagram.data.firebase.FirebaseSearchRepository
import com.buitanhung.instagram.data.firebase.FirebaseUsersRepository
import com.buitanhung.instagram.screens.notifications.NotificationsCreator
import com.buitanhung.instagram.screens.search.SearchPostsCreator

class InstagramApp : Application() {
    val usersRepo by lazy { FirebaseUsersRepository() }
    val feedPostsRepo by lazy { FirebaseFeedPostsRepository() }
    val notificationsRepo by lazy { FirebaseNotificationsRepository() }
    val authManager by lazy { FirebaseAuthManager() }
    val searchRepo by lazy { FirebaseSearchRepository() }

    override fun onCreate() {
        super.onCreate()
        NotificationsCreator(notificationsRepo, usersRepo, feedPostsRepo)
        SearchPostsCreator(searchRepo)
    }
}