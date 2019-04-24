import java.util.*;

public class PogingEen {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		YathzeeSpel letsGo = new YathzeeSpel();
		System.out.println("Let's play!");
		
		letsGo.Spelen();
		
	}
}





class YathzeeSpel {
	Scanner scanner = new Scanner(System.in);
	ArrayList<Integer> DobbelRij = new ArrayList<>();
	Dobbelsteen tal = new Dobbelsteen();
	tal.Werpen(d1) = 0;
	
	
	
	void Spelen() {
		boolean ja = true;
		System.out.println("Worp");
		System.out.println("1 2 3 4 5");
		
		while (ja) {
			System.out.println("Welke wilt u vasthouden? (q om te stoppen)");
			String invoer = scanner.nextLine();
			switch (invoer) {
			case "q":
				ja = false;
				System.out.println("U bent gestopt.");
				break;
			default:
				System.out.println("Nog een rondje");
				
			}
		}
    }
	
	void Vasthouden() {
		String invoer = scanner.nextLine();
		Integer.parseInt(invoer);
		
	}
}

class Dobbelsteen {
		
		int Werpen() {
			Random getal = new Random();
			int d1 = getal.nextInt(5)+1;
			return d1;
		}
}


/*
class Gooien {
	int[] dobbelsteen = new int[5];
			for (int i =1; i<7; i++) {
				System.out.println(i);
			}
}

	void WerpenFirst() {
		Random getal = new Random();
		int d1 = getal.nextInt(5)+1;
		int d2 = getal.nextInt(5)+1;
		int d3 = getal.nextInt(5)+1;
		int d4 = getal.nextInt(5)+1;
		int d5 = getal.nextInt(5)+1;
		System.out.println(d1 + " " + d2 + " " + d3 + " " + d4 + " " + d5);
	}
*/