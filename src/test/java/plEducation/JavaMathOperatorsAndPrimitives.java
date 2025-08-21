package plEducation;

public class JavaMathOperatorsAndPrimitives {

    public static void main(String[] args) {

        int a = 20;
        int b = 5;
        int c;

        c = a + b;
        System.out.println(">>>>>>>>>>>>>>>");
        System.out.println("Операторы сравнения, используются значения a=" + a + ", b=" + b);
        System.out.println("c после сложения a и b равно " + c);
        System.out.println(">>>>>>>>>>>>>>>");

        c = a - b;
        System.out.println("c после вычитания b из a равно " + c);
        System.out.println(">>>>>>>>>>>>>>>");

        c = a * b;
        System.out.println("c после умножения a на b равно " + c);
        System.out.println(">>>>>>>>>>>>>>>");

        c = a/b;
        System.out.println("c после деления a на b равно " + c);
        System.out.println(">>>>>>>>>>>>>>>");

        double d = 9.33;
        int i = 3;
        double g = 55.55;
        int k = 5;
        double f;

        f=d+i;
        System.out.println(">>>>>>>>>>>>>>>");
        System.out.println("Матоперации с разными типами данных, используются значения d=" + d + ", i=" + i + ", g=" + g + ", k=" + k);
        System.out.println("f после сложения i и d равно " + f);
        System.out.println(">>>>>>>>>>>>>>>");
        System.out.println("Сложение int и double внутри sout " + (g+k));
        System.out.println();

        f=d-i;
        System.out.println("f после вычитания i из d равно " + f);
        System.out.println(">>>>>>>>>>>>>>>");
        System.out.println("Вычитание int из double внутри sout " + (g-k));
        System.out.println();

        f=d*i;
        System.out.println("f после умножения i на d равно " + f);
        System.out.println(">>>>>>>>>>>>>>>");
        System.out.println("Умножение int на double внутри sout " + (g*k));
        System.out.println();

        f=d/i;
        System.out.println("f после деления d на i равно " + f);
        System.out.println(">>>>>>>>>>>>>>>");
        System.out.println("Деление int и double внутри sout " + (g/k));
        System.out.println();

        boolean compare;
        int h = 5;
        int j = 6;
        int l = 4;

        System.out.println(">>>>>>>>>>>>>>>");
        System.out.println("Операторы сравнения, используются значения a=" + a + ", b=" + b + ", h=" + h + ", j=" + j + ", l=" + l);
        compare = a > b;
        System.out.println("Результат сравнения a и b с помощью знака > является " + compare);
        System.out.println("Результат сранения внутри h > b sout является " + (h > b));
        System.out.println(">>>>>>>>>>>>>>>");
        compare = a < b;
        System.out.println("Результат сравнения a и b с помощью знака < является " + compare);
        System.out.println("Результат сранения внутри h < b sout является " + (h < b));
        System.out.println(">>>>>>>>>>>>>>>");
        compare = a >= b;
        System.out.println("Результат сравнения a и b с помощью знака >= является " + compare);
        System.out.println("Результат сранения внутри h >= b sout является " + (j >= b));
        System.out.println(">>>>>>>>>>>>>>>");
        compare = a <= b;
        System.out.println("Результат сравнения a и b с помощью знака <= является " + compare);
        System.out.println("Результат сранения внутри h <= b sout является " + (l <= b));
        System.out.println(">>>>>>>>>>>>>>>");

        System.out.println();
        System.out.println("Операции с переполнением");
        byte bMax = 127;
        short sMax = 32767;
        int iMax = Integer.MAX_VALUE;
        double dMax = Double.MAX_VALUE;
        float fMax = Float.MAX_VALUE;

        System.out.println("Переполнение переменной типа byte при выполнении сложения bMax и 1 : " + (bMax + 3));
        System.out.println(">>>>>>>>>>>>>>>");
        System.out.println("Переполнение переменной типа short при выполнении сложения sMax и 1 : " + (sMax + 1));
        System.out.println(">>>>>>>>>>>>>>>");
        System.out.println("Переполнение переменной типа int при выполнении сложения iMax и 1 : " +  (iMax +1L));
        System.out.println(">>>>>>>>>>>>>>>");
        System.out.println("Переполнение переменной типа double при выполнении сложения dMax и 1 : " + (dMax +1));
        System.out.println(">>>>>>>>>>>>>>>");
        System.out.println("Переполнение переменной типа fMax при выполнении сложения fMax и 1 : " + (fMax +1));
    }
}


