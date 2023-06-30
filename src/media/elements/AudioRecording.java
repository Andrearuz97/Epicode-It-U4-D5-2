package media.elements;

public class AudioRecording extends MediaElement {
	private int volume;

	public AudioRecording(String title, int volume) {
		super(title);
		this.volume = volume;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public void abbassaVolume() {
		if (volume > 0) {
			volume--;
		}
	}

	public void alzaVolume() {
		volume++;
	}

	@Override
	public int getDuration() {
		return 1;
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
		}
	}
}