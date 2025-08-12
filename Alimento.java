package ClasseAbstrata;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public abstract class Alimento {
//    Atributos
    private String nome;
    private double custo;
    private LocalDate validade;
    protected long mesesFaltando;
    protected String classificacao;
    private String validadeFormatada;

//    Construtor
    public Alimento (String nome, double custo, LocalDate validade){
        this.nome = nome;
        this.custo = custo;
        this.validade = validade;

        this.mesesFaltando = ChronoUnit.MONTHS.between(LocalDate.now(), this.validade);
        this.classificacao = classificarValidade();
        //    FORMATADOR DE DATA
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        validadeFormatada = validade.format(dtf);
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
    public void setCusto(double custo){
        this.custo = custo;
    }
    public LocalDate getValidade(){
        return this.validade;
    }
    public long getMesesFaltando() {
        return mesesFaltando;
    }
    public String getClassificacao() {
        return classificacao;
    }

    //    Métodos
    public abstract double calcularPreco();
    public boolean verificarValidade(){
        return (this.validade.isAfter(LocalDate.now()) || this.validade.isEqual(LocalDate.now()));
    }
    public String classificarValidade(){
        if (verificarValidade()){
            if (mesesFaltando > 5){
                classificacao = "LONGE";
            } else if (mesesFaltando > 2) {
                classificacao = "MÉDIO";
            } else {
                classificacao = "PERTO";
            }
        } else {
            classificacao = "VENCIDO";
            setCusto(0);
        }

        return classificacao;
    }

    public String calculoMeses(long qtdmeses){
        if (qtdmeses < 0) {
            qtdmeses *= -1;
            return "Vencido há " + qtdmeses + " meses";
        } else {
            return mesesFaltando + " meses para o vencimento";
        }
    }

//    toString
    @Override
    public String toString() {
        return "\nNOME: " + this.nome +
                "\nCUSTO: R$" + String.format("%.2f", this.custo) +
                "\nVALIDADE: " + this.validadeFormatada +
                "\nMESES: " + calculoMeses(mesesFaltando);
    }

}