import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Crear un cliente
        Cliente cliente = new Cliente("Juan Perez", "0102030405", "0987654321");

        // Crear un vehículo
        Vehiculo vehiculo = new Vehiculo("ABC-1234", "Toyota", "Corolla", cliente);

        // Registrar el ingreso del vehículo
        IngresoVehiculo ingreso = new IngresoVehiculo(vehiculo, new Date());

        // Crear la tarifa de estacionamiento
        TarifaEst tarifa = new TarifaEst(1.50); // $1.50 por hora

        // Simular un tiempo de estacionamiento
        try {
            Thread.sleep(5000); // Esperar 5 segundos (simula el tiempo de estacionamiento)
        } catch (InterruptedException e) {
            System.err.println("Error al esperar: " + e.getMessage());
            Thread.currentThread().interrupt(); // Restoring interrupted state
        }

        // Registrar la salida del vehículo
        SalidaVehiculo salida = new SalidaVehiculo(vehiculo, new Date(), ingreso, tarifa);
        double totalAPagar = salida.calcularTotalAPagar();

        // Crear el pago
        Pago pago = new Pago(totalAPagar, "Efectivo");

        // Registrar el pago
        RegistroPago registroPago = new RegistroPago(vehiculo, pago, new Date());

        // Mostrar la información del pago
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Vehículo: " + vehiculo.getPlaca());
        System.out.println("Monto a pagar: $" + String.format("%.2f", pago.getMonto())); // Formatear el monto a dos decimales
        System.out.println("Método de pago: " + pago.getMetodoPago());
        System.out.println("Fecha de pago: " + registroPago.getFechaPago()); // Mostrar la fecha en formato legible
    }
}
