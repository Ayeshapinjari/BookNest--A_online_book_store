package Projects.OnlineBookStore.model;

public class Order {

    private int id;
    private String userName;
    private String bookName;
    private int quantity;
    private double total;

    public Order() {
    }

    public Order(int id, String userName, String bookName,
                 int quantity, double total) {
        this.id = id;
        this.userName = userName;
        this.bookName = bookName;
        this.quantity = quantity;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", bookName='" + bookName + '\'' +
                ", quantity=" + quantity +
                ", total=" + total +
                '}';
    }
}