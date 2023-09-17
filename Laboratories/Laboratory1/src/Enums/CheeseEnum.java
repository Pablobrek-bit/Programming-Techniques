package Enums;

public enum CheeseEnum {
	
	MUSSARELA("mussarela"), PRATO("prato"), PARMESAO("parmesao"), COALHO("coalho");
		
	private String selecao;

	public String getSelecao() {
		return selecao;
	}
	
	CheeseEnum(String selecao){
		this.selecao = selecao;
	}
	
	public static CheeseEnum getCheese(String selecao) {
		switch (selecao) {
			case "mussarela": 
				return MUSSARELA;
			case "prato":
				return PRATO;
			case "parmesao":
				return PARMESAO;
			case "coalho":
				return COALHO;
			default:
				return null;
		}
	}
}
