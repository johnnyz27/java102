public class RightTriangle implements Shape {
    private final Point corner;
    private final double base;
    private final double height;

    public RightTriangle(Point corner, double base, double height) {
        this.corner = corner;
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return 0.5 * base * height;
    }

    @Override
    public double perimeter() {
        return base + height + Math.sqrt(base * base + height * height);
    }

    @Override
    public boolean isInside(Point p) {
        double xDist = p.x - corner.x;
        double yDist = p.y - corner.y;
        return 0 < xDist && xDist < base && 0 < yDist && yDist < height;
    }

    @Override
    public boolean isOn(Point p) {
        return false;
    }

    @Override
    public RightTriangle translate(double x, double y) {
        return new RightTriangle(corner.translateX(x).translateY(y), base, height);
    }

    @Override
    public RightTriangle scale(double k) {
        return new RightTriangle(corner, base * k, height * k);
    }

    public static boolean similar(RightTriangle t1, RightTriangle t2) {
        double ratioBase = t1.base / t2.base;
        double ratioHeight = t1.height / t2.height;
        return ratioBase == ratioHeight;
    }

    @Override
    public String toString() {
        return "(corner: " + corner + "; base: " + base + "; height: " + height + ")";
    }
}
