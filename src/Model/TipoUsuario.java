package Model;

public enum TipoUsuario {
    ADMINISTRADOR("Administrador(A)"),
    PROFESSOR("Professor(A)"),
    ALUNO("Aluno(a)");

    private final String tipo;

    TipoUsuario(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
