package game.units.common;

import game.units.Point;
import game.units.interfaces.CommonAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Базовый юнит
 */
public abstract class BaseHero implements CommonAction {
    private static final String BASE_HERO_D = "Hero_BaseHero #%d";
    protected static int number;
    protected static Random r;

    /**
     * Имя персонажа
     */
    private final String name;

    /**
     * Текущее здоровье персонажа
     */
    protected int hp;

    /**
     * Максимальный уровень здоровья персонажа
     */
    protected int maxHp;


    /**
     * Текущая позиция персонажа на игровом поле
     */
    protected Point point;

    /**
     * Флаг проверки персонаж в не игры
     */
    boolean isDie = Boolean.FALSE;

    /**
     * Имя команды игрока
     */
    private String teamName;

    /**
     * Союзники
     */
    private List<String> allias;


    static {
        BaseHero.number = 0;
        BaseHero.r = new Random();
    }

    protected BaseHero(String name, int hp, Point point) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.point = point;
        allias = new ArrayList<>();
    }

    public BaseHero(String name, Point point) {
        this(name, BaseHero.r.nextInt(100), point);
    }

    public BaseHero() {
        this(String.format(BaseHero.BASE_HERO_D, ++BaseHero.number), new Point());
    }

    public void attack(BaseHero target) {
        int damage = BaseHero.r.nextInt(30);
        target.getDamage(damage);
    }

    public String getInfo() {
        return String.format("Name: %s Hp: %d Type: %s Speed: %s Teams: %s Allias: %s",
                this.name,
                this.hp,
                Heroes.valueOf(this.getClass().getSimpleName()).getType(),
                Heroes.valueOf(this.getClass().getSimpleName()).getSpeed(),
                this.teamName,
                this.allias);
    }

    public void healed(int Hp) {
        this.hp = Math.min(Hp + this.hp, this.maxHp);
    }

    public void getDamage(int damage) {
        if (this.hp - damage > 0) {
            this.hp -= damage;
        } else {
            this.isDie = Boolean.TRUE;
            this.hp = 0;
        }
    }

    public boolean isDie() {
        return isDie;
    }

    public BaseHero findTarget(List<BaseHero> listHero) {
        double minDist = Double.MAX_VALUE;
        BaseHero tmp = null;
        for (BaseHero hero : listHero) {
            if (this.point.getDistancePointToPoint(hero.point) < minDist) {
                minDist = point.getDistancePointToPoint(hero.point);
                tmp = hero;
            }
        }
        return tmp;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(int x, int y) {
        point.setPointX(x);
        point.setPointY(y);
    }

    @Override
    public String getTeam() {
        return this.teamName;
    }

    @Override
    public void setTeam(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public List<String> getAllias() {
        return allias;
    }

    @Override
    public void setAllias(List<String> allias) {
        this.allias = allias;
    }
}
