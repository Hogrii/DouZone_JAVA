import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Lotto {

	// 아래와 같이 ....
	private Scanner sc;
	private int[] lotto;
	Lotto[] lottos = new Lotto[5];

	public Lotto() {
		sc = new Scanner(System.in);
	}
	
	public Lotto(int[] lotto) {
		this.lotto = lotto;
	}

	public void read() {
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader("Lotto.txt");
			br = new BufferedReader(fr);
			String line = "";
			for(int i=0; (line = br.readLine()) != null; i++) {
				System.out.println(line);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
				fr.close();				
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	public void write() {
		int[] lotto = randomNum();
		bubbleSort(lotto);
		LottoNumSave(lotto);
	}
	
	private void LottoNumSave(int[] lotto) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			fw = new FileWriter("Lotto.txt", true);
			bw = new BufferedWriter(fw);
			bw.write("로또 : ");
			for(int i=0; i<lotto.length; i++) {
				bw.write(lotto[i] + " ");
			}
			bw.newLine();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				bw.close();
				fw.close();
			}catch(IOException e) {
				e.printStackTrace();
			}		
		}		
		System.out.println();
	}
	
	private void bubbleSort(int[] lotto) {
		int tmp;
		for (int i = 0; i < lotto.length - 1; i++) { // 버블 정렬
			for (int j = i + 1; j < lotto.length; j++) {
				if (lotto[i] > lotto[j]) {
					tmp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = tmp;
				}
			}
		}
	}
	
	private int[] randomNum() {
		int[] lotto = new int[6];
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = (int) (Math.random() * 45 + 1);
			for (int j = 0; j < i; j++) { // 중복 검증
				if (lotto[j] == lotto[i]) {
					i--;
					break;
				}
			}
		}
		return lotto;
	}
}
