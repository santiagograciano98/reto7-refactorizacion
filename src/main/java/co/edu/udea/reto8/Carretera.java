package co.edu.udea.reto8;

import java.util.List;

public class Carretera {

    private List listaTramos;

    public Carretera() {
    }

    public Carretera(List listaTramos) {
        this.listaTramos = listaTramos;
    }

    public List getListaTramos() {
        return listaTramos;
    }

    public void setListaTramos(List listaTramos) {
        this.listaTramos = listaTramos;
    }

    public float calcularLongitudTotal(List<Tramo> tramos) {
        float longitudTotal = 0;
        for (Tramo tramo : tramos) {
            longitudTotal += tramo.calcularLongitud();
        }
        return longitudTotal;
    }

    public float calcularAreaTotalDeCarretera(List<Tramo> tramos) {
        float areaTotal = 0;
        for (Tramo tramo : tramos) {
            areaTotal += tramo.calcularArea();
        }
        return areaTotal;
    }

    public float calcularVolumenTotal(List<Tramo> tramos) {
        float volumenTotal = 0;
        for (Tramo tramo : tramos) {
            volumenTotal += tramo.calcularVolumen();
        }
        return volumenTotal;
    }

    public float calcularVolumenTotalTramosConAsfalto(List<Tramo> tramos) {
        float volumenTotalEnAsfalto = 0;
        for (Tramo tramo : tramos) {
            String nombreClase = tramo.getClass().getSimpleName();
            if (nombreClase.equals("TramoConAsfalto")) {
                volumenTotalEnAsfalto += tramo.calcularVolumen();
            }

        }
        return volumenTotalEnAsfalto;
    }

    public float calcularVolumenTotalTramosSinAsfalto(List<Tramo> tramos) {
        float volumenTotalSinAsfalto = 0;
        for (Tramo tramo : tramos) {
            String nombreClase = tramo.getClass().getSimpleName();
            if (nombreClase.equals("TramoSinAsfalto")) {
                volumenTotalSinAsfalto += tramo.calcularVolumen();
            }

        }
        return volumenTotalSinAsfalto;
    }

    /**
     * xFinalAuxiliar,yFinalAuxiliar son variables que se utilizaran para
     * hacer la comparacion del tramo actual con las coordenadas del tramo anterior, se comportan
     * como variables auxiliares
     * @param tramos
     * @return 
     */
    public boolean validarTramosConectados(List<Tramo> tramos) {
        int xFinalAuxiliar = 0;
        int yFinalAuxiliar = 0;

        for (int i = 0; i < tramos.size(); i++) {
            if (i > 0) {
                if (xFinalAuxiliar != tramos.get(i).getxInicial() || yFinalAuxiliar != tramos.get(i).getyInicial()) {
                    return false;
                }
            }
            xFinalAuxiliar = tramos.get(i).getxFinal();
            yFinalAuxiliar = tramos.get(i).getyFinal();

        }
        return true;
    }
}
