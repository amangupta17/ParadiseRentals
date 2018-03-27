package com.paradiserentals;

import java.util.Date;

/**
 * Created by Aman on 3/25/2018.
 */
public class VehicleRequest {
    private String vehicleType;
    private Date startDate;
    private Date endDate;
    private Boolean takingOffRoad;
    private Boolean includeDriver;
    private Boolean premiumPackage;
    private int driverAge;

    public VehicleRequest(String vehicleTypeInput, Date startDateInput, Date endDateInput){
        this.vehicleType = vehicleTypeInput;
        this.startDate = startDateInput;
        this.endDate = endDateInput;
        this.takingOffRoad = false;
        this.includeDriver = false;
        this.premiumPackage = false;
        this.driverAge = 0;
    }

    public VehicleRequest(String vehicleTypeInput, Date startDateInput, Date endDateInput, Integer dAge){
        this.vehicleType = vehicleTypeInput;
        this.startDate = startDateInput;
        this.endDate = endDateInput;
        this.takingOffRoad = false;
        this.includeDriver = false;
        this.premiumPackage = false;
        this.driverAge = dAge;
    }

    public VehicleRequest(String vehicleTypeInput, Date startDateInput, Date endDateInput, Boolean takingOffRoadInput){
        this.vehicleType = vehicleTypeInput;
        this.startDate = startDateInput;
        this.endDate = endDateInput;
        this.takingOffRoad = takingOffRoadInput;
        this.includeDriver = false;
        this.premiumPackage = false;
        this.driverAge = 0;
    }

    public VehicleRequest(String vehicleTypeInput, Date startDateInput, Date endDateInput, Boolean includeDriver, Boolean premiumPackage){
        this.vehicleType = vehicleTypeInput;
        this.startDate = startDateInput;
        this.endDate = endDateInput;
        this.takingOffRoad = false;
        this.includeDriver = includeDriver;
        this.premiumPackage = premiumPackage;
        this.driverAge = 0;
    }



    public String getVehicleType(){
        return this.vehicleType;
    }

    public Date getStartDate(){
        return this.startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public Boolean getTakingOffRoad(){
        return this.takingOffRoad;
    }

    public Boolean getIncludeDriver(){
        return this.includeDriver;
    }

    public Boolean getPremiumPackage(){
        return this.premiumPackage;
    }
    public Integer getDriverAge(){
        return this.driverAge;
    }
}
