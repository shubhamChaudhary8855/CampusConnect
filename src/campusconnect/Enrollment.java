package campusconnect;

public class Enrollment {
    private final int studentId;
    private final String courseCode;

    public Enrollment(int studentId, String courseCode) {
        this.studentId = studentId;
        this.courseCode = courseCode;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "studentId=" + studentId +
                ", courseCode='" + courseCode + '\'' +
                '}';
    }
}
