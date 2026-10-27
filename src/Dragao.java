public class Dragao extends Inimigo {
    public Dragao() {
        super("Dragão", 300, 40);
    }

    @Override
    public String rugir() {
        return "ROOOAAAR! O Dragão cospe fogo!";
    }
}