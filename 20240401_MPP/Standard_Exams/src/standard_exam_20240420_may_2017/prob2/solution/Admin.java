package standard_exam_20240420_may_2017.prob2.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Admin {
    //Returns phone numbers (in sorted order) of the Library Members who have ever checked out the specified lending item
    public static List<String> getPhoneNums(LibraryMember[] members, LendingItem item) {
        // with streams
        return Arrays.stream(members).filter(
                        lm -> lm
                                .getCheckoutRecord()
                                .getCheckoutEntryList()
                                .stream()
                                .anyMatch(checkoutRecordEntry -> checkoutRecordEntry.getLendingItem().equals(item))
                ).map(LibraryMember::getPhone)
                .collect(Collectors.toList())
                ;
    }
}
