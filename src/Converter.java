public class Converter {
    public double convectDistance(int steps){
        int centimetre = steps * 75;
        int km = centimetre / 100_000;
        return km;
    }

    public int ConvectkCal(int steps) {
        int cal = steps * 50;
        int kCal = cal * 1000;
        return kCal;
    }
}
