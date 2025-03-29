package com.example.appmarsphotos.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MarsRoverSavedPhotoDao {

    //Thêm 1 ảnh vào database
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(marsRoverSavedLocalModel: MarsRoverSavedLocalModel)

    //Xóa 1 ảnh khỏi database
    @Delete
    suspend fun delete(marsRoverSavedLocalModel: MarsRoverSavedLocalModel)

    //Lấy tất cả danh sách Id của ảnh đã lưu
    @Query("SELECT roverPhotoId FROM rover_photo WHERE sol = :sol AND roverName = :roverName")
    fun allSavedIds(sol: String, roverName: String): Flow<List<Int>>


    //Lấy tất cả các ảnh đã lưu trong database
    @Query("SELECT * FROM rover_photo ORDER BY earthDate DESC")
    fun getAllSaved(): Flow<List<MarsRoverSavedLocalModel>>
}