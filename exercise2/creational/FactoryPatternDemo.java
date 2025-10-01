package creational; // or package structural;

interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw() { System.out.println("Drawing a Circle"); }
}

class Square implements Shape {
    public void draw() { System.out.println("Drawing a Square"); }
}

class ShapeFactory {
    public Shape getShape(String type) {
        if (type.equalsIgnoreCase("circle")) return new Circle();
        else if (type.equalsIgnoreCase("square")) return new Square();
        return null;
    }
}

public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        Shape shape1 = factory.getShape("circle");
        Shape shape2 = factory.getShape("square");

        shape1.draw();
        shape2.draw();
    }
}
