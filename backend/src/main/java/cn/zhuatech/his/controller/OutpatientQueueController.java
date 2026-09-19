/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.his.controller;
import cn.zhuatech.his.common.ApiResponse;import cn.zhuatech.his.service.OutpatientQueueService;import jakarta.validation.Valid;import org.springframework.web.bind.annotation.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController @RequestMapping("/api/his/insights/outpatient-queue") public class OutpatientQueueController {private final OutpatientQueueService service;/**
                                                                                                                                                            * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                            */
public OutpatientQueueController(OutpatientQueueService service){this.service=service;}/**
                                                                                                                                                                                                                                                   * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                   */
@PostMapping ApiResponse<OutpatientQueueService.Result> forecast(@Valid @RequestBody OutpatientQueueService.Request request){return ApiResponse.ok(service.forecast(request));}}
