package standard_exam_20240420_may_2017.prob2.solution;

public class LibraryMember {
   private final String memberId;
   private final String firstName;
   private final String lastName;
   private final String phone;

   private CheckoutRecord checkoutRecord;

    public LibraryMember(String id, String fName, String lName, String phone) {
        this.memberId = id;
        this.firstName = fName;
        this.lastName = lName;
        this.phone = phone;

        checkoutRecord = new CheckoutRecord();
    }

    public String getMemberId() {
        return memberId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public CheckoutRecord getCheckoutRecord() {
        return checkoutRecord;
    }

    public void setCheckoutRecord(CheckoutRecord cr) {
        this.checkoutRecord = cr;
    }
}
