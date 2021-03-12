package com.entities;

import javax.persistence.*;

@Entity
@Table(name = "dots")
public class Dot {

    public Dot(){}

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private Double x;
    private Double y;
    private Double r;
    private Boolean ingress;
    private String login;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getR() {
        return r;
    }

    public void setR(Double r) {
        this.r = r;
    }

    public Boolean isIngress() {
        return ingress;
    }

    public void setIngress(Boolean ingress) {
        this.ingress = ingress;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
