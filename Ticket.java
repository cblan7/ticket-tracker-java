class Ticket {
    private int ticketID;
    private String userName;
    private String issueType;
    private String priority;
    private boolean isResolved;

    // Default constructor
    public Ticket() {
        this(0, "Unknown", "Unknown", "Low", false);
    }

    // Custom constructor
    public Ticket(int ticket, String user, String issue, String priority, boolean status) {
        this.ticketID = ticket;
        this.userName = user;
        this.issueType = issue;
        this.priority = priority;
        this.isResolved = status;
    }

    public int getTicketID() {
        return ticketID;
    }

    public String getUserName() {
        return userName;
    }

    public String getIssueType() {
        return issueType;
    }

    public String getPriority() {
        return priority;
    }

    public boolean isResolved() {
        return isResolved;
    }

    public void resolveTicket() {
        this.isResolved = true;
    }

    public void setName(String name) {
        this.userName = name;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setIssueType(String issue) {
        this.issueType = issue;
    }

    public void displayTicket() {
        System.out.println("Ticket ID: " + ticketID);
        System.out.println("User Name: " + userName);
        System.out.println("Issue Type: " + issueType);
        System.out.println("Priority: " + priority);
        System.out.println("Resolved: " + (isResolved ? "Yes" : "No"));
        System.out.println("------------------------");
    }
}