/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.ciclo3.patinetas.patinetas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "puntaje")
public class Puntaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPuntaje;
    
    private Byte score;
    private String messageScore;
    private Double costo;
    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "score")
    @JsonIgnoreProperties({"score"})
    public List<Reserva> reservation;

    public Long getIdPuntaje() {
        return idPuntaje;
    }

    public void setIdPuntaje(Long idPuntaje) {
        this.idPuntaje = idPuntaje;
    }

    public Byte getScore() {
        return score;
    }

    public void setScore(Byte score) {
        this.score = score;
    }

    public String getMessageScore() {
        return messageScore;
    }

    public void setMessageScore(String messageScore) {
        this.messageScore = messageScore;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }
    
    
}
