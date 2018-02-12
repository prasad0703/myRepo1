package myPack;

//bounded types
public class MyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gen1<Number> g1 = new Gen1<Number>();
		Gen1<Integer> g2 = new Gen1<Integer>();
		//below line compile error - bound mismatch
		//Gen1<String> g7 = new Gen1<String>();
		Gen2<Thread> g3 = new Gen2<Thread>();
		Gen2<Runnable> g4 = new Gen2<Runnable>();
		Gen3<Integer> g5 = new Gen3<Integer>();
		//below line compile error - bound mismatch
		//Gen3<Number> g6 = new Gen3<Number>();
	}

}
//extends class
class Gen1<T extends Number>{
	
}
//extends interface(not implements)
class Gen2<T extends Runnable>{
	
}
//extends final class
class Gen3<T extends Integer>{
	
}
//extends one class and extends multiple interfaces
class Gen4<T extends Number & Runnable>{
	
}
class Gen5<T extends A & B & Runnable>{
	
}
class A{}
interface B{}
