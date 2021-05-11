package Dominio;

public class GrafoMetro {
    public Via [][] matrizAdy;
    public Estacion [] estacionesUsadas;
    int size;//tamaño actual estaciones
    int cantEstaciones;//maxima cantidad de estaciones permitidas

    
    public GrafoMetro(int cantEstaciones) {
        this.cantEstaciones = cantEstaciones;
        this.matrizAdy = new Via [cantEstaciones+1][cantEstaciones+1];
        this.estacionesUsadas = new Estacion [cantEstaciones+1];
        this.size = 0;
         
        for (int i = 1; i <= cantEstaciones; i++) {
            this.estacionesUsadas[i] = new Estacion();
        }
        
        for (int i = 1; i <= cantEstaciones; i++) {
            for (int j = 1; j <= cantEstaciones; j++) {
                this.matrizAdy[i][j] = new Via();
            }
        }
    }
    
    public Via[][] getMatrizAdy() {
        return matrizAdy;
    }

    public void setMatrizAdy(Via[][] matrizAdy) {
        this.matrizAdy = matrizAdy;
    }

    public Estacion[] getEstacionesUsadas() {
        return estacionesUsadas;
    }

    public void setEstacionesUsadas(Estacion[] estacionesUsadas) {
        this.estacionesUsadas = estacionesUsadas;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCantEstaciones() {
        return cantEstaciones;
    }

    public void setCantEstaciones(int cantEstaciones) {
        this.cantEstaciones = cantEstaciones;
    }    

    public boolean estaEstacion(Double coordX, Double coordY) {
        for (int i = 1; i <= cantEstaciones; i++) {
            if (this.getEstacionesUsadas()[i].existeEstacionXCoordenadas(coordX, coordY)) {
                return true;
            }
        }
        return false;
    }

    public void agregarEstacion(String nombre, Double coordX, Double coordY, int codigoEstacion) {
       Estacion estacion = new Estacion(nombre, coordX, coordY, codigoEstacion); 
       estacion.setExiste(true);
       this.getEstacionesUsadas()[codigoEstacion] = estacion;
    }
   
    
}
