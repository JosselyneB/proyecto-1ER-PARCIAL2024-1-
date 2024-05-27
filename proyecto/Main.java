import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/bd_ProyectoWeb";
        String usuario = "postgres";
        String contraseña = "1234";

        // Llama a los métodos para insertar un nuevo cliente, leer todos los clientes y actualizar un cliente
        insertCliente("Juan", "Pérez", "123456789", "Calle Principal 123", "juan@example.com");
        CRUD.readClientes();
        CRUD.updateCliente(1, "Juan", "Pérez", "987654321", "Calle Secundaria 456", "juan_nuevo@example.com");

        // Llama a los métodos para insertar un nuevo carro, leer todos los carros y eliminar un carro
        CRUD.insertCarro("Toyota", "Corolla", "Azul", "DPC-467", 1);
        CRUD.readCarros();
        CRUD.deleteCarro(1);

        // Llama a los métodos para insertar un nuevo ingreso, leer todos los ingresos y actualizar un ingreso
        CRUD.insertIngreso(new Timestamp(System.currentTimeMillis()), 1);
        CRUD.readIngresos();
        CRUD.updateIngreso(1, new Timestamp(System.currentTimeMillis()), 2);

        // Llama a los métodos para insertar una nueva salida, leer todas las salidas y eliminar una salida
        CRUD.insertSalida(new Timestamp(System.currentTimeMillis()), 1);
        CRUD.readSalidas();
        CRUD.deleteSalida(1);

        // Llama a los métodos para insertar un nuevo pago, leer todos los pagos y actualizar un pago
        CRUD.insertPago(new BigDecimal("150.00"), "Efectivo", (java.sql.Date) new Date(System.currentTimeMillis()), 1);
        CRUD.readPagos();
        CRUD.updatePago(1, new BigDecimal("200.00"), "Tarjeta", (java.sql.Date) new Date(System.currentTimeMillis()), 2);

        // Llama a los métodos para insertar un nuevo registro de pago, leer todos los registros de pagos y eliminar un registro de pago
        CRUD.insertRegistroPago(1, new Timestamp(System.currentTimeMillis()));
        CRUD.readRegistroPagos();
        CRUD.deleteRegistroPago(1);

        // Llama a los métodos para insertar un nuevo registro de parqueadero, leer todos los registros de parqueadero y actualizar un registro de parqueadero
        insertParqueadero(100, 50);
        CRUD.readParqueadero();
        CRUD.updateParqueadero(1, 150, 75);
    }

    private static void insertParqueadero(int i, int i1) {
    }

    private static void insertCliente(String juan, String pérez, String number, String s, String mail) {
    }
}
