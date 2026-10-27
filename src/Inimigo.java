/**
 * Produto abstrato da Factory. O código cliente só enxerga esta classe,
 * nunca as subclasses concretas.
 */
public abstract class Inimigo {
    private final String nome;
    private int vida;
    private final int dano;

    protected Inimigo(String nome, int vida, int dano) {
        this.nome = nome;
        this.vida = vida;
        this.dano = dano;
    }

    public abstract String rugir();

    public void receberDano(int valor) {
        this.vida = Math.max(0, this.vida - valor);
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public String getNome() { return nome; }
    public int getVida() { return vida; }
    public int getDano() { return dano; }
}
