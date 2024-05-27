package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "registro_pagos", schema = "public")
public class RegistroPago {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pagos_id")
    private Clientes pagos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Clientes getPagos() {
        return pagos;
    }

    public void setPagos(Clientes pagos) {
        this.pagos = pagos;
    }

    //TODO [Reverse Engineering] generate columns from DB
}