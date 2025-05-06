package com.pluralsight;

public class Testing {
    public static void main(String[] args) throws InterruptedException {
        // Test Employee class
        Employee employee = new Employee("E001", "Alice Smith", "IT", 25.0f, 38.0f);
        System.out.println("Punching in...");
        employee.punchTimeCard(); // Punch in
        Thread.sleep(2000); // Simulate some work time
        System.out.println("Punching out...");
        employee.punchTimeCard(); // Punch out
        System.out.printf("Employee: %s, Total Pay: $%.2f%n", employee.getName(), employee.getTotalPay());

        // Test Reservation class
        Reservation reservation = new Reservation("king", 3, true);
        System.out.printf("Reservation for %s room, Total: $%.2f%n",
                reservation.getRoomType(), reservation.getReservationTotal());

        // Test Room class
        Room room = new Room(2, 120.0f, false, false);
        System.out.println("Room available? " + room.isAvailable());
        room.checkIn();
        System.out.println("Checked in. Room available? " + room.isAvailable());
        room.checkOut();
        System.out.println("Checked out. Room available? " + room.isAvailable());
    }
}
