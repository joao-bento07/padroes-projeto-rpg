public class AtaqueMagia implements EstrategiaAtaque {
    @Override
    public String getNome() {
        return "Bola de Fogo";
    }

    @Override
    public int calcularDano(int nivel) {
        return 15 + nivel * 4;
    }
}
