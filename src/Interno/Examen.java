
package Interno;

public class Examen {
    private float nota;
    private Alumno alumno;
    private Prueba prueba;

    public Examen(float nota, Alumno alumno, Prueba prueba) {
        this.nota = nota;
        this.alumno = alumno;
        this.prueba = prueba;
    }

    
    
    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Prueba getPrueba() {
        return prueba;
    }

    public void setPrueba(Prueba prueba) {
        this.prueba = prueba;
    }

    @Override
    public String toString() {
        return "Examen{" + "nota=" + nota + ", prueba=" + prueba + '}';
    }

    
}
