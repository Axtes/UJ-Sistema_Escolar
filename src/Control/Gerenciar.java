package Control;

import Model.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Gerenciar {
    private Scanner leitor = new Scanner(System.in);
    private Usuario usuario = new Usuario();
    private Curso curso = new Curso();
    private Disciplina disciplina = new Disciplina();
    private Turma turma = new Turma();
    private List<Curso> cursos = new ArrayList<>();
    private List<Professor> professores = new ArrayList<>();
    private List<Aluno> alunos = new ArrayList<>();
    private List<Disciplina> disciplinas = new ArrayList<>();
    private List<Turma> turmas = new ArrayList<>();

    public void cadastrarUsuario() {
        if (cursos.isEmpty()){
            System.out.println("Por-favor, cadastre um curso antes de cadastrar um usuário!");
        } else {
            String termoBusca;
            System.out.println("Por favor digite o nome");
            String entrada;
            entrada = leitor.nextLine();
            usuario.setNome(entrada);

            System.out.println("Por favor a senha");
            entrada = leitor.nextLine();
            usuario.setSenha(entrada);

            System.out.print("Digite a data de nascimento no formato somente com números!: ");
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String dataDeNascimentoStr;
            dataDeNascimentoStr = leitor.nextLine().replaceAll("(\\d{2})(\\d{2})(\\d{4})", "$1/$2/$3");
            LocalDate dataDeNascimento = LocalDate.parse(dataDeNascimentoStr, formato);
            usuario.setDataDeNascimento(dataDeNascimento);

            System.out.println("Digite o CPF somente com números!");
            entrada = leitor.nextLine();
            usuario.setCpf(entrada);

            System.out.println("Digite o email!");
            entrada = leitor.nextLine();
            usuario.setEmail(entrada);

            System.out.println("Por fim, qual tipo de usuário será? Digite 'p' para Professor e 'a' para Aluno!");
            String tipoUsuario = leitor.nextLine();

            if (tipoUsuario.equalsIgnoreCase("P")) {
                usuario.setTipoUsuario(TipoUsuario.PROFESSOR);
                Professor professor = new Professor();
                usuario.manterDados(professor);
                usuario = professor;
                professor.gerarMatricula();
                System.out.println("Qual o nível de formação acâdemica?");
                System.out.println("""
                          *************************
                          * 1 - DOUTOR(A)         *
                          * 2 - MESTRE(A)         *
                          * 3 - ESPECIALISTA      *
                          * 4 - GRADUADO(A)       *
                          *************************
                        """);
                int op;
                try {
                    op = leitor.nextInt();
                    leitor.nextLine();
                    switch (op) {
                        case 1 -> professor.setTitulacao(Titulacao.DOUTOR);
                        case 2 -> professor.setTitulacao(Titulacao.MESTRE);
                        case 3 -> professor.setTitulacao(Titulacao.ESPECIALISTA);
                        case 4 -> professor.setTitulacao(Titulacao.GRADUADO);
                        default -> System.out.println("Opção inválida! Digite o número correspondente a formação!");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida! Digite um número inteiro entre 1 e 4!");
                    leitor.nextLine();
                }

                System.out.println("E ele será professor(a) de quais cursos? Digite o código do curso para adicionar ou 'sair' para encerrar)");
                cursos.forEach(System.out::println);

                do {
                    termoBusca = leitor.nextLine();
                    for (Curso c : cursos) {
                        if (termoBusca.isBlank() || termoBusca.matches("\\d+")) {
                            System.out.println("Entrada inválida! Por-favor, digite corretamente o código do curso!");
                            termoBusca = leitor.nextLine();
                        } else if (c.getCodigoCurso().equalsIgnoreCase(termoBusca)) {
                            professor.getCursos().add(c);
                            turma.gerarCodigoTurma();
                            professor.getTurmas().add(turma);
                            System.out.println("Adicionado ao curso!");
                            System.out.println("E ele será de mais algum curso?(Digite 'Sair' para terminar!): ");
                            cursos.forEach(System.out::println);
                        }
                    }
                } while (!termoBusca.equalsIgnoreCase("sair"));
                professores.add(professor);

            } else if (tipoUsuario.equalsIgnoreCase("A")) {
                usuario.setTipoUsuario(TipoUsuario.ALUNO);
                Aluno aluno = new Aluno();
                usuario.manterDados(aluno);
                usuario = aluno;
                aluno.gerarMatricula();
                System.out.println("E de qual curso será? (Digite pelo código do curso!)");
                cursos.forEach(System.out::println);
                termoBusca = leitor.nextLine();

                for (Curso c : cursos) {
                    if (termoBusca.isBlank() || termoBusca.matches("\\d+")) {
                        System.out.println("Entrada inválida! Por-favor, digite corretamente o código do curso!");
                    } else if (c.getCodigoCurso().equalsIgnoreCase(termoBusca)) {
                        aluno.setCurso(c);

                        if (turma.getAlunos().size() <= turma.getQtdAlunosMax()) {
                            c.getTurmas().add(turma);
                            turma.getAlunos().add(aluno);
                            aluno.setTurma(turma);
                            alunos.add(aluno);
                            turmas.add(turma);
                        } else {
                            Turma turmaNova = new Turma();
                            c.getTurmas().add(turmaNova);
                            turmaNova.getAlunos().add(aluno);
                            aluno.setTurma(turmaNova);
                            alunos.add(aluno);
                            turmas.add(turmaNova);
                        }
                    }
                }
            }

            System.out.println("Cadastrado Realizado com Sucesso!!");
        }
    }

    public void cadastrarCurso() {
        System.out.println("Digite o nome do curso: ");
        String entrada;
        entrada = leitor.nextLine();
        curso.setNome(entrada);
        curso.gerarCodigo();
        System.out.println("Agora digite quantos semestres tem esse curso");

        try {
            Integer semestres = leitor.nextInt();
            leitor.nextLine();
            curso.setSemestre(semestres);
            System.out.println("Semestres alocados!");
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida! Digite somente números inteiros!!");
            leitor.nextLine();
        }
        cursos.add(curso);
    }

    public void cadastrarDisciplina() {
        if (cursos.isEmpty()) {
            System.out.println("Por-favor, cadastre um curso antes de cadastrar um disciplina!");
        } else {
            String termoBusca;
            System.out.println("Digite o nome da disciplina: ");
            String entrada;
            entrada = leitor.nextLine();
            disciplina.setNome(entrada);
            disciplina.gerarCodigoDisciplina();

            System.out.println("Essa disciplina pertence a quais cursos? (Digite sair para encerrar!): ");
            cursos.forEach(System.out::println);

            do {
                termoBusca = leitor.nextLine();
                for (Curso c : cursos) {
                    if (termoBusca.isBlank() || termoBusca.matches("\\d+")) {
                        System.out.println("Entrada inválida! Por-favor, digite corretamente o código do curso!");
                    } else if (c.getCodigoCurso().equalsIgnoreCase(termoBusca)) {
                        disciplina.getCursos().add(c);
                        curso.getDisciplinas().add(disciplina);

                        disciplina.adicionarHorario();

                        System.out.println("A qual semestre é recomendada?: ");
                        int semestre = leitor.nextInt();
                        leitor.nextLine();
                        boolean entradaValida = false;

                        while (!entradaValida) {
                            if (semestre > c.getSemestre() || semestre < 1) {
                                System.out.println("Semestre inválido! Digite um semestre válido!");
                                semestre = leitor.nextInt();
                                leitor.nextLine();
                            } else {
                                disciplina.setSemestre(semestre);
                                entradaValida = true;
                                System.out.println("Adicionado ao curso!");
                                System.out.println("E ela será de mais algum curso?(Digite 'Sair' para terminar!): ");
                                cursos.forEach(System.out::println);
                            }
                        }
                    }
                }
            } while (!termoBusca.equalsIgnoreCase("sair"));

            disciplinas.add(disciplina);
        }
    }

    public void listarProfessores() {
        if(professores.isEmpty()) {
            System.out.println("A lista de professores está vazia, por-favor cadastre um novo para ser listado!");
        } else {
            professores.forEach(System.out::println);
        }
    }

    public void listarAlunos(){
        if(alunos.isEmpty()) {
            System.out.println("A lista de alunos está vazia, por-favor cadastre um novo para ser listado!");
        } else {
            alunos.forEach(System.out::println);
        }
    }

    public void listarDisciplinas(){
        if(disciplinas.isEmpty()) {
            System.out.println("A lista de disciplinas está vazia, por-favor cadastre um novo para ser listado!");
        } else {
            disciplinas.forEach(System.out::println);
        }
    }

    public void listarCursos(){
        if (cursos.isEmpty()) {
            System.out.println("A lista de cursos está vazia, por-favor cadastre um novo para ser listado!");
        } else {
            cursos.forEach(System.out::println);
        }
    }

    public void listarTurmas(){
        if (turmas.isEmpty()) {
            System.out.println("A lista de turmas está vazia, por-favor cadastre um novo para ser listado!");
        } else {
            turmas.forEach(System.out::println);
        }
    }

    public void lancarNotas() {
        Scanner scanner = new Scanner(System.in);
        Nota notaControl = new Nota();

        System.out.println("***** LANÇAMENTO-DE-NOTAS *****");
        System.out.print("Digite o nome do aluno: ");
        alunos.forEach(System.out::println);

        String nomeAluno = scanner.nextLine();

        Aluno alunoSelecionado = null;
        for (Aluno a : alunos) {
            if (a.getNome().equalsIgnoreCase(nomeAluno)) {
                alunoSelecionado = a;
                break;
            }
        }

        System.out.print("Digite o nome da disciplina: ");
        disciplinas.forEach(System.out::println);
        String nomeDisciplina = scanner.nextLine();

        Disciplina disciplinaSelecionada = null;
        for (Disciplina d : disciplinas) {
            if (d.getNome().equalsIgnoreCase(nomeDisciplina)) {
                disciplinaSelecionada = d;
                break;
            }
        }

        if (alunoSelecionado == null || disciplinaSelecionada == null) {
            System.out.println("Aluno ou disciplina não definidos!");
            return;
        }

        List<Double> notas = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            System.out.print("Nota " + i + ": ");
            double nota = scanner.nextDouble();
            notaControl.lancarNota(disciplinaSelecionada, alunoSelecionado, nota);
        }

        double media = notaControl.calcularMedia(disciplinaSelecionada, alunoSelecionado);
        System.out.printf("Média inicial: %.1f%n", media);
        System.out.println("Situação final de " + alunoSelecionado.getNome() + ": "
                + notaControl.verificarSituacao(disciplinaSelecionada, alunoSelecionado));
    }

    public void exibirNotasESituacoes(Nota sistemaNotas) {
        if (alunos.isEmpty() || disciplinas.isEmpty()) {
            System.out.println("Não há alunos ou disciplinas cadastrados!");
            return;
        }

        System.out.println("RELATÓRIO DE NOTAS\n");

        for (Disciplina d : disciplinas) {
            System.out.println(" Disciplina: " + d.getNome());

            for (Aluno a : alunos) {
                double notaFinal = sistemaNotas.calcularNotaFinal(d, a);
                String situacao = sistemaNotas.verificarSituacao(d, a);

                System.out.println("Aluno: " + a.getNome());
                System.out.println("Nota final: " + String.format("%.1f", notaFinal));
                System.out.println("Situação: " + situacao);
                System.out.println();
            }
        }
    }


}
