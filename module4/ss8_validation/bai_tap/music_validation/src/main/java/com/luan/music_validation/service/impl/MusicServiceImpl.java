package com.luan.music_validation.service.impl;

import com.luan.music_validation.model.Music;
import com.luan.music_validation.repository.IMusicRepository;
import com.luan.music_validation.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImpl implements IMusicService {
    @Autowired
    private IMusicRepository musicRepository;

    @Override
    public List<Music> findAll() {
        return musicRepository.findAll();
    }

    @Override
    public void save(Music music) {
        musicRepository.save(music);
    }

    @Override
    public Music getMusic(int id) {
        return musicRepository.getMusic(id);
    }

    @Override
    public void delete(int id) {
        musicRepository.deleteById(id);
    }
}
