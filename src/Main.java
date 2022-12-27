import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        float side = readSquareSide();

        float areaOfPicture1 = calculateComplexFigureArea(side, 0, 0, 2);

        float areaOfPicture2 = calculateComplexFigureArea(side, 0, 1, 2);

        float areaOfPicture3 = calculateComplexFigureArea(side, 1, 0, 1);

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

    private static float calculateComplexFigureArea(float side, int squareQuarterAmount, int inscribedCircleAmount, int squareQuarterWithoutCircleQuarterAmount)
    {
        return squareQuarterAmount * calculateSquareQuarterArea(side) +
               inscribedCircleAmount * calculateInscribedCircleArea(side) +
               squareQuarterWithoutCircleQuarterAmount * calculateSquareQuarterWithoutCircleQuarterArea(side);
    }

    private static void printAreaOfPicture(String figureNumber, float areaOfPicture)
    {
        System.out.printf("Площадь фигуры %s = %.2f\n", figureNumber, areaOfPicture);
    }

    private static float calculateSquareArea(float side)
    {
        return (float) Math.pow(side, 2);
    }

    private static float calculateSquareQuarterArea(float side)
    {
        return (float) Math.pow(side, 2) / 4;
    }

    private static float calculateInscribedCircleArea(float side)
    {
        return (float) (Math.PI * (Math.pow(side, 2) / 4));
    }

    private static float calculateSquareQuarterWithoutCircleQuarterArea(float side)
    {
        return (calculateSquareArea(side) - calculateInscribedCircleArea(side)) / 4;
    }

}