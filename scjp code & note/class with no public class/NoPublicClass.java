class A{
	public static void main(String[] args){
		System.out.println("A");
		B b = new B();
		b.b();
	}
}

class B{
	public void b(){
		System.out.println("B");
	}
}