package com.service.Impl;

import com.model.Music;
import com.repository.IMusicRepository;
import com.repository.Impl.BaseRepository;
import com.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImpl implements IMusicService {
    @Autowired
    private IMusicRepository iMusicRepository;

    @Override
    public List<Music> getAllMusic() {
        return iMusicRepository.getAllMusic();
    }

    @Override
    public Music findBy(int id) {
        return iMusicRepository.findBy(id);
    }

    @Override
    public void create(Music music) {
        iMusicRepository.create(music);
    }

    @Override
    public void edit(Music music) {
        iMusicRepository.edit(music);
    }

    @Override
    public void delete(int id) {
        iMusicRepository.delete(id);
    }
}
