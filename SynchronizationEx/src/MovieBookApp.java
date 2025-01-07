class BookTheaterSeat {

    int total_seats = 10;
    void bookSeat(int seats) {
        if(total_seats>=seats){
            System.out.println(seats + " Seats booked successfully.");
            total_seats = total_seats-seats;
            System.out.println("Seats left: "+total_seats);
        }else{
            System.out.println("Sorry seats cannot be booked...!");
            System.out.println("Seats left: "+total_seats);
        }
    }
}

public class MovieBookApp extends Thread {

    static BookTheaterSeat b;
    int seats;
    public void run(){
        b.bookSeat(seats);
    }
    public static void main(String[] args) {
        b = new BookTheaterSeat();

        MovieBookApp rahul = new MovieBookApp();
        rahul.seats=7;
        rahul.start();

        MovieBookApp chinmay = new MovieBookApp();
        chinmay.seats=6;
        chinmay.start();
    }
}
