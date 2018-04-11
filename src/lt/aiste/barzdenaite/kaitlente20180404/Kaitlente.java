package lt.aiste.barzdenaite.kaitlente20180404;

import java.util.ArrayList;

public class Kaitlente {

    private ArrayList <Anga> anguSarasas = new ArrayList<>();
    private boolean vaikuApsauga = false;
    private boolean ijungta = true;

    public Kaitlente(){
        sukurtiKaitlente();
    }

    private void sukurtiKaitlente() {
        this.pridetiAnga(new Anga(Anga.NULINE_PADETIS));
        this.pridetiAnga(new Anga(Anga.NULINE_PADETIS));
        this.pridetiAnga(new Anga(Anga.NULINE_PADETIS));
        this.pridetiAnga(new Anga(Anga.NULINE_PADETIS));

    }

    public boolean isVaikuApsauga() {
        return vaikuApsauga;
    }

    public void setVaikuApsauga(boolean vaikuApsauga) {
        this.vaikuApsauga = vaikuApsauga;
    }

    public void pridetiAnga(Anga anga) {
        anguSarasas.add(anga);
    }

    public ArrayList<Anga> getAnguSarasas() {
        return anguSarasas;
    }

    public void setAnguSarasas(ArrayList<Anga> anguSarasas) {
        this.anguSarasas = anguSarasas;
    }

    public boolean isIjungta() {
        return ijungta;
    }

    public void setIjungta(boolean ijungta) {
        this.ijungta = ijungta;
    }

    public void issijunk(){
        for (int i = 0; i < this.anguSarasas.size(); i++) {
            nustatykKarsti(i, Anga.NULINE_PADETIS);
        }
        this.setIjungta(false);
    }

    public boolean arGalimaAnga(int angosSk) {
        return angosSk > 0 && angosSk <= anguSarasas.size();
    }

    public AngosGalingumoKeitimoResultatas nustatykKarsti(int angaNr, int karstis){
        if (!vaikuApsauga && ijungta && karstis >= Anga.NULINE_PADETIS && karstis <= Anga.MAKSIMALI_PADETIS) {
            Anga anga = anguSarasas.get(angaNr);
            anga.setPadala(karstis);
            return AngosGalingumoKeitimoResultatas.PAVYKO;
        } else {
            if (!ijungta){
                return AngosGalingumoKeitimoResultatas.KAITLENTE_ISJUNGTA;
            } else if (vaikuApsauga){
                return AngosGalingumoKeitimoResultatas.VAIKU_APSAUGA_IJUNGTA;
            } else if (karstis < Anga.NULINE_PADETIS || karstis > Anga.MAKSIMALI_PADETIS) {
                return AngosGalingumoKeitimoResultatas.BLOGAS_PADALOS_SKAICIUS;
            } else {
                return AngosGalingumoKeitimoResultatas.NEZINAU;
            }
        }
    }

    public void spausdinkBusena(){
        System.out.println(Pagalba.iifStr(ijungta, "Kaitlente ijungta", "Kaitlente isjungta"));
        System.out.println(Pagalba.iifStr(vaikuApsauga, "Vaiku apsauga ijungta", "Vaiku apsauga isjungta"));
        for (int i = 0; i < this.anguSarasas.size(); i++) {
            System.out.println((i+1) + " anga nustatyta padala " + this.anguSarasas.get(i).getPadala());
        }

    }

    @Override
    public String toString() {
        return "Kaitlente{" +
                "anguSarasas=" + anguSarasas +
                '}';
    }

}
