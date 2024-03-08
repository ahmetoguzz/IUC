package zTest3_NYPOdev2_1;

public class Kare extends Dortgen implements Shape {
    public Kare(Nokta nokta) {
        super(nokta);
    }

    @Override
    public double hesaplaAlan() {
        return Math.pow(kenar1, 2);
    }

    @Override
    public double hesaplaKütle() {
        return 1.0; // Yoğunluk sabit 1
    }
}
