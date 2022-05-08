package case_study.service;

import case_study.model.Facility;

public interface IFacilityService{
    void addFacilitylist(Facility facility);
    void display();
    void displayListFacilityMaintenance();
    void maintenanceCheck(Facility facility);
    void addVilla();
    void addHouse();
    void addRoom();

}