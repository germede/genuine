package org.fluentness.service.localization;

import java.util.AbstractMap;
import java.util.Map;

public abstract class BaseLocalization implements Localization {

    // todo maybe another way of declaring translations
    public static final Translation
        _submit = msg("Submit", de("Absenden"), es("Enviar")),
        _search = msg("Search", de("Suchen"), es("Buscar")),
        _switch = msg("Switch", de("Umschalten"), es("Alternar")),
        _accept = msg("Accept", de("Akzeptieren"), es("Aceptar")),
        _cancel = msg("Cancel", de("Abbrechen"), es("Cancelar")),
        _select = msg("Select", de("Auswählen"), es("Seleccionar")),
        _create = msg("Create", de("Erstellen"), es("Crear")),
        _update = msg("Update", de("Editieren"), es("Editar")),
        _delete = msg("Delete", de("Entfernen"), es("Eliminar")),
        _dark_mode = msg("Dark mode", de("Dunkelmodus"), es("Modo oscuro")),
        _previous = msg("Previous", de("Vorheriger"), es("Anterior")),
        _next = msg("Next", de("Nächster"), es("Siguiente"));

    protected static Translation msg(String defaultTranslation, Map.Entry<String, String>... translations) {
        return new Translation(defaultTranslation, translations);
    }

    private static Map.Entry<String, String> mapEntry(String language, String translation) {
        return new AbstractMap.SimpleImmutableEntry<>(language, translation);
    }

    protected static Map.Entry<String, String> af(String translation) {
        return mapEntry("af", translation);
    }

    protected static Map.Entry<String, String> af_za(String translation) {
        return mapEntry("af_ZA", translation);
    }

    protected static Map.Entry<String, String> ar(String translation) {
        return mapEntry("ar", translation);
    }

    protected static Map.Entry<String, String> ar_ae(String translation) {
        return mapEntry("ar_AE", translation);
    }

    protected static Map.Entry<String, String> ar_bh(String translation) {
        return mapEntry("ar_BH", translation);
    }

    protected static Map.Entry<String, String> ar_dz(String translation) {
        return mapEntry("ar_DZ", translation);
    }

    protected static Map.Entry<String, String> ar_eg(String translation) {
        return mapEntry("ar_EG", translation);
    }

    protected static Map.Entry<String, String> ar_iq(String translation) {
        return mapEntry("ar_IQ", translation);
    }

    protected static Map.Entry<String, String> ar_jo(String translation) {
        return mapEntry("ar_JO", translation);
    }

    protected static Map.Entry<String, String> ar_kw(String translation) {
        return mapEntry("ar_KW", translation);
    }

    protected static Map.Entry<String, String> ar_lb(String translation) {
        return mapEntry("ar_LB", translation);
    }

    protected static Map.Entry<String, String> ar_ly(String translation) {
        return mapEntry("ar_LY", translation);
    }

    protected static Map.Entry<String, String> ar_ma(String translation) {
        return mapEntry("ar_MA", translation);
    }

    protected static Map.Entry<String, String> ar_om(String translation) {
        return mapEntry("ar_OM", translation);
    }

    protected static Map.Entry<String, String> ar_qa(String translation) {
        return mapEntry("ar_QA", translation);
    }

    protected static Map.Entry<String, String> ar_sa(String translation) {
        return mapEntry("ar_SA", translation);
    }

    protected static Map.Entry<String, String> ar_sy(String translation) {
        return mapEntry("ar_SY", translation);
    }

    protected static Map.Entry<String, String> ar_tn(String translation) {
        return mapEntry("ar_TN", translation);
    }

    protected static Map.Entry<String, String> ar_ye(String translation) {
        return mapEntry("ar_YE", translation);
    }

    protected static Map.Entry<String, String> az(String translation) {
        return mapEntry("az", translation);
    }

    protected static Map.Entry<String, String> az_az(String translation) {
        return mapEntry("az_AZ", translation);
    }

    protected static Map.Entry<String, String> be(String translation) {
        return mapEntry("be", translation);
    }

    protected static Map.Entry<String, String> be_by(String translation) {
        return mapEntry("be_BY", translation);
    }

    protected static Map.Entry<String, String> bg(String translation) {
        return mapEntry("bg", translation);
    }

    protected static Map.Entry<String, String> bg_bg(String translation) {
        return mapEntry("bg_BG", translation);
    }

    protected static Map.Entry<String, String> bs_ba(String translation) {
        return mapEntry("bs_BA", translation);
    }

    protected static Map.Entry<String, String> ca(String translation) {
        return mapEntry("ca", translation);
    }

    protected static Map.Entry<String, String> ca_es(String translation) {
        return mapEntry("ca_ES", translation);
    }

    protected static Map.Entry<String, String> cs(String translation) {
        return mapEntry("cs", translation);
    }

    protected static Map.Entry<String, String> cs_cz(String translation) {
        return mapEntry("cs_CZ", translation);
    }

    protected static Map.Entry<String, String> cy(String translation) {
        return mapEntry("cy", translation);
    }

    protected static Map.Entry<String, String> cy_gb(String translation) {
        return mapEntry("cy_GB", translation);
    }

    protected static Map.Entry<String, String> da(String translation) {
        return mapEntry("da", translation);
    }

    protected static Map.Entry<String, String> da_dk(String translation) {
        return mapEntry("da_DK", translation);
    }

    protected static Map.Entry<String, String> de(String translation) {
        return mapEntry("de", translation);
    }

    protected static Map.Entry<String, String> de_at(String translation) {
        return mapEntry("de_AT", translation);
    }

    protected static Map.Entry<String, String> de_ch(String translation) {
        return mapEntry("de_CH", translation);
    }

    protected static Map.Entry<String, String> de_de(String translation) {
        return mapEntry("de_DE", translation);
    }

    protected static Map.Entry<String, String> de_li(String translation) {
        return mapEntry("de_LI", translation);
    }

    protected static Map.Entry<String, String> de_lu(String translation) {
        return mapEntry("de_LU", translation);
    }

    protected static Map.Entry<String, String> dv(String translation) {
        return mapEntry("dv", translation);
    }

    protected static Map.Entry<String, String> dv_mv(String translation) {
        return mapEntry("dv_MV", translation);
    }

    protected static Map.Entry<String, String> el(String translation) {
        return mapEntry("el", translation);
    }

    protected static Map.Entry<String, String> el_gr(String translation) {
        return mapEntry("el_GR", translation);
    }

    protected static Map.Entry<String, String> en(String translation) {
        return mapEntry("en", translation);
    }

    protected static Map.Entry<String, String> en_au(String translation) {
        return mapEntry("en_AU", translation);
    }

    protected static Map.Entry<String, String> en_bz(String translation) {
        return mapEntry("en_BZ", translation);
    }

    protected static Map.Entry<String, String> en_ca(String translation) {
        return mapEntry("en_CA", translation);
    }

    protected static Map.Entry<String, String> en_cb(String translation) {
        return mapEntry("en_CB", translation);
    }

    protected static Map.Entry<String, String> en_gb(String translation) {
        return mapEntry("en_GB", translation);
    }

    protected static Map.Entry<String, String> en_ie(String translation) {
        return mapEntry("en_IE", translation);
    }

    protected static Map.Entry<String, String> en_jm(String translation) {
        return mapEntry("en_JM", translation);
    }

    protected static Map.Entry<String, String> en_nz(String translation) {
        return mapEntry("en_NZ", translation);
    }

    protected static Map.Entry<String, String> en_ph(String translation) {
        return mapEntry("en_PH", translation);
    }

    protected static Map.Entry<String, String> en_tt(String translation) {
        return mapEntry("en_TT", translation);
    }

    protected static Map.Entry<String, String> en_us(String translation) {
        return mapEntry("en_US", translation);
    }

    protected static Map.Entry<String, String> en_za(String translation) {
        return mapEntry("en_ZA", translation);
    }

    protected static Map.Entry<String, String> en_zw(String translation) {
        return mapEntry("en_ZW", translation);
    }

    protected static Map.Entry<String, String> eo(String translation) {
        return mapEntry("eo", translation);
    }

    protected static Map.Entry<String, String> es(String translation) {
        return mapEntry("es", translation);
    }

    protected static Map.Entry<String, String> es_ar(String translation) {
        return mapEntry("es_AR", translation);
    }

    protected static Map.Entry<String, String> es_bo(String translation) {
        return mapEntry("es_BO", translation);
    }

    protected static Map.Entry<String, String> es_cl(String translation) {
        return mapEntry("es_CL", translation);
    }

    protected static Map.Entry<String, String> es_co(String translation) {
        return mapEntry("es_CO", translation);
    }

    protected static Map.Entry<String, String> es_cr(String translation) {
        return mapEntry("es_CR", translation);
    }

    protected static Map.Entry<String, String> es_do(String translation) {
        return mapEntry("es_DO", translation);
    }

    protected static Map.Entry<String, String> es_ec(String translation) {
        return mapEntry("es_EC", translation);
    }

    protected static Map.Entry<String, String> es_es(String translation) {
        return mapEntry("es_ES", translation);
    }

    protected static Map.Entry<String, String> es_gt(String translation) {
        return mapEntry("es_GT", translation);
    }

    protected static Map.Entry<String, String> es_hn(String translation) {
        return mapEntry("es_HN", translation);
    }

    protected static Map.Entry<String, String> es_mx(String translation) {
        return mapEntry("es_MX", translation);
    }

    protected static Map.Entry<String, String> es_ni(String translation) {
        return mapEntry("es_NI", translation);
    }

    protected static Map.Entry<String, String> es_pa(String translation) {
        return mapEntry("es_PA", translation);
    }

    protected static Map.Entry<String, String> es_pe(String translation) {
        return mapEntry("es_PE", translation);
    }

    protected static Map.Entry<String, String> es_pr(String translation) {
        return mapEntry("es_PR", translation);
    }

    protected static Map.Entry<String, String> es_py(String translation) {
        return mapEntry("es_PY", translation);
    }

    protected static Map.Entry<String, String> es_sv(String translation) {
        return mapEntry("es_SV", translation);
    }

    protected static Map.Entry<String, String> es_uy(String translation) {
        return mapEntry("es_UY", translation);
    }

    protected static Map.Entry<String, String> es_ve(String translation) {
        return mapEntry("es_VE", translation);
    }

    protected static Map.Entry<String, String> et(String translation) {
        return mapEntry("et", translation);
    }

    protected static Map.Entry<String, String> et_ee(String translation) {
        return mapEntry("et_EE", translation);
    }

    protected static Map.Entry<String, String> eu(String translation) {
        return mapEntry("eu", translation);
    }

    protected static Map.Entry<String, String> eu_es(String translation) {
        return mapEntry("eu_ES", translation);
    }

    protected static Map.Entry<String, String> fa(String translation) {
        return mapEntry("fa", translation);
    }

    protected static Map.Entry<String, String> fa_ir(String translation) {
        return mapEntry("fa_IR", translation);
    }

    protected static Map.Entry<String, String> fi(String translation) {
        return mapEntry("fi", translation);
    }

    protected static Map.Entry<String, String> fi_fi(String translation) {
        return mapEntry("fi_FI", translation);
    }

    protected static Map.Entry<String, String> fo(String translation) {
        return mapEntry("fo", translation);
    }

    protected static Map.Entry<String, String> fo_fo(String translation) {
        return mapEntry("fo_FO", translation);
    }

    protected static Map.Entry<String, String> fr(String translation) {
        return mapEntry("fr", translation);
    }

    protected static Map.Entry<String, String> fr_be(String translation) {
        return mapEntry("fr_BE", translation);
    }

    protected static Map.Entry<String, String> fr_ca(String translation) {
        return mapEntry("fr_CA", translation);
    }

    protected static Map.Entry<String, String> fr_ch(String translation) {
        return mapEntry("fr_CH", translation);
    }

    protected static Map.Entry<String, String> fr_fr(String translation) {
        return mapEntry("fr_FR", translation);
    }

    protected static Map.Entry<String, String> fr_lu(String translation) {
        return mapEntry("fr_LU", translation);
    }

    protected static Map.Entry<String, String> fr_mc(String translation) {
        return mapEntry("fr_MC", translation);
    }

    protected static Map.Entry<String, String> gl(String translation) {
        return mapEntry("gl", translation);
    }

    protected static Map.Entry<String, String> gl_es(String translation) {
        return mapEntry("gl_ES", translation);
    }

    protected static Map.Entry<String, String> gu(String translation) {
        return mapEntry("gu", translation);
    }

    protected static Map.Entry<String, String> gu_in(String translation) {
        return mapEntry("gu_IN", translation);
    }

    protected static Map.Entry<String, String> he(String translation) {
        return mapEntry("he", translation);
    }

    protected static Map.Entry<String, String> he_il(String translation) {
        return mapEntry("he_IL", translation);
    }

    protected static Map.Entry<String, String> hi(String translation) {
        return mapEntry("hi", translation);
    }

    protected static Map.Entry<String, String> hi_in(String translation) {
        return mapEntry("hi_IN", translation);
    }

    protected static Map.Entry<String, String> hr(String translation) {
        return mapEntry("hr", translation);
    }

    protected static Map.Entry<String, String> hr_ba(String translation) {
        return mapEntry("hr_BA", translation);
    }

    protected static Map.Entry<String, String> hr_hr(String translation) {
        return mapEntry("hr_HR", translation);
    }

    protected static Map.Entry<String, String> hu(String translation) {
        return mapEntry("hu", translation);
    }

    protected static Map.Entry<String, String> hu_hu(String translation) {
        return mapEntry("hu_HU", translation);
    }

    protected static Map.Entry<String, String> hy(String translation) {
        return mapEntry("hy", translation);
    }

    protected static Map.Entry<String, String> hy_am(String translation) {
        return mapEntry("hy_AM", translation);
    }

    protected static Map.Entry<String, String> id(String translation) {
        return mapEntry("id", translation);
    }

    protected static Map.Entry<String, String> id_id(String translation) {
        return mapEntry("id_ID", translation);
    }

    protected static Map.Entry<String, String> is(String translation) {
        return mapEntry("is", translation);
    }

    protected static Map.Entry<String, String> is_is(String translation) {
        return mapEntry("is_IS", translation);
    }

    protected static Map.Entry<String, String> it(String translation) {
        return mapEntry("it", translation);
    }

    protected static Map.Entry<String, String> it_ch(String translation) {
        return mapEntry("it_CH", translation);
    }

    protected static Map.Entry<String, String> it_it(String translation) {
        return mapEntry("it_IT", translation);
    }

    protected static Map.Entry<String, String> ja(String translation) {
        return mapEntry("ja", translation);
    }

    protected static Map.Entry<String, String> ja_jp(String translation) {
        return mapEntry("ja_JP", translation);
    }

    protected static Map.Entry<String, String> ka(String translation) {
        return mapEntry("ka", translation);
    }

    protected static Map.Entry<String, String> ka_ge(String translation) {
        return mapEntry("ka_GE", translation);
    }

    protected static Map.Entry<String, String> kk(String translation) {
        return mapEntry("kk", translation);
    }

    protected static Map.Entry<String, String> kk_kz(String translation) {
        return mapEntry("kk_KZ", translation);
    }

    protected static Map.Entry<String, String> kn(String translation) {
        return mapEntry("kn", translation);
    }

    protected static Map.Entry<String, String> kn_in(String translation) {
        return mapEntry("kn_IN", translation);
    }

    protected static Map.Entry<String, String> ko(String translation) {
        return mapEntry("ko", translation);
    }

    protected static Map.Entry<String, String> ko_kr(String translation) {
        return mapEntry("ko_KR", translation);
    }

    protected static Map.Entry<String, String> kok(String translation) {
        return mapEntry("koK", translation);
    }

    protected static Map.Entry<String, String> kok_in(String translation) {
        return mapEntry("koK_IN", translation);
    }

    protected static Map.Entry<String, String> ky(String translation) {
        return mapEntry("ky", translation);
    }

    protected static Map.Entry<String, String> ky_kg(String translation) {
        return mapEntry("ky_KG", translation);
    }

    protected static Map.Entry<String, String> lt(String translation) {
        return mapEntry("lt", translation);
    }

    protected static Map.Entry<String, String> lt_lt(String translation) {
        return mapEntry("lt_LT", translation);
    }

    protected static Map.Entry<String, String> lv(String translation) {
        return mapEntry("lv", translation);
    }

    protected static Map.Entry<String, String> lv_lv(String translation) {
        return mapEntry("lv_LV", translation);
    }

    protected static Map.Entry<String, String> mi(String translation) {
        return mapEntry("mi", translation);
    }

    protected static Map.Entry<String, String> mi_nz(String translation) {
        return mapEntry("mi_NZ", translation);
    }

    protected static Map.Entry<String, String> mk(String translation) {
        return mapEntry("mk", translation);
    }

    protected static Map.Entry<String, String> mk_mk(String translation) {
        return mapEntry("mk_MK", translation);
    }

    protected static Map.Entry<String, String> mn(String translation) {
        return mapEntry("mn", translation);
    }

    protected static Map.Entry<String, String> mn_mn(String translation) {
        return mapEntry("mn_MN", translation);
    }

    protected static Map.Entry<String, String> mr(String translation) {
        return mapEntry("mr", translation);
    }

    protected static Map.Entry<String, String> mr_in(String translation) {
        return mapEntry("mr_IN", translation);
    }

    protected static Map.Entry<String, String> ms(String translation) {
        return mapEntry("ms", translation);
    }

    protected static Map.Entry<String, String> ms_bn(String translation) {
        return mapEntry("ms_BN", translation);
    }

    protected static Map.Entry<String, String> ms_my(String translation) {
        return mapEntry("ms_MY", translation);
    }

    protected static Map.Entry<String, String> mt(String translation) {
        return mapEntry("mt", translation);
    }

    protected static Map.Entry<String, String> mt_mt(String translation) {
        return mapEntry("mt_MT", translation);
    }

    protected static Map.Entry<String, String> nb(String translation) {
        return mapEntry("nb", translation);
    }

    protected static Map.Entry<String, String> nb_no(String translation) {
        return mapEntry("nb_NO", translation);
    }

    protected static Map.Entry<String, String> nl(String translation) {
        return mapEntry("nl", translation);
    }

    protected static Map.Entry<String, String> nl_be(String translation) {
        return mapEntry("nl_BE", translation);
    }

    protected static Map.Entry<String, String> nl_nl(String translation) {
        return mapEntry("nl_NL", translation);
    }

    protected static Map.Entry<String, String> nn_no(String translation) {
        return mapEntry("nn_NO", translation);
    }

    protected static Map.Entry<String, String> ns(String translation) {
        return mapEntry("ns", translation);
    }

    protected static Map.Entry<String, String> ns_za(String translation) {
        return mapEntry("ns_ZA", translation);
    }

    protected static Map.Entry<String, String> pa(String translation) {
        return mapEntry("pa", translation);
    }

    protected static Map.Entry<String, String> pa_in(String translation) {
        return mapEntry("pa_IN", translation);
    }

    protected static Map.Entry<String, String> pl(String translation) {
        return mapEntry("pl", translation);
    }

    protected static Map.Entry<String, String> pl_pl(String translation) {
        return mapEntry("pl_PL", translation);
    }

    protected static Map.Entry<String, String> ps(String translation) {
        return mapEntry("ps", translation);
    }

    protected static Map.Entry<String, String> ps_ar(String translation) {
        return mapEntry("ps_AR", translation);
    }

    protected static Map.Entry<String, String> pt(String translation) {
        return mapEntry("pt", translation);
    }

    protected static Map.Entry<String, String> pt_br(String translation) {
        return mapEntry("pt_BR", translation);
    }

    protected static Map.Entry<String, String> pt_pt(String translation) {
        return mapEntry("pt_PT", translation);
    }

    protected static Map.Entry<String, String> qu(String translation) {
        return mapEntry("qu", translation);
    }

    protected static Map.Entry<String, String> qu_bo(String translation) {
        return mapEntry("qu_BO", translation);
    }

    protected static Map.Entry<String, String> qu_ec(String translation) {
        return mapEntry("qu_EC", translation);
    }

    protected static Map.Entry<String, String> qu_pe(String translation) {
        return mapEntry("qu_PE", translation);
    }

    protected static Map.Entry<String, String> ro(String translation) {
        return mapEntry("ro", translation);
    }

    protected static Map.Entry<String, String> ro_ro(String translation) {
        return mapEntry("ro_RO", translation);
    }

    protected static Map.Entry<String, String> ru(String translation) {
        return mapEntry("ru", translation);
    }

    protected static Map.Entry<String, String> ru_ru(String translation) {
        return mapEntry("ru_RU", translation);
    }

    protected static Map.Entry<String, String> sa(String translation) {
        return mapEntry("sa", translation);
    }

    protected static Map.Entry<String, String> sa_in(String translation) {
        return mapEntry("sa_IN", translation);
    }

    protected static Map.Entry<String, String> se(String translation) {
        return mapEntry("se", translation);
    }

    protected static Map.Entry<String, String> se_fi(String translation) {
        return mapEntry("se_FI", translation);
    }

    protected static Map.Entry<String, String> se_no(String translation) {
        return mapEntry("se_NO", translation);
    }

    protected static Map.Entry<String, String> se_se(String translation) {
        return mapEntry("se_SE", translation);
    }

    protected static Map.Entry<String, String> sk(String translation) {
        return mapEntry("sk", translation);
    }

    protected static Map.Entry<String, String> sk_sk(String translation) {
        return mapEntry("sk_SK", translation);
    }

    protected static Map.Entry<String, String> sl(String translation) {
        return mapEntry("sl", translation);
    }

    protected static Map.Entry<String, String> sl_si(String translation) {
        return mapEntry("sl_SI", translation);
    }

    protected static Map.Entry<String, String> sq(String translation) {
        return mapEntry("sq", translation);
    }

    protected static Map.Entry<String, String> sq_al(String translation) {
        return mapEntry("sq_AL", translation);
    }

    protected static Map.Entry<String, String> sr_ba(String translation) {
        return mapEntry("sr_BA", translation);
    }

    protected static Map.Entry<String, String> sr_sp(String translation) {
        return mapEntry("sr_SP", translation);
    }

    protected static Map.Entry<String, String> sv(String translation) {
        return mapEntry("sv", translation);
    }

    protected static Map.Entry<String, String> sv_fi(String translation) {
        return mapEntry("sv_FI", translation);
    }

    protected static Map.Entry<String, String> sv_se(String translation) {
        return mapEntry("sv_SE", translation);
    }

    protected static Map.Entry<String, String> sw(String translation) {
        return mapEntry("sw", translation);
    }

    protected static Map.Entry<String, String> sw_ke(String translation) {
        return mapEntry("sw_KE", translation);
    }

    protected static Map.Entry<String, String> syr(String translation) {
        return mapEntry("syR", translation);
    }

    protected static Map.Entry<String, String> syr_sy(String translation) {
        return mapEntry("syR_SY", translation);
    }

    protected static Map.Entry<String, String> ta(String translation) {
        return mapEntry("ta", translation);
    }

    protected static Map.Entry<String, String> ta_in(String translation) {
        return mapEntry("ta_IN", translation);
    }

    protected static Map.Entry<String, String> te(String translation) {
        return mapEntry("te", translation);
    }

    protected static Map.Entry<String, String> te_in(String translation) {
        return mapEntry("te_IN", translation);
    }

    protected static Map.Entry<String, String> th(String translation) {
        return mapEntry("th", translation);
    }

    protected static Map.Entry<String, String> th_th(String translation) {
        return mapEntry("th_TH", translation);
    }

    protected static Map.Entry<String, String> tl(String translation) {
        return mapEntry("tl", translation);
    }

    protected static Map.Entry<String, String> tl_ph(String translation) {
        return mapEntry("tl_PH", translation);
    }

    protected static Map.Entry<String, String> tn(String translation) {
        return mapEntry("tn", translation);
    }

    protected static Map.Entry<String, String> tn_za(String translation) {
        return mapEntry("tn_ZA", translation);
    }

    protected static Map.Entry<String, String> tr(String translation) {
        return mapEntry("tr", translation);
    }

    protected static Map.Entry<String, String> tr_tr(String translation) {
        return mapEntry("tr_TR", translation);
    }

    protected static Map.Entry<String, String> tt(String translation) {
        return mapEntry("tt", translation);
    }

    protected static Map.Entry<String, String> tt_ru(String translation) {
        return mapEntry("tt_RU", translation);
    }

    protected static Map.Entry<String, String> ts(String translation) {
        return mapEntry("ts", translation);
    }

    protected static Map.Entry<String, String> uk(String translation) {
        return mapEntry("uk", translation);
    }

    protected static Map.Entry<String, String> uk_ua(String translation) {
        return mapEntry("uk_UA", translation);
    }

    protected static Map.Entry<String, String> ur(String translation) {
        return mapEntry("ur", translation);
    }

    protected static Map.Entry<String, String> ur_pk(String translation) {
        return mapEntry("ur_PK", translation);
    }

    protected static Map.Entry<String, String> uz(String translation) {
        return mapEntry("uz", translation);
    }

    protected static Map.Entry<String, String> uz_uz(String translation) {
        return mapEntry("uz_UZ", translation);
    }

    protected static Map.Entry<String, String> vi(String translation) {
        return mapEntry("vi", translation);
    }

    protected static Map.Entry<String, String> vi_vn(String translation) {
        return mapEntry("vi_VN", translation);
    }

    protected static Map.Entry<String, String> xh(String translation) {
        return mapEntry("xh", translation);
    }

    protected static Map.Entry<String, String> xh_za(String translation) {
        return mapEntry("xh_ZA", translation);
    }

    protected static Map.Entry<String, String> zh(String translation) {
        return mapEntry("zh", translation);
    }

    protected static Map.Entry<String, String> zh_cn(String translation) {
        return mapEntry("zh_CN", translation);
    }

    protected static Map.Entry<String, String> zh_hk(String translation) {
        return mapEntry("zh_HK", translation);
    }

    protected static Map.Entry<String, String> zh_mo(String translation) {
        return mapEntry("zh_MO", translation);
    }

    protected static Map.Entry<String, String> zh_sg(String translation) {
        return mapEntry("zh_SG", translation);
    }

    protected static Map.Entry<String, String> zh_tw(String translation) {
        return mapEntry("zh_TW", translation);
    }

    protected static Map.Entry<String, String> zu(String translation) {
        return mapEntry("zu", translation);
    }

    protected static Map.Entry<String, String> zu_za(String translation) {
        return mapEntry("zu_ZA", translation);
    }
}