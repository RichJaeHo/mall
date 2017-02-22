package com.shopping.mall.controller;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shopping.mall.common.Util;
import com.shopping.mall.dto.PdaProductDto;
import com.shopping.mall.dto.PjhMemberDto;
import com.shopping.mall.dto.PjhMyCartDto;
import com.shopping.mall.dto.PjhProductAdverDto;
import com.shopping.mall.service.PdaProductService;



@Controller
public class PdaProductController {
	
	@Autowired
	@Qualifier(value="PdaProductService")
	private PdaProductService pdaProductService;
	
	//나의 상품 카테고리 페이지 이동
	@RequestMapping(value="/myProduct.action", method=RequestMethod.GET)
	public String myProduct(){
		 System.out.println("Myproduct 들어옴");
		 return "myaccount";
	}
	
	//상품 카테고리 조회
	@ResponseBody
	@RequestMapping(value="/registerform.action", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public String requestCategoryList(PdaProductDto pdaProductDto) {
		
		List<PdaProductDto> category1List = pdaProductService.requestCategory1List(pdaProductDto);
		List<PdaProductDto> category2List = pdaProductService.requestCategory2List(pdaProductDto);
		
//		List<PdaProductDto> list = new ArrayList<>();
//		list.addAll(category1List);
//		list.addAll(category2List);

		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String category1 = gson.toJson(category1List);
		String category2 = gson.toJson(category2List);
		String list = category1 + "#" + category2;
		list = gson.toJson(list);
//		String categoriesJson = "";
//        categoriesJson += "{";
//        categoriesJson += "        'category1' : ";
//        categoriesJson +=                        category1;
//        categoriesJson +=                                    ",";
//        categoriesJson += "        'category2' : ";
//        categoriesJson +=                        category2;
//        categoriesJson += "}";

        return list;
		
	}
	
	//상품 등록
	@RequestMapping(value="/register.action", method = RequestMethod.POST)
	public String registerProductInfo(PdaProductDto pdaProductDto, MultipartHttpServletRequest mReq, HttpSession session) {

		System.out.println("Product register 들어옴 : " + pdaProductDto.toString());
	
		//사용자(세션) 정보 저장
		String memberId = ((PjhMemberDto)session.getAttribute("session")).getMemberId();
		pdaProductDto.setMemberId(memberId);
		
		//상품 등록 
		//1. 이미지 전송데이터 읽기
		String path = mReq.getRealPath("/resources/imagefile");//실제 파일을 저장할 경로
		System.out.println(path);
		
//		PdaProductImageDto f = new PdaProductImageDto();
		
		List<String> oriNameList = new ArrayList();
		List<String> fileNameList = new ArrayList();
		
		try {
//			PdaProductImageDto 테이블에 insert할 데이터를 저장할 객체
//			ArrayList<PdaProductImageDto> files = new ArrayList<>();

			List<MultipartFile> uploadedFiles = mReq.getFiles("fileUp");
			for (MultipartFile mFile : uploadedFiles) {
				if (mFile != null && mFile.getSize() > 0) {
					String fileName = mFile.getOriginalFilename();
					//C:\\AAA\\BBB\\CCC.txt -> CCC.txt
					if (fileName.contains("\\")) {
						fileName = fileName.substring(
							fileName.lastIndexOf("\\") + 1);
					}
								
					String uniqueFileName =
						Util.getUniqueFileName(path, fileName);
					//업로드된 파일을 지정된 경로에 저장
					//(임시파일을 실제파일로 저장 or 메모리데이터를 파일로 저장)
					mFile.transferTo(new File(path, uniqueFileName));
								
//					f.setOriName(fileName);
//					f.setFileName("/mall/resources/imagefile/" + uniqueFileName);
					
					oriNameList.add(fileName);
					fileNameList.add("/mall/resources/imagefile/" + uniqueFileName);
//					files.add(f);
					
				}
			}						
			//데이터베이스에 데이터 insert(상품정보, 이미지 정보)
			pdaProductService.registerProductInfo(pdaProductDto, oriNameList, fileNameList); //product insert
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return "redirect:/success.action";
	}
	
	//상품 등록 성공 페이지 이동
	@RequestMapping(value="/success.action", method=RequestMethod.GET)
	public String success() {
		 System.out.println("상품 등록 성공");
		 return "/pda/product/register-successform";
	}
	

	
	
	//상품 목록 조회
	@ResponseBody
	@RequestMapping(value="/list.action", method = RequestMethod.GET, produces="text/plain;charset=UTF-8")
	public String requestList(HttpSession session) {
	
		System.out.println("list 요청 들어옴");
		
		String memberId = ((PjhMemberDto)session.getAttribute("session")).getMemberId();
		System.out.println(memberId);
		
		List<PdaProductDto> myProduct = pdaProductService.findMyProductList(memberId);
		
		for(PdaProductDto pdaMyProductDto : myProduct) {
			System.out.println("상품 번호 : " + pdaMyProductDto.getProductNo());
		}
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String data = gson.toJson(myProduct);
		
        return data;
		
	}
	
	//상품 상세 정보 조회
	@RequestMapping(value="/detail.action", method=RequestMethod.GET)
	public ModelAndView datailInfo(int productNo){
		
		System.out.println("detail 들어옴 : " + productNo);
		
		PdaProductDto product =  pdaProductService.findDetailInfoByProductNo(productNo);
	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("pda/product/detail");
		mav.addObject("product", product);
		
		return mav;
	}
	
	//상품 삭제
	@RequestMapping(value="/delete.action", method=RequestMethod.GET)
	public String delete(String productNo) {
		 System.out.println("상품 삭제 성공");
		 
		 pdaProductService.removeProductByProductNo(productNo);
		 
		 return "/pda/product/delete-successform";
	}	
	
	//상품 수정 페이지 이동
	@RequestMapping(value="/modify.action", method=RequestMethod.GET)
	public ModelAndView modify(int productNo){
		
		System.out.println("modify 들어옴 : " + productNo);
		
		PdaProductDto product =  pdaProductService.findDetailInfoByProductNo(productNo);
	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("pda/product/modify-form");
		mav.addObject("product", product);
		
		return mav;
	}
	
	//상품 수정
	@RequestMapping(value="/modify.action", method = RequestMethod.POST)
	public String modifyProduct(PdaProductDto pdaProductDto) {

		System.out.println("Product modify 들어옴 : " + pdaProductDto.toString());
		
		System.out.println("ProductNo : " + pdaProductDto.getProductNo());
		System.out.println("category1 : " + pdaProductDto.getCategory1());
		System.out.println("category2 : " + pdaProductDto.getCategory2());
		System.out.println("name : " + pdaProductDto.getName());
		System.out.println("price : " + pdaProductDto.getPrice());
		System.out.println("qty : " + pdaProductDto.getQty());
		
		
		pdaProductService.modifyProductInfoByProductNo(pdaProductDto); //product update
		
		return "redirect:/modifysuccess.action";
	}
	
	//상품 수정 성공 페이지 이동
	@RequestMapping(value="/modifysuccess.action", method=RequestMethod.GET)
	public String modfiySuccess() {
		 System.out.println("상품 수정 성공");
		 return "/pda/product/modify-successform";
	}
	
	
}
