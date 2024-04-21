import java.util.*;

public class Main {
    public static void main(String[] args) {
//        1. Sukurti @FunctionalInterface 'MathOperation' su metodu 'int operate(int a, int b)'.
//           Sukurti objektus iš a anoniminės klasės, kad atlikti veiksmus:
//           sudeti, atimti, padauginti, padalinti

        MathOperation addition = new MathOperation() {
            @Override
            public int operate(int a, int b) {
                return a + b;
            }
        };
        MathOperation subtraction = new MathOperation() {
            @Override
            public int operate(int a, int b) {
                return a - b;
            }
        };
        MathOperation multiplication = new MathOperation() {
            @Override
            public int operate(int a, int b) {
                return a * b;
            }
        };
        MathOperation division = new MathOperation() {
            @Override
            public int operate(int a, int b) {
                return a / b;
            }
        };

//        2. Sukurti List su 20 atsitiktiniu Integer reiksmiu. Iteruoti per poras, kad atlikti
//        visus veiksmus su 'MathoOpertion' sukurtais objektais.
//        Rezultatus dedam į atskirus List'us:
//        a) List<Double> sumPairs;
//        a) List<Double> substractPairs;
//        a) List<Double> multiplyPairs;
//        a) List<Double> devidePairs;
//        Atspausdinam rezultatus.

        List<Integer> randomIntList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            randomIntList.add((random.nextInt(201) - 100)); //range -100 to 100
        }
        System.out.println("random list: " + randomIntList);
        List<Double> sumPairs = new ArrayList<>();
        for (int i = 0; i < 20; i += 2) {
            sumPairs.add((double) (addition.operate(randomIntList.get(i), randomIntList.get(i + 1))));
        }
        System.out.println("sumPairs " + sumPairs);
        List<Double> substractPairs = new ArrayList<>();
        for (int i = 0; i < 20; i += 2) {
            substractPairs.add((double) (subtraction.operate(randomIntList.get(i), randomIntList.get(i + 1))));
        }
        System.out.println("substractPairs " + substractPairs);
        List<Double> multiplyPairs = new ArrayList<>();
        for (int i = 0; i < 20; i += 2) {
            multiplyPairs.add((double) (multiplication.operate(randomIntList.get(i), randomIntList.get(i + 1))));
        }
        System.out.println("multiplyPairs " + multiplyPairs);
        List<Double> devidePairs = new ArrayList<>();
        for (int i = 0; i < 20; i += 2) {
            if (randomIntList.get(i + 1) != 0) {
                devidePairs.add((double) (division.operate(randomIntList.get(i), randomIntList.get(i + 1))));
            }
        }
        System.out.println("devidePairs " + devidePairs);
        System.out.println();

//        3. Sukurti @FunctionalInterface 'StringOperation' su metodu 'String manipulate(String input)'.
//           Sukurti objektus iš anoniminės klasės, kad atlikti veiksmus:
//           uppercase, lowercase ir reverse

        StringOperation uppercase = new StringOperation() {
            @Override
            public String manipulate(String input) {
                return input.toUpperCase();
            }
        };
        StringOperation lowercase = new StringOperation() {
            @Override
            public String manipulate(String input) {
                return input.toLowerCase();
            }
        };
        StringOperation reverse = new StringOperation() {
            @Override
            public String manipulate(String input) {
                StringBuilder sb = new StringBuilder(input);
                return String.valueOf(sb.reverse());
            }
        };

//        4. Sukurti List su visais savaitės dienų pavadinimais. Iteruojam per List'a, naudojam
//           'StringOperation' sukurtus objektus kad transformuoti reiksmes.
//           Rezultatus dedam į atskirus List'us:
//           a) List<String> uppercaseWords;
//           a) List<String> lowercaseWords;
//           a) List<String> reversedWords;
//           Atskirai atspausdinam rezultatus.
        List<String> weekDays = new ArrayList<>();
        weekDays.add("Pirmadienis");
        weekDays.add("Antradienis");
        weekDays.add("Trečiadienis");
        weekDays.add("Ketvirtadienis");
        weekDays.add("Penktadienis");
        weekDays.add("Šeštadienis");
        weekDays.add("Sekmadienis");
        List<String> uppercaseWords = new ArrayList<>();
        List<String> lowercaseWords = new ArrayList<>();
        List<String> reversedWords = new ArrayList<>();
        for(String item : weekDays){
            uppercaseWords.add(uppercase.manipulate(item));
            lowercaseWords.add(lowercase.manipulate(item));
            reversedWords.add(reverse.manipulate(item));
        }
        System.out.println("uppercaseWords " + uppercaseWords);
        System.out.println("lowercaseWords " + lowercaseWords);
        System.out.println("uppercaseWords " + reversedWords);
        System.out.println();

//        5. Sukurti @FunctionalInterface 'Predicate' su metodu 'boolean test(int number)'.
//           Sukurti objektus iš anoniminės klasės, kad atlikti veiksmus:
//           patikrinti:
//           a) ar skaičius lyginis - true, nelyginis - false
//           b) ar reikšme teigiama - true, neigiama - false.
//           c) ar pirminis skaičius - true, atitinkamai - false.


        Predicate evenNumber = new Predicate() {
            @Override
            public boolean test(int number) {
                if(number % 2 == 0) return true;
                    else return false;
            }
        };
        Predicate positiveNumber = new Predicate() {
            @Override
            public boolean test(int number) {
                if(number >= 0) return true;
                return false;
            }
        };
        Predicate primeNumber = new Predicate() {
            @Override
            public boolean test(int number) {
                if(number <= 1) return false;
                if(number <= 3) return true;
                if(number % 2 == 0 || number % 3 == 0) return false;
                for (int i = 5; i * i <= number; i += 6) {
                    if (number % i == 0 || number % (i + 2) == 0) {
                        return false;
                    }
                }
                return true;
            }
        };

//        6. Sukurti List su 20 atsitiktiniu Integer reiksmiu (-100, 100).
//           Iteruoti per visus veiksmus su 'Predicate' sukurtais objektais ir deti
//           i atskikrus List'us:
//           a) List<Integer> evenNumbers,
//           b) List<Integer> oddNumbers,
//           c) List<Integer> positiveNumbers,
//           d) List<Integer> negativeNumbers,
//           e) List<Integer> primaryNumbers,
//           f) List<Integer> notPrimaryNumbers,

        //using list randomIntList from exercise #2
        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();
        List<Integer> positiveNumbers = new ArrayList<>();
        List<Integer> negativeNumbers = new ArrayList<>();
        List<Integer> primaryNumbers = new ArrayList<>();
        List<Integer> notPrimaryNumbers = new ArrayList<>();
        for(Integer item : randomIntList){
            if(evenNumber.test(item)) evenNumbers.add(item); else oddNumbers.add(item);
            if(positiveNumber.test(item)) positiveNumbers.add(item); else negativeNumbers.add(item);
            if(primeNumber.test(item)) primaryNumbers.add(item); else notPrimaryNumbers.add(item);
        }
        System.out.println("evenNumbers " + evenNumbers);
        System.out.println("oddNumbers " + oddNumbers);
        System.out.println("positiveNumbers " + positiveNumbers);
        System.out.println("negativeNumbers " + negativeNumbers);
        System.out.println("primaryNumbers " + primaryNumbers);
        System.out.println("notPrimaryNumbers " + notPrimaryNumbers);
        System.out.println();

//        7. Sukurti @FunctionalInterface 'Converter' su metodu 'double convert(double input)'
//           Sukurti objektus iš anoniminės klasės, kad atlikti veiksmus:
//           a) kovertuojam temeratūros parodymus iš F į C.
//           b) kovertuojam ilgio vienetus iš 'feet' i 'meter'

        Converter fahrenheitToCelsius = new Converter() {
            @Override
            public double convert(double input) {
                return (input - 32) * 5 / 9;
            }
        };
        Converter feetToMeters = new Converter() {
            @Override
            public double convert(double input) {
                return input * 0.3048;
            }
        };

//        8. Sukurti List su 10 atsitiktiniu Integer reiksmiu (1, 100).
//           Iteruoti per visus veiksmus su 'Converter' sukurtais objektais ir deti
//           i atslikrus List'us
//           Atskirai atspausdinam rezultatus.

        List <Integer> randomList = new ArrayList<>();
        for (int i = 0 ; i < 10; i++){
            randomList.add(random.nextInt(100)+1);
        }
        List<Double> celsiusResult = new ArrayList<>();
        List<Double> metersResult = new ArrayList<>();
        for(Integer item : randomList){
            celsiusResult.add(fahrenheitToCelsius.convert(item));
            metersResult.add(feetToMeters.convert(item));
        }
        System.out.println("randomList " + randomList);
        System.out.println("celsiusResult " + celsiusResult);
        System.out.println("metersResult " + metersResult);
        System.out.println();

//        9. Sukurti @FunctionalInterface 'SortText' su metodu 'List<String> sort(List<String> list)'.
//           Sukurti objeką iš anoniminės klasės, kad išrušiuotų sąrašą didejančia tvarka.
//           Sukurti List'ą, atlikti veiksmus ir atspausdinti rezultatus

        SortText sortList = new SortText() {
            @Override
            public List<String> sort(List<String> list) {
                Collections.sort(list);
                return list;
            }
        };
        List<String> nameList = new ArrayList<>(Arrays.asList("Petras", "Jonas", "Antanina", "Marija", "Kristina", "Saulius", "Darius"));
        System.out.println("List: " + nameList);
        sortList.sort(nameList);
        System.out.println("Sorted list : " + nameList);
        System.out.println();

//        10. Sukurti @FunctionalInterface 'SortIntegers' su metodu 'List<Integer> sort(List<Integer> list)'.
//            Sukurti objektą iš anoniminės klasės, kad išrušiuotų sąrašą mažėjančia tvarka.
//            Sukurti List'ą, atlikti veiksmus ir atspausdinti rezultatus

        SortIntegers sortInt = new SortIntegers() {
            @Override
            public List<Integer> sort(List<Integer> list) {
                Collections.sort(list, Collections.reverseOrder());
                return list;
            }
        };
        //using list randomList from exercise #6
        System.out.println("List: " + randomList);
        sortInt.sort(randomList);
        System.out.println("Sorted list: " + randomList);
        System.out.println();

//        11. Sukurti @FunctionalInterface 'Transformer' su metodu 'List<String> transform(List<String> list)'.
//            Sukurti objektą iš anoniminės klasės, kad pašalintų visus elementus su tuščiais String ir
//            gražina modifikuotą List'ą.
//            Sukuriam List'ą, kas antras elementas turi 'empty String', atliekame veiksmus ir atspausdinam.

        Transformer transformer = new Transformer() {
            @Override
            public List<String> transform(List<String> list) {
                Iterator<String> iterator = list.iterator();
                while(iterator.hasNext()){
                    String item = iterator.next();
                    if(item.isEmpty()){
                        iterator.remove();
                    }
                }
                return list;
            }
        };
        List<String> myNameList = new ArrayList<>(Arrays.asList("Petras", "Jonas", "", "Marija", "Kristina", "", "Darius"));
        System.out.println("List: " + myNameList);
        transformer.transform(myNameList);
        System.out.println("List without empty elements: " + myNameList);
        System.out.println();

//        12. Sukuriam List<StringOperation>, sukuriam ir pridedam objektus, kurie atskirai atlieka
//            veiksmus su lowercase, uppercase, revese.
//            Skuriam metoda 'performActions(String text, List<StringOperation> list)', kuriame iteruojame
//            per parametrus paduotą List'ą, iš kiekvieno objekto iškviečiam metoda, kurį ansčiau perraščėm.
//            Paduodam parametro 'text' reikšmę, kad transformuotų ir atspausdintų.
//            Iškviečiam metodą, paduodam argumentus, kad atliktu veiksmus

        List<StringOperation> stringOp = new ArrayList<>();
        stringOp.add(uppercase); // line 77
        stringOp.add(lowercase); // line 83
        stringOp.add(reverse); // line 89
        String text = "text";
        System.out.println("Original text is: " + text);
        //stringOp.get(0).manipulate(text); -uppercase without method performActions()
        performActions(text, stringOp);

    }
    public static void performActions(String text, List<StringOperation> list){
        for(StringOperation item : list){
            String resultText = item.manipulate(text);
            System.out.println("Result is: " + resultText);
        }
    }
}