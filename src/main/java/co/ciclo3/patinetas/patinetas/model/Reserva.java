/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.ciclo3.patinetas.patinetas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;
    
    private Date startDate;
    private Date devolutionDate;
    private String status;
    
    @ManyToOne
    @JoinColumn(name = "idSkates")
    @JsonIgnoreProperties({"client","skates","reservations"})
    private Patineta skate;
    
    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"client","skates","reservations","messages"})
    private Cliente client;
    
    @ManyToOne
    @JoinColumn(name = "id_Score")
    @JsonIgnoreProperties({"scores"})
    private Puntaje score;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Puntaje getScore() {
        return score;
    }

    public void setScore(Puntaje score) {
        this.score = score;
    }
    
    
    public Long getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Long idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public Patineta getSkate() {
        return skate;
    }

    public void setSkate(Patineta skate) {
        this.skate = skate;
    }
    
    
}
