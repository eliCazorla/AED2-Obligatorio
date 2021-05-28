package Dominio;

import Estructuras.ListaCamino;
import Estructuras.ListaVia;
import Retorno.Retorno;

public class GrafoMetro {
    public ListaVia [][] matrizAdy;
    public Estacion [] estacionesUsadas;
    int size;//tamaño actual estaciones
    int cantEstaciones;//maxima cantidad de estaciones permitidas

    
    public GrafoMetro(int cantEstaciones) {
        this.cantEstaciones = cantEstaciones;
        this.matrizAdy = new ListaVia [cantEstaciones+1][cantEstaciones+1];
        this.estacionesUsadas = new Estacion [cantEstaciones+1];
        this.size = 0;
         
        for (int i = 1; i <= cantEstaciones; i++) {
            this.estacionesUsadas[i] = new Estacion();
        }
        
        for (int i = 1; i <= cantEstaciones; i++) {
            for (int j = 1; j <= cantEstaciones; j++) {
                this.matrizAdy[i][j] = new ListaVia();
            }
        }
    }
    
    public ListaVia[][] getMatrizAdy() {
        return matrizAdy;
    }

    public void setMatrizAdy(ListaVia[][] matrizAdy) {
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
            if (this.getEstacionesUsadas()[i].esLaEstacion(coordX, coordY)) {
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
    
    public void agregarTramo(Double coordXi, Double coordYi, Double coordXf, Double coordYf, int metros, int minutos) {
        Via via = new Via(metros, minutos);
        int codigoEstacionI = this.getEstacionXCoordenadas(coordXi, coordYi).getCodigo();
        int codigoEstacionF = this.getEstacionXCoordenadas(coordXf, coordYf).getCodigo();
        this.getMatrizAdy()[codigoEstacionI][codigoEstacionF].agregarInicio(via);
        this.getMatrizAdy()[codigoEstacionF][codigoEstacionI].agregarInicio(via);
    }
    
    public Estacion getEstacionXCoordenadas(Double coordX, Double coordY) {
        for (int i = 1; i <= cantEstaciones; i++) {
            Estacion estacion = this.getEstacionesUsadas()[i];
            if(estacion.esLaEstacion(coordX, coordY)) {
                return estacion;
            }
        }
        return null;
    }

    public Retorno caminoMinimo(Estacion origen, Estacion destino) {
        Retorno retorno = new Retorno();
        boolean[] visitados = new boolean[this.cantEstaciones+1];
        int[] costos = new int[this.cantEstaciones+1];
        Estacion[] predecesores = new Estacion[this.cantEstaciones+1];
        
        visitados[origen.getCodigo()] = true;
        
        for (int i = 1; i <= this.cantEstaciones; i++) {
            if (i!=origen.getCodigo()) {
                if (sonAdyacentes(origen.getCodigo(), i)) {
                    costos[i] = matrizAdy[origen.getCodigo()][i].getLongitudMinima();
                    predecesores[i] = origen;
                }else{
                    costos[i] = Integer.MAX_VALUE;
                }
            }
        }
        
        boolean encontroDestino = false;
        
        while(!encontroDestino){
            Estacion w = estacionConDistanciaMasCortaNoVisitado(costos, visitados);
            if (w == destino) {
                retorno.valorEntero = costos[w.getCodigo()];
                retorno.valorString = caminoDesdeOrigenADestino(origen,destino,predecesores);
                retorno.resultado = retorno.resultado.OK;
                encontroDestino = true;
            }
            visitados[w.getCodigo()] = true;
            for (int j = 1; j <= this.cantEstaciones; j++) {
                if (sonAdyacentes(w.getCodigo(), j) && !visitados[j]) {
                    if (costos[w.getCodigo()] + matrizAdy[w.getCodigo()][j].getLongitudMinima() < costos[j]) {
                        costos[j] = costos[w.getCodigo()] + matrizAdy[w.getCodigo()][j].getLongitudMinima();
                        predecesores[j] = w;
                    }
                }
            }
        }
        return retorno;
    }
    
    public boolean sonAdyacentes(int a, int b){
        return this.matrizAdy[a][b].getExiste();
    }

    private Estacion estacionConDistanciaMasCortaNoVisitado(int[] costos, boolean[] visitados) {
        int minimo = Integer.MAX_VALUE;
        int posicion = 0;
        for (int i = 1; i < costos.length; i++) {
            if (costos[i] != 0) {
                if (costos[i] < minimo && !visitados[i]) {
                    minimo = costos[i]; 
                    posicion = i;
                }
            }
        }
        Estacion estacion = estacionXCodigo(posicion);
        return estacion;
    }
    
    private Estacion estacionXCodigo(int codigo){
        for (int i = 1; i <= this.cantEstaciones; i++) {
            if (estacionesUsadas[i].getCodigo() == codigo) {
                return estacionesUsadas[i];
            }
        }
        return null;
    }

    private String caminoDesdeOrigenADestino(Estacion origen, Estacion destino, Estacion[] predecesores) {
        //recorrer hasta que el predecesor sea el origen
        boolean esElOrigen = false;
        ListaCamino camino = new ListaCamino();
        camino.agregarInicio(destino);
        //String recorrido = destino.getNombre();
        while(!esElOrigen){
            if (predecesores[destino.getCodigo()] == origen) {
                esElOrigen = true;
                //recorrido = "<" + predecesores[destino.getCodigo()].getCoordX() +  "> <" + predecesores[destino.getCodigo()].getCoordY() + ">" + recorrido;
                camino.agregarInicio(predecesores[destino.getCodigo()]);
            }else{
                //faltaria agregar el string
                destino = predecesores[destino.getCodigo()]; 
                //recorrido = destino.getNombre() +  " " + recorrido;
                camino.agregarInicio(destino);
            }
        }
        //return recorrido;
        return "";
    }
}
