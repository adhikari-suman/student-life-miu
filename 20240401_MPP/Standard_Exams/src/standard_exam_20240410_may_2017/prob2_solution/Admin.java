package standard_exam_20240410_may_2017.prob2_solution;

import java.util.ArrayList;
import java.util.List;

public class Admin {
    //Returns phone numbers (in sorted order) of the Library Members who have ever checked out the specified lending item
    public static List<String> getPhoneNums(LibraryMember[] members, LendingItem item) {
        List<String> phoneNums = new ArrayList<>();

        //implement
        for (LibraryMember m : members) {
            if (m == null)
                continue;

            for (var entry : m.getCheckoutRecord().getCheckoutEntryList()) {
                if (entry != null && entry.getLendingItem().equals(item)) {
                    phoneNums.add(m.getPhone());
                }
            }
        }

        phoneNums.sort(String::compareTo);

        return phoneNums;
    }
}
