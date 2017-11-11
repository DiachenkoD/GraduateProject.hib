package com.level.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "seria")

public class Seria {
    private long idSeria;
    private String seriaName;
    private String image;
    private String shortDescription;

    private Set<Game> gamesSet = new HashSet<>();

    public Seria(){}

    public Seria(long idSeria, String seriaName, String image, String shortDescription, Set<Game> gamesSet) {
        this.idSeria = idSeria;
        this.seriaName = seriaName;
        this.image = image;
        this.shortDescription = shortDescription;
        this.gamesSet = gamesSet;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment",strategy = "increment")
    @Column(name = "idSeria")
    public long getIdSeria(){
        return idSeria;
    }

    public void setIdSeria(long idSeria){
        this.idSeria = idSeria;
    }

    @Column(name = "seriaName")
    public String getSeriaName() {
        return seriaName;
    }

    public void setSeriaName(String seriaName) {
        this.seriaName = seriaName;
    }

    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    @Column(name = "shortDescription",length = 700)
    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "seria")
    public Set<Game> getGamesSet(){
        return this.gamesSet;
    }

    public void setGamesSet(Set<Game> gamesSet){
        this.gamesSet = gamesSet;
    }

    @Override
    public String toString(){
        return "idSeria = " + idSeria +
                "seriaName = " + seriaName +
                "image = " + image +
                "short description = " + shortDescription +
                "games Set = " + gamesSet;

    }

}
