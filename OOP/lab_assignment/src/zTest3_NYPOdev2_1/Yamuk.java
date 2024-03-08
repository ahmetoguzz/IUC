package zTest3_NYPOdev2_1;

public class Yamuk extends Dortgen implements Shape {
    public Yamuk(Nokta nokta) {
        super(nokta);
    }

    @Override
    public double hesaplaAlan() {
        double ustTaban = Math.max(nokta.x1, nokta.x2);
        double altTaban = Math.min(nokta.x1, nokta.x2);
        double yukseklik = Math.abs(nokta.y1 - nokta.y2);

        return 0.5 * (ustTaban + altTaban) * yukseklik;
    }

    @Override
    public double hesaplaKütle() {
        return 1.0; // Yoğunluğu 1 al
    }
}