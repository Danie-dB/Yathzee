import java.util.*;


//RECHT PRINTEN??

public class PogingEen {
	public static void main(String[] args) {
		YathzeeSpel letsGo = new YathzeeSpel();
		System.out.println("Let's play!");
		letsGo.Spelen();
		
	}
}

class YathzeeSpel {
	Scanner scanner = new Scanner(System.in);
	ArrayList<Dobbelsteen> DobbelRij = new ArrayList<>();
	int[] blokkeerarray = new int[] {0,0,0,0,0};
	
	YathzeeSpel(){
		for (int d = 0; d < 5; d++) {
			DobbelRij.add(d, new Dobbelsteen());
			} 
		}
	
	void Spelen() {
		boolean ja = true;
		System.out.println("Worpmogelijkheden:");
		System.out.println("1 2 3 4 5");
		
		while (ja) {
			System.out.println("Dobbelen maar! (klik q om te stoppen)");
			int x = 0;
			String invoer = scanner.nextLine();
			invoer = invoer.toLowerCase();
			switch (invoer) {
			case "q":
				ja = false;
				System.out.println("U bent gestopt.");
			default:
				for (Dobbelsteen uitkomst : DobbelRij) {
					if (blokkeerarray[x] == 0) {
					uitkomst.d1 = uitkomst.Werpen();
					System.out.println(uitkomst.d1 + " ");
					}
		//			Dobbelsteen.d1[x] = uitkomst.d1;
				}
		//		Dobbelsteen.Werpen();
		//		YathzeeSpel.DobbelRij.add(Dobbelsteen.geworpen);
				
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
		int [] geworpen = new int [5];
		int d1;
		
		int Werpen() {
			Random getal = new Random();
			int d1 = getal.nextInt(5)+1;
			return d1;
		}
}


/*
 * class Dobbelsteen {
		int [] geworpen = new int [5];
		int d1;
		
		int Werpen() {
			Random getal = new Random();
			int d1 = getal.nextInt(5)+1;
			return d1;
		}
}


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