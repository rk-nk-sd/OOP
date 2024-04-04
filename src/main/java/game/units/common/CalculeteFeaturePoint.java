package game.units.common;

import game.base.BaseContext;
import game.units.Point;

import java.util.ArrayList;
import java.util.List;

public class CalculeteFeaturePoint{
    BaseContext context;
    BaseHero hero;
    public CalculeteFeaturePoint(BaseContext context, BaseHero hero) {
        this.context = context;
        this.hero = hero;
    }

    public Point featurePosition(BaseHero target) {
        Point nextPosition = new Point(hero.getPoint().getPointX(), hero.getPoint().getPointY());

        switch (getDirectionLessDist(target)) {
            case "left":
                nextPosition.setPointX(this.leftStep().getPointX());
                break;
            case "right":
                nextPosition.setPointX(this.rightStep().getPointX());
                break;
            case "up":
                nextPosition.setPointY(this.upStep().getPointY());
                break;
            case "down":
                nextPosition.setPointY(downStep().getPointY());
                break;
            default:
        }
        return nextPosition;
    }

    private Point rightStep() {
        return new Point(hero.getPoint().getPointX() + 1, hero.getPoint().getPointY());
    }

    private Point leftStep() {
        return new Point(hero.getPoint().getPointX() - 1, hero.getPoint().getPointY());
    }

    private Point downStep() {
        return new Point(hero.getPoint().getPointX(), hero.getPoint().getPointY() + 1);
    }

    private Point upStep() {
        return new Point(hero.getPoint().getPointX(), hero.getPoint().getPointY() - 1);
    }

    private double getDist(BaseHero target, String direction) {
        double tmp;
        switch (direction) {
            case "left":
                tmp = this.leftStep().getDistancePointToPoint(target.getPoint());
                break;
            case "right":
                tmp = this.rightStep().getDistancePointToPoint(target.getPoint());
                break;
            case "up":
                tmp = this.upStep().getDistancePointToPoint(target.getPoint());
                break;
            case "down":
                tmp = this.downStep().getDistancePointToPoint(target.getPoint());
                break;
            default:
                tmp = Double.MAX_VALUE;
        }
        return tmp;
    }

    private List<String> getFreeDirectons() {
        List<String> list = new ArrayList<>();
        if (context.getListHeroes().stream().filter(target -> !target.isDie).noneMatch(p->p.getPoint().equals(this.downStep()))) {
            list.add("down");
        }
        if (context.getListHeroes().stream().filter(target -> !target.isDie).noneMatch(p->p.getPoint().equals(this.upStep()))) {
            list.add("up");
        }
        if (context.getListHeroes().stream().filter(target -> !target.isDie).noneMatch(p->p.getPoint().equals(this.leftStep()))) {
            list.add("left");
        }
        if (context.getListHeroes().stream().filter(target -> !target.isDie).noneMatch(p->p.getPoint().equals(this.rightStep()))) {
            list.add("right");
        }
        return list;
    }

    private String getDirectionLessDist(BaseHero target) {
        List<String> directions = getFreeDirectons();
        double minDistance = Double.MAX_VALUE;
        String direction = "";
        for (String direct:directions) {
            if (getDist(target, direct) < minDistance && checkDirection(direct)) {
                direction = direct;
                minDistance = getDist(target, direct);
            }
        }
        return direction;
    }

    private boolean checkDirection(String direction) {
        Point tmp = null;
        switch (direction) {
            case "left":
                tmp = this.leftStep();
                break;
            case "right":
                tmp = this.rightStep();
                break;
            case "up":
                tmp = this.upStep();
                break;
            case "down":
                tmp = this.downStep();
                break;
            default:
        }
        if (tmp != null
                && tmp.getPointX() >= 0
                && tmp.getPointY() >= 0
                && tmp.getPointX() < context.getBoardSize().getX()
                && tmp.getPointY() < context.getBoardSize().getY()) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
