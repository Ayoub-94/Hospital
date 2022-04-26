package com.example.hospital.entities;

import javax.persistence.*;
import java.util.Date;
@Entity
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date date;
    @Enumerated(EnumType.STRING)
    private StatusRDV status;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Medecin medecin;
    @OneToOne(mappedBy = "rendezVous",fetch = FetchType.LAZY)
    private Consultation consultation;

    public RendezVous() {
    }

    public RendezVous(Long id, Date date, StatusRDV status, Patient patient, Medecin medecin) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.patient = patient;
        this.medecin = medecin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public StatusRDV getStatus() {
        return status;
    }

    public void setStatus(StatusRDV status) {
        this.status = status;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }
}
