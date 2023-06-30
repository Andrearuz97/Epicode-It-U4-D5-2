
/**
 * Questo è il metodo principale (main) dell'applicazione che permette di riprodurre diversi tipi di elementi multimediali.
 * L'applicazione richiede all'utente di inserire il tipo di elemento (audio, video o immagine) e il relativo titolo.
 * Per gli elementi audio, viene richiesto anche il volume, mentre per i video viene richiesto sia il volume che la luminosità.
 * Una volta che gli elementi sono stati inseriti, vengono memorizzati in un array di elementi multimediali.
 * Successivamente, l'applicazione crea un oggetto MediaPlayer passando l'array di elementi multimediali.
 * L'utente può quindi selezionare un elemento da riprodurre inserendo l'indice corrispondente. Gli elementi vengono riprodotti
 * utilizzando il metodo play() dell'elemento selezionato. Se l'elemento è un'immagine, viene visualizzata la luminosità
 * utilizzando asterischi, mentre se è un elemento audio, viene utilizzato il volume per visualizzare i punti esclamativi.
 * L'utente può inserire 0 per uscire dall'applicazione. NB se non vengono inseriti i 5 elementi non si può procedere alla 
 * lettura dei file.
 */

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
			int type;
			do {
				System.out.println("Inserisci il tipo di formato (1 = Audio, 2 = Video, 3 = Immagine):");
				while (!scanner.hasNextInt()) {
					System.out.println(
							"Input non valido. Inserisci un tipo di formato corretto (1 = Audio, 2 = Video, 3 = Immagine):");
					scanner.next();
				}
				type = scanner.nextInt();
				scanner.nextLine();
			} while (type < 1 || type > 3);

			System.out.println("Inserisci il titolo:");
			String title = scanner.nextLine();

			switch (type) {
			case 1:
				int volume;
				do {
					System.out.println("Inserisci il volume:");
					while (!scanner.hasNextInt()) {
						System.out.println("Input non valido. Inserisci il volume:");
						scanner.next();
					}
					volume = scanner.nextInt();
					scanner.nextLine();
				} while (volume <= 0);
				mediaElements[i] = new AudioRecording(title, volume);
				break;
			case 2:
				int videoVolume;
				int brightness;
				do {
					System.out.println("Inserisci il volume:");
					while (!scanner.hasNextInt()) {
						System.out.println("Input non valido. Inserisci il volume:");
						scanner.next();
					}
					videoVolume = scanner.nextInt();
					scanner.nextLine();
				} while (videoVolume <= 0);
				do {
					System.out.println("Inserisci la luminosità:");
					while (!scanner.hasNextInt()) {
						System.out.println("Input non valido. Inserisci la luminosità:");
						scanner.next();
					}
					brightness = scanner.nextInt();
					scanner.nextLine();
				} while (brightness <= 0);
				mediaElements[i] = new Video(title, videoVolume, brightness);
				break;
			case 3:
				int imageBrightness;
				do {
					System.out.println("Inserisci la luminosità:");
					while (!scanner.hasNextInt()) {
						System.out.println("Input non valido. Inserisci la luminosità:");
						scanner.next();
					}
					imageBrightness = scanner.nextInt();
					scanner.nextLine();
				} while (imageBrightness <= 0);
				mediaElements[i] = new Image(title, imageBrightness);
				break;
			}
		}

		MediaPlayer mediaPlayer = new MediaPlayer(mediaElements);

		int choice;
		do {
			System.out.println("Inserisci l'indice dell'elemento da riprodurre (0 per uscire):");
			while (!scanner.hasNextInt()) {
				System.out.println("Input non valido. Inserisci l'indice dell'elemento da riprodurre (0 per uscire):");
				scanner.next();
			}
			choice = scanner.nextInt();
			scanner.nextLine();

			if (choice >= 1 && choice <= mediaElements.length) {
				mediaPlayer.playMediaElement(choice - 1);
			} else if (choice != 0) {
				System.out.println("Indice non valido");
			}
		} while (choice != 0);

		scanner.close();
	}
}
