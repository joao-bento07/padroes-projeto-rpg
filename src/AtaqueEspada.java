public class AtaqueEspada implements EstrategiaAtaque {
    @Override
    public String getNome() {
        return "Golpe de Espada";
    }

    @Override
    public int calcularDano(int nivel) {
        return 10 + nivel * 3;
    }
}
