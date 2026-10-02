package Exportaciones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

import ClaseObjetual.ObjetoPilaCola;

public class Importar {
    public ObjetoPilaCola[][] ImportarArchivo(int tamañomatriz) {
        String rutaArchivo = "datos.txt";
        LinkedList<ObjetoPilaCola> lista = new LinkedList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            ObjetoPilaCola obj = null;

            while ((linea = br.readLine()) != null) {
                linea = linea.trim();

                if (linea.startsWith("Id: ")) {
                    if (obj != null) {
                        lista.add(obj); // Guarda el cliente anterior si existía
                    }

                    obj = new ObjetoPilaCola("", "", 0, 0, 0, 0, 0);
                    obj.setId(linea.substring(4).trim());

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

            if (obj != null) {
                lista.add(obj);
            }

        } catch (Exception e) {
            System.out.println("Error al importar el archivo: " + e.getMessage());
        }

            ObjetoPilaCola[][] matriz = new ObjetoPilaCola[tamañomatriz][tamañomatriz];

            int contador = 0;

            for (int i = 0; i < tamañomatriz; i++) {
                for (int j = 0; j < tamañomatriz; j++) {
                    if (contador < lista.size()) {
                        matriz[i][j] = lista.get(contador);
                    } else {
                        matriz[i][j] = null;
                    }
                }
            }

            System.out.println("Archivo importado correctamente. Clientes cargados: " + lista.size());


        return matriz;
    }

}