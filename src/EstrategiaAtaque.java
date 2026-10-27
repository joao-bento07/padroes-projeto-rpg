/**
 * Padrão STRATEGY: define a família de algoritmos de ataque.
 * O Personagem depende só desta interface e pode trocar de estratégia
 * em tempo de execução.
 */
public interface EstrategiaAtaque {
    String getNome();

    int calcularDano(int nivel);
}