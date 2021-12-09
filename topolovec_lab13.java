import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class topolovec_lab13 {
	ArrayList<Integer> a;
	public void readData(String filename) {
		try {
			a = new ArrayList<>();
			BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
			String inn;
			while ((inn = input.readLine()) != null ) {
				StringTokenizer st = new StringTokenizer(inn, " ");
				while (st.hasMoreTokens()) {
					a.add(Integer.valueOf(inn));
				}
			}
			input.close();
		} catch (Exception e) {
			System.out.println(e);
			System.exit(0);
		}
	}
	public long getTotalCount() {
		return a.stream().count();
	}
	public long getOddCount() {
		return a.stream().filter(x -> x % 2 != 0).count();
	}
	public long getEvenCount() {
		return a.stream().filter(x -> x % 2 == 0).count();
	}
	public long getDistinctGreaterThanFiveCount() {
		return a.stream().distinct().filter(x -> x > 5).count();
	}
	public Integer[] getResult1() {
		return a.stream().filter(x -> x > 5).filter(x -> x < 50).sorted().toArray(Integer[]::new);
	}
	public Integer[] getResult2() {
		return a.stream().limit(50).map(x -> x * x * 3).toArray(Integer[]::new);
	}
	public Integer[] getResult3() {
		return a.stream().filter(x -> x % 2 != 0).map(x -> x * 2).sorted().skip(20).distinct().toArray(Integer[]::new);
	}
}