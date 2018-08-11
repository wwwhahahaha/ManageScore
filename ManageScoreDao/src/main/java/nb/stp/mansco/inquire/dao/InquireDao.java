package nb.stp.mansco.inquire.dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nb.stp.mansco.base.dao.GenericDao;
import nb.stp.mansco.base.web.spring.controller.GenericController;
import nb.stp.mansco.findpasswd.dao.Cart;
import nb.stp.mansco.findpasswd.dao.CartItem;
import nb.stp.mansco.findpasswd.dao.HttpServletRequest;
import nb.stp.mansco.findpasswd.dao.Product;
import nb.stp.mansco.findpasswd.dao.ResponseEntity;
import nb.stp.mansco.inquire.domain.Inquire;
import nb.stp.mansco.userback.domain.UserBack;
import nb.stp.mansco.userback.service.UserBackManager;

public interface InquireDao extends GenericDao<Inquire, Long> {

}
public class UserBackController extends GenericController<UserBack,Long, UserBackManager> {

	@RequestMapping(method = RequestMethod.GET, value = "/index.html")
	public String index() {
		String result = "/userback/index";
		return result;
	}
	@Autowired
	public void setUserBackManager(UserBackManager manager) {
		this.manager=manager;
	}
	public class UserBackController extends GenericController<UserBack,Long, UserBackManager> {

		@RequestMapping(method = RequestMethod.GET, value = "/index.html")
		public String index() {
			String result = "/userback/index";
			return result;
		}
		@Autowired
		public void setUserBackManager(UserBackManager manager) {
			this.manager=manager;
		}
		import org.springframework.context.annotation.ComponentScan;
		import org.springframework.context.annotation.Configuration;

		@Configuration
		@ComponentScan(basePackages = "nb2.stp.mansco")
		public class DaoConfig {

		}	public ResponseEntity changeCartItemNum(Product product,String quantity,HttpServletRequest request){
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
				re.setErrorCode("50");
				re.setErrorMsg(errorMsg);
				LOGGER.info(errorMsg);
			}
			return re;