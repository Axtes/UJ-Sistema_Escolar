package Model;

public enum StatusDeConclusao {
    APROVADO("Aprovado(a)"),
    REPROVADO("Reprovado(a)"),
    EM_ANDAMENTO("Em andamento"),
    TRANCADO("Trancado"),
    DISPENSADO("Dispensado(a)");

    private final String status;

    StatusDeConclusao(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
