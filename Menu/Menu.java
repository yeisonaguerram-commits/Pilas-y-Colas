package Menu;

import ClaseObjetual.ObjetoPilaCola;
import Validaciones.Validaciones;
import Metodos.MetodosLlenar;

import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        MetodosLlenar ml = new MetodosLlenar();
        Validaciones v = new Validaciones();
        Exportaciones.Importar imp = new Exportaciones.Importar();

        System.out.println("Ingrese el tamaño de su sada de espera cuadrada");
        int tamañomatriz = v.ValidarEntero(sc);
        boolean continuar = true;
        int opcion;

        Stack<ObjetoPilaCola> pila = new Stack<>();
        Queue<ObjetoPilaCola> cola = new LinkedList<>();
        ObjetoPilaCola[][] matriz = imp.ImportarArchivo(tamañomatriz);

/*
// 1. Así instanciabas la clase al principio del main:
Exportaciones.Importar imp = new Exportaciones.Importar();

// 2. Y así es como tenías pensado meter los datos a la cola (usando la LinkedList que devolvía):
LinkedList<ObjetoPilaCola> datosImportados = imp.ImportarArchivo();
for (ObjetoPilaCola cliente : datosImportados) {
    cola.add(cliente); // Cargaba los datos del .txt directo a tu fila de atención
} */


        while (continuar) {
            System.out.println("=== HOSPTIAL PAPIALPA QUESO MONTAÑERO ===");
            System.out.println("1. Registrar un cliente");
            System.out.println("2. Consultar los clientes que estan esperando");
            System.out.println("3. Llamar al siguiente cliente");
            System.out.println("4. Marcar un cliente como atendido");
            System.out.println("5. Cambiar un cliente de atencion general a preferencial");
            System.out.println("6. Cancelar turno");
            System.out.println("7. Buscar cliente");
            System.out.println("8. Consultar numero de personas esperando");
            System.out.println("9. Cuantos clientes normales y preferencales estan pendientes");
            System.out.println("0. Salir");

            opcion = v.ValidarEntero(sc);
            switch (opcion) {
                case 1:
                    matriz = ml.LlenarMatriz(matriz, sc, v);
                    break;
                case 2:
                    System.out.println("[INFO] Opción 2: En mantenimiento.");
                    break;
                case 3:
                    System.out.println("[INFO] Opción 3: En mantenimiento.");
                    break;
                case 4:
                    System.out.println("[INFO] Opción 4: En mantenimiento.");
                    break;
                case 5:
                    System.out.println("[INFO] Opción 5: En mantenimiento.");
                    break;
                case 6:
                    System.out.println("[INFO] Opción 6: En mantenimiento.");
                    break;
                case 0:
                    System.out.println("Saliendo del programa... ¡Hasta luego!");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }
        }
        
        sc.close();
    }
}
