public class Goblin extends Inimigo {
    public Goblin() {
        super("Goblin", 40, 5);
    }

    @Override
    public String rugir() {
        return "Hihihi! Me dá suas moedas!";
    }
}