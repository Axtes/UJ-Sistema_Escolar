package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Professor extends Usuario {
    private String matricula;
    private Titulacao titulacao;
    private List<Disciplina> disciplinas = new ArrayList<>();
    private List<Turma> turmas = new ArrayList<>();
    private List<Curso> cursos = new ArrayList<>();

    public void gerarMatricula() {
        LocalDate anoAtual = LocalDate.now();
        matricula = "" + anoAtual.getYear() + getId();
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    public Titulacao getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(Titulacao titulacao) {
        this.titulacao = titulacao;
    }
    
    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    @Override
    public String toString() {
        return """
                %s
                Nome: %s | Título: %s | Matrícula: %s
                """.formatted(getTipoUsuario(), getNome(), getTitulacao(), getMatricula());
    }
}
