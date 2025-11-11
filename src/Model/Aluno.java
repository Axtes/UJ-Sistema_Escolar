package Model;

import Control.Usuario;

import java.time.LocalDate;

public class Aluno extends Usuario {
    private Long matricula;
    private Nota nota;
    private Curso curso;
    private Integer semestre;

    public void gerarMatricula() {
        LocalDate anoAtual = LocalDate.now();
        matricula = anoAtual.getYear() + getId();
    }

    
    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
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


}
