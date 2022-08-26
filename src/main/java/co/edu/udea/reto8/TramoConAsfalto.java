package co.edu.udea.reto8;

public class TramoConAsfalto extends Tramo {

    private String proveedorAsfalto;
    private int velocidadMaxima;
    private boolean permiteAdelantar;
    private final int ANCHO = 8;
    private final float ESPESOR = 0.25f;

    public TramoConAsfalto() {
    }

    public TramoConAsfalto(String proveedorAsfalto, int velocidadMaxima, boolean adelantar, int xInicial, int yInicial, int xFinal, int yFinal) throws VelocidadNegativaException {
        super(xInicial, yInicial, xFinal, yFinal);
        this.proveedorAsfalto = proveedorAsfalto;
        if (velocidadMaxima >= 0) {
            this.velocidadMaxima = velocidadMaxima;
        } else {
            throw new VelocidadNegativaException();
        }
        this.permiteAdelantar = adelantar;
    }

    public String getProveedorAsfalto() {
        return proveedorAsfalto;
    }

    public void setProveedorAsfalto(String proveedorAsfalto) {
        this.proveedorAsfalto = proveedorAsfalto;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(int velocidadMaxima) throws VelocidadNegativaException {
        if (velocidadMaxima >= 0) {
            this.velocidadMaxima = velocidadMaxima;
        } else {
            throw new VelocidadNegativaException();
        }
    }

    public boolean isAdelantar() {
        return permiteAdelantar;
    }

    public void setAdelantar(boolean adelantar) {
        this.permiteAdelantar = adelantar;
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
