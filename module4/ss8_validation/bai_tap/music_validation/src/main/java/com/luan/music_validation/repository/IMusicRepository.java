package com.luan.music_validation.repository;

import com.luan.music_validation.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMusicRepository extends JpaRepository<Music,Integer> {
    @Query(value = "select * from music",nativeQuery = true)
    List<Music> findAll();

    @Query(value = "select * from music m where m.id = :id",nativeQuery = true)
    Music getMusic(@Param("id") int id);
}
