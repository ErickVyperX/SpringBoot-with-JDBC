package io.erickdev.springdata.tennisplayer.datalayer;

import java.time.LocalDate;
import java.util.StringJoiner;
public class Player {
    private int id;
    private String name;
    private String nationality;
    private LocalDate birth_date;
    private int titles;

    public Player() {
    }

    public Player(int id, String name, String nationality, LocalDate birthdate, int titles) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.birth_date = birthdate;
        this.titles = titles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    public int getTitles() {
        return titles;
    }

    public void setTitles(int titles) {
        this.titles = titles;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Player.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("nationality='" + nationality + "'")
                .add("birthdate=" + birth_date)
                .add("titles=" + titles)
                .toString();
    }
}
