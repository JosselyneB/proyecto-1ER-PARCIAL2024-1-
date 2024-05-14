import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parqueadero parqueadero = new Parqueadero(50); // Capacidad del parqueadero

        // Menú de opciones
        while (true) {
            System.out.println("\n1. Registrar ingreso de vehículo");
            System.out.println("2. Registrar salida de vehículo");
            System.out.println("3. Consultar espacios disponibles");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la placa del vehículo: ");
                    String placa = scanner.next();
                    System.out.print("Ingrese la marca del vehículo: ");
                    String marca = scanner.next();
                    System.out.print("Ingrese el modelo del vehículo: ");
                    String modelo = scanner.next();
                    System.out.print("Ingrese el color del vehículo: ");
                    String color = scanner.next();
                    System.out.print("Ingrese el tipo del vehículo (automóvil/motocicleta): ");
                    String tipo = scanner.next();

                    Vehiculo vehiculo = new Vehiculo(placa, marca, modelo, color, tipo);
                    parqueadero.registrarIngreso(vehiculo);
                    break;
                case 2:
                    System.out.print("Ingrese la placa del vehículo que sale: ");
                    String placaSalida = scanner.next();
                    parqueadero.registrarSalida(placaSalida);
                    break;
                case 3:
                    parqueadero.consultarEspaciosDisponibles();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}
