
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Stack;

public class MyStack {
	
	public static void hienThiSanPhamCoTrongStack() {
		Stack<String> myStack = new Stack<>();
		try {
			FileReader fr = new FileReader("Data.txt");
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			// them data vao stack
			while (true) {
				line = br.readLine();
				if (line == null) {
					break;
				}
				myStack.push(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("ID | Title | Quantity | price\n------------------------------");
		while (!myStack.isEmpty()) {
			System.out.println(myStack.pop().replaceAll(" ", " | "));
		}
		System.out.println();
	}
}
