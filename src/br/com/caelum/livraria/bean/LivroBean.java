package br.com.caelum.livraria.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.Livro;

@ManagedBean
@ViewScoped
public class LivroBean {

	private Livro livro = new Livro();
	private Integer autorId;
	
	
	public Integer getAutorId() {
		return autorId;
	}


	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}


	public Livro getLivro() {
		return livro;
	}
	
	public List<Livro> getLivros(){
		 
		return new DAO<Livro>(Livro.class).listaTodos();
	}
	
	
	public List<Autor> getAutores(){
			
		return new DAO<Autor>(Autor.class).listaTodos();
	}
	
	public List<Autor> getAutoresDoLivro(){
		return this.livro.getAutores();
	}
	

	public void gravar() {
		System.out.println("Gravando livro " + this.livro.getTitulo());

		if (livro.getAutores().isEmpty()) {
			//throw new RuntimeException("Livro deve ter pelo menos um Autor.");
			FacesContext.getCurrentInstance().addMessage("autor", new FacesMessage("o livro deve ter pelo menos um autor"));
		}

		new DAO<Livro>(Livro.class).adiciona(this.livro);
		
	}

	
	public void gravarAutor(){

		
		Autor autor= new DAO<Autor>(Autor.class).buscaPorId(this.autorId);
		this.livro.adicionaAutor(autor);
		
	}
		
	public void comecaComUM(FacesContext fc, UIComponent ui, Object value ) throws ValidatorException {
		String valor = value.toString();
		
		if(!valor.startsWith("1")){
			throw new ValidatorException(new FacesMessage("O ISBN deve come�ar com 1"));
		}
	}
	
	public String formAutor(){
		System.out.println("chamado formulario do autor");
			return "autor.xhtml?faces-redirect=true";
		
	}

}
