package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "salidas", schema = "public")
public class Salida {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingreso_id")
    private Clientes ingreso;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Clientes getIngreso() {
        return ingreso;
    }

    public void setIngreso(Clientes ingreso) {
        this.ingreso = ingreso;
    }

    //TODO [Reverse Engineering] generate columns from DB
}