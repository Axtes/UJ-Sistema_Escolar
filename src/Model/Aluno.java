package Model;

import java.time.LocalDate;

public class Aluno extends Usuario {
    private String matricula;
    private Nota nota;
    private Curso curso;
    private Integer semestre;
    private Turma turma;

    public void gerarMatricula() {
        LocalDate anoAtual = LocalDate.now();
        matricula = "" + anoAtual.getYear()+getId();
    }
    
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    
    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
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

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    @Override
    public String toString() {
        return """
                Nome: %s | Curso: %s | Matrícula: %s
                """.formatted(getNome(), getCurso().getNome(), getMatricula());
    }
}
