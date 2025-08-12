package ClasseAbstrata;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
//        Atribuindo valores
        Legume l1 = new Legume("Cenoura", false, 3, LocalDate.of(2026, 2, 26));
        Carne c1 = new Carne("Picanha", 69.99, LocalDate.of(2025, 11, 23), 2649, 2);
        Carne c2 = new Carne("Lagarto", 43.99, LocalDate.of(2010, 6, 15), 3694, 5);

//        -- CARNE --
//        valores iniciais
        System.out.println(c1);
//        cortar em 5 pedaços a mais
        c1.cortar(5); // ← aumenta o preço em R$27.99
        System.out.println(c1);

        System.out.println("\n-------------------------------------------------------");

//        -- LEGUME --
//        valores iniciais
        System.out.println(l1);
//        descascar
        l1.descascar();
        System.out.println(l1);

        System.out.println("\n-------------------------------------------------------");
//        TESTE COM VALORES VENCIDOS
//        valores iniciais
        System.out.println(c2);

//        cortar eem 10 pedaços
        c2.cortar(10);
        System.out.println(c2);
    }
}
