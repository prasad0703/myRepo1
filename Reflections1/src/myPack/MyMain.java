package myPack;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MyMain {

	public static void main(String[] args) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException {
		// TODO Auto-generated method stub
		//Class a = Class.forName("Employee");
		//Employee e = new Employee();
		//Class b = e.getClass();
		Class a = Employee.class;
		//*************************class level*************************
		System.out.println("****************Class Level Information****************");
		System.out.println("class Name: "+a.getName());
		System.out.println("superclass Name: "+a.getSuperclass());
		System.out.println("Interfaces: ");
		for(Class m : a.getInterfaces()) {
			System.out.println("\t"+m.getName());
		}
		int i = a.getModifiers();
		System.out.println("Access Modifiers: "+Modifier.toString(i));
		//*************************variable level*************************
		System.out.println("****************Variable Level Information****************");
		//--get all public fields
		System.out.println("****************All Fields Information****************");
		for(Field f : a.getFields()) {
			System.out.println("Variable Name: "+f.getName());
			System.out.println("Variable Type: "+f.getType().getName());
			System.out.println("Variable Value: "+f.get(f));
			int x = f.getModifiers();
			System.out.println("Variable Modifiers: "+Modifier.toString(x));
			System.out.println("----------------------------------------------------");
		}
		
		//--get every declared fields
		System.out.println("****************All Declared Fields Information****************");
		for(Field f : a.getDeclaredFields()) {
			System.out.println("Variable Name: "+f.getName());
			System.out.println("Variable Type: "+f.getType().getName());
			System.out.println("Variable Value: "+f.get(f));
			int x = f.getModifiers();
			System.out.println("Variable Modifiers: "+Modifier.toString(x));
			System.out.println("----------------------------------------------------");
		}
		
		//*************************method level*************************
		//get all public methods
		System.out.println("****************All Methods Level Information****************");
		for(Method m : a.getMethods()) {
			System.out.println("Method Name: "+m.getName());
			System.out.println("Method Return Type: "+m.getReturnType().getName());
			System.out.println("Method Modifiers: "+Modifier.toString(m.getModifiers()));
			System.out.println("Method Parameter Types: ");
			for(Class c : m.getParameterTypes()) {
				System.out.println("\t"+c.getName());
			}
			System.out.println("Method Exception Types: ");
			for(Class c : m.getExceptionTypes()) {
				System.out.println("\t"+c.getName());
			}
			System.out.println("----------------------------------------------------");
		}
		//get every methods
		System.out.println("****************All Declared Methods Level Information****************");
		for(Method m : a.getDeclaredMethods()) {
			System.out.println("Method Name: "+m.getName());
			System.out.println("Method Return Type: "+m.getReturnType().getName());
			System.out.println("Method Modifiers: "+Modifier.toString(m.getModifiers()));
			System.out.println("Method Parameter Types: ");
			for(Class c : m.getParameterTypes()) {
				System.out.println("\t"+c.getName());
			}
			System.out.println("Method Exception Types: ");
			for(Class c : m.getExceptionTypes()) {
				System.out.println("\t"+c.getName());
			}
			System.out.println("----------------------------------------------------");
		}
		
		//*************************Constructor level*************************
		System.out.println("****************Constructor Level Information****************");
		//--get all public Constructors
		System.out.println("****************All Constructors Information****************");
		for(Constructor cn : a.getConstructors()) {
			System.out.println("Constructor Name: "+cn.getName());
			int x = cn.getModifiers();
			System.out.println("Constructor Modifiers: "+Modifier.toString(x));
			System.out.println("Constructor Parameter Types: ");
			for(Class c : cn.getParameterTypes()) {
				System.out.println("\t"+c.getName());
			}
			System.out.println("Constructor Exception Types: ");
			for(Class c : cn.getExceptionTypes()) {
				System.out.println("\t"+c.getName());
			}
			System.out.println("----------------------------------------------------");
		}
		
		//--get every declared Constructors
		System.out.println("****************All Declared Constructors Information****************");
		for(Constructor cn : a.getDeclaredConstructors()) {
			System.out.println("Constructor Name: "+cn.getName());
			int x = cn.getModifiers();
			System.out.println("Constructor Modifiers: "+Modifier.toString(x));
			System.out.println("Constructor Parameter Types: ");
			for(Class c : cn.getParameterTypes()) {
				System.out.println("\t"+c.getName());
			}
			System.out.println("Constructor Exception Types: ");
			for(Class c : cn.getExceptionTypes()) {
				System.out.println("\t"+c.getName());
			}
			System.out.println("----------------------------------------------------");
		}
	}

}
abstract class Employee implements Serializable, Cloneable{
	public static int eNo = 111;
	static String eName = "aaa";
	static String eAdr = "abc";
	
	public Employee() {}
	public Employee(int i, String j) throws ClassCastException {}
	Employee(int k) {}
	
	
	public int add(int x, String y) throws ArithmeticException, IOException {return 1;}
	public void search(int n) {}
	String delete() {return "success";}
	
	}