package Model;

import java.util.List;
import java.util.Scanner;

public class Curso {
    private Long id;
    private static Long autoId = 1L;
    private String nome;
    private List<Professor> professores;
    private List<Aluno> alunos;
    private String codigoCurso;
    private Scanner leitor = new Scanner(System.in);

    public Curso() {
        setId(autoId++);
    }

    public void gerarCodigo() {
        String iniciais = "";
        String[] espacos = getNome().split(" ");
        for (String letras : espacos) {
            if (!letras.isEmpty()) {
                iniciais += letras.charAt(0);
            }
        }
        codigoCurso = iniciais + "000" + getId();
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
}
