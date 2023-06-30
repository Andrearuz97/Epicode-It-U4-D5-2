package media.elements;

public class AudioRecording extends MediaElement {
	private int volume;
	private int duration;

	public AudioRecording(String title, int volume, int duration) {
		super(title);
		this.volume = volume;
		this.duration = duration;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
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
	public void play() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < duration; i++) {
			for (int j = 0; j < volume; j++) {
				sb.append("!");
			}
			System.out.println(getTitle() + sb.toString());
			sb.setLength(0);
		}
	}
}
