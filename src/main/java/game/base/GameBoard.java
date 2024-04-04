package game.base;

import game.cli.TestView;
import game.units.common.BaseHero;
import game.units.common.Heroes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class GameBoard {
    private final BaseContext context;
    public static final int DEFAULT_BOARD_SIZE = 9;


    public GameBoard(int row, int col, List<BaseHero> listHeroes) {
        context = BaseContext.getInstance();
        context.setListHeroes(listHeroes);
        context.setBoardSize(new BoardSize(col, row));
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
        LinkedList<String> linkedList = getListUniqueTeams(context.getListHeroes());

        int count = 0;
        while (!linkedList.isEmpty()) {
            List<BaseHero> left = context.getListHeroes().stream().filter(baseHero -> linkedList.get(0).equals(baseHero.getTeam())).collect(
                    Collectors.toList());
            setHerosTeamPositionOnGameBoardDefault(left, context.getBoardSize().getY(), count == 0 ? count++ : context.getBoardSize().getX());
            linkedList.pop();
        }

        System.out.println("Проверка установки координат для игроков: ");
        context.getListHeroes().forEach(s -> System.out.printf("Команда: %s Тип: %s - %s%s", s.getTeam(),
                Heroes.valueOf(s.getClass().getSimpleName()).getType(), s.getPoint(), System.lineSeparator()));

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

    public List<BaseHero> getListHeroes() {
        return context.getListHeroes();
    }

    @Override
    public String toString() {
        return "GameBoard{" +
                "row=" + context.getBoardSize().getY() +
                ", col=" + context.getBoardSize().getX() +
                '}';
    }

    public void fire() {
        List<BaseHero> heroes = new ArrayList<>(context.getListHeroes());
        heroes.sort((o1, o2) -> Heroes.valueOf(o2.getClass().getSimpleName()).getSpeed()
                - Heroes.valueOf(o1.getClass().getSimpleName()).getSpeed());
        heroes.forEach(h -> h.step(heroes));
        view();
    }

    public void view() {
        TestView example = new TestView(this.context);
        example.view();
    }

    public BoardSize getBoardSize() {
        return this.context.getBoardSize();
    }
}
