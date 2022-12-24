package com.android.advicezoid.repository

import com.android.advicezoid.Room.AdviceDao
import com.android.advicezoid.model.Advices
import com.android.advicezoid.model.Slip
import kotlinx.coroutines.flow.Flow

class AdviceRepositoryImpl (
    private val adviceDao: AdviceDao
): AdviceRepository {

    override fun getAdvicesFromRoom() = adviceDao.getAll()

    override fun addAdviceToRoom(advice: Slip) = adviceDao.insert(advice)

    override fun deleteAllAdvicesFromRoom() = adviceDao.deleteAll()


}