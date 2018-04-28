package com.SWE.Controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SWE.Entities.*;
import com.SWE.Repositories.*;

@CrossOrigin(origins = "*")
@RestController
public class StoreController {
	@Autowired
	private StoreRepository storeRepository;
	
	@Autowired
	private StoreActionsRepo saRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private StoreProductRepo storeProductRepo;
	
	@Autowired
	private  StoreBrandRepo storeBrandRepo;
	@Autowired
	private  ProductRepository productRepo;
	@Autowired
	private  BrandRepository brandRepo;
	
	public StoreController() {
		
	}
	public StoreController(StoreProductRepo storeProductRepo2, StoreActionsRepo actionRepo) {
		this.storeProductRepo = storeProductRepo2;
		this.saRepository = actionRepo;
	}
	public StoreController(StoreBrandRepo storeBrandRepo2, StoreActionsRepo actionRepo) {
		this.storeBrandRepo = storeBrandRepo2;
		this.saRepository = actionRepo;
	}

	@GetMapping("/onlinemarket/addstore/request")
	public boolean requestToAddStore(Model model, @ModelAttribute Store newStore) {
		model.addAttribute("newStore", new Store());
		newStore.setIsAccepted(false);	
		storeRepository.save(newStore);
		return true;
	}
	
	
	@GetMapping("/onlinemarket/addstore/accept-request")
	public boolean acceptStore(Model model, @ModelAttribute Store newStore) {
		model.addAttribute("newStore", new Store());
		Store s = storeRepository.findByName(newStore.getName());
		s.setIsAccepted(true);	
		storeRepository.save(s);
		return true;
	}
	
	@GetMapping("/onlinemarket/addstore/reject-request")
	public boolean rejectStore(Model model, @ModelAttribute Store newStore) {
		model.addAttribute("newStore", new Store());
		Store s = storeRepository.findByName(newStore.getName());
		storeRepository.delete(s);
		return true;
	}
	
	@GetMapping("/onlinemarket/addstore/get-all-request")
	public ArrayList<Store> getAllStoresRequests() {
		ArrayList<Store> stores = new ArrayList<>();
		for(Store s: storeRepository.findAll()) {
			if(s.getIsAccepted() == false) {
				stores.add(s);
			}
		}
		return stores;
	}
	
	public Store getStore(String sName) {
		for(Store s : storeRepository.findAll()) {
			System.out.println(s.getName());
			if(s.getName().equals(sName)) {
				return s;
			}
		}
		return null;
	}
	
	@GetMapping("/onlinemarket/store-statistics/{sName}")
	public ArrayList<Statistics> getStatistics(@PathVariable String sName) {
		Store store = getStore(sName);
		ArrayList<Statistics> statistics = new ArrayList();
		for(StoreProduct sp : storeProductRepo.findAll()) {
			if(sp.getStore().getId() == store.getId()) {
				Statistics s = new Statistics();
				s.productName = sp.getProduct().getName();
				s.numberOfViewers =sp.getNumberOfViewers();
				s.numOfSoldItems = sp.getNumberOfSoldItems();
				statistics.add(s);
			}
		}
		return statistics;
	}
	
	@GetMapping("/onlinemarket/addproduct-tostore/{store}/{product}")
	public boolean addProductToStore(Model model, @ModelAttribute StoreProduct newProduct) {
		model.addAttribute("newProduct", new Store());	
		storeProductRepo.save(newProduct);
		return true;
	}
	
	@GetMapping("/onlinemarket/add-collaborator/")
	public boolean addCollaborator( @PathParam(value = "email") String email, @PathParam(value = "sName") String sName) {
		System.out.println(email);
		User newCollaborator = userRepository.findByEmail(email);
		Store store = storeRepository.findByName(sName);
		store.getUsers().add(newCollaborator);
		if(newCollaborator != null) {
			storeRepository.save(store);
			return true;
		}
		return false;
	}

	public boolean addProduct(Store s, Product p, StoreAction a, int quantity, int price) {
		StoreProduct sp = new StoreProduct();
		sp.setProduct(p);
		sp.setStore(s);
		sp.setQuantity(quantity);
		sp.setPrice(price);
		for(StoreProduct each: storeProductRepo.findAll()) {
			if(each.getStore() == s && each.getProduct() == p) {
				sp = each;
				sp.setQuantity(sp.getQuantity() + quantity);
				sp.setPrice(price);
			}
		}
		storeProductRepo.save(sp);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		StoreActions sa = new StoreActions();
		sa.setStore(s);
		sa.setAction(a);
		sa.setDate(date);
		saRepository.save(sa);
		return true;
	}
	
	public boolean addBrand(Store s, Brand b, StoreAction a) {
		StoreBrand sb = new StoreBrand();
		sb.setBrand(b);;
		sb.setStore(s);
		storeBrandRepo.save(sb);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		StoreActions sa = new StoreActions();
		sa.setStore(s);
		sa.setAction(a);
		sa.setDate(date);
		saRepository.save(sa);
		return true;
	}
	
	public boolean editProduct(Product newproduct, Store s, int pId, StoreAction a) {
		newproduct.setId(pId);
		for(Product p: productRepo.findAll()) {
			if(p.getId() == pId) {
				p.setQuantity(newproduct.getQuantity());
				p.setPrice(newproduct.getPrice());
				productRepo.save(p);
				break;
			}
		}
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		StoreActions sa = new StoreActions();
		sa.setStore(s);
		sa.setAction(a);
		sa.setDate(date);
		saRepository.save(sa);
		return true;
	}
	
	public boolean editBrand(Brand newbrand, Store s, int bId, StoreAction a) {
		newbrand.setId(bId);
		for(Brand b: brandRepo.findAll()) {
			if(b.getId() == newbrand.getId()) {
				b= newbrand;
				brandRepo.save(b);
				break;
			}
		}
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		StoreActions sa = new StoreActions();
		sa.setStore(s);
		sa.setAction(a);
		sa.setDate(date);
		saRepository.save(sa);
		return true;
	}

	public boolean deleteProduct(Store s, Product p, StoreAction a) {
		for(StoreProduct spt: storeProductRepo.findAll()) {
			if(spt.getProduct()== p && spt.getStore() == s) {
				storeProductRepo.delete(spt);
				break;
			}
		}
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		StoreActions sa = new StoreActions();
		sa.setStore(s);
		sa.setAction(a);
		sa.setDate(date);
		saRepository.save(sa);
		return true;
	}
	
	public boolean deleteBrand(Store s, Brand b, StoreAction a) {
		for(StoreBrand sb: storeBrandRepo.findAll()) {
			if(sb.getBrand()== b && sb.getStore() == s) {
				storeBrandRepo.delete(sb);
				break;
			}
		}
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		StoreActions sa = new StoreActions();
		sa.setStore(s);
		sa.setAction(a);
		sa.setDate(date);
		saRepository.save(sa);
		return true;
	}
	
	@GetMapping("/onlinemarket/history/{sname}")
	public ArrayList<StoreActions> getAllActions(@PathVariable String sname) {
		ArrayList<StoreActions> sa = new ArrayList<>();
		for(StoreActions a: saRepository.findAll()) {
			if(a.getStore().getName().equals(sname)) {
				a.getAction().setStoreActions(null);
				a.getStore().setStatistics(null);
				a.getStore().setStoreActions(null);
				a.getStore().setStoreBrands(null);
				a.getStore().setStoreProducts(null);
				a.getStore().setUsers(null);
				sa.add(a);
			}
		}
		return sa;
	}
	
	@GetMapping("/onlinemarket/undo/{sId}/{aId}")
	public void undoAction(@PathVariable int sId, @PathVariable int aId) {
		for(StoreActions a: saRepository.findAll()) {
			if(a.getStore().getId() == sId && a.getAction().getId() == aId) {
				saRepository.delete(a);
			}
		}
	}
	
	
	public ProductRepository getProductRepo() {
		return productRepo;
	}
	public void setProductRepo(ProductRepository productRepo) {
		this.productRepo = productRepo;
	}
	public BrandRepository getBrandRepo() {
		return brandRepo;
	}
	public void setBrandRepo(BrandRepository brandRepo) {
		this.brandRepo = brandRepo;
	}
	
	
}
