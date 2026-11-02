package com.complaintmanagement;

import java.util.concurrent.*;

public class ComplaintManager {

    private ComplaintService service = new ComplaintService();
    private ComplaintStorage storage = new ComplaintStorage();

    private ExecutorService executor =
            Executors.newSingleThreadExecutor();

    public ComplaintService getService() {
        return service;
    }

    public void save() throws Exception {
        storage.saveComplaints(service.getAllComplaints());
    }

    public void load() throws Exception {
        service.replaceComplaints(storage.loadComplaints());
        System.out.println("Complaints loaded successfully!");
    }

    public void concurrencyDemo() throws Exception {

        Runnable task = () ->
                System.out.println("Background thread is running.");

        Thread thread = new Thread(task);
        thread.start();

        Future<Integer> result = executor.submit(
                () -> service.getAllComplaints().size()
        );

        System.out.println("Total complaints: " + result.get());

        thread.join();
    }

    public void close() {
        executor.shutdown();
    }
}
