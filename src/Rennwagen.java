
public class Rennwagen implements Runnable {
	private String name;
	private short weg;
	private byte geschwindigkeit;
	private byte zähler;
	private byte min = 100;
	private byte max = 0;
	private Rennstrecke strecke;

	public Rennwagen(String name, Rennstrecke strecke) {
		this.name = name;
		this.strecke=strecke;
	}

	@Override
	public void run() {

		while (weg < strecke.getLaenge()) {
			try {
				geschwindigkeit = (byte) (50 + 50 * Math.random());
				if (geschwindigkeit > max) {
					max = geschwindigkeit;
				}
				if (geschwindigkeit < min) {
					min = geschwindigkeit;
				}
				weg += geschwindigkeit;
				zähler++;
				Thread.sleep(500);
				synchronized(strecke){
				System.out.println("Rennwagen: " + name + " Weg: " + weg + "m Tempo: " + geschwindigkeit + "m/s");
				if (weg >= strecke.getLaenge()) {
					System.out.println(name + " hat das Ziel erreicht! ");
					System.out.println(
							"Durchschnitt: " + weg / zähler + "m/s Min: " + min + "m/s Max: " + max + "m/s \n");
				}
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
