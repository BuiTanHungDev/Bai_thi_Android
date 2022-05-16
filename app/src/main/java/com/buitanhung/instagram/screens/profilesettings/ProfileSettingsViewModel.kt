package com.buitanhung.instagram.screens.profilesettings

import com.buitanhung.instagram.common.AuthManager
import com.buitanhung.instagram.screens.common.BaseViewModel
import com.google.android.gms.tasks.OnFailureListener

class ProfileSettingsViewModel(private val authManager: AuthManager,
                               onFailureListener: OnFailureListener) :
        BaseViewModel(onFailureListener),
        AuthManager by authManager