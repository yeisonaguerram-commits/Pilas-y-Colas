package ClaseObjetual;

public class ObjetoPilaCola {

        private String Id;
        private String Nombre;
        private int Edad;
        private int Tipo;
        private int Turno;
        private int Discapacidad;
        public ObjetoPilaCola(String id, String nombre, int edad, int tipo, int turno, int discapacidad) {
            Id = id;
            Nombre = nombre;
            Edad = edad;
            Tipo = tipo;
            Turno = turno;
            Discapacidad = discapacidad;
        }
        public String getId() {
            return Id;
        }
        public void setId(String id) {
            Id = id;
        }
        public String getNombre() {
            return Nombre;
        }
        public void setNombre(String nombre) {
            Nombre = nombre;
        }
        public int getEdad() {
            return Edad;
        }
        public void setEdad(int edad) {
            Edad = edad;
        }
        public int getTipo() {
            return Tipo;
        }
        public void setTipo(int tipo) {
            Tipo = tipo;
        }
        public int getTurno() {
            return Turno;
        }
        public void setTurno(int turno) {
            Turno = turno;
        }
        public int getDiscapacidad() {
            return Discapacidad;
        }
        public void setDiscapacidad(int discapacidad) {
            Discapacidad = discapacidad;
        }
    }