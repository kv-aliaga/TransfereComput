package Novo.ClasseAbstrata.Alimento;

import java.time.LocalDate;

public class Legume extends Alimento {
    // Atributos
    private String textura;
    private boolean descascado;
    private String classificacao = classificarValidade(super.getValidade());

//    Construtor
    public Legume (String textura, boolean descascado, String nome, double custo, LocalDate validade){
        super(nome, custo, validade);
        this.textura = textura;
        this.descascado = descascado;
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

        if (this.classificacao.equals("LONGE")){
            porcAdicional += 0.5;
        } else if (this.classificacao.equals("MÉDIO")) {
            porcAdicional += 0.3;
        } if (this.textura.equals("FIRME")) {
            porcAdicional += 0.3;
        } if (this.descascado){
            porcAdicional += 0.2;
        }

        return getCusto() * porcAdicional;
    }

    public void descascar(){
        this.descascado = true;
    }
}
