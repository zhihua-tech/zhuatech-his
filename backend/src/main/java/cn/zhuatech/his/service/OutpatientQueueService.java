/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.his.service;
import jakarta.validation.constraints.*;import org.springframework.stereotype.Service;import java.util.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Service public class OutpatientQueueService {
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public Result forecast(Request r){int projected=Math.max(0,r.waitingPatients()+r.expectedArrivals30Minutes()-r.doctors()*Math.max(1,30/r.averageServiceMinutes()));int wait=(int)Math.ceil(projected*r.averageServiceMinutes()/(double)r.doctors());String status=r.criticalPatients()>0||wait>r.maximumWaitMinutes()*1.5?"SURGE":wait>r.maximumWaitMinutes()?"REBALANCE":"NORMAL";List<String> actions=new ArrayList<>();if(r.criticalPatients()>0)actions.add("优先分诊危急患者并通知急诊团队");if(wait>r.maximumWaitMinutes())actions.add("开放机动诊室或跨科调配医生");if(projected>r.waitingPatients())actions.add("向候诊患者推送预计等待时间");if(actions.isEmpty())actions.add("候诊压力可控，维持当前排班");return new Result(projected,wait,status,actions);}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public record Request(@Min(0) int waitingPatients,@Min(1) int doctors,@Min(1) int averageServiceMinutes,@Min(0) int expectedArrivals30Minutes,@Min(0) int criticalPatients,@Min(1) int maximumWaitMinutes){}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public record Result(int projectedQueue,int estimatedWaitMinutes,String status,List<String> actions){}
}
