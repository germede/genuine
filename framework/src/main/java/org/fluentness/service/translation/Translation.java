package org.fluentness.service.translation;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Translation {

    private String defaultTranslation;
    private Map<String, String> map = new HashMap<>();

    Translation(String defaultTranslation) {
        this.defaultTranslation = defaultTranslation;
    }

    String get(Locale locale) {
        String displayLanguage = locale.getLanguage();
        return map.getOrDefault(displayLanguage, defaultTranslation);
    }

    public Translation af(String translation) {
        map.put("af", translation);
        return this;
    }

    public Translation af_ZA(String translation) {
        map.put("af_ZA", translation);
        return this;
    }

    public Translation ar(String translation) {
        map.put("ar", translation);
        return this;
    }

    public Translation ar_AE(String translation) {
        map.put("ar_AE", translation);
        return this;
    }

    public Translation ar_BH(String translation) {
        map.put("ar_BH", translation);
        return this;
    }

    public Translation ar_DZ(String translation) {
        map.put("ar_DZ", translation);
        return this;
    }

    public Translation ar_EG(String translation) {
        map.put("ar_EG", translation);
        return this;
    }

    public Translation ar_IQ(String translation) {
        map.put("ar_IQ", translation);
        return this;
    }

    public Translation ar_JO(String translation) {
        map.put("ar_JO", translation);
        return this;
    }

    public Translation ar_KW(String translation) {
        map.put("ar_KW", translation);
        return this;
    }

    public Translation ar_LB(String translation) {
        map.put("ar_LB", translation);
        return this;
    }

    public Translation ar_LY(String translation) {
        map.put("ar_LY", translation);
        return this;
    }

    public Translation ar_MA(String translation) {
        map.put("ar_MA", translation);
        return this;
    }

    public Translation ar_OM(String translation) {
        map.put("ar_OM", translation);
        return this;
    }

    public Translation ar_QA(String translation) {
        map.put("ar_QA", translation);
        return this;
    }

    public Translation ar_SA(String translation) {
        map.put("ar_SA", translation);
        return this;
    }

    public Translation ar_SY(String translation) {
        map.put("ar_SY", translation);
        return this;
    }

    public Translation ar_TN(String translation) {
        map.put("ar_TN", translation);
        return this;
    }

    public Translation ar_YE(String translation) {
        map.put("ar_YE", translation);
        return this;
    }

    public Translation az(String translation) {
        map.put("az", translation);
        return this;
    }

    public Translation az_AZ(String translation) {
        map.put("az_AZ", translation);
        return this;
    }

    public Translation be(String translation) {
        map.put("be", translation);
        return this;
    }

    public Translation be_BY(String translation) {
        map.put("be_BY", translation);
        return this;
    }

    public Translation bg(String translation) {
        map.put("bg", translation);
        return this;
    }

    public Translation bg_BG(String translation) {
        map.put("bg_BG", translation);
        return this;
    }

    public Translation bs_BA(String translation) {
        map.put("bs_BA", translation);
        return this;
    }

    public Translation ca(String translation) {
        map.put("ca", translation);
        return this;
    }

    public Translation ca_ES(String translation) {
        map.put("ca_ES", translation);
        return this;
    }

    public Translation cs(String translation) {
        map.put("cs", translation);
        return this;
    }

    public Translation cs_CZ(String translation) {
        map.put("cs_CZ", translation);
        return this;
    }

    public Translation cy(String translation) {
        map.put("cy", translation);
        return this;
    }

    public Translation cy_GB(String translation) {
        map.put("cy_GB", translation);
        return this;
    }

    public Translation da(String translation) {
        map.put("da", translation);
        return this;
    }

    public Translation da_DK(String translation) {
        map.put("da_DK", translation);
        return this;
    }

    public Translation de(String translation) {
        map.put("de", translation);
        return this;
    }

    public Translation de_AT(String translation) {
        map.put("de_AT", translation);
        return this;
    }

    public Translation de_CH(String translation) {
        map.put("de_CH", translation);
        return this;
    }

    public Translation de_DE(String translation) {
        map.put("de_DE", translation);
        return this;
    }

    public Translation de_LI(String translation) {
        map.put("de_LI", translation);
        return this;
    }

    public Translation de_LU(String translation) {
        map.put("de_LU", translation);
        return this;
    }

    public Translation dv(String translation) {
        map.put("dv", translation);
        return this;
    }

    public Translation dv_MV(String translation) {
        map.put("dv_MV", translation);
        return this;
    }

    public Translation el(String translation) {
        map.put("el", translation);
        return this;
    }

    public Translation el_GR(String translation) {
        map.put("el_GR", translation);
        return this;
    }

    public Translation en(String translation) {
        map.put("en", translation);
        return this;
    }

    public Translation en_AU(String translation) {
        map.put("en_AU", translation);
        return this;
    }

    public Translation en_BZ(String translation) {
        map.put("en_BZ", translation);
        return this;
    }

    public Translation en_CA(String translation) {
        map.put("en_CA", translation);
        return this;
    }

    public Translation en_CB(String translation) {
        map.put("en_CB", translation);
        return this;
    }

    public Translation en_GB(String translation) {
        map.put("en_GB", translation);
        return this;
    }

    public Translation en_IE(String translation) {
        map.put("en_IE", translation);
        return this;
    }

    public Translation en_JM(String translation) {
        map.put("en_JM", translation);
        return this;
    }

    public Translation en_NZ(String translation) {
        map.put("en_NZ", translation);
        return this;
    }

    public Translation en_PH(String translation) {
        map.put("en_PH", translation);
        return this;
    }

    public Translation en_TT(String translation) {
        map.put("en_TT", translation);
        return this;
    }

    public Translation en_US(String translation) {
        map.put("en_US", translation);
        return this;
    }

    public Translation en_ZA(String translation) {
        map.put("en_ZA", translation);
        return this;
    }

    public Translation en_ZW(String translation) {
        map.put("en_ZW", translation);
        return this;
    }

    public Translation eo(String translation) {
        map.put("eo", translation);
        return this;
    }

    public Translation es(String translation) {
        map.put("es", translation);
        return this;
    }

    public Translation es_AR(String translation) {
        map.put("es_AR", translation);
        return this;
    }

    public Translation es_BO(String translation) {
        map.put("es_BO", translation);
        return this;
    }

    public Translation es_CL(String translation) {
        map.put("es_CL", translation);
        return this;
    }

    public Translation es_CO(String translation) {
        map.put("es_CO", translation);
        return this;
    }

    public Translation es_CR(String translation) {
        map.put("es_CR", translation);
        return this;
    }

    public Translation es_DO(String translation) {
        map.put("es_DO", translation);
        return this;
    }

    public Translation es_EC(String translation) {
        map.put("es_EC", translation);
        return this;
    }

    public Translation es_ES(String translation) {
        map.put("es_ES", translation);
        return this;
    }

    public Translation es_GT(String translation) {
        map.put("es_GT", translation);
        return this;
    }

    public Translation es_HN(String translation) {
        map.put("es_HN", translation);
        return this;
    }

    public Translation es_MX(String translation) {
        map.put("es_MX", translation);
        return this;
    }

    public Translation es_NI(String translation) {
        map.put("es_NI", translation);
        return this;
    }

    public Translation es_PA(String translation) {
        map.put("es_PA", translation);
        return this;
    }

    public Translation es_PE(String translation) {
        map.put("es_PE", translation);
        return this;
    }

    public Translation es_PR(String translation) {
        map.put("es_PR", translation);
        return this;
    }

    public Translation es_PY(String translation) {
        map.put("es_PY", translation);
        return this;
    }

    public Translation es_SV(String translation) {
        map.put("es_SV", translation);
        return this;
    }

    public Translation es_UY(String translation) {
        map.put("es_UY", translation);
        return this;
    }

    public Translation es_VE(String translation) {
        map.put("es_VE", translation);
        return this;
    }

    public Translation et(String translation) {
        map.put("et", translation);
        return this;
    }

    public Translation et_EE(String translation) {
        map.put("et_EE", translation);
        return this;
    }

    public Translation eu(String translation) {
        map.put("eu", translation);
        return this;
    }

    public Translation eu_ES(String translation) {
        map.put("eu_ES", translation);
        return this;
    }

    public Translation fa(String translation) {
        map.put("fa", translation);
        return this;
    }

    public Translation fa_IR(String translation) {
        map.put("fa_IR", translation);
        return this;
    }

    public Translation fi(String translation) {
        map.put("fi", translation);
        return this;
    }

    public Translation fi_FI(String translation) {
        map.put("fi_FI", translation);
        return this;
    }

    public Translation fo(String translation) {
        map.put("fo", translation);
        return this;
    }

    public Translation fo_FO(String translation) {
        map.put("fo_FO", translation);
        return this;
    }

    public Translation fr(String translation) {
        map.put("fr", translation);
        return this;
    }

    public Translation fr_BE(String translation) {
        map.put("fr_BE", translation);
        return this;
    }

    public Translation fr_CA(String translation) {
        map.put("fr_CA", translation);
        return this;
    }

    public Translation fr_CH(String translation) {
        map.put("fr_CH", translation);
        return this;
    }

    public Translation fr_FR(String translation) {
        map.put("fr_FR", translation);
        return this;
    }

    public Translation fr_LU(String translation) {
        map.put("fr_LU", translation);
        return this;
    }

    public Translation fr_MC(String translation) {
        map.put("fr_MC", translation);
        return this;
    }

    public Translation gl(String translation) {
        map.put("gl", translation);
        return this;
    }

    public Translation gl_ES(String translation) {
        map.put("gl_ES", translation);
        return this;
    }

    public Translation gu(String translation) {
        map.put("gu", translation);
        return this;
    }

    public Translation gu_IN(String translation) {
        map.put("gu_IN", translation);
        return this;
    }

    public Translation he(String translation) {
        map.put("he", translation);
        return this;
    }

    public Translation he_IL(String translation) {
        map.put("he_IL", translation);
        return this;
    }

    public Translation hi(String translation) {
        map.put("hi", translation);
        return this;
    }

    public Translation hi_IN(String translation) {
        map.put("hi_IN", translation);
        return this;
    }

    public Translation hr(String translation) {
        map.put("hr", translation);
        return this;
    }

    public Translation hr_BA(String translation) {
        map.put("hr_BA", translation);
        return this;
    }

    public Translation hr_HR(String translation) {
        map.put("hr_HR", translation);
        return this;
    }

    public Translation hu(String translation) {
        map.put("hu", translation);
        return this;
    }

    public Translation hu_HU(String translation) {
        map.put("hu_HU", translation);
        return this;
    }

    public Translation hy(String translation) {
        map.put("hy", translation);
        return this;
    }

    public Translation hy_AM(String translation) {
        map.put("hy_AM", translation);
        return this;
    }

    public Translation id(String translation) {
        map.put("id", translation);
        return this;
    }

    public Translation id_ID(String translation) {
        map.put("id_ID", translation);
        return this;
    }

    public Translation is(String translation) {
        map.put("is", translation);
        return this;
    }

    public Translation is_IS(String translation) {
        map.put("is_IS", translation);
        return this;
    }

    public Translation it(String translation) {
        map.put("it", translation);
        return this;
    }

    public Translation it_CH(String translation) {
        map.put("it_CH", translation);
        return this;
    }

    public Translation it_IT(String translation) {
        map.put("it_IT", translation);
        return this;
    }

    public Translation ja(String translation) {
        map.put("ja", translation);
        return this;
    }

    public Translation ja_JP(String translation) {
        map.put("ja_JP", translation);
        return this;
    }

    public Translation ka(String translation) {
        map.put("ka", translation);
        return this;
    }

    public Translation ka_GE(String translation) {
        map.put("ka_GE", translation);
        return this;
    }

    public Translation kk(String translation) {
        map.put("kk", translation);
        return this;
    }

    public Translation kk_KZ(String translation) {
        map.put("kk_KZ", translation);
        return this;
    }

    public Translation kn(String translation) {
        map.put("kn", translation);
        return this;
    }

    public Translation kn_IN(String translation) {
        map.put("kn_IN", translation);
        return this;
    }

    public Translation ko(String translation) {
        map.put("ko", translation);
        return this;
    }

    public Translation ko_KR(String translation) {
        map.put("ko_KR", translation);
        return this;
    }

    public Translation kok(String translation) {
        map.put("kok", translation);
        return this;
    }

    public Translation kok_IN(String translation) {
        map.put("kok_IN", translation);
        return this;
    }

    public Translation ky(String translation) {
        map.put("ky", translation);
        return this;
    }

    public Translation ky_KG(String translation) {
        map.put("ky_KG", translation);
        return this;
    }

    public Translation lt(String translation) {
        map.put("lt", translation);
        return this;
    }

    public Translation lt_LT(String translation) {
        map.put("lt_LT", translation);
        return this;
    }

    public Translation lv(String translation) {
        map.put("lv", translation);
        return this;
    }

    public Translation lv_LV(String translation) {
        map.put("lv_LV", translation);
        return this;
    }

    public Translation mi(String translation) {
        map.put("mi", translation);
        return this;
    }

    public Translation mi_NZ(String translation) {
        map.put("mi_NZ", translation);
        return this;
    }

    public Translation mk(String translation) {
        map.put("mk", translation);
        return this;
    }

    public Translation mk_MK(String translation) {
        map.put("mk_MK", translation);
        return this;
    }

    public Translation mn(String translation) {
        map.put("mn", translation);
        return this;
    }

    public Translation mn_MN(String translation) {
        map.put("mn_MN", translation);
        return this;
    }

    public Translation mr(String translation) {
        map.put("mr", translation);
        return this;
    }

    public Translation mr_IN(String translation) {
        map.put("mr_IN", translation);
        return this;
    }

    public Translation ms(String translation) {
        map.put("ms", translation);
        return this;
    }

    public Translation ms_BN(String translation) {
        map.put("ms_BN", translation);
        return this;
    }

    public Translation ms_MY(String translation) {
        map.put("ms_MY", translation);
        return this;
    }

    public Translation mt(String translation) {
        map.put("mt", translation);
        return this;
    }

    public Translation mt_MT(String translation) {
        map.put("mt_MT", translation);
        return this;
    }

    public Translation nb(String translation) {
        map.put("nb", translation);
        return this;
    }

    public Translation nb_NO(String translation) {
        map.put("nb_NO", translation);
        return this;
    }

    public Translation nl(String translation) {
        map.put("nl", translation);
        return this;
    }

    public Translation nl_BE(String translation) {
        map.put("nl_BE", translation);
        return this;
    }

    public Translation nl_NL(String translation) {
        map.put("nl_NL", translation);
        return this;
    }

    public Translation nn_NO(String translation) {
        map.put("nn_NO", translation);
        return this;
    }

    public Translation ns(String translation) {
        map.put("ns", translation);
        return this;
    }

    public Translation ns_ZA(String translation) {
        map.put("ns_ZA", translation);
        return this;
    }

    public Translation pa(String translation) {
        map.put("pa", translation);
        return this;
    }

    public Translation pa_IN(String translation) {
        map.put("pa_IN", translation);
        return this;
    }

    public Translation pl(String translation) {
        map.put("pl", translation);
        return this;
    }

    public Translation pl_PL(String translation) {
        map.put("pl_PL", translation);
        return this;
    }

    public Translation ps(String translation) {
        map.put("ps", translation);
        return this;
    }

    public Translation ps_AR(String translation) {
        map.put("ps_AR", translation);
        return this;
    }

    public Translation pt(String translation) {
        map.put("pt", translation);
        return this;
    }

    public Translation pt_BR(String translation) {
        map.put("pt_BR", translation);
        return this;
    }

    public Translation pt_PT(String translation) {
        map.put("pt_PT", translation);
        return this;
    }

    public Translation qu(String translation) {
        map.put("qu", translation);
        return this;
    }

    public Translation qu_BO(String translation) {
        map.put("qu_BO", translation);
        return this;
    }

    public Translation qu_EC(String translation) {
        map.put("qu_EC", translation);
        return this;
    }

    public Translation qu_PE(String translation) {
        map.put("qu_PE", translation);
        return this;
    }

    public Translation ro(String translation) {
        map.put("ro", translation);
        return this;
    }

    public Translation ro_RO(String translation) {
        map.put("ro_RO", translation);
        return this;
    }

    public Translation ru(String translation) {
        map.put("ru", translation);
        return this;
    }

    public Translation ru_RU(String translation) {
        map.put("ru_RU", translation);
        return this;
    }

    public Translation sa(String translation) {
        map.put("sa", translation);
        return this;
    }

    public Translation sa_IN(String translation) {
        map.put("sa_IN", translation);
        return this;
    }

    public Translation se(String translation) {
        map.put("se", translation);
        return this;
    }

    public Translation se_FI(String translation) {
        map.put("se_FI", translation);
        return this;
    }

    public Translation se_NO(String translation) {
        map.put("se_NO", translation);
        return this;
    }

    public Translation se_SE(String translation) {
        map.put("se_SE", translation);
        return this;
    }

    public Translation sk(String translation) {
        map.put("sk", translation);
        return this;
    }

    public Translation sk_SK(String translation) {
        map.put("sk_SK", translation);
        return this;
    }

    public Translation sl(String translation) {
        map.put("sl", translation);
        return this;
    }

    public Translation sl_SI(String translation) {
        map.put("sl_SI", translation);
        return this;
    }

    public Translation sq(String translation) {
        map.put("sq", translation);
        return this;
    }

    public Translation sq_AL(String translation) {
        map.put("sq_AL", translation);
        return this;
    }

    public Translation sr_BA(String translation) {
        map.put("sr_BA", translation);
        return this;
    }

    public Translation sr_SP(String translation) {
        map.put("sr_SP", translation);
        return this;
    }

    public Translation sv(String translation) {
        map.put("sv", translation);
        return this;
    }

    public Translation sv_FI(String translation) {
        map.put("sv_FI", translation);
        return this;
    }

    public Translation sv_SE(String translation) {
        map.put("sv_SE", translation);
        return this;
    }

    public Translation sw(String translation) {
        map.put("sw", translation);
        return this;
    }

    public Translation sw_KE(String translation) {
        map.put("sw_KE", translation);
        return this;
    }

    public Translation syr(String translation) {
        map.put("syr", translation);
        return this;
    }

    public Translation syr_SY(String translation) {
        map.put("syr_SY", translation);
        return this;
    }

    public Translation ta(String translation) {
        map.put("ta", translation);
        return this;
    }

    public Translation ta_IN(String translation) {
        map.put("ta_IN", translation);
        return this;
    }

    public Translation te(String translation) {
        map.put("te", translation);
        return this;
    }

    public Translation te_IN(String translation) {
        map.put("te_IN", translation);
        return this;
    }

    public Translation th(String translation) {
        map.put("th", translation);
        return this;
    }

    public Translation th_TH(String translation) {
        map.put("th_TH", translation);
        return this;
    }

    public Translation tl(String translation) {
        map.put("tl", translation);
        return this;
    }

    public Translation tl_PH(String translation) {
        map.put("tl_PH", translation);
        return this;
    }

    public Translation tn(String translation) {
        map.put("tn", translation);
        return this;
    }

    public Translation tn_ZA(String translation) {
        map.put("tn_ZA", translation);
        return this;
    }

    public Translation tr(String translation) {
        map.put("tr", translation);
        return this;
    }

    public Translation tr_TR(String translation) {
        map.put("tr_TR", translation);
        return this;
    }

    public Translation tt(String translation) {
        map.put("tt", translation);
        return this;
    }

    public Translation tt_RU(String translation) {
        map.put("tt_RU", translation);
        return this;
    }

    public Translation ts(String translation) {
        map.put("ts", translation);
        return this;
    }

    public Translation uk(String translation) {
        map.put("uk", translation);
        return this;
    }

    public Translation uk_UA(String translation) {
        map.put("uk_UA", translation);
        return this;
    }

    public Translation ur(String translation) {
        map.put("ur", translation);
        return this;
    }

    public Translation ur_PK(String translation) {
        map.put("ur_PK", translation);
        return this;
    }

    public Translation uz(String translation) {
        map.put("uz", translation);
        return this;
    }

    public Translation uz_UZ(String translation) {
        map.put("uz_UZ", translation);
        return this;
    }

    public Translation vi(String translation) {
        map.put("vi", translation);
        return this;
    }

    public Translation vi_VN(String translation) {
        map.put("vi_VN", translation);
        return this;
    }

    public Translation xh(String translation) {
        map.put("xh", translation);
        return this;
    }

    public Translation xh_ZA(String translation) {
        map.put("xh_ZA", translation);
        return this;
    }

    public Translation zh(String translation) {
        map.put("zh", translation);
        return this;
    }

    public Translation zh_CN(String translation) {
        map.put("zh_CN", translation);
        return this;
    }

    public Translation zh_HK(String translation) {
        map.put("zh_HK", translation);
        return this;
    }

    public Translation zh_MO(String translation) {
        map.put("zh_MO", translation);
        return this;
    }

    public Translation zh_SG(String translation) {
        map.put("zh_SG", translation);
        return this;
    }

    public Translation zh_TW(String translation) {
        map.put("zh_TW", translation);
        return this;
    }

    public Translation zu(String translation) {
        map.put("zu", translation);
        return this;
    }

    public Translation zu_ZA(String translation) {
        map.put("zu_ZA", translation);
        return this;
    }

}
