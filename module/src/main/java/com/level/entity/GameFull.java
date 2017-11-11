package com.level.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "gameFullInformation")

public class GameFull {
    private long idGameFullInformation;
    private String name;
    private String image;
    private String images;
    private String description;
    private String reviews;
    private String gameplay;

    private Set<Image> imagesSet = new HashSet<>();

    private Game game;

    public GameFull(){}

    public GameFull(long gameFullInformation, String name, String image, String images, String description, String reviews, String gameplay) {
        this.idGameFullInformation = gameFullInformation;
        this.name = name;
        this.image = image;
        this.images = images;
        this.description = description;
        this.reviews = reviews;
        this.gameplay = gameplay;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public long getIdGameFullInformation() {
        return idGameFullInformation;
    }

    public void setIdGameFullInformation(long idGameFullInformation) {
        this.idGameFullInformation = idGameFullInformation;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Column(name = "images")
    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "review")
    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    @Column(name = "gameplay")
    public String getGameplay() {
        return gameplay;
    }

    public void setGameplay(String gameplay) {
        this.gameplay = gameplay;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "gameFull")
    public Set<Image> getImagesSet() {
        return imagesSet;
    }

    public void setImagesSet(Set<Image> imagesSet) {
        this.imagesSet = imagesSet;
    }


    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public String toString() {
        return "GameFull{" +
                "idGameFullInformation=" + idGameFullInformation +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", images='" + images + '\'' +
                ", description='" + description + '\'' +
                ", reviews='" + reviews + '\'' +
                ", gameplay='" + gameplay + '\'' +
                ", game=" + game +
                '}';
    }
}
