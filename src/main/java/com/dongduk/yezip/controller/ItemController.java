package com.dongduk.yezip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.dongduk.yezip.domain.Item;

@Controller
public class ItemController {
	@GetMapping("/item-register")
	public String showRegisterItem() {
		return "register-item";
	}
	
	//@Autowired
    //private ItemService itemService; // 서비스 레이어를 사용하여 비즈니스 로직 처리

    @PostMapping("/item-register/{id}")
    public String registerItem(
    		@PathVariable("id") int id,
            @RequestParam("title") String title,
            @RequestParam("size") String size,
            @RequestParam("material") String material,
            @RequestParam("technique") String technique,
            @RequestParam("productionDate") String productionDate,
            @RequestParam("price") int price,
            @RequestParam("stock") int stock,
            @RequestParam("detail") String detail,
            @RequestParam("category") String[] categories,
            @RequestParam(value = "mainImage", required = false) MultipartFile mainImage,
            @RequestParam(value = "images", required = false) MultipartFile[] images,
            @RequestParam(value = "videos", required = false) MultipartFile[] videos,
            Model model) {

        /*// Item 객체 생성
        Item item = new Item();
        item.setTitle(title);
        item.setSize(size);
        item.setMaterial(material);
        item.setTechnique(technique);
        item.setProductionDate(productionDate);
        item.setPrice(price);
        item.setStock(stock);
        item.setDetail(detail);
        item.setCategories(Arrays.asList(categories));

        // 이미지 및 비디오 처리
        if (!mainImage.isEmpty()) {
            // 메인 이미지 저장 로직
            String mainImagePath = itemService.saveImage(mainImage);
            item.setMainImagePath(mainImagePath);
        }

        if (portfolioImages.length > 0) {
            for (MultipartFile portfolioImage : portfolioImages) {
                if (!portfolioImage.isEmpty()) {
                    String imagePath = itemService.saveImage(portfolioImage);
                    item.addPortfolioImage(imagePath);
                }
            }
        }

        if (portfolioVideos.length > 0) {
            for (MultipartFile portfolioVideo : portfolioVideos) {
                if (!portfolioVideo.isEmpty()) {
                    String videoPath = itemService.saveVideo(portfolioVideo);
                    item.addPortfolioVideo(videoPath);
                }
            }
        }

        // 아이템 저장
        itemService.saveItem(item);*/

        // 성공 메시지 또는 리디렉션
        model.addAttribute("message", "작품이 성공적으로 등록되었습니다!");
        return "redirect:/success"; // 성공 후 리디렉션할 페이지
    }
    
    @PostMapping("/item-update/{id}")
    public String updateItem(
            @PathVariable("id") int id,
            @RequestParam("title") String title,
            @RequestParam("size") String size,
            @RequestParam("material") String material,
            @RequestParam("technique") String technique,
            @RequestParam("productionDate") String productionDate,
            @RequestParam("price") int price,
            @RequestParam("stock") int stock,
            @RequestParam("detail") String detail,
            @RequestParam("category") String[] categories,
            @RequestParam(value = "mainImage", required = false) MultipartFile mainImage,
            @RequestParam(value = "images", required = false) MultipartFile[] images,
            @RequestParam(value = "videos", required = false) MultipartFile[] videos,
            Model model) {

        /*// 아이템 수정
        Item item = itemService.findItemById(id);
        if (item == null) {
            model.addAttribute("error", "작품을 찾을 수 없습니다.");
            return "redirect:/error"; // 에러 페이지로 리디렉션
        }

        item.setTitle(title);
        item.setSize(size);
        item.setMaterial(material);
        item.setTechnique(technique);
        item.setProductionDate(productionDate);
        item.setPrice(price);
        item.setStock(stock);
        item.setDetail(detail);
        item.setCategories(Arrays.asList(categories));

        // 이미지 및 비디오 처리
        if (mainImage != null && !mainImage.isEmpty()) {
            String mainImagePath = itemService.saveImage(mainImage);
            item.setMainImagePath(mainImagePath);
        }

        // 포트폴리오 이미지 및 비디오 처리
        item.clearPortfolio(); // 기존 포트폴리오 삭제
        if (portfolioImages.length > 0) {
            for (MultipartFile portfolioImage : portfolioImages) {
                if (!portfolioImage.isEmpty()) {
                    String imagePath = itemService.saveImage(portfolioImage);
                    item.addPortfolioImage(imagePath);
                }
            }
        }

        if (portfolioVideos.length > 0) {
            for (MultipartFile portfolioVideo : portfolioVideos) {
                if (!portfolioVideo.isEmpty()) {
                    String videoPath = itemService.saveVideo(portfolioVideo);
                    item.addPortfolioVideo(videoPath);
                }
            }
        }

        itemService.updateItem(item); // 아이템 업데이트
    	*/
        model.addAttribute("message", "작품이 성공적으로 수정되었습니다!");
        return "redirect:/success"; // 성공 후 리디렉션
    }

    @PostMapping("/item-delete/{id}")
    public String deleteItem(@PathVariable("id") int id, Model model) {
        /*boolean deleted = itemService.deleteItemById(id);
        if (!deleted) {
            model.addAttribute("error", "작품 삭제에 실패했습니다.");
            return "redirect:/error"; // 에러 페이지로 리디렉션
        }*/

        model.addAttribute("message", "작품이 성공적으로 삭제되었습니다!");
        return "redirect:/success"; // 성공 후 리디렉션
    }
}
