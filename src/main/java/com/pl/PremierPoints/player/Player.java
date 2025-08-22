package com.pl.PremierPoints.player;

import jakarta.persistence.*;

@Entity
@Table(name = "player_statistic")
public class Player {
    @Id
    @Column(name = "player_name", unique = true)
    private String name;

    @Column(name = "nation")
    private String nation;

    @Column(name = "position")
    private String pos;

    @Column(name = "age")
    private Integer age;

    @Column(name = "matches_played")
    private Integer mp;

    @Column(name = "starts")
    private Integer starts;

    @Column(name = "minutes_played")
    private Double min;

    @Column(name = "goals")
    private Double gls;

    @Column(name = "assists")
    private Double ast;

    @Column(name = "penalties_scored")
    private Double pk;

    @Column(name = "yellow_cards")
    private Double crdy;

    @Column(name = "red_cards")
    private Double crdr;

    @Column(name = "expected_goals")  // Note: you mentioned "_expected_goals" in description
    private Double xg;

    @Column(name = "expected_assists")
    private Double xag;

    @Column(name = "team_name")
    private String team;

    // Default constructor (required by JPA)
    public Player() { }

    // Constructor with name only
    public Player(String name) {
        this.name = name;
    }

    // Full constructor - Fixed parameter types to match field types
    public Player(String name, String nation, String pos, Integer age, Integer mp, Integer starts,
                  Double min, Double gls, Double ast, Double pk, Double crdy, Double crdr,
                  Double xg, Double xag, String team) {
        this.name = name;
        this.nation = nation;
        this.pos = pos;
        this.age = age;
        this.mp = mp;
        this.starts = starts;
        this.min = min;
        this.gls = gls;
        this.ast = ast;
        this.pk = pk;
        this.crdy = crdy;
        this.crdr = crdr;
        this.xg = xg;
        this.xag = xag;
        this.team = team;
    }

    // Getters and Setters - Fixed return types
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public Integer getAge() {  // Changed to Integer
        return age;
    }

    public void setAge(Integer age) {  // Changed to Integer
        this.age = age;
    }

    public Integer getMp() {  // Changed to Integer
        return mp;
    }

    public void setMp(Integer mp) {  // Changed to Integer
        this.mp = mp;
    }

    public Integer getStarts() {  // Changed to Integer
        return starts;
    }

    public void setStarts(Integer starts) {  // Changed to Integer
        this.starts = starts;
    }

    public Double getMin() {  // Changed to Double
        return min;
    }

    public void setMin(Double min) {  // Changed to Double
        this.min = min;
    }

    public Double getGls() {  // Changed to Double
        return gls;
    }

    public void setGls(Double gls) {  // Changed to Double
        this.gls = gls;
    }

    public Double getAst() {  // Changed to Double
        return ast;
    }

    public void setAst(Double ast) {  // Changed to Double
        this.ast = ast;
    }

    public Double getPk() {  // Changed to Double
        return pk;
    }

    public void setPk(Double pk) {  // Changed to Double
        this.pk = pk;
    }

    public Double getCrdy() {  // Changed to Double
        return crdy;
    }

    public void setCrdy(Double crdy) {  // Changed to Double
        this.crdy = crdy;
    }

    public Double getCrdr() {  // Changed to Double
        return crdr;
    }

    public void setCrdr(Double crdr) {  // Changed to Double
        this.crdr = crdr;
    }

    public Double getXg() {  // Changed to Double
        return xg;
    }

    public void setXg(Double xg) {  // Changed to Double
        this.xg = xg;
    }

    public Double getXag() {  // Changed to Double
        return xag;
    }

    public void setXag(Double xag) {  // Changed to Double
        this.xag = xag;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", nation='" + nation + '\'' +
                ", pos='" + pos + '\'' +
                ", age=" + age +
                ", mp=" + mp +
                ", starts=" + starts +
                ", min=" + min +
                ", gls=" + gls +
                ", ast=" + ast +
                ", pk=" + pk +
                ", crdy=" + crdy +
                ", crdr=" + crdr +
                ", xg=" + xg +
                ", xag=" + xag +
                ", team='" + team + '\'' +
                '}';
    }
}