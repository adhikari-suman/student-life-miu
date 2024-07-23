package bank.contract;

public class CustomerResponse {

    private  Long id;

    private String name;

    public CustomerResponse(String name) {
        this.name = name;
    }

    public CustomerResponse() {
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
