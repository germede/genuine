package org.fluentness.service.localization;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Translation implements CharSequence {

    private static final String DEFAULT = "default";

    private Map<String, String> translations = new HashMap<>();

    Translation(String defaultTranslation) {
        translations.put(DEFAULT, defaultTranslation);
    }

    @Override
    public int length() {
        return toString().length();
    }

    @Override
    public char charAt(int index) {
        return toString().charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return toString().subSequence(start, end);
    }

    @Override
    public String toString() {
        return translations.getOrDefault(Locale.getDefault().getLanguage(), translations.get(DEFAULT));
    }

    private Translation add(String language, String translation) {
        translations.put(language,translation);
        return this;
    }

    public Translation af(String translation) {
        return add("af", translation);
    }

    public Translation af_za(String translation) {
        return add("af_ZA", translation);
    }

    public Translation ar(String translation) {
        return add("ar", translation);
    }

    public Translation ar_ae(String translation) {
        return add("ar_AE", translation);
    }

    public Translation ar_bh(String translation) {
        return add("ar_BH", translation);
    }

    public Translation ar_dz(String translation) {
        return add("ar_DZ", translation);
    }

    public Translation ar_eg(String translation) {
        return add("ar_EG", translation);
    }

    public Translation ar_iq(String translation) {
        return add("ar_IQ", translation);
    }

    public Translation ar_jo(String translation) {
        return add("ar_JO", translation);
    }

    public Translation ar_kw(String translation) {
        return add("ar_KW", translation);
    }

    public Translation ar_lb(String translation) {
        return add("ar_LB", translation);
    }

    public Translation ar_ly(String translation) {
        return add("ar_LY", translation);
    }

    public Translation ar_ma(String translation) {
        return add("ar_MA", translation);
    }

    public Translation ar_om(String translation) {
        return add("ar_OM", translation);
    }

    public Translation ar_qa(String translation) {
        return add("ar_QA", translation);
    }

    public Translation ar_sa(String translation) {
        return add("ar_SA", translation);
    }

    public Translation ar_sy(String translation) {
        return add("ar_SY", translation);
    }

    public Translation ar_tn(String translation) {
        return add("ar_TN", translation);
    }

    public Translation ar_ye(String translation) {
        return add("ar_YE", translation);
    }

    public Translation az(String translation) {
        return add("az", translation);
    }

    public Translation az_az(String translation) {
        return add("az_AZ", translation);
    }

    public Translation be(String translation) {
        return add("be", translation);
    }

    public Translation be_by(String translation) {
        return add("be_BY", translation);
    }

    public Translation bg(String translation) {
        return add("bg", translation);
    }

    public Translation bg_bg(String translation) {
        return add("bg_BG", translation);
    }

    public Translation bs_ba(String translation) {
        return add("bs_BA", translation);
    }

    public Translation ca(String translation) {
        return add("ca", translation);
    }

    public Translation ca_es(String translation) {
        return add("ca_ES", translation);
    }

    public Translation cs(String translation) {
        return add("cs", translation);
    }

    public Translation cs_cz(String translation) {
        return add("cs_CZ", translation);
    }

    public Translation cy(String translation) {
        return add("cy", translation);
    }

    public Translation cy_gb(String translation) {
        return add("cy_GB", translation);
    }

    public Translation da(String translation) {
        return add("da", translation);
    }

    public Translation da_dk(String translation) {
        return add("da_DK", translation);
    }

    public Translation de(String translation) {
        return add("de", translation);
    }

    public Translation de_at(String translation) {
        return add("de_AT", translation);
    }

    public Translation de_ch(String translation) {
        return add("de_CH", translation);
    }

    public Translation de_de(String translation) {
        return add("de_DE", translation);
    }

    public Translation de_li(String translation) {
        return add("de_LI", translation);
    }

    public Translation de_lu(String translation) {
        return add("de_LU", translation);
    }

    public Translation dv(String translation) {
        return add("dv", translation);
    }

    public Translation dv_mv(String translation) {
        return add("dv_MV", translation);
    }

    public Translation el(String translation) {
        return add("el", translation);
    }

    public Translation el_gr(String translation) {
        return add("el_GR", translation);
    }

    public Translation en(String translation) {
        return add("en", translation);
    }

    public Translation en_au(String translation) {
        return add("en_AU", translation);
    }

    public Translation en_bz(String translation) {
        return add("en_BZ", translation);
    }

    public Translation en_ca(String translation) {
        return add("en_CA", translation);
    }

    public Translation en_cb(String translation) {
        return add("en_CB", translation);
    }

    public Translation en_gb(String translation) {
        return add("en_GB", translation);
    }

    public Translation en_ie(String translation) {
        return add("en_IE", translation);
    }

    public Translation en_jm(String translation) {
        return add("en_JM", translation);
    }

    public Translation en_nz(String translation) {
        return add("en_NZ", translation);
    }

    public Translation en_ph(String translation) {
        return add("en_PH", translation);
    }

    public Translation en_tt(String translation) {
        return add("en_TT", translation);
    }

    public Translation en_us(String translation) {
        return add("en_US", translation);
    }

    public Translation en_za(String translation) {
        return add("en_ZA", translation);
    }

    public Translation en_zw(String translation) {
        return add("en_ZW", translation);
    }

    public Translation eo(String translation) {
        return add("eo", translation);
    }

    public Translation es(String translation) {
        return add("es", translation);
    }

    public Translation es_ar(String translation) {
        return add("es_AR", translation);
    }

    public Translation es_bo(String translation) {
        return add("es_BO", translation);
    }

    public Translation es_cl(String translation) {
        return add("es_CL", translation);
    }

    public Translation es_co(String translation) {
        return add("es_CO", translation);
    }

    public Translation es_cr(String translation) {
        return add("es_CR", translation);
    }

    public Translation es_do(String translation) {
        return add("es_DO", translation);
    }

    public Translation es_ec(String translation) {
        return add("es_EC", translation);
    }

    public Translation es_es(String translation) {
        return add("es_ES", translation);
    }

    public Translation es_gt(String translation) {
        return add("es_GT", translation);
    }

    public Translation es_hn(String translation) {
        return add("es_HN", translation);
    }

    public Translation es_mx(String translation) {
        return add("es_MX", translation);
    }

    public Translation es_ni(String translation) {
        return add("es_NI", translation);
    }

    public Translation es_pa(String translation) {
        return add("es_PA", translation);
    }

    public Translation es_pe(String translation) {
        return add("es_PE", translation);
    }

    public Translation es_pr(String translation) {
        return add("es_PR", translation);
    }

    public Translation es_py(String translation) {
        return add("es_PY", translation);
    }

    public Translation es_sv(String translation) {
        return add("es_SV", translation);
    }

    public Translation es_uy(String translation) {
        return add("es_UY", translation);
    }

    public Translation es_ve(String translation) {
        return add("es_VE", translation);
    }

    public Translation et(String translation) {
        return add("et", translation);
    }

    public Translation et_ee(String translation) {
        return add("et_EE", translation);
    }

    public Translation eu(String translation) {
        return add("eu", translation);
    }

    public Translation eu_es(String translation) {
        return add("eu_ES", translation);
    }

    public Translation fa(String translation) {
        return add("fa", translation);
    }

    public Translation fa_ir(String translation) {
        return add("fa_IR", translation);
    }

    public Translation fi(String translation) {
        return add("fi", translation);
    }

    public Translation fi_fi(String translation) {
        return add("fi_FI", translation);
    }

    public Translation fo(String translation) {
        return add("fo", translation);
    }

    public Translation fo_fo(String translation) {
        return add("fo_FO", translation);
    }

    public Translation fr(String translation) {
        return add("fr", translation);
    }

    public Translation fr_be(String translation) {
        return add("fr_BE", translation);
    }

    public Translation fr_ca(String translation) {
        return add("fr_CA", translation);
    }

    public Translation fr_ch(String translation) {
        return add("fr_CH", translation);
    }

    public Translation fr_fr(String translation) {
        return add("fr_FR", translation);
    }

    public Translation fr_lu(String translation) {
        return add("fr_LU", translation);
    }

    public Translation fr_mc(String translation) {
        return add("fr_MC", translation);
    }

    public Translation gl(String translation) {
        return add("gl", translation);
    }

    public Translation gl_es(String translation) {
        return add("gl_ES", translation);
    }

    public Translation gu(String translation) {
        return add("gu", translation);
    }

    public Translation gu_in(String translation) {
        return add("gu_IN", translation);
    }

    public Translation he(String translation) {
        return add("he", translation);
    }

    public Translation he_il(String translation) {
        return add("he_IL", translation);
    }

    public Translation hi(String translation) {
        return add("hi", translation);
    }

    public Translation hi_in(String translation) {
        return add("hi_IN", translation);
    }

    public Translation hr(String translation) {
        return add("hr", translation);
    }

    public Translation hr_ba(String translation) {
        return add("hr_BA", translation);
    }

    public Translation hr_hr(String translation) {
        return add("hr_HR", translation);
    }

    public Translation hu(String translation) {
        return add("hu", translation);
    }

    public Translation hu_hu(String translation) {
        return add("hu_HU", translation);
    }

    public Translation hy(String translation) {
        return add("hy", translation);
    }

    public Translation hy_am(String translation) {
        return add("hy_AM", translation);
    }

    public Translation id(String translation) {
        return add("id", translation);
    }

    public Translation id_id(String translation) {
        return add("id_ID", translation);
    }

    public Translation is(String translation) {
        return add("is", translation);
    }

    public Translation is_is(String translation) {
        return add("is_IS", translation);
    }

    public Translation it(String translation) {
        return add("it", translation);
    }

    public Translation it_ch(String translation) {
        return add("it_CH", translation);
    }

    public Translation it_it(String translation) {
        return add("it_IT", translation);
    }

    public Translation ja(String translation) {
        return add("ja", translation);
    }

    public Translation ja_jp(String translation) {
        return add("ja_JP", translation);
    }

    public Translation ka(String translation) {
        return add("ka", translation);
    }

    public Translation ka_ge(String translation) {
        return add("ka_GE", translation);
    }

    public Translation kk(String translation) {
        return add("kk", translation);
    }

    public Translation kk_kz(String translation) {
        return add("kk_KZ", translation);
    }

    public Translation kn(String translation) {
        return add("kn", translation);
    }

    public Translation kn_in(String translation) {
        return add("kn_IN", translation);
    }

    public Translation ko(String translation) {
        return add("ko", translation);
    }

    public Translation ko_kr(String translation) {
        return add("ko_KR", translation);
    }

    public Translation kok(String translation) {
        return add("koK", translation);
    }

    public Translation kok_in(String translation) {
        return add("koK_IN", translation);
    }

    public Translation ky(String translation) {
        return add("ky", translation);
    }

    public Translation ky_kg(String translation) {
        return add("ky_KG", translation);
    }

    public Translation lt(String translation) {
        return add("lt", translation);
    }

    public Translation lt_lt(String translation) {
        return add("lt_LT", translation);
    }

    public Translation lv(String translation) {
        return add("lv", translation);
    }

    public Translation lv_lv(String translation) {
        return add("lv_LV", translation);
    }

    public Translation mi(String translation) {
        return add("mi", translation);
    }

    public Translation mi_nz(String translation) {
        return add("mi_NZ", translation);
    }

    public Translation mk(String translation) {
        return add("mk", translation);
    }

    public Translation mk_mk(String translation) {
        return add("mk_MK", translation);
    }

    public Translation mn(String translation) {
        return add("mn", translation);
    }

    public Translation mn_mn(String translation) {
        return add("mn_MN", translation);
    }

    public Translation mr(String translation) {
        return add("mr", translation);
    }

    public Translation mr_in(String translation) {
        return add("mr_IN", translation);
    }

    public Translation ms(String translation) {
        return add("ms", translation);
    }

    public Translation ms_bn(String translation) {
        return add("ms_BN", translation);
    }

    public Translation ms_my(String translation) {
        return add("ms_MY", translation);
    }

    public Translation mt(String translation) {
        return add("mt", translation);
    }

    public Translation mt_mt(String translation) {
        return add("mt_MT", translation);
    }

    public Translation nb(String translation) {
        return add("nb", translation);
    }

    public Translation nb_no(String translation) {
        return add("nb_NO", translation);
    }

    public Translation nl(String translation) {
        return add("nl", translation);
    }

    public Translation nl_be(String translation) {
        return add("nl_BE", translation);
    }

    public Translation nl_nl(String translation) {
        return add("nl_NL", translation);
    }

    public Translation nn_no(String translation) {
        return add("nn_NO", translation);
    }

    public Translation ns(String translation) {
        return add("ns", translation);
    }

    public Translation ns_za(String translation) {
        return add("ns_ZA", translation);
    }

    public Translation pa(String translation) {
        return add("pa", translation);
    }

    public Translation pa_in(String translation) {
        return add("pa_IN", translation);
    }

    public Translation pl(String translation) {
        return add("pl", translation);
    }

    public Translation pl_pl(String translation) {
        return add("pl_PL", translation);
    }

    public Translation ps(String translation) {
        return add("ps", translation);
    }

    public Translation ps_ar(String translation) {
        return add("ps_AR", translation);
    }

    public Translation pt(String translation) {
        return add("pt", translation);
    }

    public Translation pt_br(String translation) {
        return add("pt_BR", translation);
    }

    public Translation pt_pt(String translation) {
        return add("pt_PT", translation);
    }

    public Translation qu(String translation) {
        return add("qu", translation);
    }

    public Translation qu_bo(String translation) {
        return add("qu_BO", translation);
    }

    public Translation qu_ec(String translation) {
        return add("qu_EC", translation);
    }

    public Translation qu_pe(String translation) {
        return add("qu_PE", translation);
    }

    public Translation ro(String translation) {
        return add("ro", translation);
    }

    public Translation ro_ro(String translation) {
        return add("ro_RO", translation);
    }

    public Translation ru(String translation) {
        return add("ru", translation);
    }

    public Translation ru_ru(String translation) {
        return add("ru_RU", translation);
    }

    public Translation sa(String translation) {
        return add("sa", translation);
    }

    public Translation sa_in(String translation) {
        return add("sa_IN", translation);
    }

    public Translation se(String translation) {
        return add("se", translation);
    }

    public Translation se_fi(String translation) {
        return add("se_FI", translation);
    }

    public Translation se_no(String translation) {
        return add("se_NO", translation);
    }

    public Translation se_se(String translation) {
        return add("se_SE", translation);
    }

    public Translation sk(String translation) {
        return add("sk", translation);
    }

    public Translation sk_sk(String translation) {
        return add("sk_SK", translation);
    }

    public Translation sl(String translation) {
        return add("sl", translation);
    }

    public Translation sl_si(String translation) {
        return add("sl_SI", translation);
    }

    public Translation sq(String translation) {
        return add("sq", translation);
    }

    public Translation sq_al(String translation) {
        return add("sq_AL", translation);
    }

    public Translation sr_ba(String translation) {
        return add("sr_BA", translation);
    }

    public Translation sr_sp(String translation) {
        return add("sr_SP", translation);
    }

    public Translation sv(String translation) {
        return add("sv", translation);
    }

    public Translation sv_fi(String translation) {
        return add("sv_FI", translation);
    }

    public Translation sv_se(String translation) {
        return add("sv_SE", translation);
    }

    public Translation sw(String translation) {
        return add("sw", translation);
    }

    public Translation sw_ke(String translation) {
        return add("sw_KE", translation);
    }

    public Translation syr(String translation) {
        return add("syR", translation);
    }

    public Translation syr_sy(String translation) {
        return add("syR_SY", translation);
    }

    public Translation ta(String translation) {
        return add("ta", translation);
    }

    public Translation ta_in(String translation) {
        return add("ta_IN", translation);
    }

    public Translation te(String translation) {
        return add("te", translation);
    }

    public Translation te_in(String translation) {
        return add("te_IN", translation);
    }

    public Translation th(String translation) {
        return add("th", translation);
    }

    public Translation th_th(String translation) {
        return add("th_TH", translation);
    }

    public Translation tl(String translation) {
        return add("tl", translation);
    }

    public Translation tl_ph(String translation) {
        return add("tl_PH", translation);
    }

    public Translation tn(String translation) {
        return add("tn", translation);
    }

    public Translation tn_za(String translation) {
        return add("tn_ZA", translation);
    }

    public Translation tr(String translation) {
        return add("tr", translation);
    }

    public Translation tr_tr(String translation) {
        return add("tr_TR", translation);
    }

    public Translation tt(String translation) {
        return add("tt", translation);
    }

    public Translation tt_ru(String translation) {
        return add("tt_RU", translation);
    }

    public Translation ts(String translation) {
        return add("ts", translation);
    }

    public Translation uk(String translation) {
        return add("uk", translation);
    }

    public Translation uk_ua(String translation) {
        return add("uk_UA", translation);
    }

    public Translation ur(String translation) {
        return add("ur", translation);
    }

    public Translation ur_pk(String translation) {
        return add("ur_PK", translation);
    }

    public Translation uz(String translation) {
        return add("uz", translation);
    }

    public Translation uz_uz(String translation) {
        return add("uz_UZ", translation);
    }

    public Translation vi(String translation) {
        return add("vi", translation);
    }

    public Translation vi_vn(String translation) {
        return add("vi_VN", translation);
    }

    public Translation xh(String translation) {
        return add("xh", translation);
    }

    public Translation xh_za(String translation) {
        return add("xh_ZA", translation);
    }

    public Translation zh(String translation) {
        return add("zh", translation);
    }

    public Translation zh_cn(String translation) {
        return add("zh_CN", translation);
    }

    public Translation zh_hk(String translation) {
        return add("zh_HK", translation);
    }

    public Translation zh_mo(String translation) {
        return add("zh_MO", translation);
    }

    public Translation zh_sg(String translation) {
        return add("zh_SG", translation);
    }

    public Translation zh_tw(String translation) {
        return add("zh_TW", translation);
    }

    public Translation zu(String translation) {
        return add("zu", translation);
    }

    public Translation zu_za(String translation) {
        return add("zu_ZA", translation);
    }
}
