package myCafe.model;

public class Cafe {
	// 고객
	private String id; // 고객 아이디
	private String name; // 고객 이름
	private String password; // 고객 비밀번호
	private String hphone;
	private int balance; // 고객의 현재 잔액

	// 메뉴
	private int cid; // 메뉴 고유 번호
	private String cname; // 메뉴 이름
	private String image; // 이미지
	private int price; // 메뉴 가격
	private int kcal; // 메뉴 칼로리

	// 주문
	private int oid; // 주문 고유 번호
	private int total; // 총 주문 금액

	public Cafe() {

	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getKcal() {
		return kcal;
	}

	public void setKcal(int kcal) {
		this.kcal = kcal;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getHphone() {
		return hphone;
	}

	public void setHphone(String hphone) {
		this.hphone = hphone;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
