import java.util.Scanner;

import media.elements.AudioRecording;
import media.elements.Image;
import media.elements.MediaElement;
import media.elements.Video;
import media.player.MediaPlayer;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MediaElement[] mediaElements = new MediaElement[5];

		for (int i = 0; i < mediaElements.length; i++) {
			System.out.println("Inserisci il tipo di elemento (1 = Audio, 2 = Video, 3 = Immagine):");
			int type = scanner.nextInt();
			scanner.nextLine();

			System.out.println("Inserisci il titolo:");
			String title = scanner.nextLine();

			switch (type) {
			case 1:
				System.out.println("Inserisci il volume:");
				int volume = scanner.nextInt();
				mediaElements[i] = new AudioRecording(title, volume);
				break;
			case 2:
				System.out.println("Inserisci il volume:");
				int videoVolume = scanner.nextInt();
				System.out.println("Inserisci la luminosità:");
				int brightness = scanner.nextInt();
				mediaElements[i] = new Video(title, videoVolume, brightness);
				break;
			case 3:
				System.out.println("Inserisci la luminosità:");
				int imageBrightness = scanner.nextInt();
				mediaElements[i] = new Image(title, imageBrightness) {
					@Override
					public void play() {
						show();
					}
				};
				break;

			}
		}

		MediaPlayer mediaPlayer = new MediaPlayer(mediaElements);

		int choice;
		do {
			System.out.println("Inserisci l'indice dell'elemento da riprodurre (0 per uscire):");
			choice = scanner.nextInt();

			if (choice >= 1 && choice <= mediaElements.length) {
				mediaPlayer.playMediaElement(choice - 1);
			} else if (choice != 0) {
				System.out.println("Indice non valido");
			}
		} while (choice != 0);

		scanner.close();
	}
}