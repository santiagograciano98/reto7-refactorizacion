package co.edu.udea.reto8;

public class VelocidadNegativaException extends Exception{
    
    public VelocidadNegativaException(){
        super("El limite de velocidad no puede ser negativo");
    }
    
}
