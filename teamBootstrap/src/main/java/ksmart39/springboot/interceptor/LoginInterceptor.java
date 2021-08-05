package ksmart39.springboot.interceptor;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import ksmart39.springboot.controller.LoginController;

@Component
public class LoginInterceptor implements HandlerInterceptor{
	
	private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		String sessionId = (String)	session.getAttribute("SID"); 
		int sessionLevel = (int)	session.getAttribute("SLEVEL"); 
		
		String[] adminUri = {"/rawMaterials/addInWarehousing", "/rawMaterials/addExWarehousing", "/quality/qualityInspectionRequest",
							 "/quality/addDefectiveProduct", "/system/addHumanResources", "/system/addClient", "/system/addRawMaterials",
							 "/system/addProductionProcess", "/system/addQualityInspection", "/production/stopProcessByProduct", "/production/startProcessByProduct",
							 "/production/pCodeToStartSend", "/quality/addInspectionMeasurementValue", "/quality/getQulityInspectionCategory", "/quality/addInspectionMeasurementValue",
							 "/quality/qualityInspectionRequest", "/quality/getFinalResult", "/quality/modifyDefectiveProduct", "/quality/modifyQualityInspectionRequest", "/quality/approvalInspectionRequest",
							 "/rawMaterials/modifyExHousing", "/rawMaterials/deleteExHousing", "/rawMaterials/modifyInWarehousing", "/system/modifyHumanResources", "/system/deleteHumanResources", "/system/modifyClient", "/system/deleteClient",
							 "/system/modifyRawMaterials"};
		
		String[] facUri = {"/contract/addBuyerOrder", "/contract/addBuyerContract", "/contract/addSupplierRequest", 
						   "/contract/addSupplierContract", "/production/addProductionPlan", "/production/addWorkOrder", "/quality/addStandardTable",
						   "/shipment/addShipmentOrder", "/shipment/addShipmentInvoice", "/shipment/addShipment", "/system/addHumanResources",
						   "/system/addClient", "/contract/modifyBuyerOrder", "/contract/completeRequest", "/contract/modifyBuyerContract", "/contract/deleteSupplierContract",
						   "/contract/modifySupplierContract", "/contract/deleteSupplierRequest", "/contract/modifySupplierRequest", "/contract/addBuyerOrderSize", "/contract/getMeasurementPart",
						   "/contract/getDetailedCategorizedName", "/production/deleteProductionPlan", "/production/modifyProductionPlan", "/production/modifyWorkOrder",
						   "/shipment/deleteShipmentInvoice", "/shipment/modifyShipmentInvoice", "/shipment/searchInvoiceCode", "/shipment/deleteShipmentOrder", "/shipment/modifyShipmentOrder",
						   "/shipment/modifyShipment", "/system/deleteInspection", "/system/modifyQualityInspection", "/system/modifyHumanResources", "/system/deleteHumanResources", "/system/modifyClient", "/system/deleteClient"};		
		
		ArrayList<String> adminUriList = new ArrayList<>(Arrays.asList(adminUri));
		ArrayList<String> facUriList = new ArrayList<>(Arrays.asList(facUri));
		log.info("adminUriList 확인 :{}", adminUriList);
		log.info("facUriList 확인 :{}", facUriList);
		String uirAddr = request.getRequestURI();
		if(sessionId == null) {
			response.sendRedirect("/"); 
			return false; 
		}else {
			log.info("uirAddr 확인:{}", uirAddr);
			if(sessionLevel == 3 && adminUriList.contains(uirAddr)) {
				response.sendRedirect("/mesmain");
				return false;
			}
			return true;
		}
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
