package com.buitanhung.instagram.common.firebase

import com.buitanhung.instagram.common.AuthManager
import com.buitanhung.instagram.common.toUnit
import com.buitanhung.instagram.data.firebase.common.auth
import com.google.android.gms.tasks.Task

class FirebaseAuthManager : AuthManager {
    override fun signOut() {
        auth.signOut()
    }

    override fun signIn(email: String, password: String): Task<Unit> =
        auth.signInWithEmailAndPassword(email, password).toUnit()
}