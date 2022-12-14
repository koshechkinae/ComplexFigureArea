import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        float side = readSquareSide();

        float areaOfPicture1 = complexFigureArea(side,0,0,2);

        float areaOfPicture2 = complexFigureArea(side,0,1,2);

        float areaOfPicture3 = complexFigureArea(side,1,0,1);

        printAreaOfPicture("1", areaOfPicture1);
        printAreaOfPicture("2", areaOfPicture2);
        printAreaOfPicture("3", areaOfPicture3);
    }

    private static float readSquareSide()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите длину стороны квадрата:");

        float sideLength = scan.nextFloat();

        if (sideLength <= 0) throw new IllegalArgumentException("Длина стороны квадрата должна быть больше 0!");

        return sideLength;
    }

    private static float complexFigureArea(float side, int squareQuarterAmount, int inscribedCircleAmount, int squareQuarterWithoutCircleQuarterAmount)
    {
        return squareQuarterAmount * squareQuarterArea(side) +
               inscribedCircleAmount * inscribedCircleArea(side) +
               squareQuarterWithoutCircleQuarterAmount * squareQuarterWithoutCircleQuarterArea(side);
    }

    private static void printAreaOfPicture(String figureNumber, float areaOfPicture)
    {
        System.out.printf("Площадь фигуры %s = %.2f\n", figureNumber, areaOfPicture);
    }

    private static float squareArea(float side)
    {
        return (float) Math.pow(side, 2);
    }

    private static float squareQuarterArea(float side)
    {
        return (float) Math.pow(side, 2) / 4;
    }

    private static float inscribedCircleArea(float side)
    {
        return (float) (Math.PI * (Math.pow(side, 2) / 4));
    }

    private static float squareQuarterWithoutCircleQuarterArea(float side)
    {
        return (squareArea(side) - inscribedCircleArea(side)) / 4;
    }

}