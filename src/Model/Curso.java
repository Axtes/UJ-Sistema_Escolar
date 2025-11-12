package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Curso {
    private Long id;
    private static Long autoId = 1L;
    private String nome;
    private List<Professor> professores = new ArrayList<>();
    private List<Aluno> alunos = new ArrayList<>();
    private List<Turma> turmas = new ArrayList<>();
    private List<Disciplina> disciplinas = new ArrayList<>();
    private String codigoCurso;
    private Integer semestre;

    public Curso() {
        this.id = autoId++;
    }

    public void gerarCodigo() {
        String iniciais = "";
        String[] espacos = getNome().split(" ");
        for (String letras : espacos) {
            if (!letras.isEmpty()) {
                iniciais += letras.charAt(0);
            }
        }
        codigoCurso = iniciais.toUpperCase() + String.format("%03d",getId());
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

    public List<Professor> getProfessores() {
        return professores;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    @Override
    public String toString() {
        return """
                Curso | Semestres | Código do Curso
                %s      %d          %s
                """.formatted(getNome(), getSemestre(), getCodigoCurso());
    }
}
