import java.util.*;
public class TicTacToe{
	
	static ArrayList<Integer> oyuncuBirPozisyonu = new ArrayList<Integer>();
	static ArrayList<Integer> oyuncuIkiPozisyonu = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		
		char[][] tablo = {{' ', '|', ' ', '|', ' '},
				               {'-', '+', '-', '+', '-'},
				               {' ', '|', ' ', '|', ' '},
				               {'-', '+', '-', '+', '-'},
				               {' ', '|', ' ', '|', ' '}};
		
		printTablo(tablo);
		
		
		while(true) {
			
			Scanner scan = new Scanner(System.in);
			System.out.println("Birinci oyuncu hamle yapmak istediğiniz yeri seçin(1 ile 9 arası.):");
			int oyuncuBirPoz = scan.nextInt();
			while(oyuncuBirPozisyonu.contains(oyuncuBirPoz) || oyuncuIkiPozisyonu.contains(oyuncuBirPoz)) {
				System.out.println("Bu konum kullanılmış. Kullanılmamış bir konum girin:");
				oyuncuBirPoz = scan.nextInt();
			}			
			yerlestirme(tablo, oyuncuBirPoz, "oyuncuBir");

			String sonuc = kazananiBul();
			if(sonuc.length() > 0) {
				System.out.println(sonuc);
				break;
			}
			System.out.println("İkinci oyuncu hamle yapmak istediğiniz yeri seçin(1 ile 9 arası.):");
			int oyuncuIkiPoz = scan.nextInt();
			while(oyuncuIkiPozisyonu.contains(oyuncuIkiPoz) || oyuncuBirPozisyonu.contains(oyuncuIkiPoz)) {
				System.out.println("Bu konum kullanılmış. Kullanılmamış bir konum girin:");
				oyuncuIkiPoz = scan.nextInt();
			}
			yerlestirme(tablo, oyuncuIkiPoz, "oyuncuİki");

			printTablo(tablo);
			
            sonuc = kazananiBul();
			if(sonuc.length() > 0) {
				System.out.println(sonuc);
				break;
			}
		}
		
	}
	
	public static void printTablo(char[][] tablo) {
		for(char[] sira : tablo) {
			for(char c : sira) {
				System.out.print(c); 
			}
			System.out.println();
		}
	}
	
	public static void yerlestirme(char[][] tablo, int pozisyon, String kullanici) {
		
		char sembol = ' ';
		
		if(kullanici.equals("oyuncuBir")) {
			sembol = 'X';
			oyuncuBirPozisyonu.add(pozisyon);
		}else if(kullanici.equals("oyuncuİki")) {
			sembol = 'O';
			oyuncuIkiPozisyonu.add(pozisyon);
		}
		
		switch(pozisyon) {
	       case 1: tablo[0][0] = sembol;
	           break;	
	       case 2: tablo[0][2] = sembol;
	           break;
	       case 3: tablo[0][4] = sembol;
	           break;
	       case 4: tablo[2][0] = sembol;
	           break;
	       case 5: tablo[2][2] = sembol;
	           break;
	       case 6: tablo[2][4] = sembol;
	           break;
	       case 7: tablo[4][0] = sembol;
	           break;
	       case 8: tablo[4][2] = sembol;
	           break;
	       case 9: tablo[4][4] = sembol;
	           break;
	           default:
	        	   break;             
	   }		
		printTablo(tablo);
	}
	
	public static String kazananiBul() {
		
		List ustSira = Arrays.asList(1, 2, 3);
		List ortaSira = Arrays.asList(4, 5, 6);
		List altSira = Arrays.asList(7, 8, 9);
		List solSutun = Arrays.asList(1, 4, 7);
		List ortaSutun = Arrays.asList(2, 5, 8);
		List sagSutun = Arrays.asList(3, 6, 9);
		List capraz1 = Arrays.asList(1, 5, 9);
		List capraz2 = Arrays.asList(7, 5, 3);
		
		List<List> kazanmaDurumu = new ArrayList<List>();
		kazanmaDurumu.add(ustSira);
		kazanmaDurumu.add(ortaSira);
		kazanmaDurumu.add(altSira);
		kazanmaDurumu.add(solSutun);
		kazanmaDurumu.add(ortaSutun);
		kazanmaDurumu.add(sagSutun);
		kazanmaDurumu.add(capraz1);
		kazanmaDurumu.add(capraz2);
		
		for(List l : kazanmaDurumu) {
			if(oyuncuBirPozisyonu.containsAll(l)) {
				return "Birinci oyuncu kazandı!";
			}else if(oyuncuIkiPozisyonu.containsAll(l)) {
				return "İkinci oyuncu kazandı!";
			}else if(oyuncuBirPozisyonu.size() + oyuncuIkiPozisyonu.size() == 9) {
				return "Berabere!";
			}
		}
		
		return "";	
	}
	
}
