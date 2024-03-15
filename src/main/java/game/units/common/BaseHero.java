package game.units.common;

import game.units.Point;
import game.units.interfaces.CommonInterface;
import java.util.List;
import java.util.Random;

/**
 * Базовый юнит
 */
public abstract class BaseHero implements CommonInterface {
    private static final String BASE_HERO_D = "Hero_BaseHero #%d";
    protected static int number;
    protected static Random r;

    private final String name;
    protected int hp;
    protected int maxHp;

    protected Point point = new Point();

    boolean isDie = Boolean.FALSE;
    private String teamName;


    static {
        BaseHero.number = 0;
        BaseHero.r = new Random();
    }

    protected BaseHero(String name, int hp) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
    }

    public BaseHero(String name) {
        this(name, BaseHero.r.nextInt(100));
    }

    public BaseHero() {
        this(String.format(BaseHero.BASE_HERO_D, ++BaseHero.number));
    }

    public void attack(BaseHero target) {
        int damage = BaseHero.r.nextInt(30);
        target.getDamage(damage);
    }

    public String getInfo() {
        return String.format("Name: %s Hp: %d Type: %s Speed: %s   Teams: %s",
                this.name,
                this.hp,
                Heroes.valueOf(this.getClass().getSimpleName()).getType(),
                Heroes.valueOf(this.getClass().getSimpleName()).getSpeed(),
                this.teamName);
    }

    public void healed(int Hp) {
        this.hp = Math.min(Hp + this.hp, this.maxHp);
    }

    public void getDamage(int damage) {
        if (this.hp - damage > 0) {
            this.hp -= damage;
        } else this.isDie = Boolean.TRUE;
    }

    public boolean isDie() {
        return isDie;
    }

    public BaseHero findTarget(List<BaseHero> listHero) {
        double minDist = Double.MAX_VALUE;
        BaseHero tmp = null;
        for (BaseHero hero : listHero) {
            if (point.getDistancePointToPoint(hero.point) < minDist) {
                minDist = point.getDistancePointToPoint(hero.point);
                tmp = hero;
            }
        }
        return tmp;
    }

    @Override
    public String getTeam() {
        return this.teamName;
    }

    @Override
    public void setTeam(String teamName) {
        this.teamName = teamName;
    }
}
