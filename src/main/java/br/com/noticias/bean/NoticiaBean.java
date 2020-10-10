package br.com.noticias.bean;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.noticias.domain.Noticia;
import br.com.noticias.dto.NoticiaDTO;



@Component
@Scope("view")
public class NoticiaBean{

	@Autowired
	private NoticiaService noticiaService;

	private List<Noticia> noticias;
	
	

	public List<Noticia> getNoticias() {
		this.noticias = noticiaService.listar();
		return noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}

	private NoticiaDTO noticiaDTO = new NoticiaDTO();

	public NoticiaDTO getNoticiaDTO() {
		return noticiaDTO;
	}

	public void setNoticiaDTO(NoticiaDTO noticiaDTO) {
		this.noticiaDTO = noticiaDTO;
	}

	public String salvar() {

		noticiaService.salvar(noticiaDTO);
		return "/pages/sucesso.xhtml";
	}

	


	public void editar(Noticia noticia) {

		try {

			noticiaService.editar(noticia);
			noticias = noticiaService.listar();

		} catch (RuntimeException erro) {
			erro.printStackTrace();
		}

	}


	public void excluir(Noticia noticia) {

		try {
			
			noticiaService.excluir(noticia);
			
			noticias = noticiaService.listar();

		} catch (RuntimeException erro) {
			erro.printStackTrace();
		}

	}
	

}
