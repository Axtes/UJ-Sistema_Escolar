package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Turma {
    private Long id;
    private static Long autoId = 1L;
    private String codTurma;
    private Curso curso;
    private Integer semestre;
    private List<Aluno> alunos = new ArrayList<>();
    private Integer quantidadeAlunos;
    private final Integer qtdAlunosMax = 50;

    public Turma() {
        this.id = autoId++;
        gerarCodigoTurma();
    }

    public void gerarCodigoTurma() {
        LocalDate anoAtual = LocalDate.now();
        int mes = anoAtual.getMonthValue();
        int semestre = (mes <= 6) ? 1 : 2;
        codTurma = anoAtual.getYear() + String.format("%03d", semestre) + getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodTurma() {
        return codTurma;
    }

    public void setCodTurma(String codTurma) {
        this.codTurma = codTurma;
    }

    public Integer getQuantidadeAlunos() {
        return getAlunos().size();
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Integer getQtdAlunosMax() {
        return qtdAlunosMax;
    }

    @Override
    public String toString() {
        return """
                Turma: %s | Curso: %s | Semestre: %d | Quantidade de Alunos: %d
                """.formatted(getCodTurma(), getCurso(), getSemestre(), getQuantidadeAlunos());
    }
}
