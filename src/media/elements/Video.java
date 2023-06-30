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
		return 1;
	}

	@Override
	public void play() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < getDuration(); i++) {
			for (int j = 0; j < getVolume(); j++) {
				sb.append("!");
			}
			for (int j = 0; j < getBrightness(); j++) {
				sb.append("*");
			}
			System.out.println(getTitle() + sb.toString());
			sb.setLength(0);
		}
	}

}
