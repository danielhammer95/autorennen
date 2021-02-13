
public class Autorennen {
	public static synchronized void starteRennen() {
		Rennstrecke strecke = new Rennstrecke((short)1000);
		Thread trd1 = new Thread(new Rennwagen("Porsche", strecke));
		Thread trd2 = new Thread(new Rennwagen("Audi", strecke));
		Thread trd3 = new Thread(new Rennwagen("BMW", strecke));
		Thread trd4 = new Thread(new Rennwagen("Toyota", strecke));

		System.out.println("Rennen startet!");

		trd1.start();
		trd2.start();
		trd3.start();
		trd4.start();

		try {
			trd1.join();
			trd2.join();
			trd3.join();
			trd4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		starteRennen();
	}
}
