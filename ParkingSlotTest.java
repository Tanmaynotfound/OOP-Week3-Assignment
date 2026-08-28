class ParkingSlot {

    String slotNo;
    int capacity;
    int occupiedCount;

    // Constructor
    ParkingSlot(String slotNo, int capacity, int occupiedCount) {
        this.slotNo = slotNo;
        this.capacity = capacity;
        this.occupiedCount = occupiedCount;
    }

    // Allots one parking spot if space is available
    void allot(String vehicleNo) {

        if (occupiedCount < capacity) {
            occupiedCount++;

            System.out.println(
                vehicleNo + " allotted to slot " + slotNo
            );
        }
    }
}


public class ParkingSlotTest {

    /*
     * This method returns the first parking slot that still has space.
     * If every slot is full, it returns null.
     */
    static ParkingSlot findAvailableSlot(ParkingSlot[] slots) {

        for (ParkingSlot slot : slots) {

            if (slot.occupiedCount < slot.capacity) {
                return slot;
            }
        }

        return null;
    }


    /*
     * Arrays contain references to ParkingSlot objects.
     * Passing the array to this method does not copy every ParkingSlot.
     * The array still refers to the same objects, so changing a slot here
     * changes that same object.
     */
    static void safeAllot(ParkingSlot[] slots, String vehicleNo) {

        ParkingSlot availableSlot = findAvailableSlot(slots);

        // Check for null before using the returned object.
        if (availableSlot != null) {

            availableSlot.allot(vehicleNo);

        } else {

            System.out.println(
                "No slots available for " + vehicleNo
            );
        }
    }


    public static void main(String[] args) {

        // First test: one slot is available.
        ParkingSlot slot1 = new ParkingSlot("A1", 4, 3);
        ParkingSlot slot2 = new ParkingSlot("A2", 5, 5);

        ParkingSlot[] availableSlots = {
            slot1,
            slot2
        };

        safeAllot(availableSlots, "TN09AB1234");


        // Second test: every slot is full.
        ParkingSlot fullSlot1 = new ParkingSlot("A1", 4, 4);
        ParkingSlot fullSlot2 = new ParkingSlot("A2", 5, 5);

        ParkingSlot[] fullSlots = {
            fullSlot1,
            fullSlot2
        };

        safeAllot(fullSlots, "TN09AB1234");
    }
}
