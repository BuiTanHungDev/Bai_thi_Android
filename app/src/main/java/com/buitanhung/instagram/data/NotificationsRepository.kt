package com.buitanhung.instagram.data

import androidx.lifecycle.LiveData
import com.buitanhung.instagram.models.Notification
import com.google.android.gms.tasks.Task

interface NotificationsRepository {
    fun createNotification(uid: String, notification: Notification): Task<Unit>
    fun getNotifications(uid: String): LiveData<List<Notification>>
    fun setNotificationsRead(uid: String, ids: List<String>, read: Boolean): Task<Unit>
}