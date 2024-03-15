package game.units.common;

import game.units.Point;

public abstract class Mana extends BaseHero {
    private int mana;
    private final int maxMana;

    public Mana(String name, int hp, Point point, int energy) {
        super(name, hp, point);
        this.mana = energy;
        this.maxMana = energy;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public String getInfo() {
        return String.format("%s Energy: %d", super.getInfo(), this.mana);
    }
}
