package Control;

import Model.Aluno;
import Model.Disciplina;
import Model.Professor;

import java.util.Scanner;

public class Gerenciar {

    public void cadastrarDisciplina(Disciplina disciplina) {
        Scanner scanner = new Scanner(System.in);
        int contador = 1;

        System.out.println("Digite o nome da disciplina: ");
        String nome;
        nome = scanner.nextLine();
        disciplina.setNome(nome);

        Disciplina.getcodDisciplina = String.format("D%03d", contador++);
    }
}
