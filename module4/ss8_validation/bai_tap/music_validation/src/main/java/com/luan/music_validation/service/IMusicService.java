package com.luan.music_validation.service;

import com.luan.music_validation.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();

    void save(Music music);

    Music getMusic(int id);

    void delete(int id);
}
