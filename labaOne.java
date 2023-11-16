package labOne;

import java.util.Scanner;
import java.lang.Math;

public class labaOne {

	public static void main(String[] args) {
		/*double a, b, x, z;
		Scanner input = new Scanner(System.in);
		System.out.println("Введите переменные:");
		System.out.print("Введите a: ");
		a = input.nextInt();
		System.out.print("Введите b: ");
		b = input.nextInt();
		System.out.print("Введите x: ");
		x = input.nextInt();
		input.close();
		if (x <= a) {
			z = Math.log(x) * Math.sin(x);
			System.out.print("Значение функции z = ln(x) * sin(x): " + z);
		} else if (a < x && x < b) {
			z = Math.pow(x, 2) * Math.cos(x);
			System.out.print("Значение функции z = pow(x,2) * cos(x): " + z);
		} else {
			z = Math.pow(x, 5);
			System.out.print("Значение функции z = pow(x,5): " + z);
		}*/
		
		try{
            Scanner in = new Scanner(System.in);
            int x = in.nextInt();
            if(x>=30){
               throw new Exception("Число х должно быть меньше 30");
           }
        }
        catch(Exception ex){
             
            System.out.println(ex.getMessage());
        }
		System.out.println("Программа завершена");
	}
}
