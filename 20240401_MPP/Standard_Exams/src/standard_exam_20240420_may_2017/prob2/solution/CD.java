package standard_exam_20240420_may_2017.prob2.solution;

import java.util.Objects;

public class CD extends LendingItem {
    private String productId;
    private String title;
    private String company;

    public CD(String productId, String title, String company) {
        this.productId = productId;
        this.title = title;
        this.company = company;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || !o.getClass().getName().equals(getClass().getName())) return false;

        CD cd = (CD) o;

        return Objects.equals(productId, cd.productId) &&
                Objects.equals(title, cd.title) &&
                Objects.equals(company, cd.company);
    }

}
