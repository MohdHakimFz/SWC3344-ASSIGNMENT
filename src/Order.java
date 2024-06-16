/*  Name : Mohd Hakim Bin Mohd Fauzi
	ID: AM2307014329
	Type: Assignment
*/
public class Order {
    // Private fields to store order details
    private int orderId;
    private String customerName;
    private String customerAddress;
    private String productName;
    private int quantity;
    private double pricePerUnit;
    private double totalPrice;
    private String orderStatus;

    // Constructor to initialize all fields
    public Order(int orderId, String customerName, String customerAddress, String productName,
                 int quantity, double pricePerUnit, double total, String orderStatus) {
        this.orderId = orderId; // Set the order ID
        this.customerName = customerName; // Set the customer's name
        this.customerAddress = customerAddress; // Set the customer's address
        this.productName = productName; // Set the product name
        this.quantity = quantity; // Set the quantity of the product
        this.pricePerUnit = pricePerUnit; // Set the price per unit
        this.totalPrice = quantity * pricePerUnit; // Calculate and set the total price
        this.orderStatus = orderStatus; // Set the order status
    }

    // Getters for all fields
    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getOrderStatus() {
        return orderStatus;
    }
    
    // Setters for fields that can be updated
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        updateTotalPrice(); // Update total price when quantity changes
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
        updateTotalPrice(); // Update total price when price per unit changes
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    // Private method to update the total price
    private void updateTotalPrice() {
        this.totalPrice = this.quantity * this.pricePerUnit; // Recalculate total price
    }

    // Override toString method to provide a string representation of the order
    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Customer: " + customerName + ", Product: " + productName +
               ", Quantity: " + quantity + ", Total Price: $" + totalPrice + ", Status: " + orderStatus;
    }

    // Override equals method to compare orders by order ID
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Check if comparing the same object
        if (o == null || getClass() != o.getClass()) return false; // Check if the other object is null or of a different class

        Order order = (Order) o;

        return orderId == order.orderId; // Compare orders by order ID
    }

    // Override hashCode method to generate a hash code based on order ID
    @Override
    public int hashCode() {
        return orderId;
    }
}

