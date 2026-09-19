/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.his.controller;

import cn.zhuatech.his.common.ApiResponse;
import cn.zhuatech.his.service.PatientDischargeReadinessService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController
@RequestMapping("/api/enterprise/his")
public class PatientDischargeReadinessController {
    private final PatientDischargeReadinessService service;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public PatientDischargeReadinessController(PatientDischargeReadinessService service) { this.service = service; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/patient-discharge-readiness")
    public ApiResponse<PatientDischargeReadinessService.Assessment> assess(
            @Valid @RequestBody PatientDischargeReadinessService.Request request) {
        return ApiResponse.ok(service.assess(request));
    }
}
