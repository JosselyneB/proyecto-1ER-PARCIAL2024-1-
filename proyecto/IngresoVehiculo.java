import java.util.Date;

public class IngresoVehiculo {
    private Vehiculo vehiculo;
    private Date horaIngreso;

    public IngresoVehiculo(Vehiculo vehiculo, Date horaIngreso) {
        this.vehiculo = vehiculo;
        this.horaIngreso = horaIngreso;
    }

    // Getters y setters
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Date getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(Date horaIngreso) {
        this.horaIngreso = horaIngreso;
    }
}
