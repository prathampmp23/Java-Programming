package com.junit.Service;

import com.junit.courses.Course;

public class PurchasedCourse {
    // private Course course;

    // java object injection like Course cource = new JavaCourse();
    public boolean proceedWithCourse(Course cource) { 
        return cource.CoursePurchased();
    }
}
