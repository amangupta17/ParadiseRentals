package com.paradiserentals;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Aman on 3/25/2018.
 */
public class RentalCalculator {
    private Boolean suvRented = false;
    private double totalRent;
    private int bicycleRentCount = 0;

    public RentalCalculator(VehicleRequest vehicleRequests[]){
        this.totalRent = 0;
        for(VehicleRequest vRequest : vehicleRequests){
            this.totalRent += calculateRent(vRequest);
        }
    }

    private double calculateRent(VehicleRequest vRequest){
        switch (vRequest.getVehicleType()) {
            case "Midsize Cars":
                return (vehicleRent(30.0, 25, 20, vRequest));
            case "Economy Cars":
                return (vehicleRent((30.0 - 0.5 * 30.0), 25, 20, vRequest));
            case "SUVs":
                this.suvRented = true;
                return (vehicleRent((30.0 + 0.5 * 30.0), 25, 20, vRequest));
            case "Luxury Cars":
                return (vehicleRent((30.0 * 2), 25, 20, vRequest));
            case "Limousines":
                return (vehicleRent(100.0, 40, 100, vRequest));
            case "Bicycles":
                this.bicycleRentCount++;
                if(this.suvRented && this.bicycleRentCount == 1)
                    return 0;
                return (vehicleRent(10.0, 0, 0, vRequest));
            case "Scooters":
                return (vehicleRent(25.0, 0, 0, vRequest));
            case "Motorcycles":
                return (vehicleRent(30.0, 25, 20, vRequest));
            case "Jetskis":
                return (vehicleRent(25.0, 0, 0, vRequest));
        }
        return 0;
    }

    private double vehicleRent(double bRate, double weekendPremium, double sundayDiscount, VehicleRequest vRequest){
        long diffMilliS = vRequest.getEndDate().getTime() - vRequest.getStartDate().getTime();
        long totalDays = (long) Math.ceil((double)diffMilliS / (24 * 60 * 60 * 1000)) + 1;

        long fridays = getTotalDays(totalDays, 6, getDayOfWeek(vRequest.getStartDate()), getDayOfWeek(vRequest.getEndDate()));
        long saturdays = getTotalDays(totalDays, 7, getDayOfWeek(vRequest.getStartDate()), getDayOfWeek(vRequest.getEndDate()));
        long sundays = getTotalDays(totalDays, 1, getDayOfWeek(vRequest.getStartDate()), getDayOfWeek(vRequest.getEndDate()));

        long remainingDays = totalDays - (fridays + saturdays + sundays);
        long remainingDaysOtherThanSundays = totalDays - sundays;

        double totalRent =  (remainingDays * bRate) +
                            (( bRate + (bRate * weekendPremium / 100)) * (fridays + saturdays)) +
                            (bRate - (bRate * sundayDiscount / 100)) * sundays;

        totalRent += ((vRequest.getTakingOffRoad()? 15.0 : 0) +
                     (vRequest.getIncludeDriver()? 150.0 : 0)) * remainingDaysOtherThanSundays +
                     (vRequest.getPremiumPackage()? 75.0: 0);

        if(vRequest.getVehicleType().equals("Limousines")){
            totalRent += sundays * 100.0;
            return totalRent;
        }

        if(vRequest.getVehicleType().equals("Jetskis")){
            long totalHours = (long) Math.ceil((double) diffMilliS / (60 * 60 * 1000));
            return totalHours * bRate;
        }

        totalRent += getDriverMotorcycleInsurance(vRequest);

        return totalRent;
    }

    /*
        Get total days depending on the input day between the start and end dates.
     */
    private long getTotalDays(long days, int day,int startDay, int endDay){
        int addDay = 0;
        if(startDay < endDay){
            if(day >= startDay && day <= endDay){
                addDay = 1;
            }
        } else {
            if(day <= startDay && day >= endDay){
                addDay = 1;
            }
        }
        return (days / 7) + addDay;
    }

    /*
        Returns day of week in the format
        Sunday - 1 :: Saturday - 7
     */
    private int getDayOfWeek(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_WEEK);
    }

    public double getTotalRent(){
        return this.totalRent;
    }

    private double getDriverMotorcycleInsurance(VehicleRequest vRequest){
        int driverAge = vRequest.getDriverAge();
        if(driverAge >= 18 && driverAge <= 25){
            return 50.0;
        } else if (driverAge >=26 && driverAge <= 32){
            return 35.0;
        } else if (driverAge >= 33 && driverAge <= 45){
            return 15.0;
        } else if (driverAge >=46){
            return 0;
        }
        return 0;
    }
}
