package org.fluentness.service.translator;

import org.fluentness.service.Service;

import java.util.Locale;

public abstract class Translator implements Service {

    private static final String SEPARATOR = "#L#";

    public static String translate(String translation) {
        String language = Locale.getDefault().getLanguage();

        String str = SEPARATOR + language;
        if (translation.contains(str)) {
            int beginIndex = translation.indexOf(str) + str.length();
            int endIndex = translation.indexOf(SEPARATOR, beginIndex + 1);
            return translation.substring(beginIndex, endIndex);
        }
        if (translation.contains(SEPARATOR)) {
            return translation.substring(0, translation.indexOf(SEPARATOR));
        }
        return translation;
    }

    protected static String translation(Language language, String translation) {
        return SEPARATOR + language + translation;
    }

    protected static String af(String translation) {
        return translation(Language.AF, translation);
    }

    protected static String af_za(String translation) {
        return translation(Language.AF_ZA, translation);
    }

    protected static String ar(String translation) {
        return translation(Language.AR, translation);
    }

    protected static String ar_ae(String translation) {
        return translation(Language.AR_AE, translation);
    }

    protected static String ar_bh(String translation) {
        return translation(Language.AR_BH, translation);
    }

    protected static String ar_dz(String translation) {
        return translation(Language.AR_DZ, translation);
    }

    protected static String ar_eg(String translation) {
        return translation(Language.AR_EG, translation);
    }

    protected static String ar_iq(String translation) {
        return translation(Language.AR_IQ, translation);
    }

    protected static String ar_jo(String translation) {
        return translation(Language.AR_JO, translation);
    }

    protected static String ar_kw(String translation) {
        return translation(Language.AR_KW, translation);
    }

    protected static String ar_lb(String translation) {
        return translation(Language.AR_LB, translation);
    }

    protected static String ar_ly(String translation) {
        return translation(Language.AR_LY, translation);
    }

    protected static String ar_ma(String translation) {
        return translation(Language.AR_MA, translation);
    }

    protected static String ar_om(String translation) {
        return translation(Language.AR_OM, translation);
    }

    protected static String ar_qa(String translation) {
        return translation(Language.AR_QA, translation);
    }

    protected static String ar_sa(String translation) {
        return translation(Language.AR_SA, translation);
    }

    protected static String ar_sy(String translation) {
        return translation(Language.AR_SY, translation);
    }

    protected static String ar_tn(String translation) {
        return translation(Language.AR_TN, translation);
    }

    protected static String ar_ye(String translation) {
        return translation(Language.AR_YE, translation);
    }

    protected static String az(String translation) {
        return translation(Language.AZ, translation);
    }

    protected static String az_az(String translation) {
        return translation(Language.AZ_AZ, translation);
    }

    protected static String be(String translation) {
        return translation(Language.BE, translation);
    }

    protected static String be_by(String translation) {
        return translation(Language.BE_BY, translation);
    }

    protected static String bg(String translation) {
        return translation(Language.BG, translation);
    }

    protected static String bg_bg(String translation) {
        return translation(Language.BG_BG, translation);
    }

    protected static String bs_ba(String translation) {
        return translation(Language.BS_BA, translation);
    }

    protected static String ca(String translation) {
        return translation(Language.CA, translation);
    }

    protected static String ca_es(String translation) {
        return translation(Language.CA_ES, translation);
    }

    protected static String cs(String translation) {
        return translation(Language.CS, translation);
    }

    protected static String cs_cz(String translation) {
        return translation(Language.CS_CZ, translation);
    }

    protected static String cy(String translation) {
        return translation(Language.CY, translation);
    }

    protected static String cy_gb(String translation) {
        return translation(Language.CY_GB, translation);
    }

    protected static String da(String translation) {
        return translation(Language.DA, translation);
    }

    protected static String da_dk(String translation) {
        return translation(Language.DA_DK, translation);
    }

    protected static String de(String translation) {
        return translation(Language.DE, translation);
    }

    protected static String de_at(String translation) {
        return translation(Language.DE_AT, translation);
    }

    protected static String de_ch(String translation) {
        return translation(Language.DE_CH, translation);
    }

    protected static String de_de(String translation) {
        return translation(Language.DE_DE, translation);
    }

    protected static String de_li(String translation) {
        return translation(Language.DE_LI, translation);
    }

    protected static String de_lu(String translation) {
        return translation(Language.DE_LU, translation);
    }

    protected static String dv(String translation) {
        return translation(Language.DV, translation);
    }

    protected static String dv_mv(String translation) {
        return translation(Language.DV_MV, translation);
    }

    protected static String el(String translation) {
        return translation(Language.EL, translation);
    }

    protected static String el_gr(String translation) {
        return translation(Language.EL_GR, translation);
    }

    protected static String en(String translation) {
        return translation(Language.EN, translation);
    }

    protected static String en_au(String translation) {
        return translation(Language.EN_AU, translation);
    }

    protected static String en_bz(String translation) {
        return translation(Language.EN_BZ, translation);
    }

    protected static String en_ca(String translation) {
        return translation(Language.EN_CA, translation);
    }

    protected static String en_cb(String translation) {
        return translation(Language.EN_CB, translation);
    }

    protected static String en_gb(String translation) {
        return translation(Language.EN_GB, translation);
    }

    protected static String en_ie(String translation) {
        return translation(Language.EN_IE, translation);
    }

    protected static String en_jm(String translation) {
        return translation(Language.EN_JM, translation);
    }

    protected static String en_nz(String translation) {
        return translation(Language.EN_NZ, translation);
    }

    protected static String en_ph(String translation) {
        return translation(Language.EN_PH, translation);
    }

    protected static String en_tt(String translation) {
        return translation(Language.EN_TT, translation);
    }

    protected static String en_us(String translation) {
        return translation(Language.EN_US, translation);
    }

    protected static String en_za(String translation) {
        return translation(Language.EN_ZA, translation);
    }

    protected static String en_zw(String translation) {
        return translation(Language.EN_ZW, translation);
    }

    protected static String eo(String translation) {
        return translation(Language.EO, translation);
    }

    protected static String es(String translation) {
        return translation(Language.ES, translation);
    }

    protected static String es_ar(String translation) {
        return translation(Language.ES_AR, translation);
    }

    protected static String es_bo(String translation) {
        return translation(Language.ES_BO, translation);
    }

    protected static String es_cl(String translation) {
        return translation(Language.ES_CL, translation);
    }

    protected static String es_co(String translation) {
        return translation(Language.ES_CO, translation);
    }

    protected static String es_cr(String translation) {
        return translation(Language.ES_CR, translation);
    }

    protected static String es_do(String translation) {
        return translation(Language.ES_DO, translation);
    }

    protected static String es_ec(String translation) {
        return translation(Language.ES_EC, translation);
    }

    protected static String es_es(String translation) {
        return translation(Language.ES_ES, translation);
    }

    protected static String es_gt(String translation) {
        return translation(Language.ES_GT, translation);
    }

    protected static String es_hn(String translation) {
        return translation(Language.ES_HN, translation);
    }

    protected static String es_mx(String translation) {
        return translation(Language.ES_MX, translation);
    }

    protected static String es_ni(String translation) {
        return translation(Language.ES_NI, translation);
    }

    protected static String es_pa(String translation) {
        return translation(Language.ES_PA, translation);
    }

    protected static String es_pe(String translation) {
        return translation(Language.ES_PE, translation);
    }

    protected static String es_pr(String translation) {
        return translation(Language.ES_PR, translation);
    }

    protected static String es_py(String translation) {
        return translation(Language.ES_PY, translation);
    }

    protected static String es_sv(String translation) {
        return translation(Language.ES_SV, translation);
    }

    protected static String es_uy(String translation) {
        return translation(Language.ES_UY, translation);
    }

    protected static String es_ve(String translation) {
        return translation(Language.ES_VE, translation);
    }

    protected static String et(String translation) {
        return translation(Language.ET, translation);
    }

    protected static String et_ee(String translation) {
        return translation(Language.ET_EE, translation);
    }

    protected static String eu(String translation) {
        return translation(Language.EU, translation);
    }

    protected static String eu_es(String translation) {
        return translation(Language.EU_ES, translation);
    }

    protected static String fa(String translation) {
        return translation(Language.FA, translation);
    }

    protected static String fa_ir(String translation) {
        return translation(Language.FA_IR, translation);
    }

    protected static String fi(String translation) {
        return translation(Language.FI, translation);
    }

    protected static String fi_fi(String translation) {
        return translation(Language.FI_FI, translation);
    }

    protected static String fo(String translation) {
        return translation(Language.FO, translation);
    }

    protected static String fo_fo(String translation) {
        return translation(Language.FO_FO, translation);
    }

    protected static String fr(String translation) {
        return translation(Language.FR, translation);
    }

    protected static String fr_be(String translation) {
        return translation(Language.FR_BE, translation);
    }

    protected static String fr_ca(String translation) {
        return translation(Language.FR_CA, translation);
    }

    protected static String fr_ch(String translation) {
        return translation(Language.FR_CH, translation);
    }

    protected static String fr_fr(String translation) {
        return translation(Language.FR_FR, translation);
    }

    protected static String fr_lu(String translation) {
        return translation(Language.FR_LU, translation);
    }

    protected static String fr_mc(String translation) {
        return translation(Language.FR_MC, translation);
    }

    protected static String gl(String translation) {
        return translation(Language.GL, translation);
    }

    protected static String gl_es(String translation) {
        return translation(Language.GL_ES, translation);
    }

    protected static String gu(String translation) {
        return translation(Language.GU, translation);
    }

    protected static String gu_in(String translation) {
        return translation(Language.GU_IN, translation);
    }

    protected static String he(String translation) {
        return translation(Language.HE, translation);
    }

    protected static String he_il(String translation) {
        return translation(Language.HE_IL, translation);
    }

    protected static String hi(String translation) {
        return translation(Language.HI, translation);
    }

    protected static String hi_in(String translation) {
        return translation(Language.HI_IN, translation);
    }

    protected static String hr(String translation) {
        return translation(Language.HR, translation);
    }

    protected static String hr_ba(String translation) {
        return translation(Language.HR_BA, translation);
    }

    protected static String hr_hr(String translation) {
        return translation(Language.HR_HR, translation);
    }

    protected static String hu(String translation) {
        return translation(Language.HU, translation);
    }

    protected static String hu_hu(String translation) {
        return translation(Language.HU_HU, translation);
    }

    protected static String hy(String translation) {
        return translation(Language.HY, translation);
    }

    protected static String hy_am(String translation) {
        return translation(Language.HY_AM, translation);
    }

    protected static String id(String translation) {
        return translation(Language.ID, translation);
    }

    protected static String id_id(String translation) {
        return translation(Language.ID_ID, translation);
    }

    protected static String is(String translation) {
        return translation(Language.IS, translation);
    }

    protected static String is_is(String translation) {
        return translation(Language.IS_IS, translation);
    }

    protected static String it(String translation) {
        return translation(Language.IT, translation);
    }

    protected static String it_ch(String translation) {
        return translation(Language.IT_CH, translation);
    }

    protected static String it_it(String translation) {
        return translation(Language.IT_IT, translation);
    }

    protected static String ja(String translation) {
        return translation(Language.JA, translation);
    }

    protected static String ja_jp(String translation) {
        return translation(Language.JA_JP, translation);
    }

    protected static String ka(String translation) {
        return translation(Language.KA, translation);
    }

    protected static String ka_ge(String translation) {
        return translation(Language.KA_GE, translation);
    }

    protected static String kk(String translation) {
        return translation(Language.KK, translation);
    }

    protected static String kk_kz(String translation) {
        return translation(Language.KK_KZ, translation);
    }

    protected static String kn(String translation) {
        return translation(Language.KN, translation);
    }

    protected static String kn_in(String translation) {
        return translation(Language.KN_IN, translation);
    }

    protected static String ko(String translation) {
        return translation(Language.KO, translation);
    }

    protected static String ko_kr(String translation) {
        return translation(Language.KO_KR, translation);
    }

    protected static String kok(String translation) {
        return translation(Language.KOK, translation);
    }

    protected static String kok_in(String translation) {
        return translation(Language.KOK_IN, translation);
    }

    protected static String ky(String translation) {
        return translation(Language.KY, translation);
    }

    protected static String ky_kg(String translation) {
        return translation(Language.KY_KG, translation);
    }

    protected static String lt(String translation) {
        return translation(Language.LT, translation);
    }

    protected static String lt_lt(String translation) {
        return translation(Language.LT_LT, translation);
    }

    protected static String lv(String translation) {
        return translation(Language.LV, translation);
    }

    protected static String lv_lv(String translation) {
        return translation(Language.LV_LV, translation);
    }

    protected static String mi(String translation) {
        return translation(Language.MI, translation);
    }

    protected static String mi_nz(String translation) {
        return translation(Language.MI_NZ, translation);
    }

    protected static String mk(String translation) {
        return translation(Language.MK, translation);
    }

    protected static String mk_mk(String translation) {
        return translation(Language.MK_MK, translation);
    }

    protected static String mn(String translation) {
        return translation(Language.MN, translation);
    }

    protected static String mn_mn(String translation) {
        return translation(Language.MN_MN, translation);
    }

    protected static String mr(String translation) {
        return translation(Language.MR, translation);
    }

    protected static String mr_in(String translation) {
        return translation(Language.MR_IN, translation);
    }

    protected static String ms(String translation) {
        return translation(Language.MS, translation);
    }

    protected static String ms_bn(String translation) {
        return translation(Language.MS_BN, translation);
    }

    protected static String ms_my(String translation) {
        return translation(Language.MS_MY, translation);
    }

    protected static String mt(String translation) {
        return translation(Language.MT, translation);
    }

    protected static String mt_mt(String translation) {
        return translation(Language.MT_MT, translation);
    }

    protected static String nb(String translation) {
        return translation(Language.NB, translation);
    }

    protected static String nb_no(String translation) {
        return translation(Language.NB_NO, translation);
    }

    protected static String nl(String translation) {
        return translation(Language.NL, translation);
    }

    protected static String nl_be(String translation) {
        return translation(Language.NL_BE, translation);
    }

    protected static String nl_nl(String translation) {
        return translation(Language.NL_NL, translation);
    }

    protected static String nn_no(String translation) {
        return translation(Language.NN_NO, translation);
    }

    protected static String ns(String translation) {
        return translation(Language.NS, translation);
    }

    protected static String ns_za(String translation) {
        return translation(Language.NS_ZA, translation);
    }

    protected static String pa(String translation) {
        return translation(Language.PA, translation);
    }

    protected static String pa_in(String translation) {
        return translation(Language.PA_IN, translation);
    }

    protected static String pl(String translation) {
        return translation(Language.PL, translation);
    }

    protected static String pl_pl(String translation) {
        return translation(Language.PL_PL, translation);
    }

    protected static String ps(String translation) {
        return translation(Language.PS, translation);
    }

    protected static String ps_ar(String translation) {
        return translation(Language.PS_AR, translation);
    }

    protected static String pt(String translation) {
        return translation(Language.PT, translation);
    }

    protected static String pt_br(String translation) {
        return translation(Language.PT_BR, translation);
    }

    protected static String pt_pt(String translation) {
        return translation(Language.PT_PT, translation);
    }

    protected static String qu(String translation) {
        return translation(Language.QU, translation);
    }

    protected static String qu_bo(String translation) {
        return translation(Language.QU_BO, translation);
    }

    protected static String qu_ec(String translation) {
        return translation(Language.QU_EC, translation);
    }

    protected static String qu_pe(String translation) {
        return translation(Language.QU_PE, translation);
    }

    protected static String ro(String translation) {
        return translation(Language.RO, translation);
    }

    protected static String ro_ro(String translation) {
        return translation(Language.RO_RO, translation);
    }

    protected static String ru(String translation) {
        return translation(Language.RU, translation);
    }

    protected static String ru_ru(String translation) {
        return translation(Language.RU_RU, translation);
    }

    protected static String sa(String translation) {
        return translation(Language.SA, translation);
    }

    protected static String sa_in(String translation) {
        return translation(Language.SA_IN, translation);
    }

    protected static String se(String translation) {
        return translation(Language.SE, translation);
    }

    protected static String se_fi(String translation) {
        return translation(Language.SE_FI, translation);
    }

    protected static String se_no(String translation) {
        return translation(Language.SE_NO, translation);
    }

    protected static String se_se(String translation) {
        return translation(Language.SE_SE, translation);
    }

    protected static String sk(String translation) {
        return translation(Language.SK, translation);
    }

    protected static String sk_sk(String translation) {
        return translation(Language.SK_SK, translation);
    }

    protected static String sl(String translation) {
        return translation(Language.SL, translation);
    }

    protected static String sl_si(String translation) {
        return translation(Language.SL_SI, translation);
    }

    protected static String sq(String translation) {
        return translation(Language.SQ, translation);
    }

    protected static String sq_al(String translation) {
        return translation(Language.SQ_AL, translation);
    }

    protected static String sr_ba(String translation) {
        return translation(Language.SR_BA, translation);
    }

    protected static String sr_sp(String translation) {
        return translation(Language.SR_SP, translation);
    }

    protected static String sv(String translation) {
        return translation(Language.SV, translation);
    }

    protected static String sv_fi(String translation) {
        return translation(Language.SV_FI, translation);
    }

    protected static String sv_se(String translation) {
        return translation(Language.SV_SE, translation);
    }

    protected static String sw(String translation) {
        return translation(Language.SW, translation);
    }

    protected static String sw_ke(String translation) {
        return translation(Language.SW_KE, translation);
    }

    protected static String syr(String translation) {
        return translation(Language.SYR, translation);
    }

    protected static String syr_sy(String translation) {
        return translation(Language.SYR_SY, translation);
    }

    protected static String ta(String translation) {
        return translation(Language.TA, translation);
    }

    protected static String ta_in(String translation) {
        return translation(Language.TA_IN, translation);
    }

    protected static String te(String translation) {
        return translation(Language.TE, translation);
    }

    protected static String te_in(String translation) {
        return translation(Language.TE_IN, translation);
    }

    protected static String th(String translation) {
        return translation(Language.TH, translation);
    }

    protected static String th_th(String translation) {
        return translation(Language.TH_TH, translation);
    }

    protected static String tl(String translation) {
        return translation(Language.TL, translation);
    }

    protected static String tl_ph(String translation) {
        return translation(Language.TL_PH, translation);
    }

    protected static String tn(String translation) {
        return translation(Language.TN, translation);
    }

    protected static String tn_za(String translation) {
        return translation(Language.TN_ZA, translation);
    }

    protected static String tr(String translation) {
        return translation(Language.TR, translation);
    }

    protected static String tr_tr(String translation) {
        return translation(Language.TR_TR, translation);
    }

    protected static String tt(String translation) {
        return translation(Language.TT, translation);
    }

    protected static String tt_ru(String translation) {
        return translation(Language.TT_RU, translation);
    }

    protected static String ts(String translation) {
        return translation(Language.TS, translation);
    }

    protected static String uk(String translation) {
        return translation(Language.UK, translation);
    }

    protected static String uk_ua(String translation) {
        return translation(Language.UK_UA, translation);
    }

    protected static String ur(String translation) {
        return translation(Language.UR, translation);
    }

    protected static String ur_pk(String translation) {
        return translation(Language.UR_PK, translation);
    }

    protected static String uz(String translation) {
        return translation(Language.UZ, translation);
    }

    protected static String uz_uz(String translation) {
        return translation(Language.UZ_UZ, translation);
    }

    protected static String vi(String translation) {
        return translation(Language.VI, translation);
    }

    protected static String vi_vn(String translation) {
        return translation(Language.VI_VN, translation);
    }

    protected static String xh(String translation) {
        return translation(Language.XH, translation);
    }

    protected static String xh_za(String translation) {
        return translation(Language.XH_ZA, translation);
    }

    protected static String zh(String translation) {
        return translation(Language.ZH, translation);
    }

    protected static String zh_cn(String translation) {
        return translation(Language.ZH_CN, translation);
    }

    protected static String zh_hk(String translation) {
        return translation(Language.ZH_HK, translation);
    }

    protected static String zh_mo(String translation) {
        return translation(Language.ZH_MO, translation);
    }

    protected static String zh_sg(String translation) {
        return translation(Language.ZH_SG, translation);
    }

    protected static String zh_tw(String translation) {
        return translation(Language.ZH_TW, translation);
    }

    protected static String zu(String translation) {
        return translation(Language.ZU, translation);
    }

    protected static String zu_za(String translation) {
        return translation(Language.ZU_ZA, translation);
    }

}
