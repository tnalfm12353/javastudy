package chapter03;

public class SongTest {

	public static void main(String[] args) {
		Song song = new Song();
		
		song.setArtist("IU");
		song.setAlbum("Real");
		song.setTitle("좋은날");
		song.setComposer("이민수");
		song.setTrack(3);
		song.setYear(2010);
		
		song.show();
		
		Song song2 = new Song("Rollin", "브레이브걸스");
		song2.show();
		
	}

}
