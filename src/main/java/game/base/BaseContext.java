package game.base;

import game.units.common.BaseHero;

import java.util.List;

public class BaseContext {
    private static BaseContext INSTANCE;
    private List<BaseHero> listHeroes;
    private BoardSize boardSize;

    BaseContext() {
    }

    public static BaseContext getInstance() {
        if (INSTANCE == null) {
            synchronized (BaseContext.class) {
                if (INSTANCE == null) {
                    INSTANCE = new BaseContext();
                }
            }
        }
        return INSTANCE;
    }

    public List<BaseHero> getListHeroes() {
        return listHeroes;
    }

    public void setListHeroes(List<BaseHero> listHeroes) {
        this.listHeroes = listHeroes;
    }

    public BoardSize getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(BoardSize boardSize) {
        this.boardSize = boardSize;
    }
}
