import java.util.Date;

public class SalidaVehiculo {
    private Vehiculo vehiculo;
    private Date horaSalida;
    private IngresoVehiculo ingreso;
    private TarifaEst tarifa;

    public SalidaVehiculo(Vehiculo vehiculo, Date horaSalida, IngresoVehiculo ingreso, TarifaEst tarifa) {
        this.vehiculo = vehiculo;
        this.horaSalida = horaSalida;
        this.ingreso = ingreso;
        this.tarifa = tarifa;
    }

    // Getters y setters
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public IngresoVehiculo getIngreso() {
        return ingreso;
    }

    public void setIngreso(IngresoVehiculo ingreso) {
        this.ingreso = ingreso;
    }

    public TarifaEst getTarifa() {
        return tarifa;
    }

    public void setTarifa(TarifaEst tarifa) {
        this.tarifa = tarifa;
    }

    // Método para calcular el total a pagar
    public double calcularTotalAPagar() {
        long diferenciaEnMillis = horaSalida.getTime() - ingreso.getHoraIngreso().getTime();
        long horasEstacionadas = (diferenciaEnMillis / (1000 * 60 * 60));
        return tarifa.calcularCosto(horasEstacionadas);
    }
}
