package Model;

public class Disciplina {
    private Long id;
    private static Long autoId;
    private String nome;
    private String codDisciplina;
    private StatusDeConclusao statusDeConclusao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getcodDisciplina() {
        return codDisciplina;
    }

    public void setcodDisciplina(String codDisciplina) {
        this.codDisciplina = codDisciplina;
    }

    public StatusDeConclusao getStatusDeConclusao() {
        return statusDeConclusao;
    }

    public void setStatusDeConclusao(StatusDeConclusao statusDeConclusao) {
        this.statusDeConclusao = statusDeConclusao;
    }
}
