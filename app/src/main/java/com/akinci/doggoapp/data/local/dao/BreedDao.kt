package com.akinci.doggoapp.data.local.dao

import androidx.room.*
import com.akinci.doggoapp.data.local.entity.BreedEntity

@Dao
interface BreedDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertBreed(breedList: List<BreedEntity>)

    @Query("SELECT * FROM breedTable ORDER BY id ASC")
    fun getAllBreeds(): List<BreedEntity>
}