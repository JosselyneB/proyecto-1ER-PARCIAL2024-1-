import java.math.BigDecimal;
import java.sql.*;

public class CRUD {
    private static final String URL = "jdbc:postgresql://localhost:5432/bd_ProyectoWeb";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";

    // Método para insertar un nuevo cliente
    public static void insertCliente(String nombre, String apellido, String telefono, String direccion, String email) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO clientes (nombre, apellido, telefono, direccion, email) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, nombre);
                statement.setString(2, apellido);
                statement.setString(3, telefono);
                statement.setString(4, direccion);
                statement.setString(5, email);
                statement.executeUpdate();
                System.out.println("Cliente insertado exitosamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para leer todos los clientes
    public static void readClientes() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM clientes";
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nombre = resultSet.getString("nombre");
                    String apellido = resultSet.getString("apellido");
                    String telefono = resultSet.getString("telefono");
                    String direccion = resultSet.getString("direccion");
                    String email = resultSet.getString("email");
                    System.out.println("ID: " + id + ", Nombre: " + nombre + ", Apellido: " + apellido + ", Teléfono: " + telefono + ", Dirección: " + direccion + ", Email: " + email);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para actualizar un cliente
    public static void updateCliente(int id, String nombre, String apellido, String telefono, String direccion, String email) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "UPDATE clientes SET nombre = ?, apellido = ?, telefono = ?, direccion = ?, email = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, nombre);
                statement.setString(2, apellido);
                statement.setString(3, telefono);
                statement.setString(4, direccion);
                statement.setString(5, email);
                statement.setInt(6, id);
                int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Cliente actualizado exitosamente.");
                } else {
                    System.out.println("No se encontró ningún cliente con el ID proporcionado.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un cliente
    public static void deleteCliente(int id) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "DELETE FROM clientes WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                int rowsDeleted = statement.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Cliente eliminado exitosamente.");
                } else {
                    System.out.println("No se encontró ningún cliente con el ID proporcionado.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para insertar un nuevo carro
    public static void insertCarro(String marca, String modelo, String color, String placa, int propietario_id) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO carros (marca, modelo, color, placa, propietario_id) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, marca);
                statement.setString(2, modelo);
                statement.setString(3, color);
                statement.setString(4, placa);
                statement.setInt(5, propietario_id);
                statement.executeUpdate();
                System.out.println("Carro insertado exitosamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para leer todos los carros
    public static void readCarros() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM carros";
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String marca = resultSet.getString("marca");
                    String modelo = resultSet.getString("modelo");
                    String color = resultSet.getString("color");
                    String placa = resultSet.getString("placa");
                    int propietario_id = resultSet.getInt("propietario_id");
                    System.out.println("ID: " + id + ", Marca: " + marca + ", Modelo: " + modelo + ", Color: " + color + ", Placa: " + placa + ", Propietario ID: " + propietario_id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para actualizar un carro
    public static void updateCarro(int id, String marca, String modelo, String color, String placa, int propietario_id) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "UPDATE carros SET marca = ?, modelo = ?, color = ?, placa = ?, propietario_id = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, marca);
                statement.setString(2, modelo);
                statement.setString(3, color);
                statement.setString(4, placa);
                statement.setInt(5, propietario_id);
                statement.setInt(6, id);
                int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Carro actualizado exitosamente.");
                } else {
                    System.out.println("No se encontró ningún carro con el ID proporcionado.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un carro
    public static void deleteCarro(int id) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "DELETE FROM carros WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                int rowsDeleted = statement.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Carro eliminado exitosamente.");
                } else {
                    System.out.println("No se encontró ningún carro con el ID proporcionado.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Método para insertar un nuevo ingreso
    public static void insertIngreso(Timestamp fecha_entrada, int vehiculo_id) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO ingresos (fecha_entrada, vehiculo_id) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setTimestamp(1, fecha_entrada);
                statement.setInt(2, vehiculo_id);
                statement.executeUpdate();
                System.out.println("Ingreso registrado exitosamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para leer todos los ingresos
    public static void readIngresos() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM ingresos";
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    Timestamp fecha_entrada = resultSet.getTimestamp("fecha_entrada");
                    int vehiculo_id = resultSet.getInt("vehiculo_id");
                    System.out.println("ID: " + id + ", Fecha de entrada: " + fecha_entrada + ", ID del vehículo: " + vehiculo_id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para actualizar un ingreso
    public static void updateIngreso(int id, Timestamp fecha_entrada, int vehiculo_id) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "UPDATE ingresos SET fecha_entrada = ?, vehiculo_id = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setTimestamp(1, fecha_entrada);
                statement.setInt(2, vehiculo_id);
                statement.setInt(3, id);
                int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Ingreso actualizado exitosamente.");
                } else {
                    System.out.println("No se encontró ningún ingreso con el ID proporcionado.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un ingreso
    public static void deleteIngreso(int id) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "DELETE FROM ingresos WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                int rowsDeleted = statement.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Ingreso eliminado exitosamente.");
                } else {
                    System.out.println("No se encontró ningún ingreso con el ID proporcionado.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Método para insertar una nueva salida
    public static void insertSalida(Timestamp fecha_salida, int ingreso_id) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO salidas (fecha_salida, ingreso_id) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setTimestamp(1, fecha_salida);
                statement.setInt(2, ingreso_id);
                statement.executeUpdate();
                System.out.println("Salida registrada exitosamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para leer todas las salidas
    public static void readSalidas() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM salidas";
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    Timestamp fecha_salida = resultSet.getTimestamp("fecha_salida");
                    int ingreso_id = resultSet.getInt("ingreso_id");
                    System.out.println("ID: " + id + ", Fecha de salida: " + fecha_salida + ", ID del ingreso: " + ingreso_id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para actualizar una salida
    public static void updateSalida(int id, Timestamp fecha_salida, int ingreso_id) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "UPDATE salidas SET fecha_salida = ?, ingreso_id = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setTimestamp(1, fecha_salida);
                statement.setInt(2, ingreso_id);
                statement.setInt(3, id);
                int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Salida actualizada exitosamente.");
                } else {
                    System.out.println("No se encontró ninguna salida con el ID proporcionado.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar una salida
    public static void deleteSalida(int id) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "DELETE FROM salidas WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                int rowsDeleted = statement.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Salida eliminada exitosamente.");
                } else {
                    System.out.println("No se encontró ninguna salida con el ID proporcionado.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Método para insertar un nuevo pago
    public static void insertPago(BigDecimal monto, String metodo_pago, Date fecha_pago, int ingreso_id) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO pagos (monto, metodo_pago, fecha_pago, ingreso_id) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setBigDecimal(1, monto);
                statement.setString(2, metodo_pago);
                statement.setDate(3, fecha_pago);
                statement.setInt(4, ingreso_id);
                statement.executeUpdate();
                System.out.println("Pago registrado exitosamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para leer todos los pagos
    public static void readPagos() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM pagos";
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    BigDecimal monto = resultSet.getBigDecimal("monto");
                    String metodo_pago = resultSet.getString("metodo_pago");
                    Date fecha_pago = resultSet.getDate("fecha_pago");
                    int ingreso_id = resultSet.getInt("ingreso_id");
                    System.out.println("ID: " + id + ", Monto: " + monto + ", Método de pago: " + metodo_pago + ", Fecha de pago: " + fecha_pago + ", ID del ingreso: " + ingreso_id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para actualizar un pago
    public static void updatePago(int id, BigDecimal monto, String metodo_pago, Date fecha_pago, int ingreso_id) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "UPDATE pagos SET monto = ?, metodo_pago = ?, fecha_pago = ?, ingreso_id = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setBigDecimal(1, monto);
                statement.setString(2, metodo_pago);
                statement.setDate(3, fecha_pago);
                statement.setInt(4, ingreso_id);
                statement.setInt(5, id);
                int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Pago actualizado exitosamente.");
                } else {
                    System.out.println("No se encontró ningún pago con el ID proporcionado.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un pago
    public static void deletePago(int id) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "DELETE FROM pagos WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                int rowsDeleted = statement.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Pago eliminado exitosamente.");
                } else {
                    System.out.println("No se encontró ningún pago con el ID proporcionado.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para insertar un nuevo registro de pago
    public static void insertRegistroPago(int pagos_id, Timestamp fecha_pago) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO registro_pagos (pagos_id, fecha_pago) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, pagos_id);
                statement.setTimestamp(2, fecha_pago);
                statement.executeUpdate();
                System.out.println("Registro de pago insertado exitosamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para leer todos los registros de pagos
    public static void readRegistroPagos() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM registro_pagos";
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    int pagos_id = resultSet.getInt("pagos_id");
                    Timestamp fecha_pago = resultSet.getTimestamp("fecha_pago");
                    System.out.println("ID: " + id + ", ID del pago: " + pagos_id + ", Fecha de pago: " + fecha_pago);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para actualizar un registro de pago
    public static void updateRegistroPago(int id, int pagos_id, Timestamp fecha_pago) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "UPDATE registro_pagos SET pagos_id = ?, fecha_pago = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, pagos_id);
                statement.setTimestamp(2, fecha_pago);
                statement.setInt(3, id);
                int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Registro de pago actualizado exitosamente.");
                } else {
                    System.out.println("No se encontró ningún registro de pago con el ID proporcionado.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un registro de pago
    public static void deleteRegistroPago(int id) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "DELETE FROM registro_pagos WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                int rowsDeleted = statement.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Registro de pago eliminado exitosamente.");
                } else {
                    System.out.println("No se encontró ningún registro de pago con el ID proporcionado.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Método para insertar un nuevo registro de parqueadero
    public static void insertParqueadero(int capacidad, int espacios_disponibles) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO parqueadero (capacidad, espacios_disponibles) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, capacidad);
                statement.setInt(2, espacios_disponibles);
                statement.executeUpdate();
                System.out.println("Registro de parqueadero insertado exitosamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para leer todos los registros de parqueadero
    public static void readParqueadero() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM parqueadero";
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    int capacidad = resultSet.getInt("capacidad");
                    int espacios_disponibles = resultSet.getInt("espacios_disponibles");
                    System.out.println("ID: " + id + ", Capacidad: " + capacidad + ", Espacios disponibles: " + espacios_disponibles);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para actualizar un registro de parqueadero
    public static void updateParqueadero(int id, int capacidad, int espacios_disponibles) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "UPDATE parqueadero SET capacidad = ?, espacios_disponibles = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, capacidad);
                statement.setInt(2, espacios_disponibles);
                statement.setInt(3, id);
                int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Registro de parqueadero actualizado exitosamente.");
                } else {
                    System.out.println("No se encontró ningún registro de parqueadero con el ID proporcionado.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un registro de parqueadero
    public static void deleteParqueadero(int id) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "DELETE FROM parqueadero WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                int rowsDeleted = statement.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Registro de parqueadero eliminado exitosamente.");
                } else {
                    System.out.println("No se encontró ningún registro de parqueadero con el ID proporcionado.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
