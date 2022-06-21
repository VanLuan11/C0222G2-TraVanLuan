package com.repository;

import com.model.Music;

import java.util.List;

public interface IMusicRepository {
    List<Music> getAllMusic();
    Music findBy(int id);
    void create(Music music);
    void edit(Music music);
    void delete(int id);
}
