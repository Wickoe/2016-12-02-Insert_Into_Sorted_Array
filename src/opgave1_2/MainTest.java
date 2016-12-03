package opgave1_2;

import java.util.ArrayList;

public class MainTest {
	public static void main(String[] args) {
		ArrayList<Kunde> kunder = new ArrayList<>();
		kunder.add(new Kunde("Martin", "Behrens", 23));
		kunder.add(new Kunde("Martin", "Hansen", 23));

		System.out.println(kunder);
		inds�tKunde(kunder, new Kunde("Niels", "Behrens", 20));
		System.out.println(kunder);
		inds�tKunde(kunder, new Kunde("�ge", "Behrens", 55));
		System.out.println(kunder);
		inds�tKunde(kunder, new Kunde("Ase", "Behrens", 55));
		System.out.println(kunder);
	}

	/**
	 * Inds�tter objektet kunde i den sorterede liste kunder. Post: Listen
	 * kunder skal fortsat v�re sorteret.
	 */
	public static void inds�tKunde(ArrayList<Kunde> kunder, Kunde kunde) {
		boolean indexFound = false;
		int index = kunder.size() - 1;

		while (!indexFound && index > 0) {
			if (kunde.compareTo(kunder.get(index - 1)) >= 0) {
				indexFound = true;
			} else {
				index--;
			}
		}
		kunder.add(index, kunde);
	}

	public static void ins�tKunde(Kunde[] kunder, Kunde kunde) {
		boolean indexFound = false;
		int index = kunder.length - 1;

		while (!indexFound && index >= 0) {
			if (kunde.compareTo(kunder[index]) < 0) {
				indexFound = true;
			} else {
				kunder[index + 1] = kunder[index];
				index--;
			}
		}
		kunder[index] = kunde;
	}
}