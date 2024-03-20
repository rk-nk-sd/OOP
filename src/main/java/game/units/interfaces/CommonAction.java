package game.units.interfaces;

import game.units.common.BaseHero;
import java.util.List;

public interface CommonAction extends Allias {
    void step(List<BaseHero> list);
}
