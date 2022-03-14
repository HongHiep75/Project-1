
public class MyList {
	static Node head;
	static Node tall;

	public MyList() {
		head = tall = null;
	}

//  kiem tra danh sach co phần tử hay không
	static boolean isEmpty() {
		return (head == null);
	}

//  tinh so luong san pham
	public static int soLuongSanPham() {
		int soLuong = 0;
		Node copyHead = head;
		while (copyHead != null) {
			soLuong += 1;
			copyHead = copyHead.next;
		}
		return soLuong;
	}

//  them phan tu vao danh sach
	public static void add(Product x) {
		Node person = new Node(x);
		if (isEmpty()) {
			head = person;
			tall = person;
			return;
		} else if (head.next == null) {
			tall = person;
			head.next = tall;
			return;
		} else {
			tall.next = person;
			tall = tall.next;
		}

	}

//  tim qua id
	public static void timTheoId(String id) {
		if (head == null) {
			System.out.println("Không có sản phẩm trong kho");
			return;
		}
		Node copyHear = head;
		// vong lap tim ma san pham
		while (copyHear != null) {
			if (copyHear.product.getMaSanPham().equalsIgnoreCase(id)) {
				copyHear.product.intThongTin();
				return;
			}
			copyHear = copyHear.next;

		}
		System.out.println(-1);
		return;

	}

//  xoa theo id		
	public static void xoaTheoId(String id) {
		if (head == null) {
			System.out.println("Không có sản phẩm trong kho");
			return;
		}
		// xoa Node khi có mã sản phẩm giong id
		if (head.product.getMaSanPham().equalsIgnoreCase(id)) {
			System.out.println("Deleted!");
			head = head.next;
			return;

		}

		Node copyHead = head.next;
		Node nodeSau = head;

//	    vong lap tim vi tri va xoa Node
		while (copyHead != null) {
			if (copyHead.product.getMaSanPham().equalsIgnoreCase(id)) {
				// neu node muon xoa bang tall gan lại tall
				if (copyHead.product.getMaSanPham().equalsIgnoreCase(tall.product.getMaSanPham())) {
					tall = nodeSau;
					tall.next = null;
				}
				nodeSau.next = copyHead.next;
				copyHead.next = null;
				System.out.println("Deleted!");
				return;
			}
			nodeSau = copyHead;
			copyHead = copyHead.next;
		}

		System.out.println("Không tìm thấy mã id");

	}

//  hien thi thong tin san pham		
	public static void inThongTinSanPham() {
		if (head == null) {
			System.out.println("Không có sản phẩm trong kho");
			return;
		}
		Node copyHear = head;
		System.out.println("ID | Title | Quantity | price\n------------------------------");
		// vong lap hien thong tin san pham
		while (copyHear != null) {
			copyHear.product.intThongTin();
			copyHear = copyHear.next;

		}
		System.out.println();
	}

//  gan lai Node tall
	public static void ganLaiGiaTriNodeTall() {
		Node copyhead = head;
		while (copyhead.next != null) {
			copyhead = copyhead.next;
		}
		tall = copyhead;
	}
}
