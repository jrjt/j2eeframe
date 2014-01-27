package com.sunshineroad.driverschool.cscompletionreport.controller;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sunshineroad.framework.support.service.IBaseService;
import com.sunshineroad.framework.util.ResponseUtils;
import com.sunshineroad.framework.util.WebUtils; 

import com.sunshineroad.driverschool.cscompletionreport.entity.CsCompletionReport;
import com.sunshineroad.driverschool.cscompletionreport.entityvo.CsCompletionReportVo;
import com.sunshineroad.driverschool.cscompletionreport.service.CsCompletionReportService;

import com.sunshineroad.framework.support.controller.impl.BaseControllerImpl;

import org.apache.log4j.Logger;
/**   
 * @Title: Controller
 * @Description: 完工报告
 * @author auto Generate
 * @date 2014-01-15 11:57:33
 * @version V1.0   
 *
 */
 
 
	
@Controller
@RequestMapping(value="csCompletionReport")
public class CsCompletionReportController extends BaseControllerImpl {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(CsCompletionReportController.class);

	public CsCompletionReportController(){		
	}

	@Autowired
	private CsCompletionReportService csCompletionReportService;
	 
 
 @RequestMapping(value="list",method=RequestMethod.GET)
	public @ResponseBody Object list( ){
	 	 HttpServletRequest request =WebUtils.getRequestByContext();
		CsCompletionReport csCompletionReport= new CsCompletionReport();
		String paramReportNumber = request.getParameter("paramReportId");
		String paramcontractNumber = request.getParameter("paramcontractNumber");
		String paramReportType = request.getParameter("paramReportType");
		
		if (null!=paramReportNumber||null!=paramcontractNumber||null!=paramReportType) {
			byte b[];
			try {
				b = paramReportNumber.getBytes("GBK"); 
				paramReportNumber = new String(b);
				
				b = paramcontractNumber.getBytes("GBK"); 
				paramcontractNumber = new String(b);
				
				b = paramReportType.getBytes("GBK");
				paramReportType = new String(b);
			} catch (UnsupportedEncodingException e) {
				paramReportNumber = null;
				paramcontractNumber = null;
				paramReportType = null;
			}
			if (null!=paramReportNumber||null!=paramcontractNumber||null!=paramReportType) {
				csCompletionReport.setReportNumber(paramReportNumber);
				csCompletionReport.setContractNumber(paramcontractNumber);
				csCompletionReport.setReportType(paramReportType);
			}
		}
		
		return ResponseUtils.sendPagination(csCompletionReportService.list(csCompletionReport)) ;
	}
 
	@RequestMapping(value="update",  method=RequestMethod.PUT)
	public @ResponseBody Object update(@RequestBody CsCompletionReportVo csCompletionReportVo) throws Exception{
		CsCompletionReport csCompletionReport =new CsCompletionReport();
		csCompletionReport.setId(csCompletionReportVo.getId());
		PropertyUtils.copyProperties(csCompletionReport, csCompletionReportVo);
		this.csCompletionReportService.update(csCompletionReport);
		return ResponseUtils.sendSuccess("保存成功");
	}
	
	@RequestMapping(value="create",method=RequestMethod.POST)
	public @ResponseBody Object save(@RequestBody CsCompletionReportVo csCompletionReportVo) throws Exception{
		CsCompletionReport csCompletionReport =new CsCompletionReport();
		PropertyUtils.copyProperties(csCompletionReport, csCompletionReportVo);
		return ResponseUtils.sendSuccess("保存成功",this.csCompletionReportService.save(csCompletionReport).getId());
	}
	
	@RequestMapping(value="delete",method=RequestMethod.DELETE)
	public @ResponseBody Object delete(@RequestBody CsCompletionReportVo vo) throws Exception{
		CsCompletionReport bo=new CsCompletionReport();
		bo.setId(vo.getId());
		this.csCompletionReportService.delete(bo);
		return ResponseUtils.sendSuccess("删除成功");
	}
    
 
  
}
