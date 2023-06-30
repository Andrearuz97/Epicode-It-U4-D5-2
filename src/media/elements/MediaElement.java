package media.elements;

public abstract class MediaElement implements Reproducible {
	private String title;

	public MediaElement(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
}