package Models;

public class Celsius extends Grado{
    public Celsius(Double valor) {

        this.setValor(valor);
        this.setUnidad("C");
    }

    public Celsius parse (Farenheith F){
        Double valor=(F.getValor()*9/5)+32;
        return new Celsius(valor);
    }

    public Celsius parse (Kelvin K){
        Double valor=(K.getValor()+273.15);
        return new Celsius(valor);
    }
}
