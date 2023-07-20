import java.util.Scanner;

public class S26486_p01 {
    public static void main(String[] args) {
        boolean mainCondition = true;
        System.out.println("Witaj w programie Kalkulator.");

        do{
            System.out.println();
            System.out.println("Podaj liczby oraz operacje jaka chcesz na nich wykonac.");
            System.out.println("Jesli chcesz przerwac program, wprowadz liczbe 0 dla obu wartosci.");
            Scanner scanner = new Scanner(System.in);
            boolean conditionNumber1 = true;
            int num1 = 0;
            int num2 = 0;
            while(conditionNumber1) {
                System.out.print("Podaj pierwsza liczbe:");
                num1 = scanner.nextInt();
                System.out.print("Podaj druga liczbe:");
                num2 = scanner.nextInt();
                if ((num1 < 0) || (num1 > 65535) || ((num2 < 0) || (num2 > 65535))) {
                    System.out.println("Nieprawidlowe wartosci, prosze podaj liczby z zakresu 0 - 65536");
                } else {
                    conditionNumber1 = false;
                    System.out.println();
                }
                if (num1 == 0 && num2 == 0) {
                    mainCondition = false;

                    break;
                }
            }

            if(!mainCondition){
                System.out.println("Obie wartosci to 0 - zgodnie z zasadami, kalkulator zostaje zamkniety.");

                break;
            }

            System.out.print("Podaj operacje: ");
            String operation = scanner.next();

            switch(operation){
                case "+":{
//                    System.out.println("Dodawanie");
                    System.out.print(num1 + " - ");
                    for (int i = 15; i >= 0; i--) {
                        int mask = 1 << i;
                        int bit = (num1 & mask) != 0 ? 1 : 0;
                        System.out.print(bit);
                    }
                    System.out.println();

                    System.out.print(num2 + " - ");
                    for (int i = 15; i >= 0; i--) {
                        int mask = 1 << i;
                        int bit = (num2 & mask) != 0 ? 1 : 0;
                        System.out.print(bit);
                    }


                    int tmp;
                    int result;

                    do {
                        result = num1 ^ num2;
                        tmp = num1 & num2;
                        tmp = tmp << 1;
                        num1 = result;
                        num2 = tmp;
                    } while (tmp != 0);

                    System.out.println();
                    System.out.print(result + " - ");
                    for (int i = 15; i >= 0; i--) {
                        int mask = 1 << i;
                        int bit = (result & mask) != 0 ? 1 : 0;
                        System.out.print(bit);
                    }


                    break;
                }
                case "-":{
                    if(num1 < num2){
                        int tmp;
                        tmp = num2;
                        num2 = num1;
                        num1 = tmp;
                    }
//                    System.out.println("Odejmowanie");
                    System.out.print(num1 + " - ");
                    for (int i = 15; i >= 0; i--) {
                        int mask = 1 << i;
                        int bit = (num1 & mask) != 0 ? 1 : 0;
                        System.out.print(bit);
                    }
                    System.out.println();

                    System.out.print(num2 + " - ");
                    for (int i = 15; i >= 0; i--) {
                        int mask = 1 << i;
                        int bit = (num2 & mask) != 0 ? 1 : 0;
                        System.out.print(bit);
                    }
                    System.out.println();
                    int result;
                    int tmp;
                    while (num2 != 0) {
                        int mask = num1 ^ num2;
                        tmp = (~num1 & num2) << 1;
                        num1 = mask;
                        num2 = tmp;
                    }
                    result = num1;

                    System.out.print(result + " - ");
                    for (int i = 15; i >= 0; i--) {
                        int mask = 1 << i;
                        int bit = (result & mask) != 0 ? 1 : 0;
                        System.out.print(bit);
                    }
                    break;
                }
                case "*":{
//                    System.out.println("Mnozenie");
                    System.out.print(num1 + " - ");
                    for (int i = 15; i >= 0; i--) {
                        int mask = 1 << i;
                        int bit = (num1 & mask) != 0 ? 1 : 0;
                        System.out.print(bit);
                    }
                    System.out.println();

                    System.out.print(num2 + " - ");
                    for (int i = 15; i >= 0; i--) {
                        int mask = 1 << i;
                        int bit = (num2 & mask) != 0 ? 1 : 0;
                        System.out.print(bit);
                    }
                    System.out.println();

                    int result = 0;
                    while (num2 != 0) {
                        if ((num2 & 1) == 1) {
                            result = result + num1;
                        }
                        num1 = num1 << 1;
                        num2 = num2 >> 1;
                    }
                    System.out.print(result + " - ");
                    for (int i = 15; i >= 0; i--) {
                        int mask = 1 << i;
                        int bit = (result & mask) != 0 ? 1 : 0;
                        System.out.print(bit);
                    }

                    break;
                }
                case "/":{
//                    System.out.println("Dzielnie");
                    if(num1 < num2){
                        int tmp;
                        tmp = num2;
                        num2 = num1;
                        num1 = tmp;
                    }
                    System.out.print(num1 + " - ");
                    for (int i = 15; i >= 0; i--) {
                        int mask = 1 << i;
                        int bit = (num1 & mask) != 0 ? 1 : 0;
                        System.out.print(bit);
                    }
                    System.out.println();

                    System.out.print(num2 + " - ");
                    for (int i = 15; i >= 0; i--) {
                        int mask = 1 << i;
                        int bit = (num2 & mask) != 0 ? 1 : 0;
                        System.out.print(bit);
                    }
                    System.out.println();


                    int result = 0;
                    while (num1 >= num2) {
                        int temp = num2;
                        int i = 0;
                        while (num1 >= temp) {
                            num1 -= temp;
                            result += 1 << i;
                            i++;
                            temp <<= 1;
                        }
                    }
                    System.out.print(result + " - ");
                    for (int i = 15; i >= 0; i--) {
                        int mask = 1 << i;
                        int bit = (result & mask) != 0 ? 1 : 0;
                        System.out.print(bit);
                    }

                    break;
                }
                default:{
                    System.out.println("Wprowadzono niepoprawną operacje, spróbuj ponownie.");
                }
            }

        } while(mainCondition);
    }
}