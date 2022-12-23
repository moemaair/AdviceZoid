package com.android.advicezoid.repository


import com.android.advicezoid.model.Slip
import java.util.concurrent.Flow


typealias Slips = List<Slip>

interface AdviceRepository{

    //CRUD --> CREATE -> READ -> DELETE
    fun getAdvicesFromRoom(): kotlinx.coroutines.flow.Flow<Slips>   // get all
    fun addAdviceToRoom(advice: Slip) // add
    fun deleteBookFromRoom(advice: Slip) // delete
}