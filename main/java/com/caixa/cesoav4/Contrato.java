package com.caixa.cesoav4;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cliente;
    private double valor;
    private LocalDate dataContrato;


    public Contrato() {
    }

    public Contrato(String cliente, double valor, LocalDate dataContrato) {
        this.cliente = cliente;
        this.valor = valor;
        this.dataContrato = dataContrato;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getDataContrato() {
        return dataContrato;
    }

    public void setDataContrato(LocalDate dataContrato) {
        this.dataContrato = dataContrato;
    }


    @Override
    public String toString() {
        return "Contrato{" +
                "id=" + id +
                ", cliente='" + cliente + '\'' +
                ", valor=" + valor +
                ", dataContrato=" + dataContrato +
                '}';
    }
}