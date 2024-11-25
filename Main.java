import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        // point
        Point a = new Point(1,2);
        Point b = new Point(3,4);
        System.out.println("Distance: " + Point.distance(a, b));
        System.out.println("Angle: " + a.angle());
        
        System.out.println();
        
        // grid
        Grid<Integer> grid1 = new Grid<>(5, 0);
        Grid<Integer> grid2 = new Grid<>(7, 1);
        Grid<Integer> grid3 = new Grid<>(3, 2);
        
        System.out.println("Max Side Length: " + Grid.maxSideLength());
        
        Grid<Integer> gridDiagonal = new Grid<>(3, 0);

        gridDiagonal.set(0, 0, 1);
        gridDiagonal.set(1, 1, 2);
        gridDiagonal.set(2, 2, 3);
    
        System.out.println("Grid:");
        System.out.println(gridDiagonal);
        ArrayList<Integer> diagonal = gridDiagonal.diagonal();
        System.out.println("Diagonal: " + diagonal);
        
        System.out.println();
        
        //shape
        Shape[] shapes = {
            new Circle(new Point(1.8, -20), 2), 
            new Square(new Point(100, 2.1), 5.4),
            new Circle(new Point(0, 0), 1),
            new Circle(new Point(4, 9.123), 98.32),
            new Square(new Point(-321, 0), 0.02)
        };

        System.out.println("Total area: " + sumArea(shapes));

        Shape[] scaledShapes = scaleAll(shapes, 2);
        System.out.println("Scaled shapes:");
        for (Shape shape : scaledShapes) {
            System.out.println(shape);
        }

        RightTriangle t1 = new RightTriangle(new Point(0, 0), 3, 4);
        RightTriangle t2 = new RightTriangle(new Point(1, 1), 6, 8);
        System.out.println("Triangles are similar: " + RightTriangle.similar(t1, t2));
        
        System.out.println();
        
        // library
        LibraryItem[] items = {
            new Book("The Catcher in the ", "B001", "J.D. Salinger", 350),
            new DVD("The Odyssey", "D001", 150.0),
            new Book("Captain Underpants", "B002", "Dav Pilkey", 200),
            new DVD("RyeHarry Potter", "D002", 150.0)
        };

        items[0].checkOut();
        items[1].checkOut();

        ArrayList<LibraryItem> available = availableItems(items);
        System.out.println("Available items:");
        for (LibraryItem item : available) {
            System.out.println(item);
        }

        returnAll(items);
        System.out.println("\nAfter returning all items:");
        available = availableItems(items);
        for (LibraryItem item : available) {
            System.out.println(item);
        }
    }

    public static double sumArea(Shape[] shapes) {
        double sum = 0;
        for (Shape shape : shapes) {
            sum += shape.area();
        }
        return sum;
    }

    public static Shape[] scaleAll(Shape[] shapes, double k) {
        Shape[] scaled = new Shape[shapes.length];
        for (int i = 0; i < shapes.length; i++) {
            scaled[i] = shapes[i].scale(k);
        }
        return scaled;
    }
    
    public static void returnAll(LibraryItem[] items) {
        for (int i = 0; i < items.length; i++) {
        LibraryItem item = items[i];
        item.returnItem();
        }
    }
    
    public static ArrayList<LibraryItem> availableItems(LibraryItem[] items) {
        ArrayList<LibraryItem> available = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            LibraryItem item = items[i];
            if (item.available()) {
                available.add(item);
            }
        }
        return available;
    }
}