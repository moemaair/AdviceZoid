package com.android.advicezoid.repository

import com.android.advicezoid.Room.AdviceDao
import com.android.advicezoid.model.Slip

class AdviceRepositoryImpl (
    private val adviceDao: AdviceDao
): AdviceRepository {

    override fun getAdvicesFromRoom() = adviceDao.getAll()

    override fun addAdviceToRoom(advice: Slip) = adviceDao.insert(advice)

    override fun deleteAllAdvicesFromRoom() = adviceDao.deleteAll()
    override fun deteleSpeficAdviceFromRoom(advice: Slip) = adviceDao.delete(advice)
}