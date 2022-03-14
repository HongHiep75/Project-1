import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyQueue {

	public static void hienThiSanPhamCoTrongQueue() {
		Queue<String> myQueue = new LinkedList<>();
		try {
			FileReader fr = new FileReader("Data.txt");
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			// them data vao queue
			while (true) {
				line = br.readLine();
				if (line == null) {
					break;
				}
				myQueue.offer(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("ID | Title | Quantity | price\n------------------------------");
		while (!myQueue.isEmpty()) {
			System.out.println(myQueue.poll().replaceAll(" ", " | "));
		}
		System.out.println();

	}
}
