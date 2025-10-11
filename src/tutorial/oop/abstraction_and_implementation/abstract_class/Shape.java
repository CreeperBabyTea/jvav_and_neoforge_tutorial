package tutorial.oop.abstraction_and_implementation.abstract_class;

public abstract class Shape {
    protected double x;
    protected double y;

    /**
     * Moves this shape to the given position.
     * @param x target pos x.
     * @param y target pos y.
     */
    public void moveTo(double x, double y) {   //一般方法
        this.x = x;
        this.y = y;
    }

    /**
     * Moves this shape for a given distance.
     * @param dx distance on x-axis.
     * @param dy distance on y-axis.
     */
    public void move(double dx, double dy) {   //另一个一般方法
        moveTo(x + dx, y + dy);
    }

    /**
     * Get the size of this shape.
     * @return This shape's size.
     */
    public abstract double getSize();   //抽象方法

    /**
     * Get the perimeter of this shape.
     * @return This shape's perimeter.
     */
    public abstract double getPerimeter();   //另一个抽象方法
}
