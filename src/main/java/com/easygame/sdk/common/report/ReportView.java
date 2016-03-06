package com.easygame.sdk.common.report;

import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

public class ReportView extends AbstractView {

	private String reportTemplateName = null;

	private String fileType = null;
	
	private Collection<?> dataList = null;

	private IReportFileExporter reportFileExporter;
	
	protected void renderMergedOutputModel(Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) throws Exception {
//		JasperFillManager.fillReportToFile(FileUtils.getBasePhysicalPath()
//				+ "templates/" + reportTemplateName + ".jasper", params,
//				new JRBeanCollectionDataSource(dataList));
//
//		JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(new File(
//				FileUtils.getBasePhysicalPath() + "templates/"
//						+ reportTemplateName + ".jrprint"));
//
//		String filename = reportTemplateName
//				+ TimeUtils.getNowDate("yyyy_MM_dd_HH_mm_ss") + fileType;// 设置下载时客户端Excel的名称
//		response.setContentType("application/x-msdown;charset=utf-8");
//		response.setHeader("Content-disposition", "attachment;filename="
//				+ filename);
//
//		OutputStream ouputStream = response.getOutputStream();
//		reportFileExporter.export(jasperPrint, ouputStream);
//		ouputStream.flush();
//		ouputStream.close();
	}
	
	public Collection<?> getDataList() {
		return dataList;
	}

	public void setDataList(Collection<?> dataList) {
		this.dataList = dataList;
	}

	public String getReportTemplateName() {
		return reportTemplateName;
	}

	public void setReportTemplateName(String reportTemplateName) {
		this.reportTemplateName = reportTemplateName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public IReportFileExporter getReportFileExporter() {
		return reportFileExporter;
	}

	public void setReportFileExporter(IReportFileExporter reportFileExporter) {
		this.reportFileExporter = reportFileExporter;
	}

}
