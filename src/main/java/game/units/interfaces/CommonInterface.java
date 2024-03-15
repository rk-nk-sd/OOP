package game.units.interfaces;

import game.units.common.BaseHero;
import java.util.List;

public interface CommonInterface extends Team {
    void step(List<BaseHero> list);
}
