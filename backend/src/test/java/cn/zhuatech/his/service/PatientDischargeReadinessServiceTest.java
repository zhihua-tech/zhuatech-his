/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.his.service;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
class PatientDischargeReadinessServiceTest {
    private final PatientDischargeReadinessService service = new PatientDischargeReadinessService();
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void dischargesReadyPatient() {
        var result = service.assess(new PatientDischargeReadinessService.Request("E1", true, true, true,
                true, 0, true, true, true, true));
        assertThat(result.decision()).isEqualTo(PatientDischargeReadinessService.Decision.DISCHARGE);
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void coordinatesOperationalTasks() {
        var result = service.assess(new PatientDischargeReadinessService.Request("E2", true, true, true,
                true, 0, true, false, false, false));
        assertThat(result.actions()).hasSize(3);
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void blocksClinicalSafetyGaps() {
        var result = service.assess(new PatientDischargeReadinessService.Request("E3", false, false, false,
                false, 2, false, true, true, true));
        assertThat(result.blockers()).hasSize(6);
    }
}
