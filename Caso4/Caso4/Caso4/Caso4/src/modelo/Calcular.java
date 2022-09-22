package modelo;

import excepciones.CalculoImposibleException;
import excepciones.ParametroException;

public class Calcular {
    private Integer resultado_ult_operacion;

    public void calcular(int PrimerOperando, int SegundoOperando, String Operacion) throws ParametroException, CalculoImposibleException {
        //assert PrimerOperando < 0 : "El primer operando es negativo";
        //assert SegundoOperando < 0: "El segundo operando es negativo";
        Integer aux = 0;
        if(PrimerOperando < 0)
            throw  new ParametroException("El primer operando es negativo");
        else
            if(SegundoOperando < 0)
                throw new ParametroException("El segundo operando es negativo");
        //valida
        switch (Operacion)
        {
            case "+": aux = PrimerOperando + SegundoOperando;
            break;

            case "-": aux = PrimerOperando - SegundoOperando;
            break;

            case "*": aux = PrimerOperando * SegundoOperando;
            break;

            case "/": aux = PrimerOperando / SegundoOperando;
            break;

            default:  throw new CalculoImposibleException("El operando "+Operacion+" no es valido"); // informar no fue posible el calculo  ;
        }

        assert aux < 0 : "El resultado dio negativo";
        this.resultado_ult_operacion = aux;
    }

    public int traerResultado(){return this.resultado_ult_operacion;}
}

