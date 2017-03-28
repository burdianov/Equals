package info.testing;

public class Main {

	public static void main(String[] args) {
		// cream obiecte cu aceiasi parametri
        Car car1 = new Car(2);
        Car car2 = new Car(2);
        Car car3 = car1;

        // metoda equals deja compara dupa instructiunea pe care noi am
        // descris-o in metoda redefinita a clasei cu care se compara
        System.out.println(car1.equals(car2));
        System.out.println(car1.equals(car3));

	}

}
