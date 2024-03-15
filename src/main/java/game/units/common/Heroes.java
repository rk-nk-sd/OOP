package game.units.common;

public enum Heroes {
    Arbalester("Арбалетчик", 3),
    Farmer("Крестьянин", 0),
    Lancer("Копейщик", 2),
    Magician("Маг", 1),
    Monk("Монах", 1),
    Priest("Жрец", 1),
    Robber("Разбойник", 2),
    Sniper("Снайпер", 3);

    String type;
    int speed;

    Heroes(String type, int speed) {
        this.type = type;
        this.speed = speed;
    }

    Heroes(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return "Тип: " + type + ", Скорость: " + speed;
    }
}