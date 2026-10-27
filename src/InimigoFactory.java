/**
 * Padrão FACTORY: centraliza a criação dos inimigos.
 * O cliente pede um TipoInimigo e recebe um Inimigo,
 * sem usar "new Goblin()", "new Orc()" etc.
 */
public class InimigoFactory {

    private InimigoFactory() {
    }

    public static Inimigo criar(TipoInimigo tipo) {
        switch (tipo) {
            case GOBLIN:
                return new Goblin();
            case ORC:
                return new Orc();
            case DRAGAO:
                return new Dragao();
            default:
                throw new IllegalArgumentException("Tipo de inimigo desconhecido: " + tipo);
        }
    }
}