
package Interno;

import java.util.*;

public class Prueba {
    private String nombre;
    private String descripcion;
    private int porcentaje;
    private int tipo;
    private List<Examen> examenes;

    public Prueba(String nombre, String descripcion, int porcentaje, int tipo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.porcentaje = porcentaje;
        this.tipo = tipo;
        this.examenes = new ArrayList<Examen>();
    }

    public Prueba(String nombre, String descripcion, int porcentaje, int tipo, List examenes) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.porcentaje = porcentaje;
        this.tipo = tipo;
        this.examenes = examenes;
    }

    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public List getExamenes() {
        return examenes;
    }

    public void setExamenes(List<Examen> examenes) {
        this.examenes = examenes;
    }

    @Override
    public String toString() {
        return "Prueba{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", porcentaje=" + porcentaje + ", tipo=" + tipo + '}';
    }

    
    
    
}
