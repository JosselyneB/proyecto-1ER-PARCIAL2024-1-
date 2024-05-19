public class Cliente {
    private String nombre;
    private int cedula;
    private int telefono;

    public Cliente(String nombre, String cedula, String telefono) {
        this.nombre = nombre;
        this.cedula = Integer.parseInt(cedula);
        this.telefono = Integer.parseInt(telefono);
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = Integer.parseInt(cedula);
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = Integer.parseInt(telefono);
    }
}
