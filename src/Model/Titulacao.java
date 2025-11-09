package Model;

public enum Titulacao {
    DOUTOR("Doutor(a)"),
    MESTRE("Mestre(a)"),
    ESPECIALISTA("Especialista"),
    GRADUADO("Graduado(a)");


    private final String titulo;

    Titulacao(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }
}
