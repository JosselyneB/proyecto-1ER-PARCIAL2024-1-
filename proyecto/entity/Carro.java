package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "carros", schema = "public")
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "propietario_id")
    private Clientes propietario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Clientes getPropietario() {
        return propietario;
    }

    public void setPropietario(Clientes propietario) {
        this.propietario = propietario;
    }

    //TODO [Reverse Engineering] generate columns from DB
}