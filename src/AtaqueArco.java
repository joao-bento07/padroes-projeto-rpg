public class AtaqueArco implements EstrategiaAtaque {
    @Override
    public String getNome() {
        return "Flechada";
    }

    @Override
    public int calcularDano(int nivel) {
        return 8 + nivel * 2;
    }
}