import java.util.Scanner;
import java.util.Stack;

public class AS2_Main {
	static Scanner sc = new Scanner(System.in);
	static MyList list = new MyList();

	public static void main(String[] args) {

		int luaChon;
		do {
			showMenu();
			luaChon = sc.nextInt();
			switch (luaChon) {
//		    doc data tu file va hiển thị danh sach
			case 1: {
				list = OperationToProduct.readFile();
				list.inThongTinSanPham();
				System.out.println();
				break;
			}
//			them sản phẩm vao cuoi danh sach
			case 2: {
				Product sanPhamMoi = themSanPham();
				list.add(sanPhamMoi);
				System.out.println("Thêm sản phẩm mới thành công\n");
				break;
			}
//		    hien thị thông tin sản phẩm 	
			case 3: {
				list.inThongTinSanPham();
				break;
			}
//			lưu danh sách vào file
			case 4: {
				OperationToProduct.writeFile(list);
				System.out.println("Successfully!");
				break;
			}
//			Tìm kiếm thông tin của sản phẩm theo ID
			case 5: {
				System.out.println("Nhập id:");
				String id = sc.next();
				list.timTheoId(id);
				break;
			}
//			Xóa sản phẩm trong danh sách theo ID
			case 6: {
				System.out.println("Nhập id:");
				String id = sc.next();
				list.xoaTheoId(id);
//				System.out.println("Xóa thành công\n");
				break;
			}
//			Sắp xếp các sản phẩm  trong danh sách móc nối theo ID
			case 7: {
				list.head = Node.sapXepTangDan(list.head);
				list.ganLaiGiaTriNodeTall();
				System.out.println("Sắp xếp thành công\n");
				break;
			}
//			Biểu diễn số lượng sản phẩm 
			case 8: {
				int soSanPham = list.head.product.getSoLuong();
				System.out.println(
						"Quantity=" + soSanPham + "=>(" + OperationToProduct.soLuongMaNhiPhan(soSanPham) + ")\n");
				break;
			}
//			 Hiển thị ra màn hình các sản phẩm có trong stack.
			case 9: {
				MyStack.hienThiSanPhamCoTrongStack();
				break;
			}
//			Hiển thị ra màn hình các sản phẩm có trong queue.
			case 10: {
				MyQueue.hienThiSanPhamCoTrongQueue();
				break;
			}

			}
		} while (luaChon != 0);
		System.out.println("Thanks!!!");
	}

	// hien thi menu
	public static void showMenu() {

		System.out.println("Choose one of this options:");
		System.out.println("Product list:\n");
		System.out.println("1. Load data from file and display");
		System.out.println("2. Input & add to the end.");
		System.out.println("3. Display data");
		System.out.println("4. Save product list to file.");
		System.out.println("5. Search by ID");
		System.out.println("6. Delete by ID");
		System.out.println("7. Sort by ID.");
		System.out.println("8. Convert to Binary");
		System.out.println("9. Load to stack and display");
		System.out.println("10. Load to queue and display.");
		System.out.println("0. Exit");
		System.out.print("Choice: ");
		System.out.println();

	}

	public static Product themSanPham() {
		System.out.println("Điền mã sản phẩm.");
		String ma = sc.next();
		System.out.println("Điền tên sản phẩm.");
		String ten = sc.next();
		System.out.println("Điền số lượng sản phẩm.");
		int soLuong = sc.nextInt();
		System.out.println("Điền đơn giá sản phẩm.");
		double gia = sc.nextDouble();
		Product sanPham = new Product(ma, ten, soLuong, gia);

		return sanPham;
	}

}
