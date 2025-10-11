package homework.chapter2.advanced;

import homework.chapter2.basic.Gender;

public class Worker extends Human {
    private String company;

    public Worker(String name, Gender gender) {
        super(name, gender);
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
