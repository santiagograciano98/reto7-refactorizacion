package co.edu.udea.reto8;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            Carretera miCarretera = new Carretera();
            Tramo tramo = new TramoConAsfalto("ARGOS", 40, true, 0, 0, 8, 0);
            Tramo tramo2 = new TramoConAsfalto("ARGOS", 20, true, 8, 0, 16, 0);
            Tramo tramo3 = new TramoSinAsfalto("Piedra", 2.5f, 16, 0, 20, -12);
            Tramo tramo4 = new TramoConAsfalto("ARGOS", 50, false, 20, -12, 25, -15);
            Tramo tramo5 = new TramoSinAsfalto("Arena", 4.5f, 25, -15, 25, -30);
            Tramo tramo6 = new TramoSinAsfalto("Balastro", 3.0f, 25, -30, 18, -32);
            Tramo tramo7 = new TramoConAsfalto("ARGOS", 70, true, 18, -32, 8, -20);
            
            List<Tramo> carretera = new ArrayList<>();
            carretera.add(tramo);
            carretera.add(tramo2);
            carretera.add(tramo3);
            carretera.add(tramo4);
            carretera.add(tramo5);
            carretera.add(tramo6);
            carretera.add(tramo7);
            miCarretera.setListaTramos(carretera);

            for (int i = 0; i < carretera.size(); i++) {
                System.out.println("La longitud del tramo " + (i+1) + " es: " + carretera.get(i).calcularLongitud());
                System.out.println("El area del tramo " + (i +1) + " es: " + carretera.get(i).calcularArea());
                System.out.println("El volumen del tramo " + (i + 1) + " es: " + carretera.get(i).calcularVolumen());
                System.out.println("------------------------------------------------------");
            }

            float totalPerimetro = miCarretera.calcularLongitudTotal(carretera);
            System.out.println("El perimetro total de la carretera es: " + totalPerimetro);
            float totalArea = miCarretera.calcularAreaTotalDeCarretera(carretera);
            System.out.println("El area total de la carretera es: " + totalArea);
            float volumenTotal = miCarretera.calcularVolumenTotal(carretera);
            System.out.println("El volumen total de material a utilizar en la carretera es: " + volumenTotal);
            float volumenTotalEnAsfalto = miCarretera.calcularVolumenTotalTramosConAsfalto(carretera);
            System.out.println("El volumen total de asfalto a utilizar en la carretera es: " + volumenTotalEnAsfalto);
            float volumenTotalSinAsfalto = miCarretera.calcularVolumenTotalTramosSinAsfalto(carretera);
            System.out.println("El volumen total a utilizar en tramos sin asfalto es: " + volumenTotalSinAsfalto);
            System.out.println("");
            
            if (miCarretera.validarTramosConectados(carretera)) {
                System.out.println("Todos los tramos de la carretera estan conectados");
            } else {
                System.out.println("Los tramos de la carretera no estan conectados");
            }
            
        } catch (VelocidadNegativaException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
