package exception;

public class ProdutoNaoEncontradoException extends Exception{
    public ProdutoNaoEncontradoException(String msg){
        super(msg);
    }
    public static boolean validaProdLista(Produto p) throws ProdutoNaoEncontradoException{
          boolean prodNaLista=lista_prodDisponivel.stream().anyMatch(
            prod->prod.getId().equals(p.getId()));

        if(!prodNaLista){
            throw new ProdutoNaoEncontradoException("Produto não está na lista.\n");
            return false;
        }
        return true;
    }
}