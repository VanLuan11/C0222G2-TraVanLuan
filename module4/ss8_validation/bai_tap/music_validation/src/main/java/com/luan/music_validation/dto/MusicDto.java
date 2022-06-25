package com.luan.music_validation.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class MusicDto {
    @NotEmpty
    @NotBlank
    @Size(min = 5, message = "Nhập đúng ký tự")
    private String name;

    @NotEmpty
    @NotBlank
    private String singer;

    @NotEmpty
    @NotBlank
    private String type;

    @NotEmpty
    @NotBlank
    private String file;

    public MusicDto() {
    }

    public MusicDto(@NotEmpty @NotBlank @Size(min = 5, message = "Nhập đúng ký tự") String name, @NotEmpty @NotBlank String singer, @NotEmpty @NotBlank String type, @NotEmpty @NotBlank String file) {
        this.name = name;
        this.singer = singer;
        this.type = type;
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
