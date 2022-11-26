package com.android.advicezoid.Realm

import android.app.Application
import com.android.advicezoid.model.Advices
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.kotlin.executeTransactionAwait
import kotlinx.coroutines.Dispatchers


// realm pip!!

class AdviceDatabaseOperations: Application() {
  var realm: Realm? = null // realm initiazialtion
   var datamodel = AdviceRealm()

  var  current_id = realm?.where(AdviceRealm::class.java)?.max("id")


   fun insertAdvice(){
      realm?.executeTransaction { // lamda to add in realm
         transaction -> transaction.copyToRealm(datamodel)
      }
   }


   fun showAdviceFavs(){
     var dataModels: List<AdviceRealm> = realm?.where(AdviceRealm::class.java)!!.findAll()
      for(i in dataModels){ // iterating over data source
         println(i.advicetext.toString())
      }
   }










}