package game.units;

/**
 * Класс описывает положение фигуры на координатной оси двумерного пространства
 * */
public class Point {
    private Integer pointX;
    private Integer pointY;

    /**
     * Базовый конструктор описывающий положение фигуры на координатной оси
     * @param pointX
     * @param pointY
     */
    public Point(Integer pointX, Integer pointY) {
        this.pointX = pointX;
        this.pointY = pointY;
    }

    /**
     * Конструктор с одним параметром
     * @param value - Точка инициализируется значениями pointX = value, pointY = value на координатной оси
     * */
    public Point(Integer value) {
        this(value, value);
    }

    /**
     * Конструктор без параметров
     * Точка инициализируется значениями по умолчанию на координатной оси pointX = 0, pointY = 0
     * */
    public Point() {
        this(0);
    }

    public Integer getPointX() {
        return pointX;
    }

    public void setPointX(Integer pointX) {
        this.pointX = pointX;
    }

    public Integer getPointY() {
        return pointY;
    }

    public void setPointY(Integer pointY) {
        this.pointY = pointY;
    }

    public Double getDistancePointToPoint(Point shape1) {
        return Math.sqrt(Math.pow(this.getPointX() - shape1.getPointX(), 2) + Math.pow(this.getPointY() - shape1.getPointY(), 2));
    }

    @Override
    public String toString() {
        return "Point{" +
                "pointX=" + pointX +
                ", pointY=" + pointY +
                '}';
    }
}
