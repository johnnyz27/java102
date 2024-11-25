public interface Shape {
    double area();
    double perimeter();
    boolean isInside(Point p);
    boolean isOn(Point p);
    Shape translate(double x, double y);
    Shape scale(double k);
}
