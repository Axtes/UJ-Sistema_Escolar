package Viewer;

import Control.Gerenciar;

import java.util.Scanner;

public class Menus {
    private static Scanner leitor = new Scanner(System.in);
    Gerenciar gerenciar = new Gerenciar();
    int op;

    public void menuCadastro() {
        do {
            System.out.println("""
                ****************************************
                *                                      *
                * 1 - Cadastrar Usuario                *
                * 2 - Cadastrar Curso                  *
                * 3 - Cadastrar Disciplina             *
                * 4 - Sair                             *
                *                                      *
                * Digite uma opção:                    *
                ****************************************
                """);

            op = leitor.nextInt();
            leitor.nextLine();

            switch (op) {
                case 1 -> gerenciar.cadastrarUsuario();
                case 2 -> gerenciar.cadastrarCurso();
                case 3 -> gerenciar.cadastrarDisciplina();
                case 4 -> System.out.println("Voltando ao menu principal...");
                default -> System.out.println("Opção Inválida! Digite um número ente 1 e 4");
            }
        } while (op != 4);
    }

    public void menuListagem() {
        do {

            System.out.println("""
                ****************************************
                *                                      *
                * 1 - Listar Alunos                    *
                * 2 - Listar Cursos                    *
                * 3 - Listar Professores               *
                * 4 - Listar Disciplinas               *
                * 5 - Listar Turmas                    *
                * 6 - Sair                             *
                *                                      *
                * Digite uma opção:                    *
                ****************************************
                """);
            op = leitor.nextInt();
            leitor.nextLine();

            switch (op) {
                case 1 -> gerenciar.listarAlunos();
                case 2 -> gerenciar.listarCursos();
                case 3 -> gerenciar.listarProfessores();
                case 4 -> gerenciar.listarDisciplinas();
                case 5 -> gerenciar.listarTurmas();
                case 6 -> System.out.println("Voltando ao menu");
                default -> System.out.println("Opção Inválida! Digite um número ente 1 e 9");
            }
        } while (op != 6);
    }
}
