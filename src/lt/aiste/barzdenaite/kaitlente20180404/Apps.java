package lt.aiste.barzdenaite.kaitlente20180404;

import java.util.Scanner;

public class Apps {

    public static void main(String[] args) {
//Kaitentė turi keturias kaitinimo angas
//Kiekvienai angai galim įjungti kaitinimą nuo 0 iki 10 (0 – išjungta, 10 – maximumas)
//Turi „Apsauga nuo vaikų“ (blokuojamas visos funkcijos)
//Kaitlentę galima įjungti ir išjungti
        Scanner scanner = new Scanner(System.in);

        Kaitlente kaitlente = new Kaitlente();

        boolean run = true;
        while (run) {
            printMenu();
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    System.out.println("1. Ijungti kaitlente 2. Isjungti kaitlente");
                    int ijungimas = scanner.nextInt();
                    if (ijungimas == 1) {
                        System.out.println("Kaitlente ijungta");
                    } else if (ijungimas == 2) {
                        kaitlente.issijunk();
                        System.out.println("Kaitlente isjungta");
                    } else {
                        System.out.println("Iveskite skaiciu 1 arba 2");
                    }
                    break;
                case 2:
                    System.out.println("Kurios angos kaitinima norite didinti/mazinti?");
                    int angosSk = scanner.nextInt();
                    System.out.println("Koki karsti norite nustatyti nuo 0 iki 10?");
                    int karstis = scanner.nextInt();
                    if (kaitlente.arGalimaAnga(angosSk)) {
                        AngosGalingumoKeitimoResultatas arPavykoPakeistiKarsti = kaitlente.nustatykKarsti(angosSk - 1, karstis);
                        printAnga(arPavykoPakeistiKarsti, angosSk, karstis);
                    } else {
                        System.out.println("Blogai pasirinktas skaicius");
                    }
                    break;
                case 3:
                    System.out.println("1. Ijungti apsauga nuo vaiku 2. Isjungti apsauga nuo vaiku");
                    int apsaugaNuoVaiku = scanner.nextInt();
                    if (apsaugaNuoVaiku == 1) {
                        kaitlente.setVaikuApsauga(true);
                        System.out.println("Apsauga nuo vaiku ijungta");
                    }
                    if (apsaugaNuoVaiku == 2) {
                        kaitlente.setVaikuApsauga(false);
                        System.out.println("Apsauga nuo vaiku isjungta");
                    }
                    break;
                case 4:
                    kaitlente.spausdinkBusena();
                    break;
                default:
                    System.out.println("Blogai ivestas numeris");
                    break;
            }
        }
        scanner.close();
    }


    public static void printMenu() {
        System.out.println("----------------------------------------");
        System.out.println("Pasirinkite, ka norite daryti:");
        System.out.println("1. Ijungti/isjungti kaitlente");
        System.out.println("2. Padidinti/pamazinti kaitinima");
        System.out.println("3. Ijungti/isjungti apsauga nuo vaiku");
        System.out.println("4. Parodyti kaitlentes busena");
        System.out.println("-----------------------------------------");
    }

    public static void printAnga(AngosGalingumoKeitimoResultatas arPavykoPakeistiKarsti, int angosSk, int karstis){
        if (AngosGalingumoKeitimoResultatas.PAVYKO.equals(arPavykoPakeistiKarsti)){
            System.out.println(angosSk + " anga nustatyta padala: " + karstis);
        } else if (AngosGalingumoKeitimoResultatas.KAITLENTE_ISJUNGTA.equals(arPavykoPakeistiKarsti)){
            System.out.println("Pirma ijunkite kaitlente");
        } else if (AngosGalingumoKeitimoResultatas.VAIKU_APSAUGA_IJUNGTA.equals(arPavykoPakeistiKarsti)){
            System.out.println("Pirma isjunkite apsauga nuo vaiku");
        } else {
            System.out.println("Kreipkites i servisa");
        }
    }

}
