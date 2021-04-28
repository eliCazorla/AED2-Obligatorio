package Dominio;

public class GrafoMetro {
    public Via [][] matrizAdy;
    public boolean [] estacionesUsadas;
    int size;//tamaño actual estaciones
    int cantEstaciones;//maxima cantidad de estaciones permitidas

    
    public GrafoMetro(int cantEstaciones) {
        this.cantEstaciones = cantEstaciones;
        this.matrizAdy = new Via [cantEstaciones+1][cantEstaciones+1];
        this.estacionesUsadas = new boolean [cantEstaciones+1];
        this.size = 0;
        
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

    public boolean[] getEstacionesUsadas() {
        return estacionesUsadas;
    }

    public void setEstacionesUsadas(boolean[] estacionesUsadas) {
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
   
    
}
