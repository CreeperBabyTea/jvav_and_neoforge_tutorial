package tutorial.oop.abstraction_and_implementation.abstract_class;

public class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getSize() {
        return radius * radius * Math.PI;
    }

    @Override
    public double getPerimeter() {
        return radius * Math.PI * 2;
    }
}
