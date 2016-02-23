package com.easygame.sdk.controller.backend.market;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.easygame.sdk.common.util.Page;
import com.easygame.sdk.controller.BaseController;
import com.easygame.sdk.repository.model.dto.backend.market.AppInformationModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.market.AppModifyDTO;
import com.easygame.sdk.repository.model.dto.backend.market.AppSearchCriteriaDTO;
import com.easygame.sdk.repository.model.vo.backend.market.AppShowVO;
import com.easygame.sdk.repository.model.vo.backend.market.AppTypeShowVO;
import com.easygame.sdk.repository.model.vo.backend.market.AppVersionShowVO;
import com.easygame.sdk.service.api.backend.market.IAppBiz;

/** 应用业务控制器 */
@Controller
@RequestMapping(value = "/backend/market/appController")
public class AppController extends BaseController {

	@Autowired
	private IAppBiz appBiz;

	/** 跳转到添加应用页面 */
	@RequestMapping(value = "/appAddPage", method = RequestMethod.GET)
	public String appAddPage(HttpServletRequest request, ModelMap modelMap) {
		
		List<AppTypeShowVO> appTypeList = appBiz.selectAllAppType();
		modelMap.addAttribute("appTypeList", appTypeList);
		
		return "/backend/market/appAdd";
		
	}

	/** 添加应用 */
	@RequestMapping(value = "/appAdd", method = RequestMethod.POST)
	public String appAdd(HttpServletRequest request, @Valid @ModelAttribute AppModifyDTO app, BindingResult bindingResult, ModelMap modelMap) {
		
		if (appBiz.checkAppDuplication(app.getName(), 0) > 0) {
			
			bindingResult.rejectValue("name", null, "已经存在相同名称的应用");
			
		}
		
		if (bindingResult.hasErrors()) {
			
			List<AppTypeShowVO> appTypeList = appBiz.selectAllAppType();
			
			modelMap.addAttribute("appTypeList", appTypeList);
			modelMap.addAttribute("app", app);
			modelMap.addAttribute("errors", bindingResult.getAllErrors());
			
			return "/backend/market/appAdd";
			
		}
		
		appBiz.insertApp(app);
		
		return "redirect:/backend/market/appController/appList.do";
		
	}

	/** 跳转到修改应用页面 */
	@RequestMapping(value = "/appUpdatePage", method = RequestMethod.GET)
	public String appUpdatePage(HttpServletRequest request, int id, ModelMap modelMap) {
		
		List<AppTypeShowVO> appTypeList = appBiz.selectAllAppType();
		// AppModifyDTO app = appBiz.selectAppForUpdate(id);
		// page.addObject("app", app);
		modelMap.addAttribute("appTypeList", appTypeList);
		
		return "/backend/market/appUpdate";
	}

	/** 更新应用 */
	@RequestMapping(value = "/appUpdate", method = RequestMethod.POST)
	public String appUpdate(HttpServletRequest request, AppInformationModifyDTO app, BindingResult bindingResult, ModelMap modelMap) {
		
//		String[] s = app.getDescription().split("\n");
		// if (appBiz.checkAppDuplication(app.getName(), app.getId()) > 0) {
		// bindingResult.rejectValue("name", null, "已经存在相同名称的应用");
		// }
		// if (bindingResult.hasErrors()) {
		// List<AppTypeShowVO> appTypeList = appBiz.selectAllAppType();
		// List<ObjectError> fieldErrors = bindingResult.getAllErrors();
		// modelMap.addAttribute("appTypeList", appTypeList);
		// modelMap.addAttribute("app", app);
		// modelMap.addAttribute("errors", fieldErrors);
		// return "/ads/appUpdate";
		// }
		// appBiz.updateApp(app);
		
		return "redirect:/backend/market/appController/appList.do";
		
	}

	/** 查找应用 */
	@RequestMapping(value = "/appList", method = { RequestMethod.GET, RequestMethod.POST })
	public String findApp(HttpServletRequest request, AppSearchCriteriaDTO criteria, ModelMap modelMap) {
		
		request.getSession().setAttribute("currentPage", "appPermission");
		
		if (criteria.getPagination() == null) {
			
			criteria.setPagination(new Page());
			
		}
		
		List<AppTypeShowVO> appTypeList = appBiz.selectAllAppType();
		List<AppShowVO> appList = appBiz.selectAppListByCriteria(criteria);
		criteria.getPagination().setTotalCount(appBiz.getAppListTotalCountByCriteria(criteria));
		
		modelMap.addAttribute("appTypeList", appTypeList);
		modelMap.addAttribute("appList", appList);
		modelMap.addAttribute("criteria", criteria);
		modelMap.addAttribute("pagination", criteria.getPagination());
		
		return "/backend/market/appList";
	}

	/** 删除应用 */
	@RequestMapping(value = "/appDelete", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody String appDelete(HttpServletRequest request, int id) {
		
		int success = 0;
		
		success = appBiz.deleteApp(id);
		
		return success + "";
		
	}

	@RequestMapping(value = "/appUploadPage", method = RequestMethod.GET)
	public String appUploadPage(int id) {
		
		return "/backend/market/appUpload";
		
	}

	@RequestMapping(value = "/appUpload", method = RequestMethod.POST)
	public @ResponseBody String appUpload(MultipartHttpServletRequest request) {
		
		MultipartFile file = request.getFile("apkFile");
		if (file != null && !"".equals(file)) {
			System.out.println(file.getOriginalFilename() + ":"
					+ file.getSize());
			try {
				File localFile = new File("/Users/fromgrey/"
						+ file.getOriginalFilename());
				 file.transferTo(localFile);
				SaveFileFromInputStream(file.getInputStream(),
						"/Users/fromgrey/", file.getOriginalFilename(),
						request.getSession());
				FileOutputStream fs = new FileOutputStream("/Users/fromgrey/"
						+ "/" + file.getOriginalFilename());
				byte[] buffer = new byte[1024 * 1024];
				int bytesum = 0;
				int byteread = 0;
				while ((byteread = file.getInputStream().read(buffer)) != -1) {
					bytesum += byteread;
					fs.write(buffer, 0, byteread);
					fs.flush();
				}
				fs.close();
				file.getInputStream().close();
			} catch (IOException e) {
				return "failure";
			}
		}
		
		return "success";
		
	}

	public void SaveFileFromInputStream(InputStream stream, String path, String filename, HttpSession session) throws IOException {
		FileOutputStream fs = new FileOutputStream(path + "/" + filename);
		byte[] buffer = new byte[1024 * 1024];
		int bytesum = 0;
		int byteread = 0;
		while ((byteread = stream.read(buffer)) != -1) {
			bytesum += byteread;
			fs.write(buffer, 0, byteread);
			fs.flush();
		}
		fs.close();
		stream.close();
	}

	@RequestMapping(value = "/appVersionList", method = RequestMethod.GET)
	public String appVersionList(int id, Page pagination, ModelMap modelMap) {
		
		List<AppVersionShowVO> appVersionList = appBiz.selectAppVersionListByAppId(id, pagination);
		
		modelMap.addAttribute("appVersionList", appVersionList);
		modelMap.addAttribute("pagination", pagination);
		modelMap.addAttribute("appId",id);
		
		return "/backend/market/appVersionList";
	}

	@RequestMapping(value = "/appVersionAddPage", method = RequestMethod.GET)
	public String appVersionAddPage(int id, ModelMap modelMap) {
		
		modelMap.addAttribute("appId", id);
		
		return "/backend/market/appVersionAdd";
		
	}


	@RequestMapping(value = "/appDownloadUrlList", method = RequestMethod.GET)
	public String appDownloadUrlList(int id) {
		
		return "/backend/market/appDownloadUrlList";
		
	}

	@RequestMapping(value = "/appDownloadUrlAddPage", method = RequestMethod.GET)
	public String appDownloadUrlAddPage() {
		
		return "/backend/market/appDownloadUrlAdd";
		
	}

}
