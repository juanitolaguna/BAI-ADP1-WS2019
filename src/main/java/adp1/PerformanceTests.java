package adp1;
import java.util.Random;

public class PerformanceTests {

    public static DoubleLinkedList<Integer> makeIntList(Integer laengeDerListe) {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        for (int j = 0; j < laengeDerListe; j++) {
            list.addFirst(j);
        }
        return list;
    }


    /**
     * Run with gradle (example):
     * ./gradlew clean performanceTest -Parg=addAt,10,500,40000
     * @param args
     */
    public static void main(String[] args) {
        String methode = args[0];
        int anzahlExperimente = Integer.parseInt(args[1]);
        int anzahlWiederholungen = Integer.parseInt(args[2]);
        int laengeDerListe = Integer.parseInt(args[3]);

        Random random = new Random();

        System.out.println(String.format("%s %d-mal, Listenlaenge=%d, Anzahl Exp=%d", methode, anzahlWiederholungen, laengeDerListe, anzahlExperimente));
        System.out.println("Wdh  Zeit(ms)   Zeit/repOp(ms)");

        for (int i = 0; i < anzahlExperimente; i++) {
            DoubleLinkedList<Integer> list = makeIntList(laengeDerListe);
            double time = 0.0;

            switch (methode) {
                case "addAt":
                    for (int j = 0; j < anzahlWiederholungen; j++) {
                        int rand = random.nextInt(laengeDerListe);
                        Stopwatch t1 = new Stopwatch();
                        list.addAt(1945, rand);
                        double duration = t1.elapsedTime();
                        time += duration;
                    }
                    break;
                case "deleteAt":
                    int mutableLength = laengeDerListe;
                    for (int j = 0; j < anzahlWiederholungen; j++) {
                        int rand = random.nextInt(mutableLength--);
                        Stopwatch t1 = new Stopwatch();
                        list.deleteAt(rand);
                        double duration = t1.elapsedTime();
                        time += duration;
                    }
                    break;
                case "hasSuchElement":
                    for (int j = 0; j < anzahlWiederholungen; j++) {
                        int rand = random.nextInt(laengeDerListe);
                        Stopwatch t1 = new Stopwatch();
                        list.hasSuchElement(rand);
                        double duration = t1.elapsedTime();
                        time += duration;
                    }
                    break;
                case "deleteElem":
                    for (int j = 0; j < anzahlWiederholungen; j++) {
                        int rand = random.nextInt(laengeDerListe);
                        Stopwatch t1 = new Stopwatch();
                        list.deleteElem(rand);
                        double duration = t1.elapsedTime();
                        time += duration;
                    }

            }
            System.out.println(String.format("%d %4.3f %2.3f", anzahlWiederholungen, time, time / anzahlWiederholungen));
            // System.out.println(String.format("%d %4.3f %2.3f", anzahlWiederholungen, time, time / anzahlWiederholungen));



        }


    }
}
