package game.cli;

import game.base.BaseContext;
import game.units.Point;
import game.units.common.BaseHero;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TestView {
    private static int step = 1;
    BaseContext context;

    public TestView(BaseContext context) {
        this.context = context;
    }

    public void view() {

        System.out.println("\n\n" + context.getBoardSize() + "\n");
        System.out.println("Список героев: " + context.getListHeroes().stream().map(h -> {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(h.getClass().getSimpleName());
            stringBuilder.append(" ");
            stringBuilder.append(h.getPoint().toString());
            return stringBuilder;
        }).collect(Collectors.toList()) + "\n");
        BaseHero baseHero = context.getListHeroes().stream().findFirst().orElse(null);
        List<BaseHero> group1 = new ArrayList<>();
        group1 = context.getListHeroes().stream().filter(h -> h.getTeam().equals(baseHero.getTeam()) || baseHero.getAllias().contains(h.getTeam())).collect(
                Collectors.toList());
        System.out.println("Группа союзников: " + baseHero.getTeam());

        System.out.println("Step_" + step++ + "\n");
        System.out.print("|");
        for (int i = 0; i < 10; i++) {
            System.out.printf("-%d-|",i);
        }
        System.out.println();
        for (int i = 0; i < context.getBoardSize().getY() + 1; i++) {
            for (int j = 0; j < context.getBoardSize().getX() + 1; j++) {
                System.out.print("|");
                for (BaseHero hero : context.getListHeroes()) {
                    if (hero.getPoint().equals(new Point(j,i))) {
                        if (group1.contains(hero) && !hero.isDie()) {
                            System.out.print(AnsiColors.ANSI_GREEN + hero.getClass().getSimpleName().charAt(0) + AnsiColors.ANSI_RESET);
                        } else if (!hero.isDie()){
                            System.out.print(AnsiColors.ANSI_BLUE + hero.getClass().getSimpleName().charAt(0) + AnsiColors.ANSI_RESET);
                        } else {
                            System.out.print(AnsiColors.ANSI_RED + hero.getClass().getSimpleName().charAt(0) + AnsiColors.ANSI_RESET);
                        }
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.print("|" + System.lineSeparator());
        }
    }
}
