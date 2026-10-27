public class Main {

    public static void main(String[] args) {
        demonstrarBuilder();
        demonstrarStrategy();
        demonstrarFactory();
    }

    private static void demonstrarBuilder() {
        System.out.println("\n========== PADRÃO BUILDER ==========");

        Personagem mago = new Personagem.Builder()
                .nome("Merlin")
                .classe(ClassePersonagem.MAGO)
                .nivel(10)
                .vida(80)
                .mana(200)
                .armadura(5)
                .adicionarItem("Cajado de Carvalho")
                .adicionarItem("Poção de Mana")
                .estrategiaAtaque(new AtaqueMagia())
                .build();
        mago.exibirFicha();

        // Só o nome é obrigatório; o resto usa valores padrão
        Personagem novato = Personagem.builder().nome("Aprendiz").build();
        novato.exibirFicha();

        // Validação: sem nome, o build() falha
        try {
            Personagem.builder().nivel(5).build();
        } catch (IllegalStateException e) {
            System.out.println("Erro esperado ao construir: " + e.getMessage());
        }
    }

    private static void demonstrarStrategy() {
        System.out.println("\n========== PADRÃO STRATEGY ==========");

        Personagem heroi = Personagem.builder()
                .nome("Aragorn")
                .classe(ClassePersonagem.GUERREIRO)
                .nivel(5)
                .estrategiaAtaque(new AtaqueEspada())
                .build();

        Inimigo alvo = InimigoFactory.criar(TipoInimigo.ORC);
        System.out.println("Alvo: " + alvo.getNome() + " (vida " + alvo.getVida() + ")\n");

        heroi.atacar(alvo);

        // Troca da estratégia em tempo de execução
        heroi.setEstrategiaAtaque(new AtaqueArco());
        heroi.atacar(alvo);

        heroi.setEstrategiaAtaque(new AtaqueMagia());
        heroi.atacar(alvo);

        System.out.println("O alvo ainda está vivo? " + alvo.estaVivo());
    }

    private static void demonstrarFactory() {
        System.out.println("\n========== PADRÃO FACTORY ==========");

        for (TipoInimigo tipo : TipoInimigo.values()) {
            Inimigo inimigo = InimigoFactory.criar(tipo);
            System.out.println(inimigo.getNome()
                    + " | vida: " + inimigo.getVida()
                    + " | dano: " + inimigo.getDano()
                    + " | " + inimigo.rugir());
        }
    }
}