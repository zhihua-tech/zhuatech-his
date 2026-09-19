/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.his;
import cn.zhuatech.his.service.OutpatientQueueService;import org.junit.jupiter.api.Test;import static org.junit.jupiter.api.Assertions.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
class OutpatientQueueServiceTests {private final OutpatientQueueService service=new OutpatientQueueService();/**
                                                                                                              * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                              */
@Test void startsSurgeForCriticalQueue(){var r=service.forecast(new OutpatientQueueService.Request(40,2,15,20,1,60));assertEquals("SURGE",r.status());}/**
                                                                                                                                                                                                                                                                     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                     */
@Test void keepsShortQueueNormal(){var r=service.forecast(new OutpatientQueueService.Request(5,3,10,3,0,60));assertEquals("NORMAL",r.status());}}
