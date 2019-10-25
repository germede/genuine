package org.fluentness.base.localization;

import org.fluentness.base.Component;

import java.util.HashMap;
import java.util.Map;

import static org.fluentness.base.localization.Language.*;

public class Translations implements Component {

    private static Language defaultLanguage;
    private static Map<String, Map<Language, String>> translationMap;

    private Map<Language, String> translations = new HashMap<>();
    private Translations next;
    private String key;

    public Translations(Language defaultLanguage) {
        Translations.defaultLanguage = defaultLanguage;
    }

    private Translations(String key) {
        this.key = key;
    }

    String translate(String key, Language language) {
        if (translationMap == null) {
            translationMap = new HashMap<>();
            Translations current = this;
            while (current.next != null) {
                translationMap.put(current.key, current.translations);
                current = current.next;
            }
        }
        Map<Language, String> languageStringMap = translationMap.get(key);
        if (languageStringMap != null) {
            return languageStringMap.getOrDefault(language, key);
        } else {
            return key;
        }
    }

    public Translations add(String key) {
        Translations next = new Translations(key);
        this.next = next;
        return next;
    }

    public Translations af(String value) {
        translations.put(AF, value);
        return this;
    }

    public Translations ar(String value) {
        translations.put(AR, value);
        return this;
    }

    public Translations az(String value) {
        translations.put(AZ, value);
        return this;
    }

    public Translations be(String value) {
        translations.put(BE, value);
        return this;
    }

    public Translations bg(String value) {
        translations.put(BG, value);
        return this;
    }

    public Translations ca(String value) {
        translations.put(CA, value);
        return this;
    }

    public Translations cs(String value) {
        translations.put(CS, value);
        return this;
    }

    public Translations cy(String value) {
        translations.put(CY, value);
        return this;
    }

    public Translations da(String value) {
        translations.put(DA, value);
        return this;
    }

    public Translations de(String value) {
        translations.put(DE, value);
        return this;
    }

    public Translations dv(String value) {
        translations.put(DV, value);
        return this;
    }

    public Translations el(String value) {
        translations.put(EL, value);
        return this;
    }

    public Translations en(String value) {
        translations.put(EN, value);
        return this;
    }

    public Translations eo(String value) {
        translations.put(EO, value);
        return this;
    }

    public Translations es(String value) {
        translations.put(ES, value);
        return this;
    }

    public Translations et(String value) {
        translations.put(ET, value);
        return this;
    }

    public Translations eu(String value) {
        translations.put(EU, value);
        return this;
    }

    public Translations fa(String value) {
        translations.put(FA, value);
        return this;
    }

    public Translations fi(String value) {
        translations.put(FI, value);
        return this;
    }

    public Translations fo(String value) {
        translations.put(FO, value);
        return this;
    }

    public Translations fr(String value) {
        translations.put(FR, value);
        return this;
    }

    public Translations gl(String value) {
        translations.put(GL, value);
        return this;
    }

    public Translations gu(String value) {
        translations.put(GU, value);
        return this;
    }

    public Translations he(String value) {
        translations.put(HE, value);
        return this;
    }

    public Translations hi(String value) {
        translations.put(HI, value);
        return this;
    }

    public Translations hr(String value) {
        translations.put(HR, value);
        return this;
    }

    public Translations hu(String value) {
        translations.put(HU, value);
        return this;
    }

    public Translations hy(String value) {
        translations.put(HY, value);
        return this;
    }

    public Translations id(String value) {
        translations.put(ID, value);
        return this;
    }

    public Translations is(String value) {
        translations.put(IS, value);
        return this;
    }

    public Translations it(String value) {
        translations.put(IT, value);
        return this;
    }

    public Translations ja(String value) {
        translations.put(JA, value);
        return this;
    }

    public Translations ka(String value) {
        translations.put(KA, value);
        return this;
    }

    public Translations kk(String value) {
        translations.put(KK, value);
        return this;
    }

    public Translations kn(String value) {
        translations.put(KN, value);
        return this;
    }

    public Translations ko(String value) {
        translations.put(KO, value);
        return this;
    }

    public Translations ky(String value) {
        translations.put(KY, value);
        return this;
    }

    public Translations lt(String value) {
        translations.put(LT, value);
        return this;
    }

    public Translations lv(String value) {
        translations.put(LV, value);
        return this;
    }

    public Translations mi(String value) {
        translations.put(MI, value);
        return this;
    }

    public Translations mk(String value) {
        translations.put(MK, value);
        return this;
    }

    public Translations mn(String value) {
        translations.put(MN, value);
        return this;
    }

    public Translations mr(String value) {
        translations.put(MR, value);
        return this;
    }

    public Translations ms(String value) {
        translations.put(MS, value);
        return this;
    }

    public Translations mt(String value) {
        translations.put(MT, value);
        return this;
    }

    public Translations nb(String value) {
        translations.put(NB, value);
        return this;
    }

    public Translations nl(String value) {
        translations.put(NL, value);
        return this;
    }

    public Translations ns(String value) {
        translations.put(NS, value);
        return this;
    }

    public Translations pa(String value) {
        translations.put(PA, value);
        return this;
    }

    public Translations pl(String value) {
        translations.put(PL, value);
        return this;
    }

    public Translations ps(String value) {
        translations.put(PS, value);
        return this;
    }

    public Translations pt(String value) {
        translations.put(PT, value);
        return this;
    }

    public Translations qu(String value) {
        translations.put(QU, value);
        return this;
    }

    public Translations ro(String value) {
        translations.put(RO, value);
        return this;
    }

    public Translations ru(String value) {
        translations.put(RU, value);
        return this;
    }

    public Translations sa(String value) {
        translations.put(SA, value);
        return this;
    }

    public Translations se(String value) {
        translations.put(SE, value);
        return this;
    }

    public Translations sk(String value) {
        translations.put(SK, value);
        return this;
    }

    public Translations sl(String value) {
        translations.put(SL, value);
        return this;
    }

    public Translations sq(String value) {
        translations.put(SQ, value);
        return this;
    }

    public Translations sv(String value) {
        translations.put(SV, value);
        return this;
    }

    public Translations sw(String value) {
        translations.put(SW, value);
        return this;
    }

    public Translations ta(String value) {
        translations.put(TA, value);
        return this;
    }

    public Translations te(String value) {
        translations.put(TE, value);
        return this;
    }

    public Translations th(String value) {
        translations.put(TH, value);
        return this;
    }

    public Translations tl(String value) {
        translations.put(TL, value);
        return this;
    }

    public Translations tn(String value) {
        translations.put(TN, value);
        return this;
    }

    public Translations tr(String value) {
        translations.put(TR, value);
        return this;
    }

    public Translations tt(String value) {
        translations.put(TT, value);
        return this;
    }

    public Translations ts(String value) {
        translations.put(TS, value);
        return this;
    }

    public Translations uk(String value) {
        translations.put(UK, value);
        return this;
    }

    public Translations ur(String value) {
        translations.put(UR, value);
        return this;
    }

    public Translations uz(String value) {
        translations.put(UZ, value);
        return this;
    }

    public Translations vi(String value) {
        translations.put(VI, value);
        return this;
    }

    public Translations xh(String value) {
        translations.put(XH, value);
        return this;
    }

    public Translations zh(String value) {
        translations.put(ZH, value);
        return this;
    }

    public Translations zu(String value) {
        translations.put(ZU, value);
        return this;
    }

}
