package um.evaluarPostFija;	

import um.Exceptions.EmptyStackException;
import um.StackListaEnlazada.Stack;

public class evaluarPostFija {	
	
	public evaluarPostFija() throws EmptyStackException {
	}
	
	public int evaluar(String sEvaluar) throws EmptyStackException {
		int nExit = 0;
		String [] textoSeparado = separarTexto(sEvaluar);
		Stack<String> stackTextoSeparado = stackDeTexto(textoSeparado);
		Stack<String> stackOperando = new Stack<>();
		while(!stackTextoSeparado.isEmpty()) {
			if(!esOperador(stackTextoSeparado.top())) {
				stackOperando.push(topAndPop(stackTextoSeparado));
			}else if(esOperador(stackTextoSeparado.top())){
				stackOperando.push(evaluar(topAndPop(stackTextoSeparado),topAndPop(stackOperando),topAndPop(stackOperando)));
			}					
		}
		nExit = Integer.parseInt(stackOperando.top());
		return nExit;
	}
	
	private String topAndPop( Stack<String> oTemp ) throws EmptyStackException {
		String oExit;
		oExit = oTemp.top();
		oTemp.pop();
		return oExit;
	}
	
	private String[] separarTexto(String textoASeparar) {
		String[] sExit;
		sExit = textoASeparar.split(" ");
		return sExit;
	}
	
	private Stack<String> stackDeTexto(String [] textoSeparado) {
		Stack<String> stackSeparado = new Stack<>();
			for(int i = (textoSeparado.length -1) ; i >= 0 ; i--) {
				stackSeparado.push(textoSeparado[i]);
			}
		return stackSeparado;
	}
	
	private String evaluar(String operador , String num0 , String num1) {
		int nExitTemp = 0;
		int n0 = Integer.parseInt(num0);
		int n1 = Integer.parseInt(num1);
		switch(operador) {
		case "+":
			nExitTemp = n0 + n1;
			break;
		case "-":
			nExitTemp = n1 - n0;
			break;
		case "*":
			nExitTemp = n0 * n1;
			break;
		case "/":
			nExitTemp = n1 / n0;
			break;
		}
		String sExit = Integer.toString(nExitTemp);
		return sExit;
	}
	
	private boolean esOperador(String operador) {
		boolean bExit = false;
		switch (operador) {
		case "+":
			bExit = true;
			break;
		case "-":
			bExit = true;
			break;
		case "*":
			bExit = true;
			break;
		case "/":
			bExit = true;
			break;
		}
		return bExit;
	}
	
//	private MyStackImplements<String> stackOperadores (MyStackImplements<String> stackTexto) throws EmptyStackException{
//		MyStackImplements<String> stackOperadores = new MyStackImplements<String>();
//		String sCharStackTexto;
//		for(int i = 0 ; i < stackTexto.size() ; i++) {
//			sCharStackTexto = stackTexto.top();
//			switch (sCharStackTexto) {
//			case "+":
//				stackOperadores.push(sCharStackTexto);
//				break;
//			case "-":
//				stackOperadores.push(sCharStackTexto);
//				break;
//			case "*":
//				stackOperadores.push(sCharStackTexto);
//				break;
//			case "/":
//				stackOperadores.push(sCharStackTexto);
//				break;
//			}
//		}
//	}
}
