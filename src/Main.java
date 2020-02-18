import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static Map<String, String> map = Map.of("1","A240","2","C21");
    static Map[] solutions = {Map.of("6","B231","8","C67"),Map.of("8","A9","5","B34")};
    static int grp = -1;
    static int sol= 0;
    static Set<String> done = new HashSet<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String input;
        int num;
        System.out.println("اهلا وسهلا بكم في لعبة البحث عن الكنز");
        System.out.println("-----------------------------------");
        while(sol < 2){
            while (grp < 0){
                System.out.println("الرجاء ادخال كود المجموعة:");
                while (!sc.hasNextInt()){
                    System.out.println("الرجاء ادخال رقم.");
                    sc.next();
                }
                num = sc.nextInt();
                if (num > 0 && num <3){
                    System.out.println("اهلا وسهلا بمجموعة رقم "+num);
                    System.out.println("احسنتم, لقد تجاوزتم المرحلة الاولى");
                    System.out.println("هيا بنا نحل اللغز التالي لكي نجد كود التشفير");
                    System.out.println(map.get(String.valueOf(num))+"اللغز موجود في طاولة رقم ");
                    System.out.println("*********************************************************");
                    grp = num;
                }
            }

            System.out.println("الرجاء ادخال كود التشفير الحالي");
            input = sc.next();
            while (!solutions[grp-1].containsKey(input) || done.contains(input)){
                System.out.println("الرجاء المحاولة مرة اخرى!!!");
                input = sc.next();
            }
            done.add(input);
            sol++;
            if (sol == 2) {
                System.out.println("ممتاز, حللتم لغز الكنز");
                System.out.println("كنزكم موجود عند حارس البناية, اذهبوا للحصول عليه");
            }else {
                System.out.println("ممتاز, حللتم لغز اخر في طريقكم نحو الكنز");
                System.out.println(solutions[grp-1].get(input)+"اللغز الجديد موجود في طاولة رقم ");
                System.out.println("*********************************************************");
            }
            //solutions[grp-1].remove(input);
        }
    }
}
