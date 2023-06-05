package java_hw20;

public class Main {
    public static void main(String[] args) {
        System.out.println("Сумма int = " + sumInt(10, 20));
        System.out.println("Умножение int = " + multiplicationInt(7, 8));
        System.out.println("Деление int = " + divisionInt(100, 10));
        System.out.println("Вычитание int = " + subtractInt(50, 30));
        System.out.println("Сумма double = " + sumDouble(3.14, 2.71));
        System.out.println("Сумма double + int = " + sumIntDouble(4.2, 10));
        System.out.println("Деление double = " + divisionDouble(15.5, 2.5));
        System.out.println("Сравнение int = " + compareInt(50, 30));
        System.out.println("Сравние double и int = " + compareDoubleInt(8.5, 7));
        System.out.println("Сложение с переполнением = " + sumOverflowInt(1000, 500));
        System.out.println("Остаток от деления = " + remainDivisionInt(20, 7));
        System.out.println("Инкремент = " + incrementInt(10));
        System.out.println(getLaptopModel("MacBook Pro"));
        System.out.println(getLaptopModel("ThinkPad X1 Carbon"));
        System.out.println(getLaptopModel("Dell XPS"));
        System.out.println(getCountry("Russia"));
        System.out.println(getCountry("USA"));
        System.out.println(getCountry("China"));
        System.out.println("Умножение int с переполнением = " + multiplicationOverflowInt(100, 200));
    }

    public static int sumInt(int a, int b) {
        return a + b;
    }

    public static int multiplicationInt(int a, int b) {
        return a * b;
    }

    public static int divisionInt(int a, int b) {
        return a / b;
    }

    public static int subtractInt(int a, int b) {
        return a - b;
    }

    public static double sumDouble(double a, double b) {
        return a + b;
    }

    public static double sumIntDouble(double a, int b) {
        return a + b;
    }

    public static double divisionDouble(double a, double b) {
        return a / b;
    }

    public static boolean compareInt(int a, int b) {
        return a > b;
    }

    public static boolean compareDoubleInt(double a, int b) {
        return a <= b;
    }

    public static int sumOverflowInt(int a, int b) {
        return a * b;
    }

    public static int remainDivisionInt(int a, int b) {
        return a % b;
    }

    public static int incrementInt(int a) {
        return ++a;
    }

    public static String getLaptopModel(String laptopModel) {
        if (laptopModel != null && laptopModel.equals("MacBook Pro")) {
            return laptopModel;
        } else if (laptopModel != null && laptopModel.equals("ThinkPad X1 Carbon")) {
            return laptopModel;
        } else if (laptopModel != null && laptopModel.equals("Dell XPS")) {
            return laptopModel;
        } else {
            return "Модель ноутбука неизвестна";
        }
    }

    public static int multiplicationOverflowInt(int a, int b) {
        return a * b;
    }

    public static String getCountry(String country) {
        switch (country) {
            case "Russia":
            case "Tajikistan":
                System.out.println("Вы выбрали страну из СНГ.");
                break;
            case "USA":
            case "Canada":
                System.out.println("Вы выбрали страну из Северной Америки.");
                break;
            case "China":
            case "Japan":
                System.out.println("Вы выбрали страну из Азии.");
                break;
            default:
                System.out.println("Вы выбрали неизвестную страну.");
                break;
        }
        return country;
    }
}
