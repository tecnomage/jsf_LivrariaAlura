package br.com.caelum.livraria.util;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class temaBean {
	
	private String tema = "airsto";
	
	public String getTema(){
		return tema;
	}
	
	public void setTema(String tema){
		this.tema= tema;
	}

	
	public List<String> getTemas(){
		return Arrays.asList("aristo", "black-tie", "blitzer", "bluesky", "casablanca", "cupertino", "dark-hive",
                "dot-luv", "eggplant", "excite-bike", "flick", "glass-x", "hot-sneaks", "humanity", "le-frog",
                "midnight", "mint-choc", "overcast", "pepper-grinder", "redmond", "rocket", "sam", "smoothness",
                "south-street", "start", "sunny", "swanky-purse", "trontastic", "ui-darkness", "ui-lightness", "vader");
		}
}
