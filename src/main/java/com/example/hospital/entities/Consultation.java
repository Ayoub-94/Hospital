package com.example.hospital.entities;

import javax.persistence.*;
import java.sql.DatabaseMetaData;
import java.util.Date;
@Entity
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date dateConsultation;
    private String rapport;
    @OneToOne
    private RendezVous rendezVous;


    public Consultation() {
    }

    public Consultation(Long id, Date dateConsultation, String rapport, RendezVous rendezVous) {
        this.id = id;
        this.dateConsultation = dateConsultation;
        this.rapport = rapport;
        this.rendezVous = rendezVous;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateConsultation() {
        return dateConsultation;
    }

    public void setDateConsultation(Date dateConsultation) {
        this.dateConsultation = dateConsultation;
    }

    public String getRapport() {
        return rapport;
    }

    public void setRapport(String rapport) {
        this.rapport = rapport;
    }

    public RendezVous getRendezVous() {
        return rendezVous;
    }

    public void setRendezVous(RendezVous rendezVous) {
        this.rendezVous = rendezVous;
    }
}
