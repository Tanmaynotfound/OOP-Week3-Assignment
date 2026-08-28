class LibraryMember {

    // Instance fields: each member has their own values.
    private String name;
    private String memberId;
    private int booksIssued;

    // Static fields: shared by the whole library.
    static String libraryName = "City Library";
    static int memberCount = 0;

    // Constructor
    LibraryMember(String name, int booksIssued) {

        this.name = name;
        this.booksIssued = booksIssued;

        // Increase the shared member count.
        memberCount++;

        // Generate member ID automatically.
        this.memberId = "LM-" + (1000 + memberCount);
    }

    // Prints this particular member's card.
    void printMemberCard() {
        System.out.println(
            name + " | " + memberId
            + " | Books issued: " + booksIssued
        );
    }

    // Prints the total number of members in the library.
    static void printTotalMembers() {
        System.out.println("Total members: " + memberCount);
    }
}


/*
 * BROKEN VERSION
 *
 * If name, memberId, and booksIssued were static, they would belong
 * to the LibraryMember class rather than to individual members.
 *
 * name is wrong as static because every member would share one name.
 * memberId is wrong as static because every member would share one ID.
 * booksIssued is wrong as static because every member would share
 * the same number of issued books.
 *
 * Creating the second member would overwrite the shared values.
 */
class BrokenLibraryMember {

    static String name;
    static String memberId;
    static int booksIssued;

    BrokenLibraryMember(String name, String memberId, int booksIssued) {
        BrokenLibraryMember.name = name;
        BrokenLibraryMember.memberId = memberId;
        BrokenLibraryMember.booksIssued = booksIssued;
    }

    void printMemberCard() {
        System.out.println(
            name + " | " + memberId
            + " | Books issued: " + booksIssued
        );
    }
}


public class LibraryMemberTest {

    public static void main(String[] args) {

        // ==========================================
        // BROKEN VERSION
        // ==========================================

        System.out.println("Broken version:");

        BrokenLibraryMember member1 =
            new BrokenLibraryMember("Aditi", "LM-1001", 2);

        BrokenLibraryMember member2 =
            new BrokenLibraryMember("Rohan", "LM-1002", 3);

        System.out.println("First member:");
        member1.printMemberCard();

        System.out.println("Second member:");
        member2.printMemberCard();


        // ==========================================
        // FIXED VERSION
        // ==========================================

        System.out.println();
        System.out.println("Fixed version:");

        // Reset the counter for this demonstration.
        LibraryMember.memberCount = 0;

        LibraryMember fixedMember1 =
            new LibraryMember("Aditi", 2);

        LibraryMember fixedMember2 =
            new LibraryMember("Rohan", 3);

        fixedMember1.printMemberCard();
        fixedMember2.printMemberCard();

        LibraryMember.printTotalMembers();
    }
}
