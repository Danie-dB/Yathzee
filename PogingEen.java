import java.util.*;

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
		int Worpie = 1;
		System.out.println("Worpmogelijkheden: ");
		System.out.println("1 2 3 4 5");
		
		while (ja) {
			System.out.println("Dobbelen maar!");
			System.out.println("Enter = gooien, Q = stoppen");
			Worp dobbelen = new Worp(); 
			String invoer = scanner.nextLine();
			invoer = invoer.toLowerCase();
			switch (invoer) {
			
				case "q":
					ja = false;
					System.out.println("U bent gestopt.");
					break;
				default:
					System.out.println("Worp " + Worpie++ + ": ");
					
						for (int g = 0; g <DobbelRij.size(); g++) {
							Dobbelsteen huidige = DobbelRij.get(g);
								if (blokkeerarray[g]==0) {
								huidige.d1 = huidige.Werpen();
						}
								dobbelen.Geschiedde(huidige.d1);
						}
						for (int uitslagPrint : dobbelen.WorpGeschiedenis) {
							System.out.print(uitslagPrint);
							System.out.print(" ");
						}
					System.out.println(" ");
					System.out.println("Welke steen/stenen wilt u graag vasthouden?");
					Vasthouden();
					System.out.println("Nog een rondje");
					}
			}
		}
	
	void Vasthouden() {
		String reeks = scanner.nextLine();
		for (int i =0; i < reeks.length(); i++) {
			String positie = reeks.substring(i, i+1);
			Integer intpositie = Integer.parseInt(positie) -1;
			blokkeerarray[intpositie] = 1;
		}
		
	}
}

class Dobbelsteen {
		int d1;
		
		int Werpen() {
			Random getal = new Random();
			d1 = getal.nextInt(6)+1;
			return d1;
		}
}


class Worp {
	ArrayList<Integer> WorpGeschiedenis = new ArrayList<Integer>();
		void Geschiedde(int d2) {
			WorpGeschiedenis.add(d2);
	}
	
}

class Speler {
	Scanner scanner = new Scanner(System.in);
	ArrayList<Speler> History = new ArrayList<>();
	String Speler1 = scanner.nextLine();
	Worp Ed = new Worp(); 
	
	
}