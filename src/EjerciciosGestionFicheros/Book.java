package EjerciciosGestionFicheros;

import java.io.Serializable;

public class Book implements Serializable {
    String nombre;
    String editorial;
    int fecha;

    public Book(String nombre, String editorial, int fecha) {
        this.nombre = nombre;
        this.editorial = editorial;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getInfo() {
        return "Nombre=" + nombre + ", editorial=" + editorial + ", fecha=" + fecha;
    }

    public int getFecha() {
        return fecha;
    }
}
