package entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "propietario")
    private Set<Carro> carros = new LinkedHashSet<>();

    @Column(name = "fecha_entrada")
    private Instant fechaEntrada;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehiculo_id")
    private Carro vehiculo;

    @OneToMany(mappedBy = "ingreso")
    private Set<Pago> pagos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "ingreso")
    private Set<Salida> salidas = new LinkedHashSet<>();

    @Column(name = "monto", precision = 10, scale = 2)
    private BigDecimal monto;

    @Column(name = "metodo_pago", length = 100)
    private String metodoPago;

    @Column(name = "fecha_pago")
    private LocalDate fechaPago;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingreso_id")
    private Ingreso ingreso;

    @OneToMany(mappedBy = "pagos")
    private Set<RegistroPago> registroPagos = new LinkedHashSet<>();

    @Column(name = "capacidad")
    private Integer capacidad;

    @Column(name = "espacios_disponibles")
    private Integer espaciosDisponibles;

    public Clientes(int id, String nombre, String apellido, String telefono, String direccion, String email) {
    }

    public Integer getEspaciosDisponibles() {
        return espaciosDisponibles;
    }

    public void setEspaciosDisponibles(Integer espaciosDisponibles) {
        this.espaciosDisponibles = espaciosDisponibles;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Set<RegistroPago> getRegistroPagos() {
        return registroPagos;
    }

    public void setRegistroPagos(Set<RegistroPago> registroPagos) {
        this.registroPagos = registroPagos;
    }

    public Ingreso getIngreso() {
        return ingreso;
    }

    public void setIngreso(Ingreso ingreso) {
        this.ingreso = ingreso;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Set<Salida> getSalidas() {
        return salidas;
    }

    public void setSalidas(Set<Salida> salidas) {
        this.salidas = salidas;
    }

    public Set<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(Set<Pago> pagos) {
        this.pagos = pagos;
    }

    public Carro getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Carro vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Instant getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Instant fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Set<Carro> getCarros() {
        return carros;
    }

    public void setCarros(Set<Carro> carros) {
        this.carros = carros;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
