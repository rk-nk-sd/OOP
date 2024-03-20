package game.units.common;

import game.units.Point;
import game.units.interfaces.other.Move;

public abstract class InfantryAbstract extends ManaAbstract implements Move {

    public InfantryAbstract(String name, int hp, Point point, int energy) {
        super(name, hp, point, energy);
    }
}
