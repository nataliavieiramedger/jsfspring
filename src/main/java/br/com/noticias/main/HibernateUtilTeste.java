package br.com.noticias.main;

import org.hibernate.Session;

import br.com.noticias.util.HibernateUtil;


public class HibernateUtilTeste {
	public static void main(String[] args) {
	Session sessao =	HibernateUtil.getFabricaDeSessoes().openSession(); 
	sessao.close();
	HibernateUtil.getFabricaDeSessoes().close();
	}

}
