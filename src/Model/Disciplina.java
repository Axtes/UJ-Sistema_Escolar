package Model;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private Long id;
    private static Long autoId = 1L;
    private String nome;
    private String codDisciplina;
    private Integer semestre;
    private StatusDeConclusao statusDeConclusao;
    private Curso curso = new Curso();
    private List<Curso> cursos = new ArrayList<>();

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
}
