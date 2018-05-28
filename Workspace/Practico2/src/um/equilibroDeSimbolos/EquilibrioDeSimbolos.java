package um.equilibroDeSimbolos;

import java.util.Scanner;

import um.Exceptions.EmptyStackException;
import um.Exceptions.NoEquilibrioDeSimbolos;
import um.StackListaEnlazada.Stack;

public class EquilibrioDeSimbolos {
	private Stack<String> miStack;

	public EquilibrioDeSimbolos() {
		miStack = new Stack<>();
	}

	public void agregarParentesis(String pare) {
		switch (pare) {
		case "(":
			miStack.push(pare);
			break;
		case "{":
			miStack.push(pare);
			break;
		case"[":
			miStack.push(pare);
			break;
		}
	}

	public void borrarParentesis() throws EmptyStackException {
		miStack.pop();
	}

	public boolean parentesisCorrecto(String pare) throws EmptyStackException,NoEquilibrioDeSimbolos{
		boolean bExit = false;
		switch (pare) {
		case ")":
			if (miStack.top().equals("(")) {
				bExit = true;
			}else {
				NoEquilibrioDeSimbolos e = new NoEquilibrioDeSimbolos("No hay equilibrio en los simbolos.");
				throw e;
			}
			break;
		case "}":
			if (miStack.top().equals("{")) {
				bExit = true;
			}else {
				NoEquilibrioDeSimbolos e = new NoEquilibrioDeSimbolos("No hay equilibrio en los simbolos.");
				throw e;
			}
			break;
		case "]":
			if (miStack.top().equals("[")) {
				bExit = true;
			}else {
				NoEquilibrioDeSimbolos e = new NoEquilibrioDeSimbolos("No hay equilibrio en los simbolos.");
				throw e;
			}
			break;
		}
		return bExit;
	}
	
	public void aplicacion() throws EmptyStackException, NoEquilibrioDeSimbolos {
		Scanner sc = new Scanner(System.in);
		System.out.println("Escriba centencia: ");
		String centencia = sc.nextLine();
		char[] chrArray = centencia.toCharArray();
		for(int i = 0 ; i<chrArray.length ; i++) {
			agregarParentesis(String.valueOf(chrArray[i]));
			if(parentesisCorrecto(String.valueOf(chrArray[i]))) {
				borrarParentesis();
			}
		}
		sc.close();
		if( !miStack.isEmpty() )
			throw new NoEquilibrioDeSimbolos("No hay equilibrio en los simbolos.");
	}
}