package zTest3_NYPOdev2_1;

public class Paralelkenar extends Dortgen implements Shape {
    public Paralelkenar(Nokta nokta) {
        super(nokta);
    }

    @Override
    public double hesaplaAlan() {
        return kenar1 * kenar2;
    }

    @Override
    public double hesaplaKütle() {
        return 1.0; // Yoğunluğu 1 al
    }
}