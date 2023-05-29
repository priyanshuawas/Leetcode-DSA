class ParkingSystem {
    
    int[] cars = new int[3];

    public ParkingSystem(int big, int medium, int small) {
        cars[0] = big;
        cars[1] = medium;
        cars[2] = small;
    }
    
    public boolean addCar(int carType) {
        if (cars[carType - 1] <= 0)
            return false;
        
        cars[carType-1] -= 1;
        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */