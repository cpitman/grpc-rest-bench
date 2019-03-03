package com.chrispitman.rest;

public class Telemetry {
 
    private long timeRecorded;
    private long timeReceived;

    private float latitude;
    private float longitude;
    private float bearing;

    private int odometer;
    private float speed;

    private float fuelLevel;

    private long accountId;
    private long vehicleId;
    private long driverId;

    /**
     * @return the timeRecorded
     */
    public long getTimeRecorded() {
        return timeRecorded;
    }

    /**
     * @return the driverId
     */
    public long getDriverId() {
        return driverId;
    }

    /**
     * @param driverId the driverId to set
     */
    public void setDriverId(long driverId) {
        this.driverId = driverId;
    }

    /**
     * @return the vehicleId
     */
    public long getVehicleId() {
        return vehicleId;
    }

    /**
     * @param vehicleId the vehicleId to set
     */
    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }

    /**
     * @return the accountId
     */
    public long getAccountId() {
        return accountId;
    }

    /**
     * @param accountId the accountId to set
     */
    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    /**
     * @return the fuelLevel
     */
    public float getFuelLevel() {
        return fuelLevel;
    }

    /**
     * @param fuelLevel the fuelLevel to set
     */
    public void setFuelLevel(float fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    /**
     * @return the speed
     */
    public float getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(float speed) {
        this.speed = speed;
    }

    /**
     * @return the odometer
     */
    public int getOdometer() {
        return odometer;
    }

    /**
     * @param odometer the odometer to set
     */
    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    /**
     * @return the bearing
     */
    public float getBearing() {
        return bearing;
    }

    /**
     * @param bearing the bearing to set
     */
    public void setBearing(float bearing) {
        this.bearing = bearing;
    }

    /**
     * @return the longitude
     */
    public float getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    /**
     * @return the latitude
     */
    public float getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the timeReceived
     */
    public long getTimeReceived() {
        return timeReceived;
    }

    /**
     * @param timeReceived the timeReceived to set
     */
    public void setTimeReceived(long timeReceived) {
        this.timeReceived = timeReceived;
    }

    /**
     * @param timeRecorded the timeRecorded to set
     */
    public void setTimeRecorded(long timeRecorded) {
        this.timeRecorded = timeRecorded;
    }

}