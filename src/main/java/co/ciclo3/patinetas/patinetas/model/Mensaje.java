/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.ciclo3.patinetas.patinetas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "mensaje")
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long idMessage;
    private String messageText;
    
    @ManyToOne
    @JoinColumn(name = "skate_id")
    @JsonIgnoreProperties({"messages","reservations"})
    private Patineta skate;
    
    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnoreProperties({"messages","reservations"})
    private Cliente client;
    
    

    public Long getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Long idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
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

    public void setSkate(Patineta stkate) {
        this.skate = stkate;
    }
    
    
}
