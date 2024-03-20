package game.units.common;

import game.units.Point;
import game.units.interfaces.other.Arrows;


public abstract class ShooterAbstract extends ManaAbstract implements Arrows {

    public ShooterAbstract(String name, int hp, Point point, int energy) {
        super(name, hp, point, energy);
    }
}
