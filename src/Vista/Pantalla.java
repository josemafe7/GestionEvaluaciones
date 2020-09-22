
package Vista;

import Interno.*;
import java.util.*;

public class Pantalla {
    private Controlador controlador;
    
    
    public Pantalla(Controlador controlador) {
        this.controlador = controlador;
    }
    
    

    public void mostrarOpciones() {
        Scanner s = new Scanner(System.in);
        int opc = -1;
        do {
            System.out.println("\n\n\n\tMenú Principal:\n");
            System.out.println("\t1. Gestión alumnos");
            System.out.println("\t2. Gestión grupos");
            System.out.println("\t3. Gestión pruebas");
            System.out.println("\t----------------------");
            System.out.println("\t\t0. Salir");
            System.out.println("\n\n--> Introduzca una opción: ");
            opc = s.nextInt();
            while (opc < 0 || opc > 3) {
                System.out.println("\n\n--> Introduzca una opción válida: ");
                opc = s.nextInt();
                System.out.println("\n");
            }
            if (opc != 0) {
                realizarOpcion(opc);
            }
        } while (opc != 0);
    }

    private void realizarOpcion(int opc) {
        switch (opc) {
            case 1:
                pantallaMenuAlumnos();
                break;
            case 2:
                pantallaMenuGrupos();
                break;
            case 3:
                pantallaMenuPruebas();
                break;

        }
    }

    private void pantallaMenuAlumnos() {
        
        Scanner s = new Scanner(System.in);
        int opc = -1;

        do {
            System.out.println("\n\n\n\tMenú Gestión Alumnos:\n");
            System.out.println("\t1. Añadir alumno");
            System.out.println("\t2. Consultar evaluación alumno");
            System.out.println("\t3. Introducir nota alumno");
            System.out.println("\t4. Introducir todas las notas");
            System.out.println("\t---------------------");
            System.out.println("\t\t0. Salir");
            System.out.print("\n\n--> Introduzca una opción: ");
            opc = s.nextInt();
            while (opc < 0 || opc > 4) {
                System.out.print("--> Introduzca una opción válida: ");
                opc = s.nextInt();
                System.out.println("\n");
            }
            if (opc != 0) {
                realizarOpcionGestionAlumnos(opc);
            }
        } while (opc != 0);
        
    }
    
    private void pantallaMenuGrupos() {
        
        Scanner s = new Scanner(System.in);
        int opc = -1;

        do {
            System.out.println("\n\n\n\tMenú Gestión Grupos:\n");
            System.out.println("\t1. Crear grupo");
            System.out.println("\t2. Añadir notas grupo");
            System.out.println("\t3. Consultar evaluación grupo");
            System.out.println("\t---------------------");
            System.out.println("\t\t0. Salir");
            System.out.print("\n\n--> Introduzca una opción: ");
            opc = s.nextInt();
            while (opc < 0 || opc > 3) {
                System.out.print("--> Introduzca una opción válida: ");
                opc = s.nextInt();
                System.out.println("\n");
            }
            if (opc != 0) {
                realizarOpcionGestionGrupos(opc);
            }
        } while (opc != 0);
        
    }

    private void pantallaMenuPruebas() {
        
        Scanner s = new Scanner(System.in);
        int opc = -1;

        do {
            System.out.println("\n\n\n\tMenú Gestión Alumnos:\n");
            System.out.println("\t1. Añadir prueba evaluable");
            System.out.println("\t2. Mostrar prueba evaluable");
            System.out.println("\t---------------------");
            System.out.println("\t\t0. Salir");
            System.out.print("\n\n--> Introduzca una opción: ");
            opc = s.nextInt();
            while (opc < 0 || opc > 2) {
                System.out.print("--> Introduzca una opción válida: ");
                opc = s.nextInt();
                System.out.println("\n");
            }
            if (opc != 0) {
                realizarOpcionGestionPruebas(opc);
            }
        } while (opc != 0);
        
    }

    private void realizarOpcionGestionAlumnos(int opc) {
        
        System.out.println("Opción elegida: " + opc);

        switch (opc) {
            case 1:
                mostrarAltaAlumno();
                break;
            case 2:
                mostrarEvaluacionAlumno();
                break;
            case 3:
                mostrarIntroducirNotaAlumno();
                break;
            case 4:
                mostrarIntroducirTodasLasNotas();
                break;
        }
        
    }

    private void mostrarAltaAlumno() {
        Scanner s = new Scanner(System.in);
        System.out.println("Introduzca los datos del alumno que desea dar de alta:");
        System.out.println("Nombre: ");
        String nombre = s.nextLine();
        System.out.println("Apellidos: ");
        String apellidos = s.nextLine();
        System.out.println("DNI: ");
        String dni = s.nextLine();
        
 
        Alumno a = this.controlador.getAlmacen().getAlumno(dni);
        if(a==null){
            this.controlador.introducirDatosAlumno(dni, nombre, apellidos);
            System.out.println("Alumno registrado con éxito");
        }
        else
            System.out.println("ERROR, DNI ya existe");    
         
    }

    private void mostrarEvaluacionAlumno() {
        Scanner s = new Scanner(System.in);
        System.out.println("Introduzca DNI del alumno que desea visualizar:");
        System.out.println("DNI: ");
        String dni = s.nextLine();
        Alumno a = this.controlador.getAlmacen().getAlumno(dni);
        if(a!=null)
        {
            this.controlador.mostrarEvaluacionAlumno(dni);
        }
        else
            System.out.println("ERROR, dni introducido no existe");
        
    }

    private void mostrarIntroducirNotaAlumno() {
        Scanner s = new Scanner(System.in);
        System.out.println("Introduzca los datos del alumno que desea introducir una nota:");
        System.out.println("Nombre de la prueba evaluable: ");
        String nombre = s.nextLine();
        Prueba p = this.controlador.getAlmacen().getPrueba(nombre);
        if(p!=null)
        {
            System.out.println("DNI del alumno que va a ser evaluado: ");
            String dni = s.nextLine();
            Alumno a = this.controlador.getAlmacen().getAlumno(dni);
            if(a!=null){
                System.out.println("Nota del alumno: ");
                float nota = s.nextFloat();
                if(nota>=0 && nota<=10)
                {
                    this.controlador.introducirNotaAlumno(nombre, dni, nota);
                    System.out.println("Nota de alumno introducida con éxito");
                }
                else
                    System.out.println("ERROR, nota incorrecta");
            }
            else
                System.out.println("ERROR, el DNI del alumno no existe");
        }
        else
            System.out.println("ERROR, la prueba introducida no existe");
        
        
    }

    private void mostrarIntroducirTodasLasNotas() {
        
        Scanner s = new Scanner(System.in);
        Iterator it = this.controlador.getAlmacen().getAlumnos().iterator();
        
        System.out.println("Nombre de la prueba evaluable: ");
        String nombre = s.nextLine();
        Prueba p = this.controlador.getAlmacen().getPrueba(nombre);
        if(p!=null)
        {
            while(it.hasNext()){
                Alumno a = (Alumno) it.next();
                System.out.println("DNI del alumno que va a ser evaluado: " + a.getDni());
                System.out.println("Nota del alumno: ");
                float nota = s.nextFloat();
                if(nota>=0 && nota<=10)
                    {
                        this.controlador.introducirNotaAlumno(nombre, a.getDni(), nota);
                        System.out.println("Nota de alumno introducida con éxito");
                    }
                    else
                        System.out.println("ERROR, nota incorrecta");
            }
        }
        else
            System.out.println("ERROR, la prueba introducida no existe");

    }
        
    

    private void realizarOpcionGestionGrupos(int opc) {
        System.out.println("Opción elegida: " + opc);

        switch (opc) {
            case 1:
                mostrarAltaGrupo();
                break;
            case 2:
                mostrarAñadirNotasGrupo();
                break;
            case 3:
                mostrarEvaluacionGrupo();
                break;
        }
    }

    private void realizarOpcionGestionPruebas(int opc) {
        
        System.out.println("Opción elegida: " + opc);

        switch (opc) {
            case 1:
                mostrarAñadirPrueba();
                break;
            case 2:
                mostrarPruebas();
                break;

        }
        
    }

    private void mostrarAltaGrupo() {
        int idGrupo = this.controlador.crearGrupo();
        System.out.println("Introduzca los datos del alumno que desea añadir a un grupo:");
        int i = 0;
        boolean salir = false;

        
        do{
            Scanner s = new Scanner(System.in);
            System.out.println("DNI: ");
            String dni = s.nextLine(); 
            
            Alumno a = this.controlador.getAlmacen().getAlumno(dni);
            if(a!=null)
            {
                this.controlador.introducirAlumnoGrupo(idGrupo, a);
            
            
                if (i<3){
                    System.out.println("Pulse 0 si desea dejar de añadir alumnos, si desea continuar pulse cualquier tecla.");
                    int num = s.nextInt();
                    if (num == 0)
                        salir = true;
                }
                
                i++;
            }
            else
            {
                System.out.println("ERROR, DNI de alumno no existe");
                salir = true;
            }
                
            
        }while(i < 3 && !salir);
        
        
    }

    private void mostrarAñadirNotasGrupo() {
        
        Scanner s = new Scanner(System.in);
        System.out.println("Introduzca los datos del grupo que desea evaluar");

        System.out.println("Id Grupo: ");
        int idGrupo = s.nextInt(); 
        Grupo g = this.controlador.getAlmacen().getGrupo(idGrupo);
        if(g!=null)
        {
            Scanner s1 = new Scanner(System.in);
            System.out.println("Nombre prueba: ");
            String nombre = s1.nextLine(); 
            Prueba p = this.controlador.getAlmacen().getPrueba(nombre);
            if(p!=null && p.getTipo()==1)
            {
                System.out.println("Nota: ");
                float nota = s.nextFloat();
                if(nota>=0 && nota<=10)
                {
                    this.controlador.introducirNotasGrupo(idGrupo, nombre, nota);
                    System.out.println("Nota grupal introducida con éxito");
                }
                else
                    System.out.println("ERROR, nota no válida");
            }
            else
                System.out.println("ERROR, prueba introducida no existe o no es grupal");
        }
        else
            System.out.println("ERROR, ID grupo no existe");

    }

    private void mostrarEvaluacionGrupo() {
        
        this.controlador.mostrarEvaluacionGrupo();
        
    }

    private void mostrarAñadirPrueba() {
        
        Scanner s = new Scanner(System.in);
        System.out.println("Introduzca los datos de la prueba que desea añadir: ");
        
        System.out.println("Nombre prueba: ");
        String nombre = s.nextLine(); 
        Prueba p = this.controlador.getAlmacen().getPrueba(nombre);
        if(p==null)
        {
            System.out.println("Descripcion: ");
            String descripcion = s.nextLine();
        
            System.out.println("Porcentaje: ");
            int porcentaje = s.nextInt();
            if(porcentaje>=0 && porcentaje<=100)
            {
                System.out.println("Tipo: \n\tIndividual 0, Grupal 1 ");
            int tipo = s.nextInt(); 
        
            this.controlador.introducirAñadirPrueba(nombre, descripcion, porcentaje, tipo);
            System.out.println("Prueba añadida con éxito");
            }
            else
                System.out.println("ERROR, porcentaje no válido");   
        }
        else
            System.out.println("ERROR, la prueba ya existe");
        
        
    }

    private void mostrarPruebas() {
        this.controlador.mostrarPruebas();
    }

   
    
}
