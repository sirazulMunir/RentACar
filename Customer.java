public class Customer {

    private  String customerName ;
    private  String address;
    private  String dateMonthYear;
    private  String time;
    private  String amPm;
    private  String phnNumber;
    private  String vehicleName;
    private  String quantity;

    public Customer() {
        this.customerName = " ";
        this.address = " ";
        this.dateMonthYear = " ";
        this.time = " ";
        this.amPm = " ";
        this.phnNumber = " ";
        this.vehicleName = " ";
        this.quantity = " ";
    }

    public Customer(String customerName, String address, String dateMonthYear, String time, String amPm, String phnNumber, String vehicleName, String quantity) {
        this.customerName = customerName;
        this.address = address;
        this.dateMonthYear = dateMonthYear;
        this.time = time;
        this.amPm = amPm;
        this.phnNumber = phnNumber;
        this.vehicleName = vehicleName;
        this.quantity = quantity;
    }

    public  String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public  String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public  String getDateMonthYear() {
        return dateMonthYear;
    }

    public void setDateMonthYear(String dateMonthYear) {
        this.dateMonthYear = dateMonthYear;
    }

    public  String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public  String getAmPm() {
        return amPm;
    }

    public void setAmPm(String amPm) {
        this.amPm = amPm;
    }

    public  String getPhnNumber() {
        return phnNumber;
    }

    public void setPhnNumber(String phnNumber) {
        this.phnNumber = phnNumber;
    }

    public  String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public  String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
