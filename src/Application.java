import model.Kotik;

public class Application {
    public static void main(String[] args) {
        Kotik kotik1 = new Kotik(150,"Alex",2189,"meaou");
        Kotik kotik2 = new Kotik();

        kotik2.liveAnotherDay();
        System.out.println(kotik2);

        System.out.println(kotik1.equals(kotik2));
        System.out.println(Kotik.getCountKotiks());

    }

}
