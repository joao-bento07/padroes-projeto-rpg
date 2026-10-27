public class AtaqueSoco implements EstrategiaAtaque {
    @Override
    public String getNome() {
        return "Soco";
    }

    @Override
    public int calcularDano(int nivel) {
        return 2 + nivel;
    }
}