package game.units.common;

import game.units.Point;
import game.units.interfaces.other.Move;

public abstract class InfantryAbstract extends ManaAbstract implements Move {
    CalculeteFeaturePoint calculeteFeaturePoint;

    public InfantryAbstract(String name, int hp, Point point, int energy) {
        super(name, hp, point, energy);
        calculeteFeaturePoint = new CalculeteFeaturePoint(context, this);
    }

    @Override
    public void move(BaseHero target) {
        Point featurePoint = calculeteFeaturePoint.featurePosition(target);
        this.setPoint(featurePoint.getPointX(), featurePoint.getPointY());
    }
}
