public class lesson2 {
    public static void main(String[] args) {
        // Задача 1
                int variable1 = 15,variable2 = 4;
                int amount = variable1 + variable2;
                int difference = variable1 - variable2;
                int product = variable1 * variable2;
                float variable_1 = (float) (variable1);
                float variable_2 = (float) (variable2);
                float quotient = variable_1 / variable_2;
                System.out.println("amount = " + amount);
                System.out.println("difference = " + difference);
                System.out.println("product = " + product);
                System.out.println("quotient = " + quotient);
       // Задача 2
                double temperature = 25;
                if (temperature >= 18) {
                    System.out.println("Наденьте сегодня майку");
                } else {
                    System.out.println("Наденьте свитер");
                }
        // Задача 3
                int salary1 = 1200, salary2 = 400, salary3 = 300;
                if (salary1>salary2 && salary1>salary3 && salary2<salary3) {
                    difference=salary1-salary2;
                    System.out.println(difference);

                }
                if (salary1>salary2 && salary1>salary3 && salary3<salary2){
                    difference=salary1-salary3;
                    System.out.println(difference);
                }

                if (salary2>salary1 && salary2>salary3 && salary3<salary1){
                    difference=salary2-salary3;
                    System.out.println(difference);
                }
                if (salary2>salary1 && salary2>salary3 && salary1<salary3){
                    difference=salary2-salary1;
                    System.out.println(difference);
                }
                if (salary3>salary2 && salary3>salary1 && salary2<salary1){
                    difference=salary3-salary2;
                    System.out.println(difference);
                }
                if (salary3>salary2 && salary3>salary1 && salary1<salary2){
                    difference=salary3-salary1;
                    System.out.println(difference);
                }
        // Задача 4
                int a=3, n=5;
                int c=a;
                for (int i=1; i<n ; i++) {
                    c=c*a;
                }
                System.out.println(c);
            }

        }

