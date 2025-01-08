package models;

public class Feedback {
    private String studentId;
    private String feedback;
    private boolean resolved;

    public Feedback(String studentId, String feedback, boolean resolved) {
        this.studentId = studentId;
        this.feedback = feedback;
        this.resolved = resolved;
    }

    // Getters and setters
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public boolean isResolved() {
        return resolved;
    }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }
}
