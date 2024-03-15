package game.units.common;

public abstract class Mana extends BaseHero {
    private int mana;
    private int maxMana;

    public Mana(String name, int hp, int energy) {
        super(name, hp);
        this.mana = energy;
        this.maxMana = energy;
    }

    public String getInfo() {
        return String.format("%s Energy: %d", super.getInfo(), this.mana);
    }
}
