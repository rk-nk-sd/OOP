package game.units;

import game.units.common.BaseHero;
import game.units.common.Mana;

import java.util.ArrayList;

/**
 * Маг
 */
public class Magician extends Mana {
    private static final String HERO_MAGICIAN_D = "Hero_Magician #%d";

    private Magician(String name, int hp, int energy) {
        super(name, hp, energy);
    }

    public Magician(String name) {
        this(name, Magician.r.nextInt(100), Magician.r.nextInt(50));
    }

    public Magician() {
        this(String.format(Magician.HERO_MAGICIAN_D, ++Magician.number));
    }


//    public void healed(int Hp) {
//        this.hp = Hp + this.hp > this.maxHp ? this.maxHp : this.hp;
//    }

    /**
     * Может оживить
     * @param list - Принимает список своей команды
     */
    @Override
    public void step(ArrayList<BaseHero> list) {
        BaseHero target = this.findTarget(list);
        if (target != null && target.isDie()) {
            target.healed(1);
        }
    }
}
