package br.com.jamezmayke.gestaobarartesanal.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.com.jamezmayke.gestaobarartesanal.enums.StatusPedido;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @JoinColumn(name = "mesa_id")
    private Mesa mesa;
    
    private LocalDateTime dataHora;

    @Enumerated(EnumType.STRING)
    private StatusPedido statusPedido;

    private List<ItemPedido> itens = new ArrayList<>();

    private BigDecimal valorTotal;


    public Pedido() {}

    public Pedido(Cliente cliente, Mesa mesa) {
        this.cliente = cliente;
        this.mesa = mesa;
        this.dataHora = LocalDateTime.now();
        this.statusPedido = StatusPedido.ABERTO;
        this.valorTotal = BigDecimal.ZERO;
    }

    public UUID getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
    
}
