package com.level.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "game")

public class Game {
    private long idGame;
    private String name;
    private String shortDescription;
    private String image;
    private Seria seria;

    private GameFull getGameFullById;

    public Game(){}

    public Game(long idGame, String name, String shortDescription, String image, Seria seria) {
        this.idGame = idGame;
        this.name = name;
        this.shortDescription = shortDescription;
        this.image = image;
        this.seria = seria;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "idGame")
    public long getIdGame() {
        return idGame;
    }

    public void setIdGame(long idGame) {
        this.idGame = idGame;
    }

    @Column(name = "game")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "shortDescription")
    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idSeria")
    public Seria getSeria() {
        return seria;
    }

    public void setSeria(Seria seria) {
        this.seria = seria;
    }

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "game")
    public GameFull getGetGameFullById() {
        return getGameFullById;
    }

    public void setGetGameFullById(GameFull getGameFullById) {
        this.getGameFullById = getGameFullById;
    }


    @Override
    public String toString() {
        return "Game{" +
                "idGame=" + idGame +
                ", name='" + name + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", image='" + image + '\'' +
                ", seria=" + seria +
                '}';
    }
}
