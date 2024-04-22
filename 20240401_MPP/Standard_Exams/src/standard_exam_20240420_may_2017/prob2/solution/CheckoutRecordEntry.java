package standard_exam_20240420_may_2017.prob2.solution;

import java.time.LocalDate;

public class CheckoutRecordEntry {
    private final LendingItem lendingItem;
    private final LocalDate checkoutDate;
    private final LocalDate dueDate;
    private final ItemType itemType;

    public CheckoutRecordEntry(LendingItem item, LocalDate chDate, LocalDate dueDate, ItemType type) {
        this.lendingItem = item;
        this.checkoutDate = chDate;
        this.dueDate = dueDate;
        this.itemType = type;
    }

    public LendingItem getLendingItem() {
        return lendingItem;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public ItemType getLendingItemType() {
        return itemType;
    }

}
