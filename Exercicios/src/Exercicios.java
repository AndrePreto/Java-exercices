import java.util.Scanner;

public class Exercicios {

	public static void main(String[] args) {
		//System.out.println(FirstLetterToUpperCase("hi, my name is André"));
		RussianMultiplication();
	}
	
	public static String FirstLetterToUpperCase(String text){
		String words = text;
		String Uppercase = "";
		for(int i=0; i < words.length(); i++){
			if(i==0){
				Uppercase = Uppercase + Character.toUpperCase(words.charAt(i));
			}else if(words.charAt(i-1) == ' '){
				Uppercase = Uppercase + Character.toUpperCase(words.charAt(i));
			}else{
				Uppercase += words.charAt(i);
			}
		}
		 return Uppercase;
		
	}
	
	public static int ValidateInt(){
		Scanner scanner = new Scanner (System.in);
		int input = 0;
		while (true){
			
			if(scanner.hasNextInt()){
				input = scanner.nextInt();
				return input;
			}else{
				System.out.println("Introduza um número");
				scanner.next();
			}
		}
	}
	
	
	public static void RussianMultiplication(){
		System.out.println("Introduza o primeiro número");
		int x = ValidateInt();
		System.out.println("Introduza o segundo número");
		int y = ValidateInt();
		int z = 0;
	
		
		if(x == 1){
			System.out.println(y);
		}else if (y == 1){
			System.out.println(x);
		}else{
		
			while(y>=1){
				if(y%2 == 0){
					x*=2;
					y/=2;
				}else{
					z += x;
					x*=2;
					y/=2;
					
				}
			}
		System.out.println(z);
		}
	}
}
