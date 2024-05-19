public class Pago {
    private double monto;
    private String metodoPago; // Ejemplo: "Efectivo", "Tarjeta"

    public Pago(double monto, String metodoPago) {
        this.monto = monto;
        this.metodoPago = metodoPago;
    }

    // Getters y setters
    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }
}
