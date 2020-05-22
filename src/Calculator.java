import java.util.Arrays;

public class Calculator {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        int[] arguments = new int[7];
        arguments[0] = 1;
        arguments[1] = 10;
        arguments[2] = 20;
        arguments[3] = 30;
        arguments[4] = 40;
        arguments[5] = 50;
        arguments[6] = 60;

        int result1 = calculator.sum(arguments);

        System.out.println(result1);

        //-----Varargs---------------

        int result2 = calculator.sumVarargs(1,10,20,30,40,50,60);
        System.out.println(result2);

    }

    //-----Option 1: method overload-------

    int sum(int a, int b){
        int result = a + b;
        return result;
    }

    int sum(int a, int b, int c){
        int result = a + b + c;
        return result;
    }

    int sum(int a, int b, int c, int d){
        int result = a + b + d;
        return result;
    }

    //-----Option 2: Arrays-----------------

    int sum(int[] numbers){

        int result = 0;

        for (int i = 0; i < numbers.length; i++) {
            result += numbers[i];
        }

        return result;
    }

    //------Option 3: Short Array------------
    //int[] arguments = [10,20,30,40,50,60];
    //int sum = calculator.sum(arguments);

    //------Option 4: Varargs----------------

    int sumVarargs(int... numbers){
        return Arrays.stream(numbers).sum();
    }

    //------Varargs (Variable Arguments)-----
    /*
        Rule 1: use ... like:

        String... words
        Integer... numbers
        Person... people
        Cat... cats

        Rule 2: just use it in methods like:

        void print(String... words)
        int sum(Integer... numbers)
        void save(Person... people)
        void feed(Cat... cats)

        Rule 3: All that argument in the method is Array:

        void print(String... words){
            for (int i = 0; i < words.length; i++) {
                System.out.println(words[i]);
            }
        }

        Rule 4: Varargs argument have to be the last in the method:

        void print(String... words, String anotherWord) // - Так нельзя!
        void print(String... words, int someNumber) // - Так нельзя!

        void print(String anotherWord, String... words) // - Так можно
        void print(int someNumber, String... words) // - Так можно

        Rule 5: is not necessary create Array for Varargs method:

        public class Main {
                public static void main(String... sss) {
                    print("Как","же","прекрасно","изучать","Java");
                }

                static void print(String... words){
                    for (int i = 0; i < words.length; i++) {
                     System.out.println(words[i]);
                    }
                }
        }

        More examples of Varargs:

        1)
                public static void main(String... sss) {
                    int[] a = new int[100];
                        for (int i = 0; i < a.length; i++) {
                        a[i] = i;
                        }

                        sum(a);
                        sum(1,2,3,4,5,6,7,8,9,10);
                }

                static void sum(int... numbers){
                    final int length = numbers.length;
                    final int sum = Arrays.stream(numbers).sum();
                    final String lineSeparator = System.lineSeparator();

                    System.out.printf("Кол-во элементов для сложения - %d, сумма - %d%s", length, sum, lineSeparator);
                }

         Result:
                    Кол-во элементов для сложения - 100, сумма - 4950
                    Кол-во элементов для сложения - 10, сумма - 55

         2)         Method printf use varargs arguments also:

                    public PrintStream printf(String format, Object ... args) {
                        return format(format, args);
                    }

         3)         String.format

                    public static String format(String format, Object... args) {
                        return new Formatter().format(format, args).toString();
                    }


          Заключение
                Итак, мы разобрали еще одну тему, varargs в Java. Разобрали, что это такое. Расписали правила использования varargs. Взглянули на примеры методов с аргументами произвольной длины, а также обсудили, когда varargs лучше использовать, а когда от использования лучше воздержаться.

                В качестве домашнего задания можно реализовать следующие методы:

                    Написать void метод, который принимает ряд целых чисел и возвращает их среднее арифметическое.
                    Написать void метод, который принимает ряд строк и выводит на печать самое длинное слово.
                    Написать метод, который возвращает boolean и принимает первым аргументом переменную типа String, а следующим аргументом ряд boolean, переменной длины.
                    Возможные значения String — AND, OR, XOR. В случае, если первый аргумент имеет какое то другое значение, метод должен бросить исключение IllegalArgumentException.
                    Метод должен осуществить логическую операцию (указанную в первом аргументе ) над каждым элементом varargs аргумента и вернуть результат вычисления.

                Пример аргументов и результата:

                    "AND", true, true, false — вернет false
                    "OR", false, true, false, false — вернет true

     */
}
