package com.complaintmanagement;

import java.util.*;

public class ComplaintService {

    private List<Complaint> complaints = new ArrayList<>();
    private HashMap<Integer, Complaint> complaintMap = new HashMap<>();
    private Set<String> categories = new HashSet<>();

    public void addComplaint(Complaint complaint) {
        complaints.add(complaint);
        complaintMap.put(complaint.getId(), complaint);

        if (complaint instanceof TechnicalComplaint) {
            TechnicalComplaint tc = (TechnicalComplaint) complaint;
            categories.add(tc.getCategory());
        }
    }

    public List<Complaint> getAllComplaints() {
        return new ArrayList<>(complaints);
    }

    public Complaint searchComplaint(int id) {
        return complaintMap.get(id);
    }

    public void sortComplaints() {
        Collections.sort(complaints,
                Comparator.comparingInt(Complaint::getId));
    }

    public void replaceComplaints(List<Complaint> loaded) {
        complaints.clear();
        complaintMap.clear();
        categories.clear();

        for (Complaint c : loaded) {
            addComplaint(c);
        }
    }
}
