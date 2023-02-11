import java.util.*;
import java.io.*;
import personas.*;

public class practica4 {
    public static void main (String[] args) {

        switch(args.length) {

            case 0:
                System.out.println("Falta el nombre del fichero de entrada.");
                break;

            case 1:

                File fichero = new File(args[0]);
                Scanner pedir = new Scanner(System.in);
                int selecion = 0;
                ArrayList<persona> Persona = new ArrayList<persona>();

                comprobarInforme(Persona);

                do {

                    borrar();

                    mostrarMenu(fichero);

                    selecion = pedir.nextInt();

                    switch (selecion) {

                        case 1: 

                            borrar();

                            persona personaN = new persona();

                            personaN.añadirPersona(pedir, Persona);
                            Persona.add(personaN);
                            
                            break;

                        case 2:
                            
                            borrar();

                            for (int i = 0; i < Persona.size(); i++) {
                                Persona.get(i).mostrarLista();
                            }

                            continuar();
                            
                            break;

                        case 3: 

                            borrar();

                            System.out.println("Introduce el id de la persona que quieres buscar: ");
                            int id = pedir.nextInt();

                            for (int i = 0; i < Persona.size(); i++) {
                                if (Persona.get(i).getId() == id) {
                                    Persona.get(i).mostrarLista();
                                }
                            }

                            continuar();

                            break;

                        case 4:

                            borrar();

                            String nombreFichero = "informe.txt";

                            File fichero2 = new File(nombreFichero);

                            try {

                                FileWriter fw = new FileWriter(fichero2);

                                for (int i = 0; i < Persona.size(); i++) {
                                    fw.write(Persona.get(i).getId()
                                    + ", " + Persona.get(i).getNombre()
                                    + ", " + Persona.get(i).getApellidos()
                                    + ", " + Persona.get(i).getAñoNac()
                                    + ", " + Persona.get(i).getEdad()
                                    + ", " + Persona.get(i).getCorreo()
                                    + "\n");
                                }

                                fw.close();

                            } catch (Exception e) {
                                System.out.println(e);
                            }

                            continuar();

                            break;

                        case 5: 
                            System.exit(0);


                    }

                } while (true);

        }

    }

    public static void mostrarMenu(File fichero) {

        Scanner s = null;

        try{
            System.out.println("");
            s = new Scanner(fichero);
            while (s.hasNextLine()) {
                String linea = s.nextLine();
                System.out.println(linea);
            }
        } catch (Exception ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        } finally {
            try {
                if (s != null) s.close();
            } catch (Exception ex2) {
                System.out.println("Mensaje 2: " + ex2.getMessage());
            }
        }

    }

    public static void continuar() {
        Scanner pedir = new Scanner(System.in);
        System.out.println("Pulsa enter para continuar...");
        pedir.nextLine();
    }

    public static void borrar() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void comprobarInforme(ArrayList<persona> Persona) {
        File fichero = new File("informe.txt");
        if (fichero.exists()) {

            try {
                Scanner s = new Scanner(fichero);
                while (s.hasNextLine()) {
                    String linea = s.nextLine();
                    String[] datos = linea.split(", ");
                    persona personaN = new persona();
                    personaN.setId(Integer.parseInt(datos[0]));
                    personaN.setNombre(datos[1]);
                    personaN.setApellidos(datos[2]);
                    personaN.setAñoNac(Integer.parseInt(datos[3]));
                    personaN.setEdad(Integer.parseInt(datos[4]));
                    personaN.setCorreo(datos[5]);
                    Persona.add(personaN);
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }

}