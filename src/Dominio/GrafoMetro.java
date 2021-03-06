package Dominio;

import Estructuras.ListaCamino;
import Estructuras.ListaVia;
import Estructuras.NodoEstacion;
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
                    costos[i] = matrizAdy[origen.getCodigo()][i].getViaConLongitudMinima().getLongitud();
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
            if(!encontroDestino) {
                visitados[w.getCodigo()] = true;
                for (int j = 1; j <= this.cantEstaciones; j++) {
                    if (sonAdyacentes(w.getCodigo(), j) && !visitados[j]) {
                        if (costos[w.getCodigo()] + matrizAdy[w.getCodigo()][j].getViaConLongitudMinima().getLongitud() < costos[j]) {
                            costos[j] = costos[w.getCodigo()] + matrizAdy[w.getCodigo()][j].getViaConLongitudMinima().getLongitud();
                            predecesores[j] = w;
                        }
                    }
                }
            }
        }
        return retorno;
    }
    
    public boolean sonAdyacentes(int a, int b){
        return this.matrizAdy[a][b].getExiste();
    }
    
    public Via getVia(int a, int b){
        return this.matrizAdy[a][b].getViaConLongitudMinima();
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
        boolean esElOrigen = false;
        ListaCamino camino = new ListaCamino();
        camino.agregarInicio(destino);
        while(!esElOrigen){
            if (predecesores[destino.getCodigo()] == origen) {
                esElOrigen = true;
                camino.agregarInicio(predecesores[destino.getCodigo()]);
            }else{
                destino = predecesores[destino.getCodigo()]; 
                camino.agregarInicio(destino);
            }
        }
        return caminoString(camino);
    }

    private String caminoString(ListaCamino camino) {
        NodoEstacion aux = camino.getInicio();
        String retorno = "";
        while(aux.getSig() != null){
            if(aux.getSig().getSig() == null) {
                retorno += aux.getEstacion().getCoordX() + ";" + aux.getEstacion().getCoordY() + ";" + aux.getSig().getEstacion().getCoordX() + ";" + aux.getSig().getEstacion().getCoordY() + ";" + idTramo(aux.getEstacion(),aux.getSig().getEstacion());
            }else {
                retorno += aux.getEstacion().getCoordX() + ";" + aux.getEstacion().getCoordY() + ";" + aux.getSig().getEstacion().getCoordX() + ";" + aux.getSig().getEstacion().getCoordY() + ";" + idTramo(aux.getEstacion(),aux.getSig().getEstacion()) + "|";
            }
            aux = aux.getSig();
        }
        return retorno;
    }

    private String idTramo(Estacion a, Estacion b) {
        Via via = this.getVia(a.getCodigo(), b.getCodigo());
        return a.getNombre() + "_" + b.getNombre() + "_" + via.getId();
    }

    public String getEstacionesComprendidas(Estacion estacion, int metros) {
        boolean[] visitados = new boolean[this.cantEstaciones+1];
        int[] costos = new int[this.cantEstaciones+1];
        Estacion[] predecesores = new Estacion[this.cantEstaciones+1];
        String estaciones = "";
            
        visitados[estacion.getCodigo()] = true;
        for (int i = 1; i <= this.cantEstaciones; i++) {
            if (i != estacion.getCodigo()) {
                if (this.sonAdyacentes(i, estacion.getCodigo())) {
                    costos[i] = matrizAdy[estacion.getCodigo()][i].getViaConLongitudMinima().getLongitud();
                    predecesores[i] = estacion;
                }else{
                    costos[i] = Integer.MAX_VALUE;
                }
            }
        }
        
        boolean seEvacuo = false;
        int cantEstacionesRecorridas = 1;
        while(!seEvacuo && cantEstacionesRecorridas!=this.getCantEstaciones()){
           Estacion w = this.estacionConDistanciaMasCortaNoVisitado(costos, visitados);
            if (costos[w.getCodigo()] > metros) {
                seEvacuo = true;
            }else{
                estaciones += w.getNombre() + "|";
            
                visitados[w.getCodigo()] = true;
                for (int i = 1; i <= this.cantEstaciones; i++) {
                    if (sonAdyacentes(w.getCodigo(),i) && !visitados[i]) {
                        if (costos[w.getCodigo()] + matrizAdy[w.getCodigo()][i].getViaConLongitudMinima().getLongitud() < costos[i]) {
                             costos[i] = costos[w.getCodigo()] + matrizAdy[w.getCodigo()][i].getViaConLongitudMinima().getLongitud();
                             predecesores[i] = w;
                        }
                    }
                }
            }
            cantEstacionesRecorridas++;
        }    
             
        return estaciones;
    }

    public String armarMapa() {
        String retorno = "http://maps.googleapis.com/maps/api/staticmap?center=Montevideo,Uruguay&zoom=12&size=1500x1500&maptype=roadmap";
        for (int i = 1; i <= this.getCantEstaciones(); i++) {
            Estacion estacion = this.getEstacionesUsadas()[i];
            retorno += "&markers=color:red%7Clabel:" + estacion.getCodigo() + "%7C" + estacion.getCoordX() + "," + estacion.getCoordY();
        }
        retorno += "&sensor=false&key=AIzaSyBTC1gW4ziuJBc6_EdVqvzDgusl34hIr6A";
        return retorno;
    }
}
