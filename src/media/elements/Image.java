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
		// Implement the play() method for the image
		String exclamationPoints = "!".repeat(brightness);
		System.out.println(getTitle() + ": " + exclamationPoints);
	}

	@Override
	public int getDuration() {
		// Return a default duration for the image
		return 0;
	}
}
