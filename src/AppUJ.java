import Viewer.Menus;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AppUJ {
    public static void main(String[] args) {
        int opcao = 0;
        Scanner leitor = new Scanner(System.in);
        Menus menus = new Menus();

        do {
                try {
                System.out.println("""
                ****************************************
                *                                      *
                * 1 - Cadastrar                        *
                * 2 - Listagem                         *
                * 3 - Sistema de Notas                 *
                * 4 - Sair                             *
                *                                      *
                * Digite uma opção:                    *
                ****************************************
                """);

                    opcao = leitor.nextInt();
                    leitor.nextLine();

                } catch (InputMismatchException e) {
                    System.out.println("Erro! Por favor, digite apenas números inteiros entre 1 e 3");
                    leitor.nextLine();
                }

            switch (opcao) {
                case 1 -> menus.menuCadastro();
                case 2 -> menus.menuListagem();
                case 3 -> menus.menuNotas();
                case 4 -> System.out.println("Encerrando a aplicação...");
                default -> System.out.println("Entrada Inválida! Por favor, digite apenas números inteiros entre 1 e 3");
            }

        }while (opcao != 4);
        leitor.close();
    }
}