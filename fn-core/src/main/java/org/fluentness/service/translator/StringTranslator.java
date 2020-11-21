package org.fluentness.service.translator;

public abstract class StringTranslator implements Translator {

    // default translations
    public static final String
        _submit = "Submit" + de("Absenden") + es("Enviar"),
        _search = "Search" + de("Suchen") + es("Buscar"),
        _switch = "Switch" + de("Umschalten") + es("Alternar"),
        _accept = "Accept" + de("Akzeptieren") + es("Aceptar"),
        _cancel = "Cancel" + de("Abbrechen") + es("Cancelar"),
        _select = "Select" + de("Auswählen") + es("Seleccionar"),
        _create = "Create" + de("Erstellen") + es("Crear"),
        _update = "Update" + de("Editieren") + es("Editar"),
        _delete = "Delete" + de("Entfernen") + es("Eliminar"),
        _dark_mode = "Dark mode" + de("Dunkelmodus") + es("Modo oscuro"),
        _previous = "Previous" + de("Vorheriger") + es("Anterior"),
        _next = "Next" + de("Nächster") + es("Siguiente");

    private static String translation(String language, String translation) {
        return DELIMITER + language + DELIMITER + translation + DELIMITER;
    }

    protected static String af(String translation) {
        return translation("af", translation);
    }

    protected static String af_za(String translation) {
        return translation("af_ZA", translation);
    }

    protected static String ar(String translation) {
        return translation("ar", translation);
    }

    protected static String ar_ae(String translation) {
        return translation("ar_AE", translation);
    }

    protected static String ar_bh(String translation) {
        return translation("ar_BH", translation);
    }

    protected static String ar_dz(String translation) {
        return translation("ar_DZ", translation);
    }

    protected static String ar_eg(String translation) {
        return translation("ar_EG", translation);
    }

    protected static String ar_iq(String translation) {
        return translation("ar_IQ", translation);
    }

    protected static String ar_jo(String translation) {
        return translation("ar_JO", translation);
    }

    protected static String ar_kw(String translation) {
        return translation("ar_KW", translation);
    }

    protected static String ar_lb(String translation) {
        return translation("ar_LB", translation);
    }

    protected static String ar_ly(String translation) {
        return translation("ar_LY", translation);
    }

    protected static String ar_ma(String translation) {
        return translation("ar_MA", translation);
    }

    protected static String ar_om(String translation) {
        return translation("ar_OM", translation);
    }

    protected static String ar_qa(String translation) {
        return translation("ar_QA", translation);
    }

    protected static String ar_sa(String translation) {
        return translation("ar_SA", translation);
    }

    protected static String ar_sy(String translation) {
        return translation("ar_SY", translation);
    }

    protected static String ar_tn(String translation) {
        return translation("ar_TN", translation);
    }

    protected static String ar_ye(String translation) {
        return translation("ar_YE", translation);
    }

    protected static String az(String translation) {
        return translation("az", translation);
    }

    protected static String az_az(String translation) {
        return translation("az_AZ", translation);
    }

    protected static String be(String translation) {
        return translation("be", translation);
    }

    protected static String be_by(String translation) {
        return translation("be_BY", translation);
    }

    protected static String bg(String translation) {
        return translation("bg", translation);
    }

    protected static String bg_bg(String translation) {
        return translation("bg_BG", translation);
    }

    protected static String bs_ba(String translation) {
        return translation("bs_BA", translation);
    }

    protected static String ca(String translation) {
        return translation("ca", translation);
    }

    protected static String ca_es(String translation) {
        return translation("ca_ES", translation);
    }

    protected static String cs(String translation) {
        return translation("cs", translation);
    }

    protected static String cs_cz(String translation) {
        return translation("cs_CZ", translation);
    }

    protected static String cy(String translation) {
        return translation("cy", translation);
    }

    protected static String cy_gb(String translation) {
        return translation("cy_GB", translation);
    }

    protected static String da(String translation) {
        return translation("da", translation);
    }

    protected static String da_dk(String translation) {
        return translation("da_DK", translation);
    }

    protected static String de(String translation) {
        return translation("de", translation);
    }

    protected static String de_at(String translation) {
        return translation("de_AT", translation);
    }

    protected static String de_ch(String translation) {
        return translation("de_CH", translation);
    }

    protected static String de_de(String translation) {
        return translation("de_DE", translation);
    }

    protected static String de_li(String translation) {
        return translation("de_LI", translation);
    }

    protected static String de_lu(String translation) {
        return translation("de_LU", translation);
    }

    protected static String dv(String translation) {
        return translation("dv", translation);
    }

    protected static String dv_mv(String translation) {
        return translation("dv_MV", translation);
    }

    protected static String el(String translation) {
        return translation("el", translation);
    }

    protected static String el_gr(String translation) {
        return translation("el_GR", translation);
    }

    protected static String en(String translation) {
        return translation("en", translation);
    }

    protected static String en_au(String translation) {
        return translation("en_AU", translation);
    }

    protected static String en_bz(String translation) {
        return translation("en_BZ", translation);
    }

    protected static String en_ca(String translation) {
        return translation("en_CA", translation);
    }

    protected static String en_cb(String translation) {
        return translation("en_CB", translation);
    }

    protected static String en_gb(String translation) {
        return translation("en_GB", translation);
    }

    protected static String en_ie(String translation) {
        return translation("en_IE", translation);
    }

    protected static String en_jm(String translation) {
        return translation("en_JM", translation);
    }

    protected static String en_nz(String translation) {
        return translation("en_NZ", translation);
    }

    protected static String en_ph(String translation) {
        return translation("en_PH", translation);
    }

    protected static String en_tt(String translation) {
        return translation("en_TT", translation);
    }

    protected static String en_us(String translation) {
        return translation("en_US", translation);
    }

    protected static String en_za(String translation) {
        return translation("en_ZA", translation);
    }

    protected static String en_zw(String translation) {
        return translation("en_ZW", translation);
    }

    protected static String eo(String translation) {
        return translation("eo", translation);
    }

    protected static String es(String translation) {
        return translation("es", translation);
    }

    protected static String es_ar(String translation) {
        return translation("es_AR", translation);
    }

    protected static String es_bo(String translation) {
        return translation("es_BO", translation);
    }

    protected static String es_cl(String translation) {
        return translation("es_CL", translation);
    }

    protected static String es_co(String translation) {
        return translation("es_CO", translation);
    }

    protected static String es_cr(String translation) {
        return translation("es_CR", translation);
    }

    protected static String es_do(String translation) {
        return translation("es_DO", translation);
    }

    protected static String es_ec(String translation) {
        return translation("es_EC", translation);
    }

    protected static String es_es(String translation) {
        return translation("es_ES", translation);
    }

    protected static String es_gt(String translation) {
        return translation("es_GT", translation);
    }

    protected static String es_hn(String translation) {
        return translation("es_HN", translation);
    }

    protected static String es_mx(String translation) {
        return translation("es_MX", translation);
    }

    protected static String es_ni(String translation) {
        return translation("es_NI", translation);
    }

    protected static String es_pa(String translation) {
        return translation("es_PA", translation);
    }

    protected static String es_pe(String translation) {
        return translation("es_PE", translation);
    }

    protected static String es_pr(String translation) {
        return translation("es_PR", translation);
    }

    protected static String es_py(String translation) {
        return translation("es_PY", translation);
    }

    protected static String es_sv(String translation) {
        return translation("es_SV", translation);
    }

    protected static String es_uy(String translation) {
        return translation("es_UY", translation);
    }

    protected static String es_ve(String translation) {
        return translation("es_VE", translation);
    }

    protected static String et(String translation) {
        return translation("et", translation);
    }

    protected static String et_ee(String translation) {
        return translation("et_EE", translation);
    }

    protected static String eu(String translation) {
        return translation("eu", translation);
    }

    protected static String eu_es(String translation) {
        return translation("eu_ES", translation);
    }

    protected static String fa(String translation) {
        return translation("fa", translation);
    }

    protected static String fa_ir(String translation) {
        return translation("fa_IR", translation);
    }

    protected static String fi(String translation) {
        return translation("fi", translation);
    }

    protected static String fi_fi(String translation) {
        return translation("fi_FI", translation);
    }

    protected static String fo(String translation) {
        return translation("fo", translation);
    }

    protected static String fo_fo(String translation) {
        return translation("fo_FO", translation);
    }

    protected static String fr(String translation) {
        return translation("fr", translation);
    }

    protected static String fr_be(String translation) {
        return translation("fr_BE", translation);
    }

    protected static String fr_ca(String translation) {
        return translation("fr_CA", translation);
    }

    protected static String fr_ch(String translation) {
        return translation("fr_CH", translation);
    }

    protected static String fr_fr(String translation) {
        return translation("fr_FR", translation);
    }

    protected static String fr_lu(String translation) {
        return translation("fr_LU", translation);
    }

    protected static String fr_mc(String translation) {
        return translation("fr_MC", translation);
    }

    protected static String gl(String translation) {
        return translation("gl", translation);
    }

    protected static String gl_es(String translation) {
        return translation("gl_ES", translation);
    }

    protected static String gu(String translation) {
        return translation("gu", translation);
    }

    protected static String gu_in(String translation) {
        return translation("gu_IN", translation);
    }

    protected static String he(String translation) {
        return translation("he", translation);
    }

    protected static String he_il(String translation) {
        return translation("he_IL", translation);
    }

    protected static String hi(String translation) {
        return translation("hi", translation);
    }

    protected static String hi_in(String translation) {
        return translation("hi_IN", translation);
    }

    protected static String hr(String translation) {
        return translation("hr", translation);
    }

    protected static String hr_ba(String translation) {
        return translation("hr_BA", translation);
    }

    protected static String hr_hr(String translation) {
        return translation("hr_HR", translation);
    }

    protected static String hu(String translation) {
        return translation("hu", translation);
    }

    protected static String hu_hu(String translation) {
        return translation("hu_HU", translation);
    }

    protected static String hy(String translation) {
        return translation("hy", translation);
    }

    protected static String hy_am(String translation) {
        return translation("hy_AM", translation);
    }

    protected static String id(String translation) {
        return translation("id", translation);
    }

    protected static String id_id(String translation) {
        return translation("id_ID", translation);
    }

    protected static String is(String translation) {
        return translation("is", translation);
    }

    protected static String is_is(String translation) {
        return translation("is_IS", translation);
    }

    protected static String it(String translation) {
        return translation("it", translation);
    }

    protected static String it_ch(String translation) {
        return translation("it_CH", translation);
    }

    protected static String it_it(String translation) {
        return translation("it_IT", translation);
    }

    protected static String ja(String translation) {
        return translation("ja", translation);
    }

    protected static String ja_jp(String translation) {
        return translation("ja_JP", translation);
    }

    protected static String ka(String translation) {
        return translation("ka", translation);
    }

    protected static String ka_ge(String translation) {
        return translation("ka_GE", translation);
    }

    protected static String kk(String translation) {
        return translation("kk", translation);
    }

    protected static String kk_kz(String translation) {
        return translation("kk_KZ", translation);
    }

    protected static String kn(String translation) {
        return translation("kn", translation);
    }

    protected static String kn_in(String translation) {
        return translation("kn_IN", translation);
    }

    protected static String ko(String translation) {
        return translation("ko", translation);
    }

    protected static String ko_kr(String translation) {
        return translation("ko_KR", translation);
    }

    protected static String kok(String translation) {
        return translation("koK", translation);
    }

    protected static String kok_in(String translation) {
        return translation("koK_IN", translation);
    }

    protected static String ky(String translation) {
        return translation("ky", translation);
    }

    protected static String ky_kg(String translation) {
        return translation("ky_KG", translation);
    }

    protected static String lt(String translation) {
        return translation("lt", translation);
    }

    protected static String lt_lt(String translation) {
        return translation("lt_LT", translation);
    }

    protected static String lv(String translation) {
        return translation("lv", translation);
    }

    protected static String lv_lv(String translation) {
        return translation("lv_LV", translation);
    }

    protected static String mi(String translation) {
        return translation("mi", translation);
    }

    protected static String mi_nz(String translation) {
        return translation("mi_NZ", translation);
    }

    protected static String mk(String translation) {
        return translation("mk", translation);
    }

    protected static String mk_mk(String translation) {
        return translation("mk_MK", translation);
    }

    protected static String mn(String translation) {
        return translation("mn", translation);
    }

    protected static String mn_mn(String translation) {
        return translation("mn_MN", translation);
    }

    protected static String mr(String translation) {
        return translation("mr", translation);
    }

    protected static String mr_in(String translation) {
        return translation("mr_IN", translation);
    }

    protected static String ms(String translation) {
        return translation("ms", translation);
    }

    protected static String ms_bn(String translation) {
        return translation("ms_BN", translation);
    }

    protected static String ms_my(String translation) {
        return translation("ms_MY", translation);
    }

    protected static String mt(String translation) {
        return translation("mt", translation);
    }

    protected static String mt_mt(String translation) {
        return translation("mt_MT", translation);
    }

    protected static String nb(String translation) {
        return translation("nb", translation);
    }

    protected static String nb_no(String translation) {
        return translation("nb_NO", translation);
    }

    protected static String nl(String translation) {
        return translation("nl", translation);
    }

    protected static String nl_be(String translation) {
        return translation("nl_BE", translation);
    }

    protected static String nl_nl(String translation) {
        return translation("nl_NL", translation);
    }

    protected static String nn_no(String translation) {
        return translation("nn_NO", translation);
    }

    protected static String ns(String translation) {
        return translation("ns", translation);
    }

    protected static String ns_za(String translation) {
        return translation("ns_ZA", translation);
    }

    protected static String pa(String translation) {
        return translation("pa", translation);
    }

    protected static String pa_in(String translation) {
        return translation("pa_IN", translation);
    }

    protected static String pl(String translation) {
        return translation("pl", translation);
    }

    protected static String pl_pl(String translation) {
        return translation("pl_PL", translation);
    }

    protected static String ps(String translation) {
        return translation("ps", translation);
    }

    protected static String ps_ar(String translation) {
        return translation("ps_AR", translation);
    }

    protected static String pt(String translation) {
        return translation("pt", translation);
    }

    protected static String pt_br(String translation) {
        return translation("pt_BR", translation);
    }

    protected static String pt_pt(String translation) {
        return translation("pt_PT", translation);
    }

    protected static String qu(String translation) {
        return translation("qu", translation);
    }

    protected static String qu_bo(String translation) {
        return translation("qu_BO", translation);
    }

    protected static String qu_ec(String translation) {
        return translation("qu_EC", translation);
    }

    protected static String qu_pe(String translation) {
        return translation("qu_PE", translation);
    }

    protected static String ro(String translation) {
        return translation("ro", translation);
    }

    protected static String ro_ro(String translation) {
        return translation("ro_RO", translation);
    }

    protected static String ru(String translation) {
        return translation("ru", translation);
    }

    protected static String ru_ru(String translation) {
        return translation("ru_RU", translation);
    }

    protected static String sa(String translation) {
        return translation("sa", translation);
    }

    protected static String sa_in(String translation) {
        return translation("sa_IN", translation);
    }

    protected static String se(String translation) {
        return translation("se", translation);
    }

    protected static String se_fi(String translation) {
        return translation("se_FI", translation);
    }

    protected static String se_no(String translation) {
        return translation("se_NO", translation);
    }

    protected static String se_se(String translation) {
        return translation("se_SE", translation);
    }

    protected static String sk(String translation) {
        return translation("sk", translation);
    }

    protected static String sk_sk(String translation) {
        return translation("sk_SK", translation);
    }

    protected static String sl(String translation) {
        return translation("sl", translation);
    }

    protected static String sl_si(String translation) {
        return translation("sl_SI", translation);
    }

    protected static String sq(String translation) {
        return translation("sq", translation);
    }

    protected static String sq_al(String translation) {
        return translation("sq_AL", translation);
    }

    protected static String sr_ba(String translation) {
        return translation("sr_BA", translation);
    }

    protected static String sr_sp(String translation) {
        return translation("sr_SP", translation);
    }

    protected static String sv(String translation) {
        return translation("sv", translation);
    }

    protected static String sv_fi(String translation) {
        return translation("sv_FI", translation);
    }

    protected static String sv_se(String translation) {
        return translation("sv_SE", translation);
    }

    protected static String sw(String translation) {
        return translation("sw", translation);
    }

    protected static String sw_ke(String translation) {
        return translation("sw_KE", translation);
    }

    protected static String syr(String translation) {
        return translation("syR", translation);
    }

    protected static String syr_sy(String translation) {
        return translation("syR_SY", translation);
    }

    protected static String ta(String translation) {
        return translation("ta", translation);
    }

    protected static String ta_in(String translation) {
        return translation("ta_IN", translation);
    }

    protected static String te(String translation) {
        return translation("te", translation);
    }

    protected static String te_in(String translation) {
        return translation("te_IN", translation);
    }

    protected static String th(String translation) {
        return translation("th", translation);
    }

    protected static String th_th(String translation) {
        return translation("th_TH", translation);
    }

    protected static String tl(String translation) {
        return translation("tl", translation);
    }

    protected static String tl_ph(String translation) {
        return translation("tl_PH", translation);
    }

    protected static String tn(String translation) {
        return translation("tn", translation);
    }

    protected static String tn_za(String translation) {
        return translation("tn_ZA", translation);
    }

    protected static String tr(String translation) {
        return translation("tr", translation);
    }

    protected static String tr_tr(String translation) {
        return translation("tr_TR", translation);
    }

    protected static String tt(String translation) {
        return translation("tt", translation);
    }

    protected static String tt_ru(String translation) {
        return translation("tt_RU", translation);
    }

    protected static String ts(String translation) {
        return translation("ts", translation);
    }

    protected static String uk(String translation) {
        return translation("uk", translation);
    }

    protected static String uk_ua(String translation) {
        return translation("uk_UA", translation);
    }

    protected static String ur(String translation) {
        return translation("ur", translation);
    }

    protected static String ur_pk(String translation) {
        return translation("ur_PK", translation);
    }

    protected static String uz(String translation) {
        return translation("uz", translation);
    }

    protected static String uz_uz(String translation) {
        return translation("uz_UZ", translation);
    }

    protected static String vi(String translation) {
        return translation("vi", translation);
    }

    protected static String vi_vn(String translation) {
        return translation("vi_VN", translation);
    }

    protected static String xh(String translation) {
        return translation("xh", translation);
    }

    protected static String xh_za(String translation) {
        return translation("xh_ZA", translation);
    }

    protected static String zh(String translation) {
        return translation("zh", translation);
    }

    protected static String zh_cn(String translation) {
        return translation("zh_CN", translation);
    }

    protected static String zh_hk(String translation) {
        return translation("zh_HK", translation);
    }

    protected static String zh_mo(String translation) {
        return translation("zh_MO", translation);
    }

    protected static String zh_sg(String translation) {
        return translation("zh_SG", translation);
    }

    protected static String zh_tw(String translation) {
        return translation("zh_TW", translation);
    }

    protected static String zu(String translation) {
        return translation("zu", translation);
    }

    protected static String zu_za(String translation) {
        return translation("zu_ZA", translation);
    }
}