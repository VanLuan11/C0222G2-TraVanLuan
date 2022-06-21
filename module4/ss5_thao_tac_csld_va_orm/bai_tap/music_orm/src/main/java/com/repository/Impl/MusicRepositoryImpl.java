package com.repository.Impl;

import com.model.Music;
import com.repository.IMusicRepository;

import org.springframework.stereotype.Service;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;


@Service
public class MusicRepositoryImpl implements IMusicRepository {

    @Override
    public List<Music> getAllMusic() {
        TypedQuery<Music> typedQuery = BaseRepository.entityManager.createQuery
                ("select s from Music s", Music.class);
        return typedQuery.getResultList();
    }

    @Override
    public Music findBy(int id) {
        TypedQuery<Music> typedQuery =
                BaseRepository.entityManager.createQuery("select s" +
                        " from Music s where s.id = :musicId", Music.class);
        typedQuery.setParameter("musicId", id);

        return typedQuery.getSingleResult() ;
    }

    @Override
    public void create(Music music) {

        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(music);
        entityTransaction.commit();
    }

    @Override
    public void edit(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(music);
        entityTransaction.commit();
    }

    @Override
    public void delete(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(BaseRepository.entityManager.find(Music.class,id));
        entityTransaction.commit();
    }
}
