
public class Pessoa {
    private String nome;
    private double notaEtapa1;
    private double notaEtapa2;

    public Pessoa(String nome, double notaEtapa1, double notaEtapa2) {
        this.nome = nome;
        this.notaEtapa1 = notaEtapa1;
        this.notaEtapa2 = notaEtapa2;
    }

    public String getNome() {
        return nome;
    }

    public double getMedia() {
        return (notaEtapa1 + notaEtapa2) / 2.0;
    }

    public boolean isAprovado() {
        return getMedia() >= 70.0;
    }

    @Override
    public String toString() {
        return String.format("%s, %.1f, %.1f, MEDIA = %.2f", nome, notaEtapa1, notaEtapa2, getMedia());
    }
}
