package media.elements;

public class Video extends MediaElement {
	private int volume;
	private int brightness;

	public Video(String title, int volume, int brightness) {
		super(title);
		this.volume = volume;
		this.brightness = brightness;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getBrightness() {
		return brightness;
	}

	public void setBrightness(int brightness) {
		this.brightness = brightness;
	}

	public void aumentaLuminosita() {
		brightness++;
	}

	public void diminuisciLuminosita() {
		if (brightness > 0) {
			brightness--;
		}
	}

	@Override
	public int getDuration() {
		return 2;
	}

	@Override
	public void play() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < getDuration(); i++) {
			for (int j = 0; j < volume; j++) {
				sb.append("!");
			}
			System.out.println(getTitle() + sb.toString());
			sb.setLength(0); // Resetta la StringBuilder

			for (int k = 0; k < brightness; k++) {
				sb.append("*");
			}
			System.out.println(sb.toString());
			sb.setLength(0); // Resetta la StringBuilder
		}
	}
}