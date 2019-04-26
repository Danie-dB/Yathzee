import java.util.*;

public class PogingEen {
	public static void main(String[] args) {
		YathzeeSpel letsGo = new YathzeeSpel();
		System.out.println("Welkom bij Yathzee!");
		Speler a = new Speler();
		Speler b = new Speler();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Wat is de naam van speler 1?");
		String naamInvoer = scanner.nextLine();
		a.naam = naamInvoer;
		System.out.println("Wat is de naam van speler 2?");
		String naamInvoer2 = scanner.nextLine();
		b.naam = naamInvoer2;
		System.out.println("Welkom " + naamInvoer + " en " + naamInvoer2 + ",");
		System.out.println("Let's play Yathzee! \n");
		letsGo.Spelen(a);
		System.out.println("*********************");
		letsGo.Spelen(b);
		System.out.println("*********************");
		System.out.println("Bedankt voor het spelen!");
	}
}

class YathzeeSpel {
	Scanner scanner = new Scanner(System.in);
	ArrayList<Dobbelsteen> DobbelRij = new ArrayList<>();
	int[] blokkeerarray = new int[] { 0, 0, 0, 0, 0 };

	YathzeeSpel() {
		for (int d = 0; d < 5; d++) {
			DobbelRij.add(d, new Dobbelsteen());
		}
	}

	void Spelen(Speler Speler) {
		boolean ja = true;
		int Worpie = 1;
		System.out.println(Speler.naam + " it's your turn! Veel plezier met spelen!");
		System.out.println("Worpmogelijkheden: ");
		System.out.println("1 2 3 4 5");
		System.out.println("Dobbelen maar!");
		Speler bob = new Speler();

		while (ja) {
			System.out.println("Enter = gooien, Q = stoppen");
			Worp dobbelen = new Worp();
			String invoer = scanner.nextLine();
			invoer = invoer.toLowerCase();
			switch (invoer) {

			case "q":
				ja = false;
				System.out.println(Speler.naam + ", u wilt stoppen met gooien.");
				System.out.println("Een overzicht van uw worpen:");

				int p = 0;
				for (int totalUitslag : bob.getHistory()) {
					if (p % 5 == 0) {
						System.out.print(" \n");
					}
					System.out.print(totalUitslag);
					System.out.print(" ");
					p++;
				}
				System.out.println(" ");
				Arrays.fill(blokkeerarray, 0);
				break;
			default:
				System.out.println("Worp " + Worpie++ + ": ");

				for (int g = 0; g < DobbelRij.size(); g++) {
					Dobbelsteen huidige = DobbelRij.get(g);
					if (blokkeerarray[g] == 0) {
						huidige.d1 = huidige.Werpen();
					}
					dobbelen.Geschiedde(huidige.d1);
				}
				bob.AddAll(dobbelen.WorpGeschiedenis);

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
		for (int i = 0; i < reeks.length(); i++) {
			String positie = reeks.substring(i, i + 1);
			Integer intpositie = Integer.parseInt(positie) - 1;
			blokkeerarray[intpositie] = 1;
		}
	}
}

class Dobbelsteen {
	int d1;
	int Werpen() {
		Random getal = new Random();
		d1 = getal.nextInt(6) + 1;
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
	String naam;
	private ArrayList<Integer> History = new ArrayList<>();

	public void AddAll(ArrayList<Integer> totaalLijst) {
		History.addAll(totaalLijst);
	}

	public ArrayList<Integer> getHistory() {
		return History;
	}
}