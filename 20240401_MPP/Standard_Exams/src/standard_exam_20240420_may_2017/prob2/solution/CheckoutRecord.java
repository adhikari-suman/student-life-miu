package standard_exam_20240420_may_2017.prob2.solution;

import java.util.ArrayList;
import java.util.List;

public class CheckoutRecord {

    private final List<CheckoutRecordEntry> checkoutEntryList;

    public CheckoutRecord() {
        checkoutEntryList = new ArrayList<>();
    }

    public List<CheckoutRecordEntry> getCheckoutEntryList() {
        return checkoutEntryList;
    }

    public void addCheckoutEntry(CheckoutRecordEntry checkoutEntry) {
        checkoutEntryList.add(checkoutEntry);
    }
}
