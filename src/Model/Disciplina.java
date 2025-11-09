package Model;

public class Disciplina {
    private String nome;
    private Integer codDisciplina;
    private StatusDeConclusao statusDeConclusao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getcodDisciplina() {
        return codDisciplina;
    }

    public void setcodDisciplina(Integer codDisciplina) {
        this.codDisciplina = codDisciplina;
    }

    public StatusDeConclusao getStatusDeConclusao() {
        return statusDeConclusao;
    }

    public void setStatusDeConclusao(StatusDeConclusao statusDeConclusao) {
        this.statusDeConclusao = statusDeConclusao;
    }
}
