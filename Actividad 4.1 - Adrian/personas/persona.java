package personas;

import java.util.*;

public class persona {

    private int id;
    private String nombre;
    private String apellidos;
    private int añoNac;
    private String correo;
    private int edad;

    public void añadirPersona(Scanner pedir, ArrayList<persona> persona) {

        comprobarId(pedir, persona);

        pedir.nextLine();

        comprobarNombre(pedir);

        comprobarApellidos(pedir);

        comprobarAñoNac(pedir);

        comprobarCorreo(pedir);

        calcularEdad();
        
        System.out.print("Persona añadida Correctamente");
    
    }

    public void mostrarLista() {
        System.out.print("ID: " + this.id + ", ");
        System.out.print("Nombre: " + this.nombre + ", ");
        System.out.print("Apellidos: " + this.apellidos + ", ");
        System.out.print("Año de nacimiento: " + this.añoNac + ", ");
        System.out.print("Edad: " + this.edad + ", ");
        System.out.print("Correo: " + this.correo + "\n");
    }

    public void comprobarId(Scanner pedir, ArrayList<persona> persona) {

        do {

            try {

                System.out.print("Introduce el ID de la persona: ");
                int id = pedir.nextInt();

                for (int i = 0; i < persona.size(); i++) {
                    if (id == persona.get(i).getId()) {
                        throw new Exception("El ID introducido ya existe");
                    }
                }
                if (id > 0 && id < 1000) {
                    this.id = id;
                } else {
                    throw new Exception("El ID introducido no es válido");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } while (this.id == 0);

    }

    public void comprobarNombre(Scanner pedir) {

        do {
            try {

                System.out.print("Introduce el nombre de la persona: ");
                String nombre = pedir.nextLine();

                if (nombre.matches("[a-zA-Z]*")) {
                    this.nombre = nombre;
                } else {
                    throw new Exception("El nombre introducido no es válido");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (this.nombre == null);

    }

    public void comprobarApellidos(Scanner pedir) {

        do {
            try {

                System.out.print("Introduce los apellidos de la persona: ");
                String apellidos = pedir.nextLine();

                if (apellidos.matches("[a-zA-Z]*")) {
                    this.apellidos = apellidos;
                } else {
                    throw new Exception("Los apellidos introducidos no son válidos");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (this.apellidos == null);

    }

    public void comprobarAñoNac(Scanner pedir) {

        do {
            try {

                System.out.print("Introduce el año de nacimiento: ");
                String añoNac = pedir.nextLine();

                if (añoNac.matches("[0-9]*")) {
                    this.añoNac = Integer.parseInt(añoNac);
                } else {
                    throw new Exception("El año de nacimiento introducido no es válido");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (this.añoNac == 0);

    }

    public void comprobarCorreo(Scanner pedir) {

        do {
            try {

                System.out.print("Introduce el correo de la persona: ");
                String correo = pedir.nextLine();

                if (correo.matches("[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}")) {
                    this.correo = correo;
                } else {
                    throw new Exception("El correo introducido no es válido");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (this.correo == null);

    }

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getAñoNac() {
        return añoNac;
    }

    public void setAñoNac(int añoNac) {
        this.añoNac = añoNac;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    private void calcularEdad() {
        Calendar fechaActual = Calendar.getInstance();
        int añoActual = fechaActual.get(Calendar.YEAR);
        edad = añoActual - añoNac;
    }

}
