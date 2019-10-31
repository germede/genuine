package org.fluentness.service.localization;

import java.util.HashMap;
import java.util.Map;

import static org.fluentness.service.localization.Language.*;

public class Translation {
    
    private Map<Language, String> translations = new HashMap<>();
    private String defaultTranslation;

    public String get(Language currentLanguage) {
        return translations.get(currentLanguage);
    }

    public Translation(String defaultTranslation) {
        this.defaultTranslation = defaultTranslation;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public Translation af(String value) {
        translations.put(AF, value);
        return this;
    }

    public Translation ar(String value) {
        translations.put(AR, value);
        return this;
    }

    public Translation az(String value) {
        translations.put(AZ, value);
        return this;
    }

    public Translation be(String value) {
        translations.put(BE, value);
        return this;
    }

    public Translation bg(String value) {
        translations.put(BG, value);
        return this;
    }

    public Translation ca(String value) {
        translations.put(CA, value);
        return this;
    }

    public Translation cs(String value) {
        translations.put(CS, value);
        return this;
    }

    public Translation cy(String value) {
        translations.put(CY, value);
        return this;
    }

    public Translation da(String value) {
        translations.put(DA, value);
        return this;
    }

    public Translation de(String value) {
        translations.put(DE, value);
        return this;
    }

    public Translation dv(String value) {
        translations.put(DV, value);
        return this;
    }

    public Translation el(String value) {
        translations.put(EL, value);
        return this;
    }

    public Translation en(String value) {
        translations.put(EN, value);
        return this;
    }

    public Translation eo(String value) {
        translations.put(EO, value);
        return this;
    }

    public Translation es(String value) {
        translations.put(ES, value);
        return this;
    }

    public Translation et(String value) {
        translations.put(ET, value);
        return this;
    }

    public Translation eu(String value) {
        translations.put(EU, value);
        return this;
    }

    public Translation fa(String value) {
        translations.put(FA, value);
        return this;
    }

    public Translation fi(String value) {
        translations.put(FI, value);
        return this;
    }

    public Translation fo(String value) {
        translations.put(FO, value);
        return this;
    }

    public Translation fr(String value) {
        translations.put(FR, value);
        return this;
    }

    public Translation gl(String value) {
        translations.put(GL, value);
        return this;
    }

    public Translation gu(String value) {
        translations.put(GU, value);
        return this;
    }

    public Translation he(String value) {
        translations.put(HE, value);
        return this;
    }

    public Translation hi(String value) {
        translations.put(HI, value);
        return this;
    }

    public Translation hr(String value) {
        translations.put(HR, value);
        return this;
    }

    public Translation hu(String value) {
        translations.put(HU, value);
        return this;
    }

    public Translation hy(String value) {
        translations.put(HY, value);
        return this;
    }

    public Translation id(String value) {
        translations.put(ID, value);
        return this;
    }

    public Translation is(String value) {
        translations.put(IS, value);
        return this;
    }

    public Translation it(String value) {
        translations.put(IT, value);
        return this;
    }

    public Translation ja(String value) {
        translations.put(JA, value);
        return this;
    }

    public Translation ka(String value) {
        translations.put(KA, value);
        return this;
    }

    public Translation kk(String value) {
        translations.put(KK, value);
        return this;
    }

    public Translation kn(String value) {
        translations.put(KN, value);
        return this;
    }

    public Translation ko(String value) {
        translations.put(KO, value);
        return this;
    }

    public Translation ky(String value) {
        translations.put(KY, value);
        return this;
    }

    public Translation lt(String value) {
        translations.put(LT, value);
        return this;
    }

    public Translation lv(String value) {
        translations.put(LV, value);
        return this;
    }

    public Translation mi(String value) {
        translations.put(MI, value);
        return this;
    }

    public Translation mk(String value) {
        translations.put(MK, value);
        return this;
    }

    public Translation mn(String value) {
        translations.put(MN, value);
        return this;
    }

    public Translation mr(String value) {
        translations.put(MR, value);
        return this;
    }

    public Translation ms(String value) {
        translations.put(MS, value);
        return this;
    }

    public Translation mt(String value) {
        translations.put(MT, value);
        return this;
    }

    public Translation nb(String value) {
        translations.put(NB, value);
        return this;
    }

    public Translation nl(String value) {
        translations.put(NL, value);
        return this;
    }

    public Translation ns(String value) {
        translations.put(NS, value);
        return this;
    }

    public Translation pa(String value) {
        translations.put(PA, value);
        return this;
    }

    public Translation pl(String value) {
        translations.put(PL, value);
        return this;
    }

    public Translation ps(String value) {
        translations.put(PS, value);
        return this;
    }

    public Translation pt(String value) {
        translations.put(PT, value);
        return this;
    }

    public Translation qu(String value) {
        translations.put(QU, value);
        return this;
    }

    public Translation ro(String value) {
        translations.put(RO, value);
        return this;
    }

    public Translation ru(String value) {
        translations.put(RU, value);
        return this;
    }

    public Translation sa(String value) {
        translations.put(SA, value);
        return this;
    }

    public Translation se(String value) {
        translations.put(SE, value);
        return this;
    }

    public Translation sk(String value) {
        translations.put(SK, value);
        return this;
    }

    public Translation sl(String value) {
        translations.put(SL, value);
        return this;
    }

    public Translation sq(String value) {
        translations.put(SQ, value);
        return this;
    }

    public Translation sv(String value) {
        translations.put(SV, value);
        return this;
    }

    public Translation sw(String value) {
        translations.put(SW, value);
        return this;
    }

    public Translation ta(String value) {
        translations.put(TA, value);
        return this;
    }

    public Translation te(String value) {
        translations.put(TE, value);
        return this;
    }

    public Translation th(String value) {
        translations.put(TH, value);
        return this;
    }

    public Translation tl(String value) {
        translations.put(TL, value);
        return this;
    }

    public Translation tn(String value) {
        translations.put(TN, value);
        return this;
    }

    public Translation tr(String value) {
        translations.put(TR, value);
        return this;
    }

    public Translation tt(String value) {
        translations.put(TT, value);
        return this;
    }

    public Translation ts(String value) {
        translations.put(TS, value);
        return this;
    }

    public Translation uk(String value) {
        translations.put(UK, value);
        return this;
    }

    public Translation ur(String value) {
        translations.put(UR, value);
        return this;
    }

    public Translation uz(String value) {
        translations.put(UZ, value);
        return this;
    }

    public Translation vi(String value) {
        translations.put(VI, value);
        return this;
    }

    public Translation xh(String value) {
        translations.put(XH, value);
        return this;
    }

    public Translation zh(String value) {
        translations.put(ZH, value);
        return this;
    }

    public Translation zu(String value) {
        translations.put(ZU, value);
        return this;
    }
}
