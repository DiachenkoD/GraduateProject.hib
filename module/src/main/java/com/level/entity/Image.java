package com.level.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "image")

public class Image {
    private long idImage;
    private String imageName;
    private String imageAdress;

    private GameFull gameFull;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "idImage")
    public long getIdImage() {
        return idImage;
    }

    public void setIdImage(long idImage) {
        this.idImage = idImage;
    }

    @Column(name = "imageName")
    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Column(name = "imageAdress")
    public String getImageAdress() {
        return imageAdress;
    }

    public void setImageAdress(String imageAdress) {
        this.imageAdress = imageAdress;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "gameFull")
    public GameFull getGameFull() {
        return gameFull;
    }

    public void setGameFull(GameFull gameFull) {
        this.gameFull = gameFull;
    }

    @Override
    public String toString() {
        return "Image{" +
                "idImage=" + idImage +
                ", imageName='" + imageName + '\'' +
                ", imageAdress='" + imageAdress + '\'' +
                ", gameFull=" + gameFull +
                '}';
    }
}
