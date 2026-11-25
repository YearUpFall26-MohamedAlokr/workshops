import com.pluralsight.Console;
import com.pluralsight.forms.Location;
import com.pluralsight.forms.Turtle;
import com.pluralsight.forms.World;
import com.pluralsight.shapes.Circle;
import com.pluralsight.shapes.Hexagon;
import com.pluralsight.shapes.Shape;
import com.pluralsight.shapes.Square;
import com.pluralsight.shapes.Triangle;
import java.awt.*;


public class MainApp
{
    public static void main(String[] args) {
        int size = Console.promptForInt("Enter canvas size: ");
        World world = new World(size, size);
        Turtle turtle = new Turtle(world);
        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println("Home Screen");
            System.out.println("1) Add Shape");
            System.out.println("2) Save Image");
            System.out.println("0) Exit");

            int choice = Console.promptForInt("Enter Your Choice: ");

            switch (choice) {

                case 1:
                    addShape(turtle);
                    break;

                case 2:
                    world.saveAs("drawing.png");
                    System.out.println("Image saved.");
                    break;

                case 0:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }


    public static void addShape(Turtle turtle) {

        System.out.println();
        System.out.println("1) Square");
        System.out.println("2) Circle");
        System.out.println("3) Triangle");
        System.out.println("4) Hexagon");

        int shapeChoice = Console.promptForInt("Enter Your Choice: ");
        int borderWidth = Console.promptForInt("Enter Your Border Width: ");
        Color color = Console.getColorFromString("Enter Your color : ");
        int x = Console.promptForInt("Enter X Location: ");
        int y = Console.promptForInt("Enter Y Location: ");
        Location location = new Location(x, y);
        Shape shape = null;

        switch (shapeChoice) {

            case 1:
                shape = new Square(turtle, location, color, borderWidth);
                break;

            case 2:

                double radius = Console.promptForDouble("Enter Radius: ");

                shape = new Circle(turtle, location, color, borderWidth, radius);
                break;

            case 3:
                shape = new Triangle(turtle, location, color, borderWidth);
                break;

            case 4:
                shape = new Hexagon(turtle, location, color, borderWidth);
                break;

            default:
                System.out.println("Invalid shape.");
                return;
        }
        shape.paint();


} }




