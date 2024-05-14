import java.util.ArrayList;
import java.util.List;

public class Parqueadero {
    private int capacidad;
    private int espaciosDisponibles;
    private List<Vehiculo> vehiculos;

    // Constructor
    public Parqueadero(int capacidad) {
        this.capacidad = capacidad;
        this.espaciosDisponibles = capacidad;
        this.vehiculos = new ArrayList<>();
    }

    // Método para registrar el ingreso de un vehículo
    public void registrarIngreso(Vehiculo vehiculo) {
        if (espaciosDisponibles > 0) {
            vehiculos.add(vehiculo);
            espaciosDisponibles--;
            System.out.println("Vehículo ingresado correctamente.");
        } else {
            System.out.println("Parqueadero lleno. No se puede ingresar el vehículo.");
        }
    }

    // Método para registrar la salida de un vehículo
    public void registrarSalida(String placa) {
        boolean encontrado = false;
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equals(placa)) {
                vehiculos.remove(vehiculo);
                espaciosDisponibles++;
                System.out.println("Vehículo salió correctamente.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("El vehículo con la placa " + placa + " no se encuentra en el parqueadero.");
        }
    }

    // Método para consultar los espacios disponibles
    public void consultarEspaciosDisponibles() {
        System.out.println("Espacios disponibles: " + espaciosDisponibles);
    }
}
