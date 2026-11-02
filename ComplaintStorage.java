package com.complaintmanagement;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ComplaintStorage {

    private ObjectMapper mapper = new ObjectMapper();

    public void saveComplaints(List<Complaint> complaints)
            throws Exception {

        mapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File("complaints.json"), complaints);

        System.out.println("Complaints saved successfully!");
    }

    public List<Complaint> loadComplaints() throws Exception {

        File file = new File("complaints.json");

        return mapper.readValue(file,
                new TypeReference<List<Complaint>>() {});
    }
}
