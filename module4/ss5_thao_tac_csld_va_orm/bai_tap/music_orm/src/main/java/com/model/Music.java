package com.model;
import javax.persistence.*;

@Entity
@Table
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_music")
    private String nameMusic;

    private String singer;

    @Column(name = "type_music")
    private String typeMusic;

    @Column(name = "file_path")
    private String filePath;

    public Music() {
    }

    public Music(Integer id, String nameMusic, String singer, String typeMusic, String filePath) {
        this.id = id;
        this.nameMusic = nameMusic;
        this.singer = singer;
        this.typeMusic = typeMusic;
        this.filePath = filePath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameMusic() {
        return nameMusic;
    }

    public void setNameMusic(String nameMusic) {
        this.nameMusic = nameMusic;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getTypeMusic() {
        return typeMusic;
    }

    public void setTypeMusic(String typeMusic) {
        this.typeMusic = typeMusic;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "Music{" +
                "id=" + id +
                ", nameMusic='" + nameMusic + '\'' +
                ", singer='" + singer + '\'' +
                ", typeMusic='" + typeMusic + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
