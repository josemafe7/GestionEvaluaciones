
package Interno;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ControladorTest {
    
    public ControladorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getGruId method, of class Controlador.
     */

    /**
     * Test of getAlmacen method, of class Controlador.
     */
    @Test
    public void testGetAlmacen() {
        System.out.println("getAlmacen");
        Almacen a = new Almacen();
        Controlador c = new Controlador(a);
        Almacen expResult = a;
        Almacen result = c.getAlmacen();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAlmacen method, of class Controlador.
     */
    @Test
    public void testSetAlmacen() {
        System.out.println("setAlmacen");
        Almacen a = new Almacen();
        Almacen b = new Almacen();
        Controlador c = new Controlador(a);
        Almacen expResult = b;
        c.setAlmacen(b);
        Almacen result = c.getAlmacen();
        assertEquals(expResult, result);
    }

    /**
     * Test of introducirDatosAlumno method, of class Controlador.
     */
    @Test
    public void testIntroducirDatosAlumno() {
        System.out.println("introducirDatosAlumno");
        String dni = "1";
        String nombre = "Nombre1";
        String apellidos = "Apellidos1";
        Almacen a = new Almacen();
        Controlador c = new Controlador(a);
        c.introducirDatosAlumno(dni, nombre, apellidos);
        String result = c.getAlmacen().getAlumno(dni).getDni();
        String expResult = "1";
        assertEquals(expResult, result);
    }

    /**
     * Test of mostrarEvaluacionAlumno method, of class Controlador.
     */
    @Test
    public void testMostrarEvaluacionAlumno() { //no entra
        System.out.println("mostrarEvaluacionAlumno");
        String dni = "1";
        Almacen a = new Almacen();
        Controlador c = new Controlador(a);
        Alumno alu = new Alumno("1", "Nombre1", "Apellido1");
        a.getAlumnos().add(alu);
        Prueba p = new Prueba("Prueba1", "Descripcion1", 20, 0);
        a.getPruebas().add(p);
        Examen e = new Examen(7, alu, p);
        alu.getExamenes().add(e);
        p.getExamenes().add(e);
        c.mostrarEvaluacionAlumno(dni);
        Prueba result = (Prueba) a.getPruebas().get(a.getPruebas().indexOf(p));
        Examen result2 = (Examen) result.getExamenes().get(result.getExamenes().indexOf(e));
        assertEquals(dni, result2.getAlumno().getDni());
    }

    /**
     * Test of introducirNotaAlumno method, of class Controlador.
     */
    @Test
    public void testIntroducirNotaAlumno() {
        System.out.println("introducirNotaAlumno");
        String nombre = "Nombre1";
        String dni = "1";
        float nota = 7.0F;
        Almacen a = new Almacen();
        Controlador c = new Controlador(a);
        Alumno alu = new Alumno("1", "Nombre1", "Apellido1");
        a.getAlumnos().add(alu);
        Prueba p = new Prueba("Prueba1", "Descripcion1", 20, 0);
        a.getPruebas().add(p);
        Examen e = new Examen(7.0F, alu, p);
        alu.getExamenes().add(e);
        p.getExamenes().add(e);
        c.introducirNotaAlumno(nombre, dni, nota);
        Examen ex = (Examen) alu.getExamenes().get(alu.getExamenes().indexOf(e));
        String result = ex.getAlumno().getDni();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(dni, result);
        
    }

    /**
     * Test of crearGrupo method, of class Controlador.
     */
    @Test
    public void testCrearGrupo() {
        System.out.println("crearGrupo");
        Almacen a = new Almacen();
        Controlador c = new Controlador(a);
        int result = c.crearGrupo();
        Grupo g = (Grupo) a.getGrupos().get(a.getGrupos().size()-1);
        int expResult = g.getGrupoId();
        assertEquals(expResult, result);
    }

    /**
     * Test of introducirAlumnoGrupo method, of class Controlador.
     */
    @Test
    public void testIntroducirAlumnoGrupo() {
        System.out.println("introducirAlumnoGrupo");
        int idGrupo = 0;
        Almacen a = new Almacen();
        Controlador c = new Controlador(a);
        Alumno alu = new Alumno("DNI1", "Nombre1", "Apellido1");
        a.getAlumnos().add(alu);
        Grupo g = new Grupo(idGrupo);
        a.getGrupos().add(g);
        c.introducirAlumnoGrupo(idGrupo, alu);
        int result = a.getAlumno("DNI1").getGrupoId();
        assertEquals(idGrupo, result);
    }

    /**
     * Test of introducirNotasGrupo method, of class Controlador.
     */
    @Test
    public void testIntroducirNotasGrupo() {
        System.out.println("introducirNotasGrupo");
        int idGrupo = 0;
        String nombre = "Prueba1";
        float nota = 7.0F;
        Almacen a = new Almacen();
        Controlador c = new Controlador(a);
        Alumno alu = new Alumno("DNI1", "Nombre1", "Apellido1");
        a.getAlumnos().add(alu);
        Grupo g = new Grupo(idGrupo);
        a.getGrupos().add(g);
        c.introducirAlumnoGrupo(idGrupo, alu);
        Prueba p = new Prueba("Prueba1", "Descripcion1", 20, 0);
        a.getPruebas().add(p);
        Examen e = new Examen(7.0F, alu, p);
        alu.getExamenes().add(e);
        p.getExamenes().add(e);
        c.introducirNotasGrupo(idGrupo, nombre, nota);
        Grupo gr = a.getGrupo(idGrupo);
        Alumno al = gr.getAlumnos().get(gr.getAlumnos().indexOf(alu));
        Examen ex = (Examen) al.getExamenes().get(al.getExamenes().indexOf(e));
        String result = ex.getPrueba().getNombre();
        assertEquals(nombre, result);
    }

    /**
     * Test of mostrarEvaluacionGrupo method, of class Controlador.
     */
    @Test
    public void testMostrarEvaluacionGrupo() {// no entra
        
    }

    /**
     * Test of introducirAñadirPrueba method, of class Controlador.
     */
    @Test
    public void testIntroducirAñadirPrueba() {
        System.out.println("introducirAñadirPrueba");
        String nombre = "Prueba100";
        String descripcion = "Descripcion1";
        int porcentaje = 20;
        int tipo = 0;
        Almacen a = new Almacen();
        Controlador c = new Controlador(a);
        c.introducirAñadirPrueba(nombre, descripcion, porcentaje, tipo);
        Prueba p = c.getAlmacen().getPrueba(nombre);
        assertEquals(nombre, p.getNombre());
        
    }

    /**
     * Test of mostrarPruebas method, of class Controlador.
     */
    @Test
    public void testMostrarPruebas() { // no entra
        
    }
    
}
