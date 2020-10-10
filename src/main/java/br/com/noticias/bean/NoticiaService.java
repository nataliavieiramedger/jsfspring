package br.com.noticias.bean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.noticias.dao.NoticiaDAO;
import br.com.noticias.domain.Noticia;
import br.com.noticias.dto.NoticiaDTO;

@Service
public class NoticiaService {

	NoticiaDAO noticiaDAO = new NoticiaDAO();
	List<Noticia> noticias;

	public String salvar(NoticiaDTO noticiaDTO) {
		Noticia noticia = new Noticia();
		noticia.setTitulo(noticiaDTO.getTitulo());
		noticia.setNoticia(noticiaDTO.getNoticia());
		noticia.setAutor(noticiaDTO.getAutor());
		Calendar c = Calendar.getInstance();
		Date data = c.getTime();
		noticia.setDataCriacao(data);
		noticiaDAO.salvar(noticia);
		return "OK";
	}

	public List<Noticia> listar() {

		List<Noticia> lista = new ArrayList<Noticia>();
		try {

			lista = noticiaDAO.listar();

		} catch (RuntimeException erro) {
			erro.printStackTrace();
		}
		return lista;
	}

	public void editar(Noticia noticia) {

		Calendar c = Calendar.getInstance();
		Date data = c.getTime();
		noticia.setDataAtualizacao(data);

		try {

			noticiaDAO.editar(noticia);
			

		} catch (RuntimeException erro) {
			erro.printStackTrace();
		}

	}

	public void excluir(Noticia noticia) {

		try {
			noticiaDAO.excluir(noticia);
			noticias = noticiaDAO.listar();

		} catch (RuntimeException erro) {
			erro.printStackTrace();
		}

	}
}
