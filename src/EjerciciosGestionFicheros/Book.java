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
}
