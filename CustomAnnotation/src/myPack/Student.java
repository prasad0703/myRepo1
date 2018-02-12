package myPack;

import java.lang.annotation.Annotation;

@Course(cid = "C-333", cname = "Java", ccost = 20000)
public class Student {
	String sid;
	String sname;
	String saddr;
	public Student(String sid, String sname, String saddr) {
		this.sid = sid;
		this.sname = sname;
		this.saddr = saddr;
	}
	
	public void getStudentDetails() {
		System.out.println("Student details: ");
		System.out.println("________________");
		System.out.println("Student id: "+sid);
		System.out.println("Student name: "+sname);
		System.out.println("Student address: "+saddr);
	}
	public static void main(String[] args) {
		Student s = new Student("S-111", "Durga", "Hyd");
		s.getStudentDetails();
		Class c = s.getClass();
		Annotation an = c.getAnnotation(Course.class);
		Course cr = (Course) an;
		System.out.println("Student Course details: ");
		System.out.println("________________");
		System.out.println("Course id: "+cr.cid());
		System.out.println("Course name: "+cr.cname());
		System.out.println("Course fees: "+cr.ccost());
	}

}
