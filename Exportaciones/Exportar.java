package Exportaciones;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Queue;
import ClaseObjetual.ObjetoPilaCola;


public class Exportar {
    public void exportarArchivo(Queue<ObjetoPilaCola> p) {
        if (p.isEmpty()) {
            System.out.println("La lista esta vacia no se puede exportar el archivo");
            return;
        } else {
            try (FileWriter e = new FileWriter("datos.txt")) {
                for (ObjetoPilaCola obj : p) {
                    e.write("ID: " + obj.getId() + "\n");
                    e.write("Nombre: " + obj.getNombre() + "\n");
                    e.write("edad: " + obj.getEdad() + "\n");
                    e.write("Tipo: " + obj.getTipo() + "\n");
                    e.write("Discapacidad : " + obj.getDiscapacidad() + "\n");
                    e.write("Turno: " + obj.getTurno() + "\n");
                    e.write("Estado: " + obj.getEstado() + "\n");
                    e.write("------------------------------------------------------ \n");

                }
                System.out.println("Archivo exportado correctamente ");

            } catch (IOException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
    }
}