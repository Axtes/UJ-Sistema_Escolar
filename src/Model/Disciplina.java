package Model;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Disciplina implements Horario {
    private Long id;
    private static Long autoId = 1L;
    private String nome;
    private String codDisciplina;
    private Integer semestre;
    private StatusDeConclusao statusDeConclusao;
    private Curso curso = new Curso();
    private List<Curso> cursos = new ArrayList<>();
    private LocalTime horario;

    public Disciplina() {
        this.id = autoId++;
    }

    public void gerarCodigoDisciplina() {
        String iniciais = "";
        String[] espacos = getNome().split(" ");
        for (String letras : espacos) {
            if (!letras.isEmpty()) {
                iniciais += letras.charAt(0);
            }
        }

        setCodDisciplina(iniciais.toUpperCase()+String.format("%03d",getId()));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodDisciplina() {
        return codDisciplina;
    }

    public void setCodDisciplina(String codDisciplina) {
        this.codDisciplina = codDisciplina;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public StatusDeConclusao getStatusDeConclusao() {
        return statusDeConclusao;
    }

    public void setStatusDeConclusao(StatusDeConclusao statusDeConclusao) {
        this.statusDeConclusao = statusDeConclusao;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return """
                Nome da disciplina: %s | Código da disciplina: %s | Horário: %s
                """.formatted(getNome(), getCodDisciplina(), getHorario());
    }

    @Override
    public LocalTime adicionarHorario() {
        Scanner leitor = new Scanner(System.in);
        String horario = "";

        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                System.out.println("Qual o horário dessa disciplina?(Formato: 0000 -> 00:00): ");
                horario = leitor.nextLine();
                if (horario.matches("^\\d{3,4}$")) {
                    if (horario.length() == 3) {
                        horario = "0" + horario;
                    }
                    horario = horario.substring(0, 2) + ":" + horario.substring(2);
                } else {
                    System.out.println("Horário digitado inválido, por-favor digite o horário corretamente!(Formato: 0000 -> 00:00)");
                    horario = leitor.nextLine();
                }
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Caracteres inválidos, digite novamente por-favor");
            }
            entradaValida = true;
        }
        DateTimeFormatter horarioFormato = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime horarioAdicionado;
        horarioAdicionado = LocalTime.parse(horario, horarioFormato);
        setHorario(horarioAdicionado);
        return getHorario();
    }
}
