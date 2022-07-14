public class Converter {
    public double convectDistance(int steps){
         final double centimetre = steps * 75;
         final double km = centimetre / 100_000;
         return km;
    }

    public double ConvectkCal(int steps) {
        final double cal = steps * 50;
        final double kCal = cal / 1000;
        return kCal;
    }
}
