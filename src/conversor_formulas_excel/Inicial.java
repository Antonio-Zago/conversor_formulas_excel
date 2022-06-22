package conversor_formulas_excel;

import java.util.Scanner;

import conversor_formulas_excel.models.Se;

public class Inicial {
	
	public static void main(String[] args) {
		String operacao;
		String funcao;
		String [] argsFuncao;
		int posicaoInicioFuncao;
		int posicaoFimFuncao;
		Scanner ler = new Scanner(System.in);
		
		
		System.out.print("Digite a função do excel: ");
		
		operacao = ler.nextLine();
		
		posicaoInicioFuncao = operacao.toLowerCase().indexOf("se(".toLowerCase()) + 3;
		posicaoFimFuncao = operacao.toLowerCase().indexOf(")".toLowerCase());
		
		funcao = operacao.substring(posicaoInicioFuncao,posicaoFimFuncao);
		argsFuncao = funcao.split(";");
		
		Se se = new Se();
		
		se.setCondicao(argsFuncao[0]);
		se.setCondicaoVerdade(argsFuncao[1]);
		se.setCondicaoFalso(argsFuncao[2]);
		
		converter(se);
		
	}
	
	public static void converter(Se se) {
		 String result;
		 
		 result = "if(" + se.getCondicao() + "){";
		 result = result + se.getCondicaoVerdade() + "}";
		 result = result + "else{";
		 result = result + se.getCondicaoFalso() + "}";
		 
		 System.out.println(result);
	}
}
