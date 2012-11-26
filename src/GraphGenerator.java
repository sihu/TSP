import java.util.Random;

public class GraphGenerator {

	public static void main(String[] args) {
		int m = Integer.parseInt(args[0]);
		Random randomGenerator = new Random();

		System.out.println(m);

		for (int i = 0; i < m; i++) {
			System.out.println(randomGenerator.nextFloat()*Math.pow(10,6) + " " 
					+ randomGenerator.nextFloat()*Math.pow(10,6));
		}
	}
}
