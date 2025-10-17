import java.io.InvalidClassException;

public class DescontoInvalidoE extends Exception{
    public DescontoInvalidoE(String msg){
        super(msg);
    }
    public static void validaPercentual(double p) throws DescontoInvalidoE{
        if(p<0){
            throw new DescontoInvalidoE("O percentual negativo é inválido\n.");
        }
        if(p>0.95){
            throw new DescontoInvalidoE("Valor de desconto está acima do limite máximo\n.");
        }
    }
}
