package com.sunshineroad.driverschool.cscompletionreport.service;

import java.util.List;
 
import com.sunshineroad.driverschool.cscompletionreport.entity.CsCompletionReport;
import com.sunshineroad.driverschool.cscompletionreport.entityvo.CsCompletionReportVo;
import com.sunshineroad.framework.support.service.IBaseService;

public interface CsCompletionReportService extends IBaseService<CsCompletionReport, Integer>{
	public List<CsCompletionReportVo> list(CsCompletionReport entity) ;
}
