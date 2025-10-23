import java.io.InvalidClassException;


public class EstoqueInsuficienteE extends Exception{
    public EstoqueInsuficienteE(String msg){
        super(msg);
    }

    public static void validaQtd(int etq, Integer real_etq) throws EstoqueInsuficienteE{

        if(etq>real_etq){
            throw new EstoqueInsuficienteE("O estoque é insuficiente\n.");
        }

    }

}
