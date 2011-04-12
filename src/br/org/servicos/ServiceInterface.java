package br.org.servicos;

import java.util.List;

public interface ServiceInterface {

    public List<Object> getAll();
    public Object getByName (String nome);
    public boolean save(Object obj);    
    public void delete(String str);

}
