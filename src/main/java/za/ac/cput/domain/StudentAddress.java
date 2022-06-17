package za.ac.cput.domain;
/*
 * Velenkosini Prince Jeza (218191669)
 * */

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class StudentAddress {

    @NotNull @Id
    private String studentId;
    @Embedded
    private Address address;

    protected StudentAddress(){}

    private StudentAddress(Builder builder) {
        this.studentId = builder.studentId;
        this.address = builder.address;
    }

    //Getters
    public String getStudentId() {
        return studentId;
    }

    public Address getAddress() {
        return address;
    }

    //Setters
    public static class Builder {
        private String studentId;
        private Address address;

        public Builder setStudentId(String studentId) {
            this.studentId = studentId;
            return this;
        }

        public Builder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder copy(StudentAddress studentAddress) {
            this.studentId = studentAddress.studentId;
            this.address = studentAddress.address;
            return this;
        }
        public StudentAddress build(){
            return new StudentAddress (this);
        }
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentAddress studentAddress = (StudentAddress) o;
        return studentId.equals(studentAddress.studentId);
    }

    @Override
    public int hashCode() {return Objects.hash(studentId);}

    @Override
    public String toString() {
        return "StudentAddress{" +
                "studentId='" + studentId + '\'' +
                ", address=" + address +
                '}';
    }

}
