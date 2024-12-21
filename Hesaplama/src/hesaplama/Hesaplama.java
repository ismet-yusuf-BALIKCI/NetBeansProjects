
package hesaplama;



public class Hesaplama {
    
    String[] dizi ;
    int es;
     public void stack(int boyut){
         String[] dizi=new String[boyut];
         es=0;
     }
    

    public string pop(){
        String r = dizi[es-1];
        dizi[--es]= null;
        return r;
    }
    public void push(String a){
       if( es==dizi.length ){
           System.out.println("dizi dolu");
       }else{
           dizi[es++]=a;
       }    
    }
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
        System.out.print("İşlemi giriniz: ");
        String yıgıt = sc.nextLine();
        

    }
    
}





















import java.util.Scanner;
import java.util.Stack;

public class StackCalculatorManual {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("İşlemi giriniz: ");
        String expression = scanner.nextLine();
        scanner.close();

        System.out.println("Sonuç: " + evaluateExpression(expression));
    }

    public static int evaluateExpression(String expression) {
        Stack<Integer> values = new Stack<>();
        Stack<Character> operators = new Stack<>();

        int i = 0;
        while (i < expression.length()) {
            char c = expression.charAt(i);

            // Boşlukları geç
            if (c == ' ') {
                i++;
                continue;
            }

            // Sayı ise değeri hesapla
            if (c >= '0' && c <= '9') {
                int value = 0;
                while (i < expression.length() && expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                    value = value * 10 + (expression.charAt(i) - '0');
                    i++;
                }
                values.push(value);
                i--; // Döngünün bir karakter ilerlemesini dengelemek için geri alıyoruz
            }
            // İşlemse
            else if (c == '+' || c == '-' || c == '*' || c == '/') {
                // Öncelikli işlemleri değerlendir
                while (!operators.isEmpty() && precedence(c, operators.peek())) {
                    int b = values.pop();
                    int a = values.pop();
                    char op = operators.pop();
                    values.push(applyOperation(a, b, op));
                }
                operators.push(c);
            }
            i++;
        }

        // Kalan işleçleri uygula
        while (!operators.isEmpty()) {
            int b = values.pop();
            int a = values.pop();
            char op = operators.pop();
            values.push(applyOperation(a, b, op));
        }

        return values.pop();
    }

    public static boolean precedence(char op1, char op2) {
        // Çarpma ve bölme işlemlerinin önceliği daha yüksek
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) return false;
        else return true;
    }

    public static int applyOperation(int a, int b, char op) {
        int result = 0;
        if (op == '+') result = a + b;
        else if (op == '-') result = a - b;
        else if (op == '*') result = a * b;
        else if (op == '/') {
            if (b == 0) {
                throw new ArithmeticException("Sıfıra bölme hatası");
            }
            result = a / b;
        }
        return result;
    }
}
