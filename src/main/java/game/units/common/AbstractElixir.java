package game.units.common;

import game.units.Point;
import game.units.interfaces.Elixir;

public abstract class AbstractElixir extends BaseHero implements Elixir {
    private int elixir;
    private final int maxElixir;

    public AbstractElixir(String name, int hp, Point point, int energy) {
        super(name, hp, point);
        this.elixir = energy;
        this.maxElixir = energy;
    }

    public String getInfo() {
        return String.format("%s Energy: %d ", super.getInfo(), this.elixir);
    }

    @Override
    public int getElixir() {
        return this.elixir;
    }

    @Override
    public int getMaxElixir() {
        return this.maxElixir;
    }

    @Override
    public void setElixir(int count) {
        this.elixir -= count;
    }

    protected void shareElixir(Elixir target) {
        if (this.elixir > 1 && target.getElixir() < target.getMaxElixir()) {
            target.setElixir(1);
            this.elixir -= 2;
        }
    }
}
