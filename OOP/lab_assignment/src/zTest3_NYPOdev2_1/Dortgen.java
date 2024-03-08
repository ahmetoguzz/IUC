package zTest3_NYPOdev2_1;

public class Dortgen {
    protected Nokta nokta;
    protected int kenar1;
    protected int kenar2;

    public Dortgen(Nokta nokta) {
        this.nokta = nokta;
        kenar1 = Math.abs(nokta.x1 - nokta.x2);
        kenar2 = Math.abs(nokta.y1 - nokta.y2);
    }
}
