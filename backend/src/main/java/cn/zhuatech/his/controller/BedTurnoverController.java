/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.his.controller;

import cn.zhuatech.his.common.ApiResponse;
import cn.zhuatech.his.service.BedTurnoverService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController
@RequestMapping("/api/admin/bed-turnover")
public class BedTurnoverController {
    private final BedTurnoverService service;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public BedTurnoverController(BedTurnoverService service) { this.service = service; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping
    ApiResponse<BedTurnoverService.TurnoverResult> evaluate(
        @Valid @RequestBody BedTurnoverService.TurnoverRequest request) {
        return ApiResponse.ok(service.evaluate(request));
    }
}
