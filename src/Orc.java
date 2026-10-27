public class Orc extends Inimigo {
    public Orc() {
        super("Orc", 120, 18);
    }

    @Override
    public String rugir() {
        return "GRAAAH! Vou esmagar você!";
    }
}