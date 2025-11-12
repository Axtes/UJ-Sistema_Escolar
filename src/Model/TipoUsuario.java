package Model;

public enum TipoUsuario {
    ADMINISTRADOR("Administrador(a)"),
    PROFESSOR("Professor(a)"),
    ALUNO("Aluno(a)");

    private final String tipo;

    TipoUsuario(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
