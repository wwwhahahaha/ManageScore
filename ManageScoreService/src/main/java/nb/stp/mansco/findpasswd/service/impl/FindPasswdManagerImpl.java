package com.jack.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jack.entity.Cart;
import com.jack.entity.CartItem;
import com.jack.entity.Product;
import com.jack.service.CartService;
import com.jack.service.ProductService;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private ProductService productService;
	
	@Override
	public Product findProductBy(Product product) {
		// TODO Auto-generated method stub
		return productService.get(product.getId());
	}


	@Override
	public void setCartall(Cart cart) {
		// TODO Auto-generated method stub
		//CartItem item=new CartItem();
		double totalPrice=0;
		int totalNum=0;
		for(Map<String, CartItem> cartItemMap:cart.getMapList()){
			for (Map.Entry<String, CartItem> entry : cartItemMap.entrySet()) {
				CartItem item=entry.getValue();
				totalPrice+=item.getPrice();
				totalNum+=item.getQuantity();
			}
		}
		cart.setTotalPrice(totalPrice);
		cart.setTotalNum(totalNum);
	}


	@Override
	public Cart addProductToCart(Product product, Cart cart) {
		// TODO Auto-generated method stub
		//CartItem item=cart.getMap().get(product.getId());
		String id=product.getId();
		CartItem item=new CartItem();
		product=productService.get(id);
		for (Map<String,CartItem> cartItemMap : cart.getMapList()) {
			if(cartItemMap.get(id)!=null){
				item=cartItemMap.get(id);
				break;
			}		
		}
		if(item.getProduct()!=null){
		  if(product.getProInventory()>item.getQuantity()){
			 item.setQuantity(item.getQuantity()+1);
			 item.setPrice(product.getProPrice()*item.getQuantity());		
			 this.setCartall(cart);
		     return cart;
		  }else{
			 return cart;
		 }
		}else{
			if(product.getProInventory()>item.getQuantity()){
				item.setProduct(product);
				item.setQuantity(1);
				item.setPrice(product.getProPrice()*item.getQuantity());
				//把新的购物项添加到map集合中
				//cart.getMap().put(product.getId(),item);
				Map<String, CartItem> cartItemMap=new HashMap<String, CartItem>();
				cartItemMap.put(product.getId(), item);
				cart.getMapList().add(cartItemMap);
				this.setCartall(cart);
			    return cart; 
			}else{
				return cart;
			}
		}
	}

	@Override
	public Cart deleteCartItemById(String id, Cart cart) {
		// TODO Auto-generated method stub
		for (Map<String,CartItem> cartItemMap : cart.getMapList()) {
			if(cartItemMap.get(id)!=null){
				cartItemMap.remove(id);
				break;
			}
		}
		this.setCartall(cart);
		return cart;
	}

	@Override
	public Cart clearCart(Cart cart) {
		// TODO Auto-generated method stub
		cart.getMapList().clear();
		return cart;
	}

	@Override
	public Cart changeItemQuantity(String id, String quantity, Cart cart) {
		// TODO Auto-generated method stub
		  CartItem item=new CartItem();
		  for (Map<String, CartItem> cartItemMap : cart.getMapList()) {
			if(cartItemMap.get(id)!=null){
				item=cartItemMap.get(id);
				break;
			}
		}
		  Product product=productService.get(id);
		  item.setQuantity(Integer.parseInt(quantity));
		  item.setPrice(product.getProPrice()*item.getQuantity());
		  this.setCartall(cart);
		  return cart;
	}



}
