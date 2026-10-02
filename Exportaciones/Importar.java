package Exportaciones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

import ClaseObjetual.ObjetoPilaCola;

public class Importar {
    public LinkedList<ObjetoPilaCola> ImportarArchivo() {
        String rutaArchivo = "datos.txt"; // Cambiado a datos.txt
        LinkedList<ObjetoPilaCola> lista = new LinkedList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            ObjetoPilaCola obj = null;

            while ((linea = br.readLine()) != null) {
                linea = linea.trim(); // Limpia espacios raros al inicio y final

                if (linea.startsWith("Id: ")) {
                    if (obj != null) {
                        lista.add(obj); // Guarda el cliente anterior si existía
                    }
                    // Inicializamos con datos temporales que luego los setters corrigen
                    obj = new ObjetoPilaCola("", "", 0, 0, 0, 0);
                    obj.setId(linea.substring(4).trim()); // .substring(4) porque "Id: " son 4 caracteres

                } else if (linea.startsWith("Nombre: ")) {
                    if (obj != null)
                        obj.setNombre(linea.substring(8).trim());

                } else if (linea.startsWith("Edad: ")) {
                    if (obj != null)
                        obj.setEdad(Integer.parseInt(linea.substring(6).trim()));

                } else if (linea.startsWith("Tipo: ")) {
                    if (obj != null)
                        obj.setTipo(Integer.parseInt(linea.substring(6).trim()));

                } else if (linea.startsWith("Discapacidad: ")) {
                    if (obj != null)
                        obj.setDiscapacidad(Integer.parseInt(linea.substring(14).trim()));

                } else if (linea.startsWith("Turno: ")) {
                    if (obj != null) {
                        obj.setTurno(Integer.parseInt(linea.substring(7).trim())); // ¡Corregido a setTurno!
                    }
                }
            }

            // ¡Crucial! Guarda el último objeto procesado cuando el archivo se termina
            if (obj != null) {
                lista.add(obj);
            }

            System.out.println("Archivo importado correctamente. Clientes cargados: " + lista.size());

        } catch (Exception e) {
            System.out.println("Error al importar el archivo: " + e.getMessage());
        }
        return lista;
    }

}