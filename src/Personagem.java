import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Padrão BUILDER: Personagem é um objeto complexo com muitos atributos,
 * alguns opcionais. O Builder interno permite montá-lo passo a passo,
 * de forma fluente, e valida tudo antes de criar o objeto final.
 */
public class Personagem {

    private final String nome;
    private final ClassePersonagem classe;
    private final int nivel;
    private int vida;
    private final int mana;
    private final int armadura;
    private final List<String> inventario;
    private EstrategiaAtaque estrategiaAtaque;

    private Personagem(Builder b) {
        this.nome = b.nome;
        this.classe = b.classe;
        this.nivel = b.nivel;
        this.vida = b.vida;
        this.mana = b.mana;
        this.armadura = b.armadura;
        this.inventario = new ArrayList<>(b.inventario);
        this.estrategiaAtaque = b.estrategiaAtaque;
    }

    public static Builder builder() {
        return new Builder();
    }

    // Usa a Strategy atual para calcular o dano
    public void atacar(Inimigo alvo) {
        int dano = estrategiaAtaque.calcularDano(nivel);
        alvo.receberDano(dano);
        System.out.println(nome + " ataca " + alvo.getNome() + " com "
                + estrategiaAtaque.getNome() + " e causa " + dano
                + " de dano. (Vida restante do alvo: " + alvo.getVida() + ")");
    }

    public void setEstrategiaAtaque(EstrategiaAtaque estrategiaAtaque) {
        this.estrategiaAtaque = estrategiaAtaque;
        System.out.println(nome + " trocou de ataque para: " + estrategiaAtaque.getNome());
    }

    public void exibirFicha() {
        System.out.println("---------- FICHA DO PERSONAGEM ----------");
        System.out.println("Nome:       " + nome);
        System.out.println("Classe:     " + classe);
        System.out.println("Nível:      " + nivel);
        System.out.println("Vida:       " + vida);
        System.out.println("Mana:       " + mana);
        System.out.println("Armadura:   " + armadura);
        System.out.println("Ataque:     " + estrategiaAtaque.getNome());
        System.out.println("Inventário: " + (inventario.isEmpty() ? "vazio" : inventario));
        System.out.println("-----------------------------------------");
    }

    public String getNome() { return nome; }
    public int getNivel() { return nivel; }
    public int getVida() { return vida; }
    public List<String> getInventario() { return Collections.unmodifiableList(inventario); }

    // ===================== BUILDER =====================
    public static class Builder {
        private String nome;
        private ClassePersonagem classe = ClassePersonagem.GUERREIRO;
        private int nivel = 1;
        private int vida = 100;
        private int mana = 0;
        private int armadura = 0;
        private final List<String> inventario = new ArrayList<>();
        private EstrategiaAtaque estrategiaAtaque = new AtaqueSoco();

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder classe(ClassePersonagem classe) {
            this.classe = classe;
            return this;
        }

        public Builder nivel(int nivel) {
            this.nivel = nivel;
            return this;
        }

        public Builder vida(int vida) {
            this.vida = vida;
            return this;
        }

        public Builder mana(int mana) {
            this.mana = mana;
            return this;
        }

        public Builder armadura(int armadura) {
            this.armadura = armadura;
            return this;
        }

        public Builder adicionarItem(String item) {
            this.inventario.add(item);
            return this;
        }

        public Builder estrategiaAtaque(EstrategiaAtaque estrategiaAtaque) {
            this.estrategiaAtaque = estrategiaAtaque;
            return this;
        }

        public Personagem build() {
            if (nome == null || nome.trim().isEmpty()) {
                throw new IllegalStateException("O personagem precisa ter um nome.");
            }
            if (nivel < 1) {
                throw new IllegalStateException("O nível mínimo é 1.");
            }
            if (vida <= 0) {
                throw new IllegalStateException("A vida inicial deve ser maior que zero.");
            }
            return new Personagem(this);
        }
    }
}
