package User;

import Insurance.Insurance;

public class Enterprise extends Account {
    private String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Enterprise(User user, String companyName) {
        super(user);
        this.companyName = companyName;
    }

    @Override
    public void addInsurance(Insurance insurance) {
        double price = insurance.getPrice() * 1.1;
        insurance.setPrice(price);
        super.insurances.add(insurance);
    }
}
