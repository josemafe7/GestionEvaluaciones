
package Interno;

import java.util.*;

public class Grupo {
    
    private int grupoId;
    private List<Alumno> alumnos;

    public Grupo(int grupoId) {
        this.grupoId = grupoId;
        this.alumnos = new ArrayList();
    }

    public Grupo(int grupoId, List<Alumno> alumnos) {
        this.grupoId = grupoId;
        this.alumnos = alumnos;
    }

    public Grupo(int grupoId, List<Alumno> alumnos, List<Examen> examenes) {
        this.grupoId = grupoId;
        this.alumnos = alumnos;
    }
    
    public int getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(int grupoId) {
        this.grupoId = grupoId;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    
    
    
}
