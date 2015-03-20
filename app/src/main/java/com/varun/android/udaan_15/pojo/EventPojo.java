package com.varun.android.udaan_15.pojo;

import java.util.ArrayList;

/**
 * Created by Varun Barad on 2015-03-20.
 */
public class EventPojo {

    private String name;
    private String description;
    private ArrayList<EventManagerPojo> managers;
    private String startTime;
    private String venue;
    private String department;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<EventManagerPojo> getManagers() {
        return managers;
    }

    public void setManagers(ArrayList<EventManagerPojo> managers) {
        this.managers = managers;
    }

    public void addManager(EventManagerPojo eventManager) {
        if(this.managers == null) {
            this.managers = new ArrayList<EventManagerPojo>();
        }
        this.managers.add(eventManager);
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
