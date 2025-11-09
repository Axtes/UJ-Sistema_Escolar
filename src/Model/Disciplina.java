package Model;

public class Disciplina {
    private String nome;
    private String codigoDisicplina;
    private Nota nota;
    private StatusDeConclusao statusDeConclusao;

    public String getNome() {
        return nome;
    }

    public String getCodigoDisicplina() {
        return codigoDisicplina;
    }

    public Nota getNota() {
        return nota;
    }

    public StatusDeConclusao getStatusDeConclusao() {
        return statusDeConclusao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodigoDisicplina(String codigoDisicplina) {
        this.codigoDisicplina = codigoDisicplina;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public void setStatusDeConclusao(StatusDeConclusao statusDeConclusao) {
        this.statusDeConclusao = statusDeConclusao;
    }
}
