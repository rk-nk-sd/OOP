package game.base;

import game.units.common.BaseHero;
import game.units.common.Heroes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class GameBoard {
    public static final int DEFAULT_BOARD_SIZE = 9;
    private final int row;
    private final int col;
    private final List<BaseHero> listHeros;

    public GameBoard(int row, int col, List<BaseHero> listHeros) {
        this.row = row;
        this.col = col;
        this.listHeros = listHeros;
        defaultShapePosition();
    }

    public GameBoard(int rowAndCol, List<BaseHero> listHeros) {
        this(rowAndCol, rowAndCol, listHeros);
    }

    public GameBoard(int rowAndCol) {
        this(rowAndCol, new ArrayList<>());
    }

    public GameBoard(List<BaseHero> listHeros) {
        this(DEFAULT_BOARD_SIZE, listHeros);
    }

    public GameBoard() {
        this(new ArrayList<>());
    }

    private void defaultShapePosition() {
        LinkedList<String> linkedList = getListUniqueTeams(listHeros);

        int count = 0;
        while (!linkedList.isEmpty()) {
            List<BaseHero> left = listHeros.stream().filter(baseHero -> linkedList.get(0).equals(baseHero.getTeam())).collect(
                    Collectors.toList());
            setHerosTeamPositionOnGameBoardDefault(left, this.row, count == 0 ? count++ : this.col);
            linkedList.pop();
        }

        System.out.println("Проверка установки координат для игроков: ");
        listHeros.forEach(s -> System.out.printf("Команда: %s Тип: %s - %s%s", s.getTeam(), Heroes.valueOf(s.getClass().getSimpleName()).getType(), s.getPoint(), System.lineSeparator()));

    }

    private void setHerosTeamPositionOnGameBoardDefault(List<BaseHero> heroes, int row, int defaultCommandPosition) {
        final int direction = defaultCommandPosition > 0 ? -1 : 1;
        int tmpRow = row;
        for (int i = 0; i < heroes.size(); i++) {
            if (i == 0 || tmpRow/i > 1) {
                heroes.get(i).setPoint(i, defaultCommandPosition);
            } else {
                tmpRow += row;
                heroes.get(i).setPoint(i, defaultCommandPosition + direction);

            }
        }
    }

    private LinkedList<String> getListUniqueTeams(List<BaseHero> listHeros) {
        return listHeros.stream().map(BaseHero::getTeam).distinct().collect(Collectors.toCollection(LinkedList::new));
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public String toString() {
        return "GameBoard{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
}
