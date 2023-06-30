package media.elements;

public class Video extends MediaElement {
	private int volume;
	private int brightness;
	private int duration;

	public Video(String title, int volume, int brightness, int duration) {
		super(title);
		this.volume = volume;
		this.brightness = brightness;
		this.duration = duration;
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

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
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
	public void play() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < duration; i++) {
			for (int j = 0; j < volume; j++) {
				sb.append("!");
			}
			for (int j = 0; j < brightness; j++) {
				sb.append("*");
			}
			System.out.println(getTitle() + sb.toString());
			sb.setLength(0);
		}
	}
}
