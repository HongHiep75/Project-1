
public class Node {
	Product product;
	Node next;

	public Node(Product product) {
		this.product = product;
	}

	public static Node sapXepTangDan(Node danhSach) {
		if (danhSach == null) {
			return null;
		}
		Node head = danhSach;
		Node min = danhSach;
		Node truocMin = null;
		boolean coMin = false;
		// vòng lặp tìm mã sản phẩm thấp nhất theo từ điển
		while (head.next != null) {
			if (min.product.getMaSanPham().compareTo(head.next.product.getMaSanPham()) > 0) {
				min = head.next;
				truocMin = head;
				coMin = true;
			}
			head = head.next;
		}
		// dua min len dau danh sach
		if (coMin) {
			truocMin.next = min.next;
			min.next = danhSach;
			danhSach = min;
		}
		// chỏ danhSach.next tới Node có giá trị nhỏ nhất của phan con lại danh sách
		danhSach.next = sapXepTangDan(danhSach.next);
		return danhSach;
	}

}
