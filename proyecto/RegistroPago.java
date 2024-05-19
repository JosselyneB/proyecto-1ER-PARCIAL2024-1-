import java.util.Date;

public class RegistroPago {
    private Vehiculo vehiculo;
    private Pago pago;
    private Date fechaPago;

    public RegistroPago(Vehiculo vehiculo, Pago pago, Date fechaPago) {
        this.vehiculo = vehiculo;
        this.pago = pago;
        this.fechaPago = fechaPago;
    }

    // Getters y setters
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }
}
