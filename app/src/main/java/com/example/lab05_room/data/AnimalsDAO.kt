package com.example.lab05_room.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.lab05_room.data.entity.Animals

@Dao
interface AnimalsDAO {
    @Query("SELECT * FROM Animals")
    suspend fun getAll(): List<Animals>

    @Query("SELECT * FROM Animals WHERE id_animal = :id_animal")
    fun getAnimalById(id_animal: Int): Animals

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(animal: Animals)

    @Update
    suspend fun update(animal: Animals)

    @Delete
    suspend fun delete(animal: Animals)
}