package Models;

public class Farenheith extends Grado{

    public Farenheith(Double valor) {

       this.setValor(valor);
        this.setUnidad("F");

    }

    public Farenheith parse(Celsius C){
        Double valor=(C.getValor()-32)*5/9;
        return new  Farenheith(valor);
    }

    public Farenheith parse (Kelvin K){
        Double valor=(K.getValor()-32)*5/9+273.15;
        return new Farenheith(valor);
    }
}
