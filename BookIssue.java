public class BookIssue {

    // Fields
    String title;
    String borrowerName;
    int daysOverdue;

    // Constructor
    BookIssue(String title, String borrowerName, int daysOverdue) {
        this.title = title;
        this.borrowerName = borrowerName;
        this.daysOverdue = daysOverdue;
    }

    // Calculates the fine for this particular book
    double fineAmount() {
        if (daysOverdue > 0) {
            return daysOverdue * 5;
        } else {
            return 0;
        }
    }

    // Checks whether this particular book is severely overdue
    boolean isSeverelyOverdue() {
        return daysOverdue > 14;
    }

    /*
     * totalFineCollected() is static because it works on an array
     * containing many BookIssue objects, rather than one particular book.
     *
     * fineAmount() is not static because the fine belongs to one specific
     * BookIssue object and uses that object's daysOverdue value.
     */
    static double totalFineCollected(BookIssue[] issues) {
        double total = 0;

        for (BookIssue issue : issues) {
            total += issue.fineAmount();
        }

        return total;
    }

    public static void main(String[] args) {

        // Create an array containing five BookIssue objects
        BookIssue[] issues = {
            new BookIssue("Clean Code", "Aditi", 18),
            new BookIssue("Effective Java", "Rohan", 5),
            new BookIssue("Refactoring", "Karan", 0),
            new BookIssue("DSA Handbook", "Meera", 21),
            new BookIssue("Design Patterns", "Divya", 9)
        };

        // Print information about each book
        for (BookIssue issue : issues) {

            if (issue.isSeverelyOverdue()) {
                System.out.println(
                    issue.title + " - " + issue.daysOverdue
                    + " days - Severely overdue"
                );
            } else {
                System.out.println(
                    issue.title + " - " + issue.daysOverdue
                    + " days - OK"
                );
            }
        }

        // Calculate and print the total fine
        double totalFine = BookIssue.totalFineCollected(issues);

        System.out.println("Total fine collected: Rs " + totalFine);
    }
}

