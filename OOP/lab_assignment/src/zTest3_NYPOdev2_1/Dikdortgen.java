package zTest3_NYPOdev2_1;

public class Dikdortgen extends Dortgen implements Shape {
    public Dikdortgen(Nokta nokta) {
        super(nokta);
    }

    @Override
    public double hesaplaAlan() {
        return kenar1 * kenar2;
    }

    @Override
    public double hesaplaKütle() {
        return 1.0; // Yoğunluk sabit 1
    }
}