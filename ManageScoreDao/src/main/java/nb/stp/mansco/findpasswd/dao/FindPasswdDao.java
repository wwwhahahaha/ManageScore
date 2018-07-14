package com.jack.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jack.entity.Cart;
import com.jack.entity.CartItem;
import com.jack.entity.Product;
import com.jack.service.CartService;
import com.util.controller.BaseController;
import com.util.entity.ResponseEntity;

@RestController
@RequestMapping("cart")
public class CartController extends BaseController{

	private static final Logger LOGGER=Logger.getLogger(CartController.class);
	
	@Autowired
	private CartService cartService;
	
	@GetMapping
	public ResponseEntity getCartList(HttpServletRequest request){
		ResponseEntity re=new ResponseEntity();
		List<CartItem> cartItemList=new ArrayList<CartItem>();
		Cart cart=(Cart) super.getSessionParams(request, "cart");
		try{	
			Map<String, Object> retMap=new HashMap<String, Object>();
			if(cart!=null){
				for ( Map<String,CartItem> cartItemMap : cart.getMapList()) {
					for (Map.Entry<String,CartItem> entry : cartItemMap.entrySet()) {
						CartItem item=entry.getValue();
						cartItemList.add(item);
					}
				}
				retMap.put("list", cartItemList);
				retMap.put("totalPrice", cart.getTotalPrice());
				retMap.put("totalNum", cart.getTotalNum());
				re.setData(retMap);
			    re.setStatusCode("200");
			}else{
				re.setData(null);
			    re.setStatusCode("200");
			}
		}catch(Exception e){
			e.getStackTrace();
			String errorMsg=e.getMessage();
		    re.setStatusCode("500");
			re.setErrorCode("500");
			re.setErrorMsg(errorMsg);
			LOGGER.info(errorMsg);
		}
		return re;
	}
	
	@PostMapping
	public ResponseEntity addProductToCart(Product product,HttpServletRequest request){
		ResponseEntity re=new ResponseEntity();
		Cart cart=(Cart) super.getSessionParams(request, "cart");
		List<CartItem> cartItemList=new ArrayList<CartItem>();
		try{
			Map<String, Object> retMap=new HashMap<String, Object>();
			if(cart==null){
				Cart cart1=new Cart();
				request.getSession().setAttribute("cart", cart1);
				cart=cartService.addProductToCart(product, cart1);
				for ( Map<String,CartItem> cartItemMap : cart.getMapList()) {
					for (Map.Entry<String,CartItem> entry : cartItemMap.entrySet()) {
						CartItem item=entry.getValue();
						cartItemList.add(item);
					}
				}
				retMap.put("list", cartItemList);
				retMap.put("totalPrice", cart.getTotalPrice());
				retMap.put("totalNum", cart.getTotalNum());
				re.setData(retMap);
				re.setStatusCode("200");
			}else{
				cart=cartService.addProductToCart(product, cart);
				for ( Map<String,CartItem> cartItemMap : cart.getMapList()) {
					for (Map.Entry<String,CartItem> entry : cartItemMap.entrySet()) {
						CartItem item=entry.getValue();
						cartItemList.add(item);
					}
				}
				retMap.put("list", cartItemList);
				retMap.put("totalPrice", cart.getTotalPrice());
				retMap.put("totalNum", cart.getTotalNum());
				re.setData(retMap);
			    re.setStatusCode("200");
			}	
		}catch(Exception e){
			e.printStackTrace();
			String errorMsg=e.getMessage();
		    re.setStatusCode("500");
			re.setErrorCode("500");
			re.setErrorMsg(errorMsg);
			LOGGER.info(errorMsg);
		}
		return re;
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity deleteCartItemById(@PathVariable String id,HttpServletRequest request){
		ResponseEntity re=new ResponseEntity();
		Cart cart=(Cart) super.getSessionParams(request, "cart");
		List<CartItem> cartItemList=new ArrayList<CartItem>();
		try{
			cart=cartService.deleteCartItemById(id, cart);
			for ( Map<String,CartItem> cartItemMap : cart.getMapList()) {
				for (Map.Entry<String,CartItem> entry : cartItemMap.entrySet()) {
					CartItem item=entry.getValue();
					cartItemList.add(item);
				}
			}
			Map<String, Object> retMap=new HashMap<String, Object>();
			retMap.put("list", cartItemList);
			retMap.put("totalPrice", cart.getTotalPrice());
			retMap.put("totalNum", cart.getTotalNum());
			re.setData(retMap);
			re.setStatusCode("200");
		}catch(Exception e){
			e.printStackTrace();
			String errorMsg=e.getMessage();
		    re.setStatusCode("500");
			re.setErrorCode("500");
			re.setErrorMsg(errorMsg);
			LOGGER.info(errorMsg);
		}
		return re;
	}
	
	@DeleteMapping
	public ResponseEntity clearCart(HttpServletRequest request){
		ResponseEntity re =new ResponseEntity();
		Cart cart=(Cart) super.getSessionParams(request, "cart");
		List<CartItem> cartItemList=new ArrayList<CartItem>();
		try{
			cart=cartService.clearCart(cart);
			for ( Map<String,CartItem> cartItemMap : cart.getMapList()) {
				for (Map.Entry<String,CartItem> entry : cartItemMap.entrySet()) {
					CartItem item=entry.getValue();
					cartItemList.add(item);
				}
			}
			Map<String, Object> retMap=new HashMap<String, Object>();
			retMap.put("list", cartItemList);
			retMap.put("totalPrice", cart.getTotalPrice());
			retMap.put("totalNum", cart.getTotalNum());
			re.setData(retMap);
			re.setStatusCode("200");
		}catch (Exception e) {
			e.printStackTrace();
			String errorMsg=e.getMessage();
		    re.setStatusCode("500");
			re.setErrorCode("500");
			re.setErrorMsg(errorMsg);
			LOGGER.info(errorMsg);
		}
		return re;
	}
	
	@PutMapping
	public ResponseEntity changeCartItemNum(Product product,String quantity,HttpServletRequest request){
		ResponseEntity re=new ResponseEntity();
		Cart cart=(Cart) super.getSessionParams(request, "cart");
		List<CartItem> cartItemList=new ArrayList<CartItem>();
		try{
			cart=cartService.changeItemQuantity(product.getId(), quantity, cart);
			for ( Map<String,CartItem> cartItemMap : cart.getMapList()) {
				for (Map.Entry<String,CartItem> entry : cartItemMap.entrySet()) {
					CartItem item=entry.getValue();
					cartItemList.add(item);
				}
			}
			Map<String, Object> retMap=new HashMap<String, Object>();
			retMap.put("list", cartItemList);
			retMap.put("totalPrice", cart.getTotalPrice());
			retMap.put("totalNum", cart.getTotalNum());
			re.setData(retMap);
			re.setStatusCode("200");
		}catch(Exception e){
			e.printStackTrace();
			String errorMsg=e.getMessage();
		    re.setStatusCode("500");
			re.setErrorCode("500");
			re.setErrorMsg(errorMsg);
			LOGGER.info(errorMsg);
		}
		return re;
	}
}
