package org.fluentness.service.localization;

import java.util.HashMap;
import java.util.Map;

import static org.fluentness.service.localization.Language.*;

public class Localization {
    
    private Map<Language, String> translations = new HashMap<>();

    public String get(Language currentLanguage) {
        return translations.get(currentLanguage);
    }

    public Localization af(String value) {
        translations.put(AF, value);
        return this;
    }

    public Localization ar(String value) {
        translations.put(AR, value);
        return this;
    }

    public Localization az(String value) {
        translations.put(AZ, value);
        return this;
    }

    public Localization be(String value) {
        translations.put(BE, value);
        return this;
    }

    public Localization bg(String value) {
        translations.put(BG, value);
        return this;
    }

    public Localization ca(String value) {
        translations.put(CA, value);
        return this;
    }

    public Localization cs(String value) {
        translations.put(CS, value);
        return this;
    }

    public Localization cy(String value) {
        translations.put(CY, value);
        return this;
    }

    public Localization da(String value) {
        translations.put(DA, value);
        return this;
    }

    public Localization de(String value) {
        translations.put(DE, value);
        return this;
    }

    public Localization dv(String value) {
        translations.put(DV, value);
        return this;
    }

    public Localization el(String value) {
        translations.put(EL, value);
        return this;
    }

    public Localization en(String value) {
        translations.put(EN, value);
        return this;
    }

    public Localization eo(String value) {
        translations.put(EO, value);
        return this;
    }

    public Localization es(String value) {
        translations.put(ES, value);
        return this;
    }

    public Localization et(String value) {
        translations.put(ET, value);
        return this;
    }

    public Localization eu(String value) {
        translations.put(EU, value);
        return this;
    }

    public Localization fa(String value) {
        translations.put(FA, value);
        return this;
    }

    public Localization fi(String value) {
        translations.put(FI, value);
        return this;
    }

    public Localization fo(String value) {
        translations.put(FO, value);
        return this;
    }

    public Localization fr(String value) {
        translations.put(FR, value);
        return this;
    }

    public Localization gl(String value) {
        translations.put(GL, value);
        return this;
    }

    public Localization gu(String value) {
        translations.put(GU, value);
        return this;
    }

    public Localization he(String value) {
        translations.put(HE, value);
        return this;
    }

    public Localization hi(String value) {
        translations.put(HI, value);
        return this;
    }

    public Localization hr(String value) {
        translations.put(HR, value);
        return this;
    }

    public Localization hu(String value) {
        translations.put(HU, value);
        return this;
    }

    public Localization hy(String value) {
        translations.put(HY, value);
        return this;
    }

    public Localization id(String value) {
        translations.put(ID, value);
        return this;
    }

    public Localization is(String value) {
        translations.put(IS, value);
        return this;
    }

    public Localization it(String value) {
        translations.put(IT, value);
        return this;
    }

    public Localization ja(String value) {
        translations.put(JA, value);
        return this;
    }

    public Localization ka(String value) {
        translations.put(KA, value);
        return this;
    }

    public Localization kk(String value) {
        translations.put(KK, value);
        return this;
    }

    public Localization kn(String value) {
        translations.put(KN, value);
        return this;
    }

    public Localization ko(String value) {
        translations.put(KO, value);
        return this;
    }

    public Localization ky(String value) {
        translations.put(KY, value);
        return this;
    }

    public Localization lt(String value) {
        translations.put(LT, value);
        return this;
    }

    public Localization lv(String value) {
        translations.put(LV, value);
        return this;
    }

    public Localization mi(String value) {
        translations.put(MI, value);
        return this;
    }

    public Localization mk(String value) {
        translations.put(MK, value);
        return this;
    }

    public Localization mn(String value) {
        translations.put(MN, value);
        return this;
    }

    public Localization mr(String value) {
        translations.put(MR, value);
        return this;
    }

    public Localization ms(String value) {
        translations.put(MS, value);
        return this;
    }

    public Localization mt(String value) {
        translations.put(MT, value);
        return this;
    }

    public Localization nb(String value) {
        translations.put(NB, value);
        return this;
    }

    public Localization nl(String value) {
        translations.put(NL, value);
        return this;
    }

    public Localization ns(String value) {
        translations.put(NS, value);
        return this;
    }

    public Localization pa(String value) {
        translations.put(PA, value);
        return this;
    }

    public Localization pl(String value) {
        translations.put(PL, value);
        return this;
    }

    public Localization ps(String value) {
        translations.put(PS, value);
        return this;
    }

    public Localization pt(String value) {
        translations.put(PT, value);
        return this;
    }

    public Localization qu(String value) {
        translations.put(QU, value);
        return this;
    }

    public Localization ro(String value) {
        translations.put(RO, value);
        return this;
    }

    public Localization ru(String value) {
        translations.put(RU, value);
        return this;
    }

    public Localization sa(String value) {
        translations.put(SA, value);
        return this;
    }

    public Localization se(String value) {
        translations.put(SE, value);
        return this;
    }

    public Localization sk(String value) {
        translations.put(SK, value);
        return this;
    }

    public Localization sl(String value) {
        translations.put(SL, value);
        return this;
    }

    public Localization sq(String value) {
        translations.put(SQ, value);
        return this;
    }

    public Localization sv(String value) {
        translations.put(SV, value);
        return this;
    }

    public Localization sw(String value) {
        translations.put(SW, value);
        return this;
    }

    public Localization ta(String value) {
        translations.put(TA, value);
        return this;
    }

    public Localization te(String value) {
        translations.put(TE, value);
        return this;
    }

    public Localization th(String value) {
        translations.put(TH, value);
        return this;
    }

    public Localization tl(String value) {
        translations.put(TL, value);
        return this;
    }

    public Localization tn(String value) {
        translations.put(TN, value);
        return this;
    }

    public Localization tr(String value) {
        translations.put(TR, value);
        return this;
    }

    public Localization tt(String value) {
        translations.put(TT, value);
        return this;
    }

    public Localization ts(String value) {
        translations.put(TS, value);
        return this;
    }

    public Localization uk(String value) {
        translations.put(UK, value);
        return this;
    }

    public Localization ur(String value) {
        translations.put(UR, value);
        return this;
    }

    public Localization uz(String value) {
        translations.put(UZ, value);
        return this;
    }

    public Localization vi(String value) {
        translations.put(VI, value);
        return this;
    }

    public Localization xh(String value) {
        translations.put(XH, value);
        return this;
    }

    public Localization zh(String value) {
        translations.put(ZH, value);
        return this;
    }

    public Localization zu(String value) {
        translations.put(ZU, value);
        return this;
    }
}
