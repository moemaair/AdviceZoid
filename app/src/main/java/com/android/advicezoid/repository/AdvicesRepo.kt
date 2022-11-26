package com.android.advicezoid.repository

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat.getSystemService
import com.android.advicezoid.Realm.AdviceRealm
import com.android.advicezoid.model.Advices
import com.android.advicezoid.viewmodel.AdviceViewModel
import io.realm.Realm

class AdvicesRepo()

