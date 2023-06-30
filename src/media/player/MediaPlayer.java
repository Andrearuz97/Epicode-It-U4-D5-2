package media.player;

import media.elements.MediaElement;

public class MediaPlayer {
	private MediaElement[] mediaElements;

	public MediaPlayer(MediaElement[] mediaElements) {
		this.mediaElements = mediaElements;
	}

	public void playMediaElement(int index) {
		if (index >= 0 && index < mediaElements.length) {
			mediaElements[index].play();
		}
	}
}
