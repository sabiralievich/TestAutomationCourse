public class Triangle {
    public static void main(String[] args) throws InvalidTriangleException {
       // стороны треуголника:
        int a = 3;
        int b = 5;
        int c = 10;

        if(isTriangle(a, b, c)) {
            System.out.printf("Площаль треугольника со сторонами %1$d, %2$d, %3$d равна " + getArea(a, b, c), a, b, c);
        } else throw new InvalidTriangleException(String.format("Треугольник со сторонами %1$d, %2$d, %3$d не существует", a, b, c));

    }

    public static double getArea(int a, int b, int c) {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public static boolean isTriangle(int a, int b, int c) throws InvalidTriangleException {
        if (((a + b) > c) & ((a + c) > b) & ((b + c) > a)){
            return true;
        }
        return false;

    }
}
