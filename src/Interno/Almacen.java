
package Interno;

import java.util.*;

public class Almacen {
    private List<Alumno> alumnos;
    private List<Grupo> grupos;
    private List<Prueba> pruebas;


    public Almacen() {
        alumnos = new ArrayList<Alumno>();
        grupos = new ArrayList<Grupo>();
        pruebas = new ArrayList<Prueba>();
        inicializar();        
    }

    
    
    public List getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List alumnos) {
        this.alumnos = alumnos;
    }

    public List getGrupos() {
        return grupos;
    }

    public void setGrupos(List grupos) {
        this.grupos = grupos;
    }

    public List getPruebas() {
        return pruebas;
    }

    public void setPruebas(List pruebas) {
        this.pruebas = pruebas;
    }

    
    public Alumno getAlumno(String dni){
        Iterator it = this.getAlumnos().iterator();
        boolean enc = false;
        Alumno a = null;
        while(it.hasNext() && !enc){
            a = (Alumno) it.next();
            if(a.getDni().equals(dni)){
                enc = true;
            }
        }
        if (enc == true)
            return a;
        else
            return null;
    }
    
    public Prueba getPrueba(String nombre){
        Iterator it = this.getPruebas().iterator();
        boolean enc = false;
        Prueba p = null;
        while(it.hasNext() && !enc){
            p = (Prueba) it.next();
            if(p.getNombre().equals(nombre)){
                enc = true;
            }
        }
        if (enc == true)
            return p;
        else
            return null;
    }
    
    public Grupo getGrupo(int idGrupo){
        Iterator it = this.getGrupos().iterator();
        boolean enc = false;
        Grupo g = null;
        while(it.hasNext() && !enc){
            g = (Grupo) it.next();
            if(g.getGrupoId() == idGrupo){
                enc = true;
            }
        }
        if (enc == true)
            return g;
        else
            return null;
    }

    private void inicializar() {
       
       Alumno a1 = new Alumno("1", "nombre1", "Apellido1");
       Alumno a2 = new Alumno("2", "nombre2", "Apellido2");
       Alumno a3 = new Alumno("3", "nombre3", "Apellido3");
       Alumno a4 = new Alumno("4", "nombre4", "Apellido4");
       Alumno a5 = new Alumno("5", "nombre5", "Apellido5");
       
       alumnos.add(a1);
       alumnos.add(a2);
       alumnos.add(a3);
       alumnos.add(a4);
       alumnos.add(a5);
       
       Prueba p1 = new Prueba("prueba1", "Descripcion1", 10, 0);
       Prueba p2 = new Prueba("prueba2", "Descripcion2", 20, 1);
       pruebas.add(p1);
       pruebas.add(p2);

       Examen ex = new Examen((float)9.0,a1,p1);
       a1.getExamenes().add(ex);
       p1.getExamenes().add(ex);
    }
}
