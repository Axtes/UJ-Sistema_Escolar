package Model;

public class Turma {
    private Long codTurma;
    private Integer quantidadeAlunos;
    private String curso;

    public Long getCodTurma() {
        return codTurma;
    }

    public void setCodTurma(Long codTurma) {
        this.codTurma = codTurma;
    }

    public Integer getQuantidadeAlunos() {
        return quantidadeAlunos;
    }

    public void setQuantidadeAlunos(Integer quantidadeAlunos) {
        this.quantidadeAlunos = quantidadeAlunos;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

}
