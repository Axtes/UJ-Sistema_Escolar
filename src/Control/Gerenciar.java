package Control;

import Model.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Gerenciar {
    private Scanner leitor = new Scanner(System.in);
    private Usuario usuario;
    private Curso curso;

    public void cadastrarUsuario() {
        System.out.println("Por favor digite o seu nome");
        String entrada;
        entrada = leitor.nextLine();
        usuario.setNome(entrada);

        System.out.println("Por favor digite a sua senha");
        entrada = leitor.nextLine();
        usuario.setSenha(entrada);

        System.out.print("Digite a sua data de nascimento no formato (dd/MM/yyyy): ");
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataDeNascimentoStr;
        dataDeNascimentoStr = leitor.nextLine().replaceAll("(\\d{2})(\\d{2})(\\d{4})", "$1/$2/$3");
        LocalDate dataDeNascimento = LocalDate.parse(dataDeNascimentoStr, formato);
        usuario.setDataDeNascimento(dataDeNascimento);

        System.out.println("Digite o seu CPF somente com números!");
        entrada = leitor.nextLine();
        usuario.setCpf(entrada);

        System.out.println("Digite o seu email!");
        entrada = leitor.nextLine();
        usuario.setEmail(entrada);

        System.out.println("Por fim, qual tipo de usuário você é? Digite 'p' para Professor e 'a' para Aluno!");
        String tipoUsuario;
        tipoUsuario = leitor.nextLine();

        if (tipoUsuario.equalsIgnoreCase("P")) {
            usuario.setTipoUsuario(TipoUsuario.PROFESSOR);
            usuario = new Professor();
        } else if (tipoUsuario.equalsIgnoreCase("A")) {
            usuario.setTipoUsuario(TipoUsuario.ALUNO);
            Aluno aluno = new Aluno();
            usuario.manterDados(aluno);
            usuario = aluno;
            aluno.gerarMatricula();
        }

        System.out.println("Cadastrado Realizado com Sucesso!!");
    }

    public void cadastrarCurso() {
        System.out.println("Digite o nome do curso: ");
        String entrada;
        entrada = leitor.nextLine();
        curso.setNome(entrada);
    }

    public void cadastrarDisciplina(Disciplina disciplina) {
        int contador = 1;
        System.out.println("Digite o nome da disciplina: ");
        String nome;
        nome = leitor.nextLine();
        disciplina.setNome(nome);

        disciplina.setcodDisciplina(String.format("D%d03d", contador));
        contador++;
    }
}
