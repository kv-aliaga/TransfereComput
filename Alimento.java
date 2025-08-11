package Novo.ClasseAbstrata.Alimento;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Alimento {
//    Atributos
    private String nome;
    private double custo;
    private LocalDate validade;
    private long mesesFaltando = ChronoUnit.MONTHS.between(LocalDate.now(), this.validade);

//    Construtor
    public Alimento (String nome, double custo, LocalDate validade){
        this.nome = nome;
        this.custo = custo;
        this.validade = validade;
    }

//    Métodos Getters e Setters
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public double getCusto(){
        return this.custo;
    }
    public LocalDate getValidade(){
        return this.validade;
    }

//    Métodos
    public abstract double calcularPreco();

    public boolean verificarValidade(){
        return (this.validade.isAfter(LocalDate.now()) || this.validade.isEqual(LocalDate.now()));
    }

    public String classificarValidade(LocalDate validade){
        if (mesesFaltando > 5){
            return "LONGE";
        } else if (mesesFaltando > 2) {
            return "MÉDIO";
        } else {
            return "PERTO";
        }
    }
}