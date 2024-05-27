public class Vehiculo {
    private int id;
    private String marca;
    private String modelo;
    private String color;
    private String placa;
    private int propietarioId;

    // Constructor
    public Vehiculo(int id, String marca, String modelo, String color, String placa, int propietarioId) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.placa = placa;
        this.propietarioId = propietarioId;
    }

    // Getters y setters (puedes generarlos automáticamente en tu IDE)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getPropietarioId() {
        return propietarioId;
    }

    public void setPropietarioId(int propietarioId) {
        this.propietarioId = propietarioId;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", placa='" + placa + '\'' +
                ", propietarioId=" + propietarioId +
                '}';
    }
}
