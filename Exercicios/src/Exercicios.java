import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

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
	
	
	public static int russianMultiplication(int number1, int number2){
		if(number2==1){
			return number1;
		}
		if(Math.floorMod(number2, 2)==1){
			return number1 + russianMultiplication(number1*2,(int) Math.floor(number2/2));
		}else{
			return russianMultiplication(number1*2,(int) Math.floor(number2/2));
		}
	}
	
	public static String capitalizeFirstLetterWords(String text){
		if(!text.isEmpty()){
			String[] words = text.split("\\s+");
			for (int i = 0; i < words.length; i++) {
				words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
			}
			return String.join(" ", words);
		}else{
			return "You chose an empty string, please try again";
		}
	}
	
	public static void fibonacci(){
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Por favor indique quantos números da sequência de Fibonacci quer:");
			Integer length = null;
			while (true) {
				String stored = scanner.nextLine();
				try {
					length = Integer.parseInt(stored);
					break;
				} catch (NumberFormatException e) {
					System.out.println("Por favor escolha uma opção válida!");
				}
			}
			if(length!=0){
				ArrayList<Integer> fibonacciNumbers = new ArrayList<>();
				int sum = 0;
				for (int i = 0; i < length; i++) {
					if (i > 1) {
						fibonacciNumbers.add(fibonacciNumbers.get(i - 2) + fibonacciNumbers.get(i - 1));
					} else {
						fibonacciNumbers.add(i);
					}
					sum += fibonacciNumbers.get(i);
				}
				System.out.println("Os números são: " + fibonacciNumbers.stream().map(Object::toString).collect(Collectors.joining(", ")));
				System.out.println(String.format("A média é: %.2f", (double)sum/length));
			}
			else{
				System.out.println("Não há sequências com 0 elementos.");
			}
		}
	}
	public static final LinkedHashMap<String,Double> sideralPeriodPerPlanet = new LinkedHashMap<>();
	static{
		sideralPeriodPerPlanet.put("Mercúrio", 0.241);
		sideralPeriodPerPlanet.put("Vénus", 0.615);
		sideralPeriodPerPlanet.put("Terra", 1.000);
		sideralPeriodPerPlanet.put("Marte", 1.881);
		sideralPeriodPerPlanet.put("Júpiter", 11.86);
		sideralPeriodPerPlanet.put("Saturno", 29.46);
		sideralPeriodPerPlanet.put("Urano", 84.81);
		sideralPeriodPerPlanet.put("Neptuno", 164.8);
	}

	
	public static void planetaryAge(Long earthAgeInSeconds){
		Long earthYearInSeconds = (long) (365*24*60*60);
		double earthAgeInYears = (double) (earthAgeInSeconds/earthYearInSeconds);
		for(String planetName: sideralPeriodPerPlanet.keySet()){
			System.out.println(String.format("A pessoa teria %.3f ano(s) no planeta %s", (double) (earthAgeInYears/sideralPeriodPerPlanet.get(planetName)), planetName));
		}
	}
	
	public static void planetaryAge2(Long earthAgeInSeconds){
		Long earthYearInSeconds = (long) (365*24*60*60);
		double earthAgeInYears = (double) (earthAgeInSeconds/earthYearInSeconds);
		for(Planet p: Planet.values()){
			System.out.println(String.format("A pessoa teria %.3f ano(s) no planeta %s", (double) (earthAgeInYears/p.sideralPeriod()), p.Name()));
		}
	}
	
	public static void palyndromeString(String text){
		String text2 = text.replaceAll("\\W","").toLowerCase();
		int length = text2.length();
		String firstHalf = text2.substring(0, Math.floorDiv(length, 2));
		String secondHalf = null;
		if(length % 2 ==1){
			secondHalf = text2.substring(Math.floorDiv(length, 2)+1);
		}else{
			secondHalf = text2.substring(Math.floorDiv(length, 2));
		}
		String invertedSecondHalf = new StringBuilder(secondHalf).reverse().toString();
		if(firstHalf.equals(invertedSecondHalf)){
			System.out.println("Sim, o texto inserido é um palíndromo");
		}else{
			System.out.println("Não, o texto não é um palíndromo");
		}
	}
	
	public static void palyndromeString2(String text){
		String text2 = text.replaceAll("\\W","").toLowerCase();
		int length = text2.length();
		for(int i = 0; i < length/2; i++){
			if(text2.charAt(i) != text2.charAt(length - i - 1)){
				System.out.println("Não, o texto não é um palíndromo");
				break;
			}
		}
		System.out.println("Sim, o texto inserido é um palíndromo");
	}
	
	public static void isItASunday(){
		DayOfWeek d = LocalDate.parse("2017-01-10").getDayOfWeek();
		if(d.equals(DayOfWeek.SUNDAY)){
			System.out.println("O dia que indicou é um Domingo.");
		}else{
			System.out.println(String.format("O dia que indicou não é Domingo. O próximo Domingo é em %s",LocalDate.parse("2017-01-10").with(TemporalAdjusters.next(DayOfWeek.SUNDAY))));	
		}
	}
	
	public static void fizzBuzz(int x, int y){
		if ((x % 3 != 0) && (x % 5 != 0)) {
			System.out.println(x);
		} else if ((x % 3 == 0) && (x % 5 != 0)) {
			System.out.println("Fizz");
		} else if ((x % 3 != 0) && (x % 5 == 0)) {
			System.out.println("Buzz");
		} else {
			System.out.println("FizzBuzz");
		}
		if (x != y) {
			if (x < y) {
				fizzBuzz(x + 1, y);
			} else if (x > y) {
				fizzBuzz(x - 1, y);
			}
		}
	}
	
	public static void fizzBuzz2(int x, int y){
		if(x % 15 == 0){
			System.out.println("FizzBuzz");
		}else if(x % 3 == 0){
			System.out.println("Fizz");
		}else if(x % 5 ==0){
			System.out.println("Buzz");
		}else{
			System.out.println(x);
		}
		if (x != y) {
			if (x < y) {
				fizzBuzz(x + 1, y);
			} else if (x > y) {
				fizzBuzz(x - 1, y);
			}
		}
	}
}

enum Planet{
	MERCURY("Mercúrio", 0.241),
	VENUS("Vénus", 0.615),
	EARTH("Terra", 1.000), 
	MARS("Marte", 1.881), 
	JUPITER("Júpiter", 11.86), 
	SATURN("Saturno", 29.46), 
	URANUS("Urano", 84.81), 
	NEPTUNE("Neptuno", 164.8);
	
	private final String name;
	private final double sideralPeriod;
	
	Planet(String name, double sideralPeriod){
		this.name = name;
		this.sideralPeriod = sideralPeriod;
	}
	
	public String Name(){
		return name;
	}
	
	public double sideralPeriod(){
		return sideralPeriod;
	}
}
