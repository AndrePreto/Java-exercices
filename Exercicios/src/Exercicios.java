import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Scanner;

public class Exercicios {

	public static void main(String[] args) {
		//System.out.println(FirstLetterToUpperCase("hi, my name is André"));
		//RussianMultiplication();
		//DaystonextSunday();
		//Palindromo();
		BuzzFizz();
		
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
	
	public static void DaystonextSunday(){
		
		
		while(true){
			try{
				System.out.println("Introduza o ano");
				int ano = ValidateInt();
				System.out.println("Introduza o mês");
				int mês = ValidateInt();
				System.out.println("Introduza o dia");
				int dia = ValidateInt();
				LocalDate DiaEscolhido = LocalDate.of(ano, mês, dia);
				System.out.println("Dia escolhido -> " + DiaEscolhido);
				
				DayOfWeek DiadaSemana = DiaEscolhido.getDayOfWeek();
				int Dia = DiadaSemana.getValue();
				
				if (Dia == 7){
					System.out.println("Dia da Semana -> " + DiadaSemana);
					
				}else{
					System.out.println("Dia da Semana -> " + DiadaSemana);
					System.out.println((7-Dia) + " dia(s) para o próximo domingo");
					System.out.println(DiaEscolhido.with(TemporalAdjusters.next(DayOfWeek.SUNDAY)));
				}
			}catch(DateTimeException E){
				System.out.println("A data introduzida não é válida");
			}
		}
	}
	
	public static void Palindromo(){
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Introduza uma palavra");
		String text = scanner.nextLine();
		String textinverted = "";
		
		for(int i= text.length()-1; i >= 0; i--){
			textinverted += text.charAt(i);
		}
		System.out.println(textinverted);
		
		if(text == textinverted){
			System.out.println("É um palindromo");
		}else{
			System.out.println("Não é um palindromo");
		}
	}
	
	public static void BuzzFizz(){
		System.out.println("Introduza o x");
		int x = ValidateInt();
		System.out.println("Introduza o y");
		int y = ValidateInt();
		
		for(int i=x; i<=y; i++){
			if (i%3==0 && i%5==0){
				System.out.println(i +" FizzBuzz");
			}else if (i%5==0){
				System.out.println(i + " Buzz");
			}else if (i%3==0){
				System.out.println(i + " Fizz");
			}else{
				System.out.println(i);
			}
		}
	}
}
