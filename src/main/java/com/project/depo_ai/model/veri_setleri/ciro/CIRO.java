package com.project.depo_ai.model.veri_setleri.ciro;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ciro")
@Getter
@Setter
public class CIRO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int _ciroid;
    @Column(name = "year")
    private int _year;
    @Column(name = "jan")
    private int _jan;
    @Column(name = "feb")
    private int _feb;
    @Column(name = "mar")
    private int _mar;
    @Column(name = "apr")
    private int _apr;
    @Column(name = "may")
    private int _may;
    @Column(name = "jun")
    private int _jun;
    @Column(name = "jul")
    private int _jul;
    @Column(name = "aug")
    private int _aug;
    @Column(name = "sep")
    private int _sep;
    @Column(name = "oct")
    private int _oct;
    @Column(name = "nov")
    private int _nov;
    @Column(name = "`dec`")
    private Integer dec;

}
