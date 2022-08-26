package co.edu.udea.reto8;

public class TramoSinAsfalto extends Tramo {

    private String tipoMaterial;
    private float espesorMaterial;
    private final int ANCHO = 6;
    private final float ESPESOR = 0.25f;

    public TramoSinAsfalto() {
    }

    public TramoSinAsfalto(String tipoMaterial, float espesorMaterial, int xInicial, int yInicial, int xFinal, int yFinal) {
        super(xInicial, yInicial, xFinal, yFinal);
        this.tipoMaterial = tipoMaterial;
        this.espesorMaterial = espesorMaterial;
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public float getEspesorMaterial() {
        return espesorMaterial;
    }

    public void setEspesorMaterial(float espesorMaterial) {
        this.espesorMaterial = espesorMaterial;
    }
    
    @Override
    public float calcularLongitud() {
        float longitudRectangulo = (float) Math.sqrt(Math.pow((this.xFinal - this.xInicial), 2) + Math.pow((this.yFinal - this.yInicial), 2));
        return longitudRectangulo;
    }

    @Override
    public float calcularArea() {
        float areaRectangulo = this.ANCHO * calcularLongitud();
        return areaRectangulo;
    }

    @Override
    public float calcularVolumen() {
        float volRectangulo = calcularArea() * ESPESOR;
        return volRectangulo;
    }

}
