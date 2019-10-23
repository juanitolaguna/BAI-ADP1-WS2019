# ADP1

## Project runs with Gradle

### run DoubleLinkedList main
`./gradlew clean run`

### run PerformanceTests (example)
`./gradlew clean performanceTest -Parg=addAt,10,500,40000`

### run all Tests
`./gradlew clean test`


# Laufzeiten
```
Die Laufzeit wächst linear im Verhältniss zur Länge der Liste.
Komplexität ist O(n/2) - wegen einer Optimierung. Die loop wird nur zur Hälfte traveriert.

addAt 500-mal, Listenlaenge=400000, Anzahl Exp=10
Wdh  Zeit(ms)   Zeit/repOp(ms)
500 898,000 1,796
500 730,000 1,460
500 869,000 1,738
500 447,000 0,894
500 423,000 0,846
500 433,000 0,866
500 409,000 0,818
500 410,000 0,820
500 400,000 0,800
500 423,000 0,846


addAt 500-mal, Listenlaenge=800000, Anzahl Exp=10
Wdh  Zeit(ms)   Zeit/repOp(ms)
500 1843,000 3,686
500 1165,000 2,330
500 857,000 1,714
500 803,000 1,606
500 845,000 1,690
500 859,000 1,718
500 811,000 1,622
500 825,000 1,650
500 860,000 1,720
500 868,000 1,736




Die Laufzeit wächst linear im Verhältniss zur Länge der Liste.
Komplexität ist O(n/2) - wegen einer Optimierung. Die loop wird nur zur Hälfte traveriert.

deleteAt 500-mal, Listenlaenge=400000, Anzahl Exp=10
Wdh  Zeit(ms)   Zeit/repOp(ms)
500 1961,000 3,922
500 913,000 1,826
500 881,000 1,762
500 389,000 0,778
500 403,000 0,806
500 377,000 0,754
500 385,000 0,770
500 392,000 0,784
500 406,000 0,812
500 418,000 0,836

deleteAt 500-mal, Listenlaenge=800000, Anzahl Exp=10
Wdh  Zeit(ms)   Zeit/repOp(ms)
500 2991,000 5,982
500 2205,000 4,410
500 1290,000 2,580
500 862,000 1,724
500 993,000 1,986
500 885,000 1,770
500 847,000 1,694
500 843,000 1,686
500 1352,000 2,704
500 896,000 1,792




Die Laufzeit wächst linear im Verhältniss zur Länge der Liste.
Komplexität ist O(n). Keine Optimierung. Für die Suche wird der Iterator verwendet.

hasSuchElement 500-mal, Listenlaenge=400000, Anzahl Exp=10
Wdh  Zeit(ms)   Zeit/repOp(ms)
500 3169,000 6,338
500 1649,000 3,298
500 1650,000 3,300
500 1657,000 3,314
500 1648,000 3,296
500 1640,000 3,280
500 1658,000 3,316
500 1667,000 3,334
500 1645,000 3,290
500 1641,000 3,282

hasSuchElement 500-mal, Listenlaenge=800000, Anzahl Exp=10
Wdh  Zeit(ms)   Zeit/repOp(ms)
500 4838,000 9,676
500 3405,000 6,810
500 3438,000 6,876
500 3424,000 6,848
500 3416,000 6,832
500 3412,000 6,824
500 3323,000 6,646
500 3315,000 6,630
500 3319,000 6,638
500 3329,000 6,658


Die Laufzeit wächst linear im Verhältniss zur Länge der Liste.
Komplexität ist O(n). Keine Optimierung. Für die Suche wird der Iterator verwendet.

deleteElem 500-mal, Listenlaenge=400000, Anzahl Exp=10
Wdh  Zeit(ms)   Zeit/repOp(ms)
500 3929,000 7,858
500 1676,000 3,352
500 1657,000 3,314
500 1667,000 3,334
500 1631,000 3,262
500 1630,000 3,260
500 1663,000 3,326
500 1720,000 3,440
500 1685,000 3,370
500 2298,000 4,596

deleteElem 500-mal, Listenlaenge=800000, Anzahl Exp=10
Wdh  Zeit(ms)   Zeit/repOp(ms)
500 4677,000 9,354
500 3354,000 6,708
500 3350,000 6,700
500 3359,000 6,718
500 3366,000 6,732
500 3376,000 6,752
500 3344,000 6,688
500 3627,000 7,254
500 3603,000 7,206
500 3396,000 6,792
```