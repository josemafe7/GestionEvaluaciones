
package Interno;

import java.util.*;

public class Alumno {
    private String dni;
    private String nombre;
    private String apellidos;
    private int grupoId;
    private List <Examen>examenes;

    public Alumno(String dni, String nombre, String apellidos) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.examenes = new ArrayList<Examen>();
    }

    public Alumno(String dni, String nombre, String apellidos, int grupoId) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.grupoId = grupoId;
        this.examenes = new ArrayList<Examen>();
    }

    
    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(int grupoId) {
        this.grupoId = grupoId;
    }

    public List getExamenes() {
        return examenes;
    }

    public void setExamenes(List examenes) {
        this.examenes = examenes;
    }


    @Override
    public String toString() {
        return "Alumno{" + "dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + '}';
    }
    
    
}
