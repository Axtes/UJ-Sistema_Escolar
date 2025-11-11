package Viewer;

import Control.Gerenciar;

import java.util.Scanner;

public class AppUJ {
    public static void main(String[] args) {
//        Usuario usuario = new Usuario();
//
//        usuario.cadastrarUsuario();
        Gerenciar gerenciar = new Gerenciar();
        int opcao = 0;
        Scanner leitor = new Scanner(System.in);

        do {
            boolean entradaValida = false;

            while (!entradaValida) {
                try {
                    System.out.println("""
                ****************************************
                *                                      *
                * 1 - Cadastrar                        *
                * 2 - Listagem                         *
                * 3 - Sair                             *
                *                                      *
                * Digite uma opção:                    *
                ****************************************
                """);

                    opcao = leitor.nextInt();
                    entradaValida = true;

                } catch (NumberFormatException e) {
                    System.out.println("Erro! Por favor, digite apenas números inteiros entre 1 e 3");
                }
            }

            switch (opcao) {
                case 1 -> gerenciar.cadastrarUsuario();
            }

        }while (opcao != 9);
    }
}