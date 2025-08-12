package ClasseAbstrata;

import java.time.LocalDate;

public class Legume extends Alimento {
    // Atributos
    private String textura;
    private boolean descascado;

//    Construtor
    public Legume (String nome, boolean descascado, double custo, LocalDate validade){
        super(nome, custo, validade);
        this.textura = "Áspera";
        this.descascado = descascado;

        calcularPreco();
    }
//    Métodos Getters e Setters
    public String getTextura(){
        return this.textura;
    }
    public boolean getDescascado(){
        return this.descascado;
    }

//    Métodos
    public double calcularPreco() {
        double porcAdicional = 1;

        if (getClassificacao().equals("LONGE")){
            porcAdicional += 0.5;
        } else if (getClassificacao().equals("MÉDIO")) {
            porcAdicional += 0.3;
        } if (this.textura.equals("Lisa")) {
            porcAdicional += 0.3;
        } if (this.descascado){
            porcAdicional += 0.2;
        }

        setCusto(getCusto() * porcAdicional);
        return getCusto();
    }

    public void descascar(){
        if(!this.descascado){
            this.descascado = true;
            this.textura = "Lisa";

            setCusto(getCusto() * 1.2);
        }
    }

//    ToString
    @Override
    public String toString() {
        return super.toString() +
                "\nTEXTURA: " + this.textura +
                "\nDESCASCADO: " + (this.descascado ? "Sim" : "Não");
    }
}
