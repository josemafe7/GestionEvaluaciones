
package Interno;

import java.util.*;

public class Controlador {
    private static int gruId = 0;
    private static final int INDIVIDUAL = 0;
    private static final int GRUPAL = 1;
    private Almacen almacen;

    public Controlador(Almacen almacen) {
        this.almacen = almacen;
    }


    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public void introducirDatosAlumno(String dni, String nombre, String apellidos) {
        Alumno a = new Alumno(dni, nombre, apellidos);
        this.almacen.getAlumnos().add(a);
    }

    public void mostrarEvaluacionAlumno(String dni) {
        
        Alumno a = this.almacen.getAlumno(dni);
        System.out.println("Alumno: " + a);
        if( a != null){
        Iterator it = a.getExamenes().iterator();
            while(it.hasNext()){
                Examen e = (Examen) it.next();
                System.out.println(e);
            }
        }
                
    }

    public void introducirNotaAlumno(String nombre, String dni, float nota) {
        
        Alumno a = this.almacen.getAlumno(dni);
        Prueba p = this.almacen.getPrueba(nombre);
        if (a != null && p != null){
            Examen e = new Examen(nota, a, p);
            a.getExamenes().add(e);
        }
  
        
    }
    
    public int crearGrupo() {
        gruId++;
        Grupo g = new Grupo(gruId);
        this.getAlmacen().getGrupos().add(g);
        return gruId;
    }

    public void introducirAlumnoGrupo(int idGrupo, Alumno a) {
        Grupo g = this.getAlmacen().getGrupo(idGrupo);
        g.getAlumnos().add(a);
        System.out.println("Alumno introducido en el grupo " + g.getGrupoId() +" : " + a );
    }

    public void introducirNotasGrupo(int idGrupo, String nombre, float nota) {
        
        
        Grupo g = this.almacen.getGrupo(idGrupo);
        Prueba p = this.almacen.getPrueba(nombre);
        if (g != null && p != null && p.getTipo() == 1){
            Iterator it = g.getAlumnos().iterator();
            while(it.hasNext()){
                Alumno a = (Alumno)it.next();
                Examen e = new Examen(nota, a, p);
                a.getExamenes().add(e);
            }
            
        } else {
            if (g == null){
                System.out.println("Grupo no válido");
            } else if (p == null){
                System.out.println("Prueba no válida");
            } else {
                System.out.println("La prueba no es de tipo grupal");
            }
        }
        
        
        
    }

    public void mostrarEvaluacionGrupo() {
        
        Iterator it = this.almacen.getAlumnos().iterator();
        
        while(it.hasNext()){
            Alumno a = (Alumno) it.next();
            System.out.println("Alumno: " + a);
            Iterator it2 = a.getExamenes().iterator();
                while(it2.hasNext()){
                    Examen e = (Examen) it2.next();
                    System.out.println("\t" + e);
                }
            
        }
        
    }

    public void introducirAñadirPrueba(String nombre, String descripcion, int porcentaje, int tipo) {
        Prueba p = new Prueba(nombre, descripcion, porcentaje, tipo);
        this.almacen.getPruebas().add(p);
    }

    public void mostrarPruebas() {

        Iterator it = this.almacen.getPruebas().iterator();
        
        while(it.hasNext()){
            Prueba p = (Prueba) it.next();
            System.out.println("Prueba: " + p);

            
        }

    }
    
    
}
