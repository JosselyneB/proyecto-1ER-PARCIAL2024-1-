public class TarifaEst {
    private double tarifaPorHora;

    public TarifaEst(double tarifaPorHora) {
        this.tarifaPorHora = tarifaPorHora;
    }

    // Getter y setter para la tarifa por hora

    public double getTarifaPorHora() {
        return tarifaPorHora;
    }

    public void setTarifaPorHora(double tarifaPorHora) {
        this.tarifaPorHora = tarifaPorHora;
    }

    // Método para calcular el costo total según el tiempo estacionado, teniendo en cuenta las fracciones de hora
    public double calcularCosto(long millisEstacionados) {
        double horasEstacionadas = millisEstacionados / (1000.0 * 60.0 * 60.0); // Convertir milisegundos a horas
        return Math.ceil(horasEstacionadas) * tarifaPorHora; // Redondear hacia arriba para contar las fracciones de hora
    }
}
