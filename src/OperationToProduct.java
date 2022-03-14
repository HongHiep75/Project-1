import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class OperationToProduct {
//  ghi du lieu vao file	
	public static void writeFile(MyList list) {
		Node head = list.head;
		try {
			FileWriter fw = new FileWriter("Data.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			while (head != null) {
				bw.write(head.product.toString());
				bw.newLine();
				head = head.next;
			}

			bw.close();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

// doc du lieu tu file
	public static MyList readFile() {
		MyList danhSach = new MyList();
		Product sanPham;

		try {
			FileReader fr = new FileReader("Data.txt");
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			while (true) {
				line = br.readLine();
				if (line == null) {
					break;
				}
				// cat du lieu tai vi tri " "
				String data[] = line.split(" ");
				String id = data[0];
				String name = data[1];
				// ep kieu du lieu ve int va double
				int soLuong = Integer.parseInt(data[2]);
				double gia = Double.parseDouble(data[3]);
				sanPham = new Product(id, name, soLuong, gia);
				danhSach.add(sanPham);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return danhSach;
	}

//  chuyen doi so nguyen sang so nhi phan
	public static String soLuongMaNhiPhan(int x) {
		if (x == 0) {
			return "0";
		} else if (x == 1) {
			return "1";
		} else {
			return soLuongMaNhiPhan(x / 2) + x % 2;
		}
	}

}
