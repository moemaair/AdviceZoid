package com.android.advicezoid.Realm

import io.realm.RealmModel
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required
import org.bson.types.ObjectId

open class AdviceRealm(
    @PrimaryKey
    var id: String = "",
    @Required
var advicetext: String? = ""
): RealmObject()