package ClasseAbstrata;

import java.time.LocalDate;

public class Carne extends Alimento{
//    Criando atributos
    private double peso;
    private int pedacos;

//    Construtor
    public Carne (String nome, double custo, LocalDate validade, double peso, int pedacos){
        super(nome, custo, validade);
        this.peso = peso;
        this.pedacos = pedacos;

        calcularPreco();
    }

//    métodos getters e setters
    public double getPeso(){
        return this.peso;
    }
    public int getPedacos(){
        return this.pedacos;
    }

//    métodos
    public void cortar (int qtdCortes) {
        double porcAdicional = 1;
        this.pedacos += qtdCortes;

        for (int i = 0; i < qtdCortes; i++){
           porcAdicional += 0.05;
        }
        setCusto(getCusto() * porcAdicional);
    }

    @Override
    public double calcularPreco() {
        if (getClassificacao().equals("VENCIDO")) {
            setCusto(0);
            return getCusto();
        }

        double porcAdicional = 1;
        double precoAdicional;

        if (getClassificacao().equals("LONGE")){
            porcAdicional += 0.5;
        } else if (getClassificacao().equals("MÉDIO")) {
            porcAdicional += 0.3;
        } for (int i = 0; i < this.pedacos; i++){
            porcAdicional += 0.05;
        }
        precoAdicional = this.peso * 0.01;

        setCusto((getCusto() + precoAdicional) * porcAdicional);
        return getCusto();
    }

    // toString

    @Override
    public String toString() {
        return super.toString() +
                "\nPESO: " + ((this.peso < 1000) ? (this.peso + "g") : (String.format("%.2f", (this.peso / 1000)) + "kg")) +
                "\nPEDAÇOS: " + this.pedacos;
    }
}
