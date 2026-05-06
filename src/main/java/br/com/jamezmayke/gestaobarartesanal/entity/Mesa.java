package br.com.jamezmayke.gestaobarartesanal.entity;

import java.util.UUID;

import br.com.jamezmayke.gestaobarartesanal.enums.StatusMesa;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mesas")
public class Mesa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private int numero;

    @Enumerated(EnumType.STRING)
    private StatusMesa status;

    public Mesa() {}

    public Mesa(int numero) {
        this.numero = numero;
        this.status = StatusMesa.LIVRE;
    }

    public UUID getId() {
        return id;
    }

    public int getNumero() {
        return numero;
    }

    public StatusMesa getStatus() {
        return status;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setStatus(StatusMesa status) {
        this.status = status;
    }
    
}
