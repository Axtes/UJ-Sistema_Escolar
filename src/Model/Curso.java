package Model;

import java.util.List;

public class Curso {
    private String nome;
    private List<Professor> professores;
    private List<Aluno> alunos;
    private String codigoCurso;

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
}
