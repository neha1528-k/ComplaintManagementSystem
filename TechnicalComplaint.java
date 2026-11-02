package com.complaintmanagement;

public class TechnicalComplaint extends Complaint {

    private String category;

    public TechnicalComplaint() {
    }

    public TechnicalComplaint(int id, String name,
            String description, String category) {

        super(id, name, description);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return super.toString() + ", Category: " + category;
    }
}
