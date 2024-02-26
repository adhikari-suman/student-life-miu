package lesson3.car;

public class Car{

	private int year;
	private String make;
	private String model;
	private double price;

	public static void main(String[] args) {

		Car myCar = new Car(2010, "Toyota", "Camry", 15000);
		Car myOtherCar = myCar;
		myCar.updatePrice(12000);
		System.out.println(myCar.price);
		System.out.println(myOtherCar.price);
		
	}


	public Car(){
	}
	
	public Car(int carYear, String carMake, String carModel, double carPrice) {
		super();
		year = carYear;
		make = carMake;
		model = carModel;
		price = carPrice;
	}
	
	//update the price for the car
	public void updatePrice(double newPrice){
		price = newPrice;
	
	}

	public static int staticMethod(){
		return 5;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int carYear) {
		year = carYear;
	}

//	public String getMake() {
//		return make;
//	}
//
//	public void setMake(String make) {
//		make = make;
//	}
//
//	public String getModel() {
//		return model;
//	}
//
//	public void setModel(String model) {
//		model = model;
//	}

}
