package media.elements;

public class Image extends MediaElement implements Reproducible {
	private int brightness;

	public Image(String title, int brightness) {
		super(title);
		this.brightness = brightness;
	}

	public void show() {
		String asterisks = "*".repeat(brightness);
		System.out.println(getTitle() + ": " + asterisks);
	}

	@Override
	public void play() {
		String asterisks = "*".repeat(brightness);
		System.out.println(getTitle() + ": " + asterisks);
	}

	@Override
	public int getDuration() {
		return 0;
	}
}
