package Metodos;

import java.util.Scanner;
import Validaciones.Validaciones;
import ClaseObjetual.ObjetoPilaCola;

public class MetodosLlenar {

    public ObjetoPilaCola[][] LlenarMatriz(ObjetoPilaCola[][] matriz, Scanner sc, Validaciones v) {

        boolean continuar = true;
        do {
            boolean certificacion = false;
            ObjetoPilaCola o = new ObjetoPilaCola(null, null, 0, 0, 0, 0, 0);
            for (int i = 0; i < matriz.length && !certificacion ; i++) {
                for (int j = 0; j < matriz.length && !certificacion; j++) {
                    if (matriz[i][j] == null) {
                        System.out.println("Procedamos con el registro");
                        System.out.println("----------------------------");
                        System.out.println("Ingrese su Id");
                        o.setId(v.ValidarTexto(sc));
                        System.out.println("Ingrese su nombre");
                        o.setNombre(v.ValidarTexto(sc));
                        System.out.println("Ingrese su edad ");
                        o.setEdad(v.ValidarEntero(sc));
                        o.setTipo(TipoTramite(sc, v)); // validar tipo de tramite :o
                        o.setDiscapacidad(TipoDiscapacidad(sc, v)); // valida la discapacidad (okeyyy)
                        o.setEstado(1);

                        matriz[i][j] = o;
                        certificacion = true;

                        System.out.println("Desea registrar un nuevo cliente?  1) si / 2) no");
                        int respuesta = v.ValidarEntero(sc);

                        if (respuesta == 2) {
                            continuar = false;
                            continue;
                        } // fin if
                    } // fin if

                } // fin for 2
            } // fin for 1
        if (!certificacion) {
            System.out.println("Sala de espera esta llena");
        }


        } while (continuar == true);

        return matriz;
    } // fin llenar matriz

    public int TipoTramite(Scanner sc, Validaciones v) {
        boolean continuar = true;
        int tipotramite = 0;
        do {
            System.out.println("Ingrese la clase de cita que realizara");
            System.out.println("1) Medicina genera");
            System.out.println("2) Odontologia");
            System.out.println("3) Dermatologo");
            System.out.println("4) Psicologo");

            int opcion = v.ValidarEntero(sc);
            switch (opcion) {
                case 1:
                    System.out.println("Cita seleccionada: abrir cuenta de credito");
                    tipotramite = opcion;
                    continuar = false;
                    break;
                case 2:
                    System.out.println("Cita seleccionada: solucionar errores de cuenta");
                    tipotramite = opcion;
                    continuar = false;
                    break;
                case 3:
                    System.out.println("Cita seleccionada: Cerrar/bloquear cuenta de credito");
                    tipotramite = opcion;
                    continuar = false;
                    break;
                case 4:
                    System.out.println("Cita seleccionada: realizar transaccion");
                    tipotramite = opcion;
                    continuar = false;
                    break;
                default:
                    System.out.println("Ingrese una opcion valida...");
                    break;
            }
        } while (continuar == true);

        return tipotramite;
    } //// fin tipo de tramite

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public int TipoDiscapacidad(Scanner sc, Validaciones v) {
        boolean continuar = true;
        int TipoDiscapacidad = 0;
        System.out.println("¿el usuario tiene alguna discapacidad?");
        System.out.println("1) No");
        System.out.println("2) Si");
        int confirmacion = v.ValidarEntero(sc);
        if (confirmacion == 2) {
            do {
                System.out.println("Ingrese la discapacidad del usuario");
                System.out.println("1) Movilidad reducida");
                System.out.println("2) Discapacidad sensorial");
                System.out.println("3) Embarazo o bebe en brazo");
                System.out.println("4) Discapacidad mental");

                int opcion = v.ValidarEntero(sc);
                switch (opcion) {
                    case 1:
                        System.out.println("Seleccionado: Movilidad reducida");
                        TipoDiscapacidad = opcion;
                        continuar = false;
                        break;
                    case 2:
                        System.out.println("Seleccionado: Discapacidad sensorial");
                        TipoDiscapacidad = opcion;
                        continuar = false;
                        break;
                    case 3:
                        System.out.println("Seleccionado: Embarazo o bebe en brazo");
                        TipoDiscapacidad = opcion;
                        continuar = false;
                        break;
                    case 4:
                        System.out.println("Seleccionado: Discapacidad mental");
                        TipoDiscapacidad = opcion;
                        continuar = false;
                        break;
                    default:
                        System.out.println("Ingrese una opcion valida...");
                        break;
                }
            } while (continuar == true);
        }
        return TipoDiscapacidad;
    } //// fin tipo de discapacidad

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}