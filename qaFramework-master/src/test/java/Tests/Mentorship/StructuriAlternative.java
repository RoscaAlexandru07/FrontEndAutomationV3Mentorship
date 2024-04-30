package Tests.Mentorship;

import org.testng.annotations.Test;

import javax.management.ValueExp;

public class StructuriAlternative {

    //Structuri alternative = if - then - else; switch - case

    @Test
    public void metodaTest() {
        //verificareNumar();
        //verificareNumarPartea2(10);
        //verificareNumarPartea2(4);
        //verificareNumarPartea2(5);
        //verificareNumarPartea2(-10);
        //verificareNumarPartea2(0);

//        verificareNumarPartea3(5);
//        verificareNumarPartea3(2);
//        verificareNumarPartea3(6);

        //alegeMasina("Dacia");
        //verificareNumarParPositiv(-5);
        verificareNumarParPositivPartea2(-22);
    }


    //Verificare un numar mai mare decat 5
    public void verificareNumar() {
        if (8 > 5) {
            System.out.println("Numar 2 mai mare decat 5");
        } else {
            System.out.println("Numar 2 mai mic decat 5");
        }
    }

    public void verificareNumarPartea2(int valoare) {
        if (valoare > 5) {
            System.out.println("Numar " + valoare + " este mai mare decat 5");
        } else {
            System.out.println("Numar " + valoare + " este mai mic decat 5");
        }
    }

    public void verificareNumarPartea3(int valoare) {
        if (valoare > 5) {
            System.out.println("Numar " + valoare + " este mai mare decat 5");
        } else if (valoare < 5) {
            System.out.println("Numar " + valoare + " este mai mic decat 5");
        } else {
            System.out.println("Numar " + valoare + " este egal cu 5");
        }
    }

    public void verificareNumarParPositiv(int value) {
        if (value >= 0) {
            if (value % 2 == 0) {
                System.out.println("Numarul este par pozitiv");
            } else {
                System.out.println("Numarul este impar pozitiv");
            }
        } else {
            System.out.println("Numarul este negativ");
        }
    }

    public void verificareNumarParPositivPartea2(int value) {
        if (value > 0) {
            if (value % 2 == 0) {
                System.out.println("Numarul este par pozitiv");
            } else {
                System.out.println("Numarul este impar pozitiv");
            }
        } else if (value < 0) {
            if (value % 2 == 0) {
                System.out.println("Numarul este par negativ");
            } else {
                System.out.println("Numarul este impar negativ");
            }
        }
        else  {
            System.out.println("Numarul este 0");
        }
    }

    public void alegeMasina(String optiune) {
        switch (optiune) {
            case "Audi":
                System.out.println("Ati ales Audi");
                break;
            case "BMW":
                System.out.println("Ati ales BMW");
                break;
            case "Mercedes":
                System.out.println("Ati ales Mercedes");
                break;
            default:
                System.out.println("Nu exista optinea " + optiune);
        }
    }

}
    /// Structuri repetitive: for, while, do-while, foreach
    /* Afisam primele 100 de numere
    public void afisareNumere(){
        for(int i=0; i<=100; i++){
        System.out.println("Numarul curent este " + i)
        }

        public void afisareNumereWhile(){
        int i = 0;
        while(i <= 100){
            System.out.println("Numarul curent este " + i)
            i++;

            public voidDOwhile(){
            int i = 0;
            do {
                System.out.println("Numarul curent este " + i)
                i++;
            }
            while (i<=100);

            }

        }

        }

    }

}
*/
